package ver01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentCash extends JFrame{
    
    @FunctionalInterface
    public interface onPaymentCashListener{
        void onpCashNotify(String pCash);
    }
    private onPaymentCashListener listener;
    private Component parent;
    private JFrame frame;
    private JTextField textField;
    private String pCash;

    /**
     * Launch the application.
     */
    public static void newPaymentCash(Component parent, onPaymentCashListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PaymentCash window = new PaymentCash(parent, listener);
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
    public PaymentCash(Component parent, onPaymentCashListener listener) {
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.listener = listener;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("현금결제");
        int x = parent.getX();
        int y = parent.getY();
        frame.setBounds(x+450, y+100, 300, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 120, 260, 230);
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(4, 3, 2, 2));
        
        JButton btn1 = new JButton("1");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"1");
            }
        });
        btn1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn1);
        
        JButton btn2 = new JButton("2");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"2");
            }
        });
        btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn2);
        
        JButton btn3 = new JButton("3");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"3");
            }
        });
        btn3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn3);
        
        JButton btn4 = new JButton("4");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"4");
            }
        });
        btn4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn4);
        
        JButton btn5 = new JButton("5");
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"5");
            }
        });
        btn5.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn5);
        
        JButton btn6 = new JButton("6");
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"6");
            }
        });
        btn6.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn6);
        
        JButton btn7 = new JButton("7");
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"7");
            }
        });
        btn7.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn7);
        
        JButton btn8 = new JButton("8");
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"8");
            }
        });
        btn8.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn8);
        
        JButton btn9 = new JButton("9");
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"9");
            }
        });
        btn9.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn9);
        
        JButton btnDel = new JButton("삭제");
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField.requestFocus();
            }
        });
        btnDel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        panel.add(btnDel);
        
        JButton btn0 = new JButton("0");
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+"0");
            }
        });
        btn0.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        panel.add(btn0);
        
        JButton btnOk = new JButton("입력");
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pCash= textField.getText();
                listener.onpCashNotify(pCash);
                frame.dispose();
            }
        });
        btnOk.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        panel.add(btnOk);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 284, 120);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        textField.setBounds(12, 60, 260, 48);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel(">> 결제하실 금액을 입력하세요");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblNewLabel.setBounds(12, 40, 260, 15);
        panel_1.add(lblNewLabel);
    }

}
