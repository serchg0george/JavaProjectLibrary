import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private Connection conn = null;
	private PreparedStatement state = null;
//	private PreparedStatement stateDate = null;
	private ResultSet result = null;
//	public static Boolean checkDays = false;
	int id = -1;

//   create JTabbedPane
	JTabbedPane tab = new JTabbedPane();

//	 create JTable
	JTable booksTable = new JTable();
	JTable readersTable = new JTable();
	JTable infoTable = new JTable();
	JTable searchTable = new JTable();

//	 create JScrollPane
	JScrollPane booksScrollPane = new JScrollPane(booksTable);
	JScrollPane readersScrollPane = new JScrollPane(readersTable);
	JScrollPane infoScrollPane = new JScrollPane(infoTable);
	JScrollPane searchScrollPane = new JScrollPane(searchTable);

//	 create JPanel
	// -------------------------------------------------- books
	JPanel upPanelBooks = new JPanel();
	JPanel upPanelReaders = new JPanel();
	JPanel upPanelInfo = new JPanel();
	JPanel upPanelSearch = new JPanel();
	// -------------------------------------------------- readers
	JPanel middlePanelBooks = new JPanel();
	JPanel middlePanelReaders = new JPanel();
	JPanel middlePanelInfo = new JPanel();
	JPanel middlePanelSearch = new JPanel();
	// -------------------------------------------------- info
	JPanel downPanelBooks = new JPanel();
	JPanel downPanelReaders = new JPanel();
	JPanel downPanelInfo = new JPanel();

	JPanel booksPanel = new JPanel();
	JPanel readersPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel searchPanel = new JPanel();

	// --------------------------------------------------- search
	JPanel downPanelSearch = new JPanel();

//	 create JButton
	// -------------------------------------------------- books
	JButton addButtonBooks = new JButton("Add");
	JButton deleteButtonBooks = new JButton("Delete");
	JButton editButtonBooks = new JButton("Edit");
	JButton searchButtonBooks = new JButton("Seacrh");
	JButton restartButtonBooks = new JButton("Restart");
	JComboBox<String> comboBoxBooks = new JComboBox<String>();
	// -------------------------------------------------- readers
	JButton addButtonReaders = new JButton("Add");
	JButton deleteButtonReaders = new JButton("Delete");
	JButton editButtonReaders = new JButton("Edit");
	JButton searchButtonReaders = new JButton("Seacrh");
	JButton restartButtonReaders = new JButton("Restart");
	JComboBox<String> comboBoxReaders = new JComboBox<String>();
	// -------------------------------------------------- info
	JButton addButtonInfo = new JButton("Add");
	JButton deleteButtonInfo = new JButton("Delete");
	JButton editButtonInfo = new JButton("Edit");
	JButton searchButtonInfo = new JButton("Seacrh");
	JButton restartButtonInfo = new JButton("Restart");
	JComboBox<String> comboBoxInfoSearch = new JComboBox<String>();
	JComboBox<String> comboBoxInfoReaders = new JComboBox<String>();
	JComboBox<String> comboBoxInfoBooks = new JComboBox<String>();
	// -------------------------------------------------- search
	JButton searchButton = new JButton("Seacrh");
	JComboBox<String> comboBoxSearchBooks = new JComboBox<String>();
	JComboBox<String> comboBoxSearchReaders = new JComboBox<String>();

//	 create JLabel

	// -------------------------------------------------- books
	JLabel bookNameL = new JLabel("Title: ");
	JLabel bookYearL = new JLabel("Year: ");
	JLabel bookPagesL = new JLabel("Pages: ");
	JLabel authorNameL = new JLabel("Author : ");

	// -------------------------------------------------- readers
	JLabel readersNameL = new JLabel("Name: ");
	JLabel readersAgeL = new JLabel("Age: ");
	JLabel readersAdressL = new JLabel("Adress: ");

	// -------------------------------------------------- info
	JLabel infoTakingDateL = new JLabel("Taking date(YYYY-MM-DD): ");
	JLabel infoReturnDateL = new JLabel("Return date(YYYY-MM-DD): ");
	JLabel infoCommentL = new JLabel("Comment: ");
	JLabel infoReadersL = new JLabel("Reader: ");
	JLabel infoBooksL = new JLabel("Book: ");

