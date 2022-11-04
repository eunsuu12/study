package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

    private JFrame frame;
    private JButton btnConfirmDlg;
    private JButton btnOptionDlg;
    private JButton btnInputDlg;
    private JButton btnCustomDlg;
    private JButton btnCustomFrame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain06 window = new AppMain06();
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
    public AppMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // [닫기] 버튼 클릭 동작 -> 프로그램 종료
        frame.getContentPane().setLayout(null);
        
        JButton btnMsgDlg = new JButton("Message Dialog");
        btnMsgDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "안녕하세요.");
                JOptionPane.showMessageDialog(
                        frame, // 다이얼로그가 실행될 부모 컴포넌트
                        "안녕하세요?", // 다이얼로그에 표시될 메시지
                        "메시지", // 다이얼로그의 타이틀
                        JOptionPane.INFORMATION_MESSAGE, // 메시지 타입
                        null // 아이콘
                );
            }
        });
        btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnMsgDlg.setBounds(12, 10, 410, 64);
        frame.getContentPane().add(btnMsgDlg);
        
        btnConfirmDlg = new JButton("Confirm Dialog");
        btnConfirmDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int result = JOptionPane.showConfirmDialog(frame, "삭제할까요?");
                int result = JOptionPane.showConfirmDialog(
                        frame, // 다이얼로그의 부모 컴포넌트
                        "선택한 파일을 삭제할까요?", // 다이얼로그의 메시지
                        "삭제 확인", // 다이얼로그의 타이틀(제목 표시줄)
                        JOptionPane.YES_NO_OPTION, // 확인 옵션(YES-NO, YES-NO-CANCEL, ...)
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입(-> 아이콘을 자동으로 설정)
                        null // 아이콘
                );
                // showConfirmDialog의 리턴값: YES=0, NO=1, CANCEL=2, X(닫기)=-1
                btnConfirmDlg.setText("Confirm=" + result);
            }
        });
        btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnConfirmDlg.setBounds(12, 84, 410, 64);
        frame.getContentPane().add(btnConfirmDlg);
        
        btnOptionDlg = new JButton("Option Dialog");
        btnOptionDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"아니요", "어려워요", "재밌어요"};
                int result = JOptionPane.showOptionDialog(
                        frame, // 다이얼로그의 부모 컴포넌트
                        "Swing GUI 재미있나요?", // 다이얼로그의 메시지
                        "확인", // 다이얼로그의 타이틀
                        JOptionPane.YES_NO_CANCEL_OPTION, // 다이얼로그의 옵션 타입(Yes-No, Yes-No-Cancel, ...)
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입(QUESTION, INFORMATION, ...)
                        null, // 아이콘
                        options, // 옵션 버튼에서 사용할 문자열 배열
                        options[2] // 다이얼로그가 실행될 때 포커스를 받는 버튼 옵션
                );
                btnOptionDlg.setText("result=" + result);
            }
        });
        btnOptionDlg.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnOptionDlg.setBounds(12, 158, 410, 64);
        frame.getContentPane().add(btnOptionDlg);
        
        btnInputDlg = new JButton("Input Dialog");
        btnInputDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String input = JOptionPane.showInputDialog("이름?");
//                String input = JOptionPane.showInputDialog(frame, "이름");
                Object[] selectionValues = {"10대", "20대", "30대", "40대"};
                Object input = JOptionPane.showInputDialog(
                        frame, // 부모 컴포넌트
                        "나이?", // 메시지
                        "확인", // 타이틀
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입
                        null, // 아이콘
                        selectionValues, // 선택 값들의 배열
                        selectionValues[1] // 선택 값들 중에서 포커스를 받는 컴포넌트
                );
                //-> OK 버튼을 클릭하면 입력한 내용을 리턴, Cancel을 클릭하면 빈 문자열을 리턴.
                btnInputDlg.setText("입력=" + input);
            }
        });
        btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnInputDlg.setBounds(12, 232, 410, 64);
        frame.getContentPane().add(btnInputDlg);
        
        btnCustomDlg = new JButton("Custom Dialog");
        btnCustomDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomDialog.showMyCustomDialog();
            }
        });
        btnCustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnCustomDlg.setBounds(12, 306, 410, 64);
        frame.getContentPane().add(btnCustomDlg);
        
        btnCustomFrame = new JButton("Custom Frame");
        btnCustomFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomFrame.showMyCustomFrame();
            }
        });
        btnCustomFrame.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnCustomFrame.setBounds(12, 380, 410, 64);
        frame.getContentPane().add(btnCustomFrame);
    }
}
