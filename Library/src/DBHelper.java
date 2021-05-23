import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class DBHelper {
	public static Connection conn = null;
	public static MyModel model = null;
	public static PreparedStatement state = null;
	public static ResultSet result = null;


	static void fillCombo(JComboBox<String> combo, String variable, String nameTable) {

		conn = getConnection();
		String sql = "select id, " + variable + " from " + nameTable;
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			combo.removeAllItems();
			while (result.next()) {
				String item = result.getObject(1).toString() + " " + result.getObject(2).toString();
				combo.addItem(item);
			} // end while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	static void fillComboInfo(JComboBox<String> combo) {

		conn = getConnection();
		String sql = "SELECT I.ID, R.READERSNAME FROM INFO I, READERS R "
				+ "WHERE I.READERSID = R.ID";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			combo.removeAllItems();
			while (result.next()) {
				String item = result.getObject(1).toString() + " " + result.getObject(2).toString();
				combo.addItem(item);
			} // end while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:D:\\\\H2 Java\\\\LibraryDB\\\\LibraryDB;AUTO_SERVER=TRUE", "sa",
					"sa");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}// end getConnection

	public static MyModel getAllData(String tableName) {

		conn = getConnection();
		try {
			state = conn.prepareStatement("SELECT * FROM " + tableName);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}// end AllData
	
	public static MyModel getAllDataInfo() {

		conn = getConnection();
		try {
			state = conn.prepareStatement("SELECT INFO.ID, INFO.TAKINGDATE , INFO.RETURNDATE, INFO.COMMENT, READERS.READERSNAME, BOOKS.BOOKNAME "
					+ "FROM INFO, BOOKS, READERS "
					+ "WHERE INFO.BOOKSID = BOOKS.ID AND INFO.READERSID = READERS.ID");
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}// end AllData

}