//	 create JTextField
	// -------------------------------------------------- books
	JTextField bookNameTF = new JTextField();
	JTextField bookYearTF = new JTextField();
	JTextField bookPagesTF = new JTextField();
	JTextField authorNameTF = new JTextField();
	// -------------------------------------------------- readers
	JTextField readersNameTF = new JTextField();
	JTextField readersAgeTF = new JTextField();
	JTextField readersAdressTF = new JTextField();
	// -------------------------------------------------- info
	JTextField infoTakingDateTF = new JTextField();
	JTextField infoReturnDateTF = new JTextField();
	JTextField infoCommentTF = new JTextField();
	JTextField infoReadersTF = new JTextField();
	JTextField infoBooksTF = new JTextField();

//	 add clearPane
	public void clearBooksPane() {
		bookNameTF.setText("");
		bookYearTF.setText("");
		bookPagesTF.setText("");
		authorNameTF.setText("");
	}

	// -------------------------------------------------- readers
	public void clearReadersPane() {
		readersNameTF.setText("");
		readersAgeTF.setText("");
		readersAdressTF.setText("");
	}

	// -------------------------------------------------- info
	public void clearInfoPane() {
		infoTakingDateTF.setText("");
		infoReturnDateTF.setText("");
		infoCommentTF.setText("");
		infoReadersTF.setText("");
		infoBooksTF.setText("");
	}

	public MainFrame() {
//		 Options
		this.setSize(700, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//       add JTabbedPane
		tab.add(booksPanel, "Books");
		tab.add(readersPanel, "Readers");
		tab.add(infoPanel, "Info");
		tab.add(searchPanel, "Search");

//		 upPanel
		// -------------------------------------------------- books
		upPanelBooks.add(addButtonBooks);
		upPanelBooks.add(deleteButtonBooks);
		upPanelBooks.add(editButtonBooks);
		upPanelBooks.add(searchButtonBooks);
		upPanelBooks.add(restartButtonBooks);
		upPanelBooks.add(comboBoxBooks);

		// -------------------------------------------------- readers

		upPanelReaders.add(addButtonReaders);
		upPanelReaders.add(deleteButtonReaders);
		upPanelReaders.add(editButtonReaders);
		upPanelReaders.add(searchButtonReaders);
		upPanelReaders.add(restartButtonReaders);
		upPanelReaders.add(comboBoxReaders);

		// -------------------------------------------------- info
		upPanelInfo.add(addButtonInfo);
		upPanelInfo.add(deleteButtonInfo);
		upPanelInfo.add(editButtonInfo);
		upPanelInfo.add(searchButtonInfo);
		upPanelInfo.add(restartButtonInfo);
		upPanelInfo.add(comboBoxInfoSearch);

		// -------------------------------------------------- search
		upPanelSearch.add(searchButton);
		upPanelSearch.add(comboBoxSearchBooks);
		upPanelSearch.add(comboBoxSearchReaders);

		this.add(tab);

//		 middlePanel

		// -------------------------------------------------- books

		middlePanelBooks.setLayout(new GridLayout(4, 1));
		middlePanelBooks.add(bookNameL);
		middlePanelBooks.add(bookNameTF);
		middlePanelBooks.add(authorNameL);
		middlePanelBooks.add(authorNameTF);
		middlePanelBooks.add(bookPagesL);
		middlePanelBooks.add(bookPagesTF);
		middlePanelBooks.add(bookYearL);
		middlePanelBooks.add(bookYearTF);

		// -------------------------------------------------- readers
		middlePanelReaders.setLayout(new GridLayout(3, 1));
		middlePanelReaders.add(readersNameL);
		middlePanelReaders.add(readersNameTF);
		middlePanelReaders.add(readersAgeL);
		middlePanelReaders.add(readersAgeTF);
		middlePanelReaders.add(readersAdressL);
		middlePanelReaders.add(readersAdressTF);

		// -------------------------------------------------- info
		middlePanelInfo.setLayout(new GridLayout(5, 1, 10, 10));
		middlePanelInfo.add(infoReadersL);
		middlePanelInfo.add(infoBooksL);
		middlePanelInfo.add(comboBoxInfoReaders);
		middlePanelInfo.add(comboBoxInfoBooks);
		middlePanelInfo.add(infoTakingDateL);
		middlePanelInfo.add(infoTakingDateTF);
		middlePanelInfo.add(infoReturnDateL);
		middlePanelInfo.add(infoReturnDateTF);
		middlePanelInfo.add(infoCommentL);
		middlePanelInfo.add(infoCommentTF);
		DBHelper.fillCombo(comboBoxInfoReaders, "READERSNAME", "READERS");
		DBHelper.fillCombo(comboBoxInfoBooks, "BOOKNAME", "BOOKS");

		// -------------------------------------------------- search
		DBHelper.fillCombo(comboBoxSearchReaders, "READERSNAME", "READERS");
		DBHelper.fillCombo(comboBoxSearchBooks, "BOOKNAME", "BOOKS");

//		  downPanel

		// -------------------------------------------------- books
		downPanelBooks.add(booksScrollPane);
		booksScrollPane.setPreferredSize(new Dimension(600, 100));
		booksTable.setModel(DBHelper.getAllData("BOOKS"));
		booksTable.addMouseListener(new BooksTableListener());

		// -------------------------------------------------- readers
		downPanelReaders.add(readersScrollPane);
		readersScrollPane.setPreferredSize(new Dimension(600, 100));
		readersTable.setModel(DBHelper.getAllData("READERS"));
		readersTable.addMouseListener(new ReadersTableListener());

		// -------------------------------------------------- info
		downPanelInfo.add(infoScrollPane);
		infoScrollPane.setPreferredSize(new Dimension());
		infoTable.setModel(DBHelper.getAllDataInfo());
		infoTable.addMouseListener(new InfoTableListener());

		// -------------------------------------------------- search

		downPanelSearch.add(searchScrollPane);
		searchScrollPane.setPreferredSize(new Dimension(600, 100));
		searchTable.setModel(DBHelper.getAllDataInfo());

//		 booksPanelPane
		booksPanel.setLayout(new GridLayout(3, 1));
		booksPanel.setSize(700, 600);
		booksPanel.add(upPanelBooks);
		booksPanel.add(middlePanelBooks);
		booksPanel.add(downPanelBooks);
//		 readersPanelPane
		readersPanel.setLayout(new GridLayout(3, 1));
		readersPanel.setSize(700, 600);
		readersPanel.add(upPanelReaders);
		readersPanel.add(middlePanelReaders);
		readersPanel.add(readersScrollPane);
//		 infoPanelPane
		infoPanel.setLayout(new GridLayout(3, 1));
		infoPanel.setSize(700, 600);
		infoPanel.add(upPanelInfo);
		infoPanel.add(middlePanelInfo);
		infoPanel.add(infoScrollPane);
//       searchPanelPane
		searchPanel.setLayout(new GridLayout(3, 1));
		searchPanel.setSize(700, 600);
		searchPanel.add(upPanelSearch);
		searchPanel.add(searchScrollPane);

//		ButtonAddListener
		// -------------------------------------------------- addBooks
		addButtonBooks.addActionListener(new AddBooksAction());
		restartButtonBooks.addActionListener(new RestartActionBooks());

		// -------------------------------------------------- addReaders
		addButtonReaders.addActionListener(new AddReadersAction());
		restartButtonReaders.addActionListener(new RestartActionReaders());

		// -------------------------------------------------- addInfo
		addButtonInfo.addActionListener(new AddInfoAction());
		restartButtonInfo.addActionListener(new RestartActionInfo());

		// -------------------------------------------------- search
		searchButtonBooks.addActionListener(new SearchActionBooks());
		searchButtonReaders.addActionListener(new SearchActionReaders());
		searchButtonInfo.addActionListener(new SearchActionInfo());
		searchButton.addActionListener(new SearchAction());

		// -------------------------------------------------- books
		DBHelper.fillCombo(comboBoxBooks, "BOOKNAME", "BOOKS");
		// -------------------------------------------------- readers
		DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");
		// -------------------------------------------------- info
		DBHelper.fillComboInfo(comboBoxInfoSearch);

//		ButtonDeleteListener

		deleteButtonBooks.addActionListener(new DeleteBooksAction());

		deleteButtonReaders.addActionListener(new DeleteReadersAction());

		deleteButtonInfo.addActionListener(new DeleteInfoAction());

//		EditButtonListener

		editButtonBooks.addActionListener(new EditActionBooks());

		editButtonReaders.addActionListener(new EditActionReaders());

		editButtonInfo.addActionListener(new EditActionInfo());

		this.setVisible(true);
	}

	class AddBooksAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String bookName = bookNameTF.getText();
			int bookPages;
			try {
				bookPages = Integer.parseInt(bookPagesTF.getText());
			} catch (Exception ex) {
				bookPagesTF.setText("Invalid quantity page!");
				return;
			}
			int bookYear;
			try {
				bookYear = Integer.parseInt(bookYearTF.getText());
			} catch (Exception ex) {
				bookYearTF.setText("Invalid year!");
				return;
			}
			String authorName = authorNameTF.getText();
			// connect
			conn = DBHelper.getConnection();
			try {
				state = conn.prepareStatement("INSERT INTO BOOKS VALUES (NULL,?,?,?,?);");
				state.setString(1, bookName);
				state.setInt(2, bookYear);
				state.setInt(3, bookPages);
				state.setString(4, authorName);
				state.execute();
				booksTable.setModel(DBHelper.getAllData("BOOKS"));
				DBHelper.fillCombo(comboBoxInfoBooks, "BOOKNAME", "BOOKS");
				DBHelper.fillCombo(comboBoxBooks, "BOOKNAME", "BOOKS");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				bookYearTF.setText("Invalid year!");
				return;
//				e.printStackTrace();
			}
			clearBooksPane();
		}

	}// end AddBooksAction

	class AddReadersAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String readersName = readersNameTF.getText();
			byte readersAge;
			try {
				readersAge = Byte.parseByte(readersAgeTF.getText());
			} catch (Exception ex) {
				readersAgeTF.setText("Invalid age!");
				return;
			}

			String readersAdress = readersAdressTF.getText();
			conn = DBHelper.getConnection();
			try {
				state = conn.prepareStatement("INSERT INTO READERS VALUES (NULL,?,?,?);");
				state.setString(1, readersName);
				state.setInt(2, readersAge);
				state.setString(3, readersAdress);
				state.execute();
				readersTable.setModel(DBHelper.getAllData("READERS"));
				DBHelper.fillCombo(comboBoxInfoReaders, "READERSNAME", "READERS");
				DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				readersAgeTF.setText("Invalid age!");
				return;
			}
			clearReadersPane();
		}
	}// end AddReadersAction

	class AddInfoAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String infoTakingDate = infoTakingDateTF.getText();
