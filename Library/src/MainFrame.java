import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private Connection conn = null;
	private PreparedStatement state = null;
	int id = -1;

//   create JTabbedPane
	JTabbedPane tab = new JTabbedPane();

//	 create JTable
	JTable booksTable = new JTable();
	JTable readersTable = new JTable();
	JTable infoTable = new JTable();

//	 create JScrollPane
	JScrollPane booksScrollPane = new JScrollPane(booksTable);
	JScrollPane readersScrollPane = new JScrollPane(readersTable);
	JScrollPane infoScrollPane = new JScrollPane(infoTable);

//	 create JPanel
	// -------------------------------------------------- books
	JPanel upPanelBooks = new JPanel();
	JPanel upPanelReaders = new JPanel();
	JPanel upPanelInfo = new JPanel();
	// -------------------------------------------------- readers
	JPanel middlePanelBooks = new JPanel();
	JPanel middlePanelReaders = new JPanel();
	JPanel middlePanelInfo = new JPanel();
	// -------------------------------------------------- info
	JPanel downPanelBooks = new JPanel();
	JPanel downPanelReaders = new JPanel();
	JPanel downPanelInfo = new JPanel();

	JPanel booksPanel = new JPanel();
	JPanel readersPanel = new JPanel();
	JPanel infoPanel = new JPanel();

//	 create JButton
	// -------------------------------------------------- books
	JButton addButtonBooks = new JButton("Add");
	JButton deleteButtonBooks = new JButton("Delete");
	JButton editButtonBooks = new JButton("Edit");
	JButton searchButtonBooks = new JButton("Search");
	// -------------------------------------------------- readers
	JButton addButtonReaders = new JButton("Add");
	JButton deleteButtonReaders = new JButton("Delete");
	JButton editButtonReaders = new JButton("Edit");
	JButton searchButtonReaders = new JButton("Search");
	// -------------------------------------------------- info
	JButton addButtonInfo = new JButton("Add");
	JButton deleteButtonInfo = new JButton("Delete");
	JButton editButtonInfo = new JButton("Edit");
	JButton searchButtonInfo = new JButton("Search");

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
	JLabel infoTakingDateL = new JLabel("Taking date: ");
	JLabel infoReturnDateL = new JLabel("Return date: ");
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
	public void clearBookPane() {
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

//		 upPanel
		// -------------------------------------------------- books
		upPanelBooks.add(addButtonBooks);
		upPanelBooks.add(deleteButtonBooks);
		upPanelBooks.add(editButtonBooks);
		upPanelBooks.add(searchButtonBooks);

		// -------------------------------------------------- readers

		upPanelReaders.add(addButtonReaders);
		upPanelReaders.add(deleteButtonReaders);
		upPanelReaders.add(editButtonReaders);
		upPanelReaders.add(searchButtonReaders);

		// -------------------------------------------------- info
		upPanelInfo.add(addButtonInfo);
		upPanelInfo.add(deleteButtonInfo);
		upPanelInfo.add(editButtonInfo);
		upPanelInfo.add(searchButtonInfo);
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
		middlePanelInfo.setLayout(new GridLayout(5, 1));
		middlePanelInfo.add(infoReadersL);
		middlePanelInfo.add(infoReadersTF);
		middlePanelInfo.add(infoBooksL);
		middlePanelInfo.add(infoBooksTF);
		middlePanelInfo.add(infoTakingDateL);
		middlePanelInfo.add(infoTakingDateTF);
		middlePanelInfo.add(infoReturnDateL);
		middlePanelInfo.add(infoReturnDateTF);
		middlePanelInfo.add(infoCommentL);
		middlePanelInfo.add(infoCommentTF);

//		  downPanel

		// -------------------------------------------------- books
		downPanelBooks.add(booksScrollPane);
		booksScrollPane.setPreferredSize(new Dimension(600, 100));
		booksTable.setModel(DBHelper.getAllData("BOOKS"));
		booksTable.addMouseListener(new booksTableListener());

		// -------------------------------------------------- readers
		downPanelReaders.add(readersScrollPane);
		readersScrollPane.setPreferredSize(new Dimension(600, 100));
		readersTable.setModel(DBHelper.getAllData("READERS"));
		readersTable.addMouseListener(new readersTableListener());

		// -------------------------------------------------- info
		downPanelInfo.add(infoScrollPane);
		infoScrollPane.setPreferredSize(new Dimension());
		infoTable.setModel(DBHelper.getAllData("INFO"));
		infoTable.addMouseListener(new infoTableListener());

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

//		ButtonActionListener
		// -------------------------------------------------- addBooks
		addButtonBooks.addActionListener(new AddBooksAction());
		// -------------------------------------------------- addReaders
		addButtonReaders.addActionListener(new AddReadersAction());
		// -------------------------------------------------- addInfo
		addButtonInfo.addActionListener(new AddInfoAction());
		
//		ButtonDeleteListener
		
		deleteButtonBooks.addActionListener(new DeleteBooksAction());
		
		deleteButtonReaders.addActionListener(new DeleteReadersAction());

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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearBookPane();
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearReadersPane();
		}
	}// end AddReadersAction

	class AddInfoAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String infoTakingDate = infoTakingDateTF.getText();
			String infoReturnDate = infoReturnDateTF.getText();
			String infoComment = infoCommentTF.getText();
			
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
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}//end DeleteBooksAction
	
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
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}//end DeleteReadersAction

	class booksTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = booksTable.getSelectedRow();
			id = Integer.parseInt(booksTable.getValueAt(row, 0).toString());
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

	class readersTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = readersTable.getSelectedRow();
			id = Integer.parseInt(readersTable.getValueAt(row, 0).toString());
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

	class infoTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = infoTable.getSelectedRow();
			id = Integer.parseInt(infoTable.getValueAt(row, 0).toString());
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
