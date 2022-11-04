package ver01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import ver01.controller.PosDaoImpl;
import ver01.model.MenuBtn;
import ver01.model.Table;
import ver01.view.ShowTableDetail.onTableInsertListener;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

import static ver01.model.Table.TableInfo.*;


public class PosMain extends JFrame implements onTableInsertListener{

    private static final String[] TABLE_COL= {"영수번호", "테이블번호", "영업일자", "입장시각"};
    
    private JFrame frame;
    private Table table;
    private JTextField textSdate;
    private DefaultTableModel model;
    
    private PosDaoImpl dao;
    
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PosMain window = new PosMain();
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
    public PosMain() {
        dao= dao.getInstance();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Main");
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((windowSize.width-800)/2, (windowSize.height-600)/2, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame.getContentPane().setLayout(null);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(12, 60, 760, 420);
        frame.getContentPane().add(tablePanel);
        tablePanel.setLayout(new GridLayout(2, 5, 12, 12));
        
        JButton btnTable01 = new JButton();
        btnTable01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table1= new Table(1, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table1, PosMain.this);
                insertTable(table1);
            }
        });
        btnTable01.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnTable01.setText("Table 01");
        tablePanel.add(btnTable01);
        
        JButton btnTable02 = new JButton("Table 02");
        btnTable02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table2= new Table(2, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table2, PosMain.this);
                insertTable(table2);
            }
        });
        btnTable02.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        tablePanel.add(btnTable02);
        
        JButton btnTable03 = new JButton("Table 03");
        btnTable03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table3= new Table(3, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table3, PosMain.this);
                insertTable(table3);
            }
        });
        btnTable03.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        tablePanel.add(btnTable03);
        
        JButton btnTable04 = new JButton("Table 04");
        btnTable04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table4= new Table(4, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table4, PosMain.this);
                insertTable(table4);
            }
        });
        btnTable04.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        tablePanel.add(btnTable04);
        
        JButton btnTable05 = new JButton("Table 05");
        btnTable05.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table5= new Table(5, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table5, PosMain.this);
                insertTable(table5);
            }
        });
        btnTable05.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        tablePanel.add(btnTable05);
        
        JButton btnTable06 = new JButton("Table 06");
        btnTable06.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table6= new Table(6, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table6, PosMain.this);
                insertTable(table6);
            }
        });
        btnTable06.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        tablePanel.add(btnTable06);
        
        JButton btnTable07 = new JButton("Table 07");
        btnTable07.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table7= new Table(7, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table7, PosMain.this);
                insertTable(table7);
            }
        });
        btnTable07.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        tablePanel.add(btnTable07);
        
        JButton btnTable08 = new JButton("Table 08");
        btnTable08.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table8= new Table(8, ymde.format(sDate));
                ShowTableDetail.newShowTableDetail(table8, PosMain.this);
                insertTable(table8);
            }
        });
        btnTable08.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        tablePanel.add(btnTable08);
        
        JPanel btnPanel = new JPanel();
        btnPanel.setBounds(12, 492, 760, 58);
        frame.getContentPane().add(btnPanel);
        
        JButton btnSalesManagement = new JButton("판매관리");
        btnSalesManagement.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnSalesManagement.setBounds(335, 0, 89, 58);
        btnSalesManagement.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        	    SalesManagement.newSalesManagement();
        	}
        });
        btnPanel.setLayout(null);
        btnPanel.add(btnSalesManagement);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 12, 760, 36);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 374, 36);
        panel.add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(386, 0, 374, 36);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblSdate = new JLabel("영업일자");
        lblSdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblSdate.setBounds(6, 0, 52, 36);
        panel_2.add(lblSdate);
        
        textSdate = new JTextField();
        textSdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textSdate.setText(ymde.format(sDate)); // 영업일자
        textSdate.setEditable(false);
        textSdate.setColumns(10);
        textSdate.setBounds(58, 0, 124, 36);
        panel_2.add(textSdate);
    }

    protected void insertTable(Table table) {
        Integer tNo= table.gettNo();
        String sDate= table.getsDate();
        table= new Table(tNo, sDate);
        
        dao.insertTable(table);
    }

    protected void initializeTableInfo() {
        model= new DefaultTableModel(null, TABLE_COL);
        
    } 

    @Override
    public void onTableInserted() {
        initializeTableInfo();
        
    }
}