//			String infoReturnDate = infoReturnDateTF.getText();
			String infoComment = infoCommentTF.getText();

			String readers = comboBoxInfoReaders.getSelectedItem().toString();
			String books = comboBoxInfoBooks.getSelectedItem().toString();
			String[] contentReaders = readers.split(" ");
			String[] contentBooks = books.split(" ");
			int infoReaders = Integer.parseInt(contentReaders[0]);
			int infoBooks = Integer.parseInt(contentBooks[0]);

			conn = DBHelper.getConnection();
			try {
				state = conn.prepareStatement("INSERT INTO INFO VALUES (NULL,?,NULL,?,?,?);");
				state.setString(1, infoTakingDate);
				state.setString(2, infoComment);
				state.setInt(3, infoReaders);
				state.setInt(4, infoBooks);
				state.execute();
				infoTable.setModel(DBHelper.getAllDataInfo());
				DBHelper.fillCombo(comboBoxInfoSearch, "READERSNAME", "READERS");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				infoTakingDateTF.setText("Wrong date!");
//				return;
				e.printStackTrace();
			}

			clearInfoPane();
		}
	}// end AddInfoAction

	class DeleteBooksAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "DELETE FROM BOOKS WHERE ID=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				booksTable.setModel(DBHelper.getAllData("BOOKS"));
				DBHelper.fillCombo(comboBoxInfoBooks, "BOOKNAME", "BOOKS");
				DBHelper.fillCombo(comboBoxBooks, "BOOKNAME", "BOOKS");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}// end DeleteBooksAction

	class DeleteReadersAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "DELETE FROM READERS WHERE ID=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				readersTable.setModel(DBHelper.getAllData("READERS"));
				DBHelper.fillCombo(comboBoxInfoReaders, "READERSNAME", "READERS");
				DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}// end DeleteReadersAction

	class DeleteInfoAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "DELETE FROM INFO WHERE ID=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				infoTable.setModel(DBHelper.getAllDataInfo());
				DBHelper.fillCombo(comboBoxInfoSearch, "READERSNAME", "READERS");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}// end DeleteInfoAction

	class RestartActionBooks implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();

			String sql = "SELECT * FROM BOOKS";

			try {
				state = conn.prepareStatement(sql);
				state.execute();
				booksTable.setModel(DBHelper.getAllData("BOOKS"));

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearBooksPane();
		}
	}

	class RestartActionReaders implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();

			String sql = "SELECT * FROM READERS";

			try {
				state = conn.prepareStatement(sql);
				state.execute();
				readersTable.setModel(DBHelper.getAllData("READERS"));

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearReadersPane();
		}
	}

	class RestartActionInfo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();

			String sql = "SELECT * FROM INFO";

			try {
				state = conn.prepareStatement(sql);
				state.execute();
				infoTable.setModel(DBHelper.getAllDataInfo());

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearInfoPane();
		}
	}

	class SearchActionBooks implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String item = comboBoxBooks.getSelectedItem().toString();
			String[] content = item.split(" ");
			int personId = Integer.parseInt(content[0]);

			conn = DBHelper.getConnection();
			String sql = "SELECT * FROM BOOKS WHERE id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, personId);
				result = state.executeQuery();
				booksTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class SearchActionReaders implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String item = comboBoxReaders.getSelectedItem().toString();
			String[] content = item.split(" ");
			int readersId = Integer.parseInt(content[0]);

			conn = DBHelper.getConnection();
			String sql = "SELECT * FROM READERS WHERE id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, readersId);
				result = state.executeQuery();
				readersTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	class SearchActionInfo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String item = comboBoxInfoSearch.getSelectedItem().toString();
			String[] content = item.split(" ");
			int infoId = Integer.parseInt(content[0]);

			conn = DBHelper.getConnection();
			String sql = "SELECT INFO.ID, INFO.TAKINGDATE, INFO.RETURNDATE, INFO.COMMENT, READERS.READERSNAME, BOOKS.BOOKNAME FROM INFO, READERS, BOOKS "
					+ "WHERE INFO.READERSID = READERS.ID AND INFO.BOOKSID = BOOKS.ID AND INFO.ID=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, infoId);
				result = state.executeQuery();
				infoTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	class SearchAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String booksItem = comboBoxSearchBooks.getSelectedItem().toString();
            String [] booksContent = booksItem.split(" ");
            int booksId = Integer.parseInt(booksContent[0]);

            String readersItem = comboBoxSearchReaders.getSelectedItem().toString();
            String [] readersContent = readersItem.split(" ");
            int readersId = Integer.parseInt(readersContent[0]);

			conn = DBHelper.getConnection();
			String sql = "SELECT INFO.ID, INFO.TAKINGDATE, INFO.RETURNDATE, INFO.COMMENT, READERS.READERSNAME, BOOKS.BOOKNAME FROM INFO, READERS, BOOKS "
					+ "WHERE INFO.READERSID = READERS.ID AND INFO.BOOKSID = BOOKS.ID AND BOOKS.ID=? AND READERS.ID =?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, booksId);
				state.setInt(2, readersId);
				result = state.executeQuery();
				searchTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	class EditActionBooks implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "UPDATE BOOKS SET BOOKNAME = '" + bookNameTF.getText() + "', BOOKYEAR = '"
					+ bookYearTF.getText() + "', BOOKPAGES = '" + bookPagesTF.getText() + "', AUTHOR = '"
					+ authorNameTF.getText() + "'  WHERE ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				id = -1;
				booksTable.setModel(DBHelper.getAllData("BOOKS"));
				DBHelper.fillCombo(comboBoxInfoBooks, "BOOKNAME", "BOOKS");
				DBHelper.fillCombo(comboBoxBooks, "BOOKNAME", "BOOKS");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearBooksPane();
		}
	}

	class EditActionReaders implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "UPDATE READERS SET READERSNAME = '" + readersNameTF.getText() + "', READERSAGE = '"
					+ readersAgeTF.getText() + "', READERSADRESS = '" + readersAdressTF.getText() + "'  WHERE ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				id = -1;
				readersTable.setModel(DBHelper.getAllData("READERS"));
				DBHelper.fillCombo(comboBoxInfoReaders, "READERSNAME", "READERS");
				DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearReadersPane();
		}
	}

	class EditActionInfo implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			int row = infoTable.getSelectedRow();
			id = Integer.parseInt(infoTable.getValueAt(row, 0).toString());
			
			String selectedItemReaders = comboBoxInfoReaders.getSelectedItem().toString();
			String[] itemsReaders = selectedItemReaders.split(" ");
			int itemReadersID = Integer.parseInt(itemsReaders[0]);

			String selectedItemBooks = comboBoxInfoBooks.getSelectedItem().toString();
			String[] itemsBooks = selectedItemBooks.split(" ");
			int itemBooksID = Integer.parseInt(itemsBooks[0]);			
				
			String takingDate = infoTable.getValueAt(row, 1).toString();
