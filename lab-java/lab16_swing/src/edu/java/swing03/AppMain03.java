package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {

    private JFrame frame;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 577);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 32));
        lblName.setBounds(12, 10, 160, 72);
        frame.getContentPane().add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 32));
        lblPhone.setBounds(12, 92, 160, 72);
        frame.getContentPane().add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 32));
        lblEmail.setBounds(12, 174, 160, 72);
        frame.getContentPane().add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textName.setBounds(184, 10, 388, 72);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textPhone.setColumns(10);
        textPhone.setBounds(184, 92, 388, 72);
        frame.getContentPane().add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textEmail.setColumns(10);
        textEmail.setBounds(184, 174, 388, 72);
        frame.getContentPane().add(textEmail);
        
        JButton btnInput = new JButton("입력");
        // 버튼에 이벤트 핸들러를 등록
        // 이벤트 핸들러: 이벤트가 발생됐을 때 자동으로 호출되는 메서드.
        btnInput.addActionListener((e) -> printInfo());
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 32));
        btnInput.setBounds(12, 256, 560, 72);
        frame.getContentPane().add(btnInput);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textArea.setBounds(12, 338, 560, 182);
        frame.getContentPane().add(textArea);
    }
    
    // "입력" 버튼을 클릭했을 때 실행할 내용.
    private void printInfo() {
        // JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // JTextArea에 출력할 문자열 만들기
        StringBuilder buffer = new StringBuilder();
        buffer.append("이름: ").append(name).append("\n")
            .append("전화번호: ").append(phone).append("\n")
            .append("이메일: ").append(email);
        
        // 만들어진 문자열을 JTextArea에 출력
        textArea.setText(buffer.toString());
    }
    
}
