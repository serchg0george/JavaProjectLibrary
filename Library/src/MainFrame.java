import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private ResultSet result = null;
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
	JComboBox<String> comboBoxInfo = new JComboBox<String>();
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
		upPanelInfo.add(comboBoxInfo);

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
		booksTable.addMouseListener(new BooksTableListener());

		// -------------------------------------------------- readers
		downPanelReaders.add(readersScrollPane);
		readersScrollPane.setPreferredSize(new Dimension(600, 100));
		readersTable.setModel(DBHelper.getAllData("READERS"));
		readersTable.addMouseListener(new ReadersTableListener());

		// -------------------------------------------------- info
		downPanelInfo.add(infoScrollPane);
		infoScrollPane.setPreferredSize(new Dimension());
		infoTable.setModel(DBHelper.getAllData("INFO"));
		infoTable.addMouseListener(new InfoTableListener());

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

//		ButtonActionListener
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
//		searchButton.addActionListener(new SearchAction());
//		fillCombo
		// -------------------------------------------------- books
		DBHelper.fillCombo(comboBoxBooks, "BOOKNAME" ,"BOOKS");
		// -------------------------------------------------- readers
		DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");
		// -------------------------------------------------- info
		DBHelper.fillCombo(comboBoxInfo, "READERSID", "INFO");

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
				DBHelper.fillCombo(comboBoxBooks, "BOOKNAME" ,"BOOKS");
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
				DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");
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
				DBHelper.fillCombo(comboBoxBooks, "BOOKNAME" ,"BOOKS");
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
				DBHelper.fillCombo(comboBoxReaders, "READERSNAME", "READERS");
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}// end DeleteReadersAction

	class SearchActionBooks implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String item = comboBoxBooks.getSelectedItem().toString();
            String [] content = item.split(" ");
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
	class RestartActionBooks implements ActionListener{
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
                }
    }
	class RestartActionReaders implements ActionListener{
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
                }
    }	
	class RestartActionInfo implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
                conn = DBHelper.getConnection();

                String sql = "SELECT * FROM INFO";

                try {
                    state = conn.prepareStatement(sql);
                    state.execute();
                    infoTable.setModel(DBHelper.getAllData("INFO"));

                } catch (SQLException e1) {
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
            String [] content = item.split(" ");
            int personId = Integer.parseInt(content[0]);

            conn = DBHelper.getConnection();
            String sql = "SELECT * FROM READERS WHERE id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, personId);
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
            String item = comboBoxInfo.getSelectedItem().toString();
            String [] content = item.split(" ");
            int personId = Integer.parseInt(content[0]);

            conn = DBHelper.getConnection();
            String sql = "SELECT * FROM INFO WHERE id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, personId);
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


	class BooksTableListener implements MouseListener {

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

	class ReadersTableListener implements MouseListener {

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

	class InfoTableListener implements MouseListener {

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