//			String takingDate = infoTakingDateTF.getText();
//			String returnDate = infoTable.getValueAt(row, 2).toString();
			String returnDate = infoReturnDateTF.getText();

			
			SimpleDateFormat takingDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat returnDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date takingDateParse = null;
			Date returnDateParse = null;
			
			try {
				takingDateParse =  takingDateFormatter.parse(takingDate);
				returnDateParse =  returnDateFormatter.parse(returnDate);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			long differenceDate = returnDateParse.getTime() - takingDateParse.getTime();

			long differenceInDays = (differenceDate / (1000 * 60 * 60 * 24)) % 365;
			
			
			if (differenceInDays > 30) {
				infoCommentTF.setText("Returned with a delay!");
			}
			
			String sql = "UPDATE INFO SET TAKINGDATE = '" + infoTakingDateTF.getText() + "', RETURNDATE = '"
					+ infoReturnDateTF.getText() + "', COMMENT = '" + infoCommentTF.getText() + "', READERSID = "
					+ itemReadersID + ", BOOKSID = " + itemBooksID + "  WHERE ID=?;";
			try {

				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				id = -1;
				infoTable.setModel(DBHelper.getAllDataInfo());
				DBHelper.fillCombo(comboBoxInfoReaders, "READERSNAME", "READERS");
				DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearInfoPane();
		}
	}

	class BooksTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = booksTable.getSelectedRow();
			id = Integer.parseInt(booksTable.getValueAt(row, 0).toString());
			if (e.getClickCount() == 2) {

				bookNameTF.setText(booksTable.getValueAt(row, 1).toString());
				bookYearTF.setText(booksTable.getValueAt(row, 2).toString());
				bookPagesTF.setText(booksTable.getValueAt(row, 3).toString());
				authorNameTF.setText(booksTable.getValueAt(row, 4).toString());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class ReadersTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = readersTable.getSelectedRow();
			id = Integer.parseInt(readersTable.getValueAt(row, 0).toString());
			if (e.getClickCount() == 2) {

				readersNameTF.setText(readersTable.getValueAt(row, 1).toString());
				readersAgeTF.setText(readersTable.getValueAt(row, 2).toString());
				readersAdressTF.setText(readersTable.getValueAt(row, 3).toString());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class InfoTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = infoTable.getSelectedRow();
			id = Integer.parseInt(infoTable.getValueAt(row, 0).toString());
			
			if (e.getClickCount() == 2) {				
				
				infoTakingDateTF.setText(infoTable.getValueAt(row, 1).toString());
				try {
					infoReturnDateTF.setText(infoTable.getValueAt(row, 2).toString());
				} catch (NullPointerException e1) {
					infoReturnDateTF.setText("Haven't return date");
				}

				infoCommentTF.setText(infoTable.getValueAt(row, 3).toString());
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}// end class MainFrames
