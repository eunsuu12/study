package ver01.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ver01.controller.PosDaoImpl;
import ver01.model.MenuBtn;
import ver01.model.Sold;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SalesManagement extends JFrame{
    
    
    private static final String[] MENU_COL= {"-", "메뉴명", "단가", "수량", "금액"};
    private static final String[] SALESLIST_COL= {"영수번호", "결제금액", "현금", "카드", "할인"};

    
    private PosDaoImpl dao;
    
    private JFrame frame;
    private JTable menuTable;
    private DefaultTableModel menuModel;
    private DefaultTableModel pListModel;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTable pListTable;

    /**
     * Launch the application.
     */
    public static void newSalesManagement() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SalesManagement window = new SalesManagement();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SalesManagement() {
        initialize();
        dao= PosDaoImpl.getInstance();
        initializeSoldListTable();
//        initializeMenuTableOrder();
    }
    
    private void initializeMenuTable() {
        menuModel= new DefaultTableModel(null, MENU_COL);
        menuTable.setModel(menuModel);
        // TODO
//        List<Sold> list= posDao.readMenu();
//        
//        for(Sold m: list) {
//            Object[] rowData= {m.getMenuName(), m.getUnitCost(), m.getCount(), m.getTotalCost()};
//            menuModel.addRow(rowData);
//        }
        
    }
    
    private void initializeSoldListTable() {
        pListModel= new DefaultTableModel(null, SALESLIST_COL);
        menuTable.setModel(pListModel);
        // TODO
        List<Sold> list= dao.readSalesList();
        
        for(Sold s: list) {
            Object[] rowData= {s.getsNo()}; // TODO, s.getpTotal(), s.getpCash(), s.getpCard(), s.getpDc()};
            pListModel.addRow(rowData);
        }
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((windowSize.width-800)/2, (windowSize.height-600)/2, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel Lpanel = new JPanel();
        frame.getContentPane().add(Lpanel);
        Lpanel.setLayout(null);
        
        JScrollPane scrollMenu = new JScrollPane();
        scrollMenu.setBounds(12, 60, 380, 220);
        Lpanel.add(scrollMenu);
        
        menuTable = new JTable();
        menuTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        menuModel= new DefaultTableModel(null, MENU_COL);
        menuTable.setModel(menuModel);
        scrollMenu.setViewportView(menuTable);
        
        JPanel countBtnPanel = new JPanel();
        countBtnPanel.setBounds(12, 292, 380, 40);
        Lpanel.add(countBtnPanel);
        countBtnPanel.setLayout(new GridLayout(1, 0, 12, 0));
        
        JButton btnDeleteAll = new JButton();
        btnDeleteAll.setEnabled(false);
        btnDeleteAll.setText
        ("<HTML><body>전체<br>취소</body><HTML>");
        btnDeleteAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnDeleteAll.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnDeleteAll);
        
        JButton btnDeleteSelect = new JButton();
        btnDeleteSelect.setEnabled(false);
        btnDeleteSelect.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnDeleteSelect.setText("<HTML><body >선택<br>취소</body><HTML>");
        btnDeleteSelect.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnDeleteSelect);
        
        JButton btnCountIncrease = new JButton();
        btnCountIncrease.setEnabled(false);
        btnCountIncrease.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        JButton btnDiscount = new JButton();
        btnDiscount.setEnabled(false);
        btnDiscount.setText("<HTML><body>할인<br>처리</body><HTML>");
        btnDiscount.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnDiscount);
        
        JButton btnCountDecrease = new JButton();
        btnCountDecrease.setEnabled(false);
        btnCountDecrease.setText("-");
        btnCountDecrease.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnCountDecrease);
        btnCountIncrease.setText("+");
        btnCountIncrease.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnCountIncrease);
        
        JPanel paymentPanel = new JPanel();
        paymentPanel.setBounds(12, 344, 380, 206);
        Lpanel.add(paymentPanel);
        paymentPanel.setLayout(null);
        
        JLabel lblTotal = new JLabel("총 금 액");
        lblTotal.setBounds(12, 0, 100, 31);
        lblTotal.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblTotal);
        
        textField = new JTextField();
        textField.setBounds(112, 1, 268, 31);
        textField.setEditable(false);
        textField.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        paymentPanel.add(textField);
        textField.setColumns(10);
        
        JLabel lblDiscount = new JLabel("할인금액");
        lblDiscount.setBounds(12, 43, 100, 31);
        lblDiscount.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblDiscount);
        
        textField_1 = new JTextField();
        textField_1.setBounds(112, 44, 268, 31);
        textField_1.setEditable(false);
        textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textField_1.setColumns(10);
        paymentPanel.add(textField_1);
        
        JLabel lblTotal_2 = new JLabel("받을금액");
        lblTotal_2.setBounds(12, 86, 100, 31);
        lblTotal_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblTotal_2);
        
        textField_2 = new JTextField();
        textField_2.setBounds(112, 87, 268, 31);
        textField_2.setEditable(false);
        textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textField_2.setColumns(10);
        paymentPanel.add(textField_2);
        
        JLabel lblTotal_3 = new JLabel("받은금액");
        lblTotal_3.setBounds(12, 129, 100, 31);
        lblTotal_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblTotal_3);
        
        textField_3 = new JTextField();
        textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_3.setBounds(112, 130, 268, 31);
        textField_3.setEditable(false);
        textField_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textField_3.setColumns(10);
        paymentPanel.add(textField_3);
        
        JLabel lblCharge = new JLabel("거스름돈");
        lblCharge.setBounds(12, 172, 100, 31);
        lblCharge.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblCharge);
        
        textField_4 = new JTextField();
        textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_4.setBounds(112, 173, 268, 31);
        textField_4.setEditable(false);
        textField_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textField_4.setColumns(10);
        paymentPanel.add(textField_4);
        
        JPanel tableNoPanel = new JPanel();
        tableNoPanel.setLayout(null);
        tableNoPanel.setBounds(12, 12, 380, 36);
        Lpanel.add(tableNoPanel);
        
        JLabel lblTableNo = new JLabel("테이블");
        lblTableNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblTableNo.setBounds(280, 0, 40, 36);
        tableNoPanel.add(lblTableNo);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(320, 0, 60, 36);
        tableNoPanel.add(textField_5);
        
        JPanel Rpanel = new JPanel();
        frame.getContentPane().add(Rpanel);
        Rpanel.setLayout(null);
        
        JPanel btnPanel = new JPanel();
        btnPanel.setBounds(12, 492, 368, 58);
        Rpanel.add(btnPanel);
        btnPanel.setLayout(new GridLayout(0, 4, 4, 4));
        
        JButton btnCheck = new JButton("조회");
        btnCheck.addActionListener(new ActionListener() {
        	 @Override
             public void actionPerformed(ActionEvent e) {
        	     // TODO
             }
        });
        btnCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnPanel.add(btnCheck);
        
        JButton btnReturn = new JButton("반품");
        btnReturn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnPanel.add(btnReturn);
        
        JButton btnChange = new JButton("결제변경");
        btnChange.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnPanel.add(btnChange);
        
        JPanel datePanel = new JPanel();
        datePanel.setBounds(12, 12, 368, 36);
        Rpanel.add(datePanel);
        datePanel.setLayout(new GridLayout(0, 4, 4, 4));
        
        JScrollPane scrollSalesList = new JScrollPane();
        scrollSalesList.setBounds(12, 60, 368, 420);
        Rpanel.add(scrollSalesList);
        
        pListTable = new JTable();
        scrollSalesList.setViewportView(pListTable);
        pListModel= new DefaultTableModel(null, SALESLIST_COL);
        pListTable.setModel(pListModel);
        scrollSalesList.setViewportView(pListTable);
    }

}
