package ver01.view;

import static ver01.model.Table.TableInfo.*;

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
import ver01.model.Table;
import ver01.view.PaymentCard.onPaymentCardListener;
import ver01.view.PaymentCash.onPaymentCashListener;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ShowTableDetail extends JFrame implements onPaymentCardListener, onPaymentCashListener{
    
    public interface onTableInsertListener{
        void onTableInserted();
    }
    
    
    private static final String[] MENU_COL= {"메뉴명", "단가", "수량", "금액"};

    private onTableInsertListener listener;
    private Table table;
    private PosDaoImpl dao;
    
    private JFrame frame;
    private JTable menuTable;
    private DefaultTableModel model;
    public static JTextField textTotal;
    private JTextField textDiscount;
    private JTextField textTobeReceived;
    private JTextField textReceived;
    private JTextField textCharge;
    private JTextField textTNo;
    private JTextField textStayTime;
    private JTextField textSdate;
    
    private String pCard;

    /**
     * Launch the application.
     */
    public static void newShowTableDetail(Table table, onTableInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowTableDetail window = new ShowTableDetail(table, listener);
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
    public ShowTableDetail(Table table, onTableInsertListener listener) {
        this.table= table;
        this.listener= listener;
        dao= dao.getInstance();
        initialize();
        initializeMenuTable();
        dao.setEntTime(table);
        LocalDateTime entTime;
        entTime= dao.getTableInfoEnt(table).getEntTime();
        textStayTime.setText(kkmm.format(entTime));
    }
    
    private void initializeMenuTable() {
        model= new DefaultTableModel(null, MENU_COL);
        menuTable.setModel(model);

        List<Sold> list= dao.readMenu(table);
        
        for(Sold m: list) {
            Object[] rowData= {m.getMenuName(), m.getUnitCost(), m.getCount(), m.getTotalCost()};
            model.addRow(rowData);
        }
        
        showSumTotalCost(list);
    }
    
    private void showSumTotalCost(List<Sold> list) {
        int sum = 0;
        for (Sold s : list) {
            sum += s.getTotalCost();
        }
        textTotal.setText(String.valueOf(sum));
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((windowSize.width-800)/2, (windowSize.height-600)/2, 800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel Lpanel = new JPanel();
        frame.getContentPane().add(Lpanel);
        Lpanel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 60, 380, 220);
        Lpanel.add(scrollPane);
        
        menuTable = new JTable();
        menuTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        model= new DefaultTableModel(null, MENU_COL);
        menuTable.setModel(model);
        scrollPane.setViewportView(menuTable);
        
        JPanel countBtnPanel = new JPanel();
        countBtnPanel.setBounds(12, 292, 380, 40);
        Lpanel.add(countBtnPanel);
        countBtnPanel.setLayout(new GridLayout(1, 0, 12, 0));
        
        JButton btnDeleteAll = new JButton();
        btnDeleteAll.setText("<HTML><body>전체<br>취소</body><HTML>");
        btnDeleteAll.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        	    deleteMenuBtnAll();
        	}
        });
        btnDeleteAll.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnDeleteAll);
        
        JButton btnDeleteSelect = new JButton();
        btnDeleteSelect.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        	    deleteMenuBtnSelected();
        	}
        });
        btnDeleteSelect.setText("<HTML><body >선택<br>취소</body><HTML>");
        btnDeleteSelect.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnDeleteSelect);
        
        JButton btnCountIncrease = new JButton();
        btnCountIncrease.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        	    insertMenuBtnOneOfSelected();
        	}
        });
        
        JButton btnDiscount = new JButton();
        btnDiscount.setText("<HTML><body>할인<br>처리</body><HTML>");
        btnDiscount.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        countBtnPanel.add(btnDiscount);
        
        JButton btnCountDecrease = new JButton();
        btnCountDecrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMenuBtnOneOfSelected();
            }
        });
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
        
        textTotal = new JTextField();
        textTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        textTotal.setBounds(112, 1, 268, 31);
        textTotal.setEditable(false);
        // TODO
        textTotal.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        paymentPanel.add(textTotal);
        textTotal.setColumns(10);
        
        JLabel lblDiscount = new JLabel("할인금액");
        lblDiscount.setBounds(12, 43, 100, 31);
        lblDiscount.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblDiscount);
        
        textDiscount = new JTextField();
        textDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
        textDiscount.setBounds(112, 44, 268, 31);
        textDiscount.setEditable(false);
        textDiscount.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textDiscount.setColumns(10);
        textDiscount.setText("0");
        paymentPanel.add(textDiscount);
        
        JLabel lblTobeReceived = new JLabel("받을금액");
        lblTobeReceived.setBounds(12, 86, 100, 31);
        lblTobeReceived.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblTobeReceived);
        
        textTobeReceived = new JTextField();
        textTobeReceived.setHorizontalAlignment(SwingConstants.RIGHT);
        textTobeReceived.setBounds(112, 87, 268, 31);
        textTobeReceived.setEditable(false);
        textTobeReceived.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textTobeReceived.setColumns(10);
        textTobeReceived.setText("0");
        paymentPanel.add(textTobeReceived);
        
        JLabel lblReceived = new JLabel("받은금액");
        lblReceived.setBounds(12, 129, 100, 31);
        lblReceived.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblReceived);
        
        textReceived = new JTextField();
        textReceived.setHorizontalAlignment(SwingConstants.RIGHT);
        textReceived.setBounds(112, 130, 268, 31);
        textReceived.setEditable(false);
        textReceived.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textReceived.setColumns(10);
        textReceived.setText("0");
        paymentPanel.add(textReceived);
        
        JLabel lblCharge = new JLabel("거스름돈");
        lblCharge.setBounds(12, 172, 100, 31);
        lblCharge.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        paymentPanel.add(lblCharge);
        
        textCharge = new JTextField();
        textCharge.setHorizontalAlignment(SwingConstants.RIGHT);
        textCharge.setBounds(112, 173, 268, 31);
        textCharge.setEditable(false);
        textCharge.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        textCharge.setColumns(10);
        textCharge.setText("0");
        paymentPanel.add(textCharge);
        
        JPanel tableNoPanel = new JPanel();
        tableNoPanel.setLayout(null);
        tableNoPanel.setBounds(12, 12, 380, 36);
        Lpanel.add(tableNoPanel);
        
        JLabel lblTableNo = new JLabel("테이블");
        lblTableNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblTableNo.setBounds(280, 0, 40, 36);
        tableNoPanel.add(lblTableNo);
        
        textTNo = new JTextField();
        textTNo.setText(String.valueOf(table.gettNo()));
        textTNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textTNo.setEditable(false);
        textTNo.setColumns(10);
        textTNo.setBounds(320, 0, 60, 36);
        tableNoPanel.add(textTNo);
        
        JPanel Rpanel = new JPanel();
        frame.getContentPane().add(Rpanel);
        Rpanel.setLayout(null);
        
        JPanel menuBtnPanel = new JPanel();
        menuBtnPanel.setBounds(12, 60, 368, 420);
        Rpanel.add(menuBtnPanel);
        menuBtnPanel.setLayout(new GridLayout(0, 4, 4, 4));
        
        JButton btnMenu1 = new JButton("<HTML><body style='text-align:center'>메뉴1<br>44,000</body><HTML>");
        btnMenu1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn1(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu1);
        
        JButton btnMenu2 = new JButton("<HTML><body style='text-align:center'>메뉴2<br>27,000</body><HTML>");
        btnMenu2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn2(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu2);
        
        JButton btnMenu3 = new JButton("<HTML><body style='text-align:center'>메뉴3<br>32,000</body><HTML>");
        btnMenu3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn3(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu3);
        
        JButton btnMenu4 = new JButton("<HTML><body style='text-align:center'>메뉴4<br>8,000</body><HTML>");
        btnMenu4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn4(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu4);
        
        JButton btnMenu5 = new JButton("<HTML><body style='text-align:center'>메뉴5<br>5,500</body><HTML>");
        btnMenu5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn5(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu5);
        
        JButton btnMenu6 = new JButton("<HTML><body style='text-align:center'>메뉴6<br>18,000</body><HTML>");
        btnMenu6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn6(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu6);
        
        JButton btnMenu7 = new JButton("<HTML><body style='text-align:center'>메뉴7<br>15,000</body><HTML>");
        btnMenu7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn7(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu7);
        
        JButton btnMenu8 = new JButton("<HTML><body style='text-align:center'>메뉴8<br>8,500</body><HTML>");
        btnMenu8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn8(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu8);
        
        JButton btnMenu9 = new JButton("<HTML><body style='text-align:center'>메뉴9<br>7,500</body><HTML>");
        btnMenu9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn9(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu9);
        
        JButton btnMenu10 = new JButton("<HTML><body style='text-align:center'>메뉴10<br>30,000</body><HTML>");
        btnMenu10.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn10(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu10);
        
        JButton btnMenu11 = new JButton("<HTML><body style='text-align:center'>메뉴11<br>5,500</body><HTML>");
        btnMenu11.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn11(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu11);
        
        JButton btnMenu12 = new JButton("<HTML><body style='text-align:center'>메뉴12<br>18,000</body><HTML>");
        btnMenu12.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn12(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu12);
        
        JButton btnMenu13 = new JButton("<HTML><body style='text-align:center'>메뉴13<br>15,000</body><HTML>");
        btnMenu13.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn13(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu13);
        
        JButton btnMenu14 = new JButton("<HTML><body style='text-align:center'>메뉴14<br>8,500</body><HTML>");
        btnMenu14.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnMenu14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.insertMenuBtn14(table);
                initializeMenuTable();
            }
        });
        menuBtnPanel.add(btnMenu14);
        
        JPanel btnPanel = new JPanel();
        btnPanel.setBounds(12, 492, 368, 58);
        Rpanel.add(btnPanel);
        btnPanel.setLayout(new GridLayout(0, 4, 4, 4));
        
        JButton btnOrder = new JButton("주문");
        btnOrder.addActionListener(new ActionListener() {
        	 @Override
             public void actionPerformed(ActionEvent e) {
                 dao.setpTotal(table);
                 frame.dispose();
             }
        });
        btnOrder.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnPanel.add(btnOrder);
        
        JButton btnCard = new JButton("카드");
        btnCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PaymentCard.newPaymentCard(frame, ShowTableDetail.this);
            }
        });
        btnCard.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnPanel.add(btnCard);
        
        JButton btnCash = new JButton("현금");
        btnCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PaymentCash.newPaymentCash(frame, ShowTableDetail.this);
            }
        });
        btnCash.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        btnPanel.add(btnCash);
        
        JPanel datePanel = new JPanel();
        datePanel.setBounds(12, 12, 368, 36);
        Rpanel.add(datePanel);
        datePanel.setLayout(null);
        
        JLabel lblEntTime = new JLabel("입장시각");
        lblEntTime.setBounds(188, 0, 52, 36);
        lblEntTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        datePanel.add(lblEntTime);
        
        textStayTime = new JTextField();
        textStayTime.setText("");
        textStayTime.setBounds(240, 0, 128, 36);
        textStayTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textStayTime.setEditable(false);
        textStayTime.setColumns(10);
        // TODO
        datePanel.add(textStayTime);
        
        JLabel lblSdate = new JLabel("영업일자");
        lblSdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblSdate.setBounds(0, 0, 52, 36);
        datePanel.add(lblSdate);
        
        textSdate = new JTextField();
        textSdate.setText(ymde.format(sDate));
        textSdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        textSdate.setEditable(false);
        textSdate.setColumns(10);
        textSdate.setBounds(52, 0, 124, 36);
        datePanel.add(textSdate);
}


    protected void insertMenuBtnOneOfSelected() {
        int row= menuTable.getSelectedRow();
        if(row== -1) {
            JOptionPane.showMessageDialog(frame, 
                    "수량 변경할 메뉴를 선택하세요.", // 메시지 
                    "Error", // 타이틀 
                    JOptionPane.ERROR_MESSAGE); // 메시지 타입
            return;
        }
        String menuName= (String) model.getValueAt(row, 1);
        Integer unitCost= (Integer) model.getValueAt(row, 2);
        System.out.println(model.getValueAt(row, 1));
        
        int result= dao.insertMenuBtnIncrease(menuName, unitCost);
        if(result== 1) {
            initializeMenuTable();
        }else {
            JOptionPane.showMessageDialog(frame, "다시 시도해주세요.");
        }
        
    }

    protected void deleteMenuBtnOneOfSelected() {
        int row= menuTable.getSelectedRow();
        if(row== -1) {
            JOptionPane.showMessageDialog(frame, 
                    "수량 변경할 메뉴를 선택하세요.", // 메시지 
                    "Error", // 타이틀 
                    JOptionPane.ERROR_MESSAGE); // 메시지 타입
            return;
        }
        String menuName= (String) model.getValueAt(row, 1);
        System.out.println(model.getValueAt(row, 1));
        
        int result= dao.deleteMenuBtnDecrease(menuName);
        if(result== 1) {
            initializeMenuTable();
        }else {
            JOptionPane.showMessageDialog(frame, "다시 시도해주세요.");
        }
        
    }

    protected void deleteMenuBtnSelected() {
        int row= menuTable.getSelectedRow();
        if(row== -1) {
            JOptionPane.showMessageDialog(frame, 
                    "취소할 메뉴를 선택하세요.", // 메시지 
                    "Error", // 타이틀 
                    JOptionPane.ERROR_MESSAGE); // 메시지 타입
            return;
        }
        String menuName= (String) model.getValueAt(row, 1);
        System.out.println(model.getValueAt(row, 1));
        
        int confirm = JOptionPane.showConfirmDialog(frame, 
                "선택한 메뉴를 취소할까요?", 
                "취소 확인",
                JOptionPane.YES_NO_OPTION);
        if(confirm== JOptionPane.YES_OPTION) {
            int result= dao.deleteMenuBtn(menuName);
            if(result!= 0) {
                initializeMenuTable();
            }else {
                JOptionPane.showMessageDialog(frame, "다시 시도해주세요.");
            }
        }
        
    }

    protected void deleteMenuBtnAll() {
        int confirm= JOptionPane.showConfirmDialog(frame,
                "전체 메뉴를 취소할까요?",
                "취소 확인",
                JOptionPane.YES_NO_OPTION);
        if(confirm== JOptionPane.YES_OPTION) {
            int result= dao.deleteMenuBtn();
            if(result!= 0) {
                initializeMenuTable();
            } else {
                JOptionPane.showMessageDialog(frame, "다시 시도해주세요.");
            }
        }
        
    }

    @Override
    public void onpCardNotify(String pCard) {
        int v1= Integer.valueOf(textReceived.getText());
        int v2= Integer.valueOf(pCard);
        String vr= String.valueOf(v1+v2);
        textReceived.setText(vr);
        
        int sum= Integer.valueOf(textTotal.getText());
        int r= Integer.valueOf(textReceived.getText());
        String tbr= String.valueOf(sum-r);
        textTobeReceived.setText(tbr);
        
        String c= String.valueOf(sum-(v1+v2));
        textCharge.setText(c);
        
        
    }

    @Override
    public void onpCashNotify(String pCash) {
        int v1= Integer.valueOf(textReceived.getText());
        int v2= Integer.valueOf(pCash);
        String vr= String.valueOf(v1+v2);
        textReceived.setText(vr);
        
        int sum= Integer.valueOf(textTotal.getText());
        int r= Integer.valueOf(textReceived.getText());
        String tbr= String.valueOf(sum-r);
        textTobeReceived.setText(tbr);
        
        String c= String.valueOf((v1+v2)-sum);
        textCharge.setText(c);
        
    }

}
