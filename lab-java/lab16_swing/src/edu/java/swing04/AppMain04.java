package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JTextArea textArea;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 545, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNumber1 = new JLabel("number 1");
        lblNumber1.setForeground(Color.WHITE);
        lblNumber1.setOpaque(true);
        lblNumber1.setBackground(Color.GRAY);
        lblNumber1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumber1.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblNumber1.setBounds(12, 10, 140, 48);
        frame.getContentPane().add(lblNumber1);
        
        JLabel lblNumber2 = new JLabel("number 2");
        lblNumber2.setOpaque(true);
        lblNumber2.setBackground(Color.GRAY);
        lblNumber2.setForeground(Color.WHITE);
        lblNumber2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumber2.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblNumber2.setBounds(12, 68, 140, 48);
        frame.getContentPane().add(lblNumber2);
        
        textNumber1 = new JTextField();
        textNumber1.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textNumber1.setBounds(164, 10, 353, 48);
        frame.getContentPane().add(textNumber1);
        textNumber1.setColumns(10);
        
        textNumber2 = new JTextField();
        textNumber2.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textNumber2.setColumns(10);
        textNumber2.setBounds(164, 68, 353, 48);
        frame.getContentPane().add(textNumber2);
        
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 파라미터 ActionEvent e: 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한 정보를 가지고 있는 객체.
                // ActionEvent.getSource(): 이벤트가 발생한 컴포넌트를 리턴.
                performCalculation(e);
            }
        });
        btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnPlus.setBounds(12, 126, 48, 48);
        frame.getContentPane().add(btnPlus);
        
        btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
            }
        });
        btnMinus.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnMinus.setBounds(72, 126, 48, 48);
        frame.getContentPane().add(btnMinus);
        
        btnMultiply = new JButton("x");
        btnMultiply.addActionListener(e -> performCalculation(e));
        btnMultiply.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnMultiply.setBounds(132, 126, 48, 48);
        frame.getContentPane().add(btnMultiply);
        
        btnDivide = new JButton("/");
        btnDivide.addActionListener(e -> performCalculation(e));
        btnDivide.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnDivide.setBounds(192, 126, 48, 48);
        frame.getContentPane().add(btnDivide);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textArea.setBounds(12, 184, 505, 121);
        frame.getContentPane().add(textArea);
    }

    private void performCalculation(ActionEvent e) {
        // JTextFiled에 입력된 문자열을 읽고, double 타입으로 변환
        String s1 = textNumber1.getText();
        String s2 = textNumber2.getText();
        
        double number1 = 0;
        double number2 = 0;
        try {
            number1 = Double.parseDouble(s1);
            number2 = Double.parseDouble(s2);
        } catch (NumberFormatException ex) {
            textArea.setText("number1 또는 number2는 반드시 숫자 타입으로...");
            return; // 메서드 종료
        }
        
        double result = 0; // 산술 연산 결과를 저장하기 위한 변수.
        String op = " ";
        
        Object source = e.getSource(); // 이벤트가 발생한 컴포넌트.
        if (source == btnPlus) {
            result = number1 + number2;
            op = "+";
        } else if (source == btnMinus) {
            result = number1 - number2;
            op = "-";
        } else if (source == btnMultiply) {
            result = number1 * number2;
            op = "x";
        } else if (source == btnDivide) {
            result = number1 / number2;
            op = "/";
        }
        
        String output = String.format("%f %s %f = %f", 
                number1, op, number2, result);
        textArea.setText(output);
        
    }

}
