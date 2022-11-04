package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain10 {
    private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

    private JFrame frame;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain10 window = new AppMain10();
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
    public AppMain10() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 460, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblKorean = new JLabel("국어");
        lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
        lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblKorean.setBounds(12, 10, 100, 48);
        frame.getContentPane().add(lblKorean);
        
        JLabel lblEnglish = new JLabel("영어");
        lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblEnglish.setBounds(12, 68, 100, 48);
        frame.getContentPane().add(lblEnglish);
        
        JLabel lblMath = new JLabel("수학");
        lblMath.setHorizontalAlignment(SwingConstants.CENTER);
        lblMath.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblMath.setBounds(12, 126, 100, 48);
        frame.getContentPane().add(lblMath);
        
        textKorean = new JTextField();
        textKorean.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textKorean.setBounds(124, 10, 160, 48);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        textEnglish = new JTextField();
        textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textEnglish.setColumns(10);
        textEnglish.setBounds(124, 68, 160, 48);
        frame.getContentPane().add(textEnglish);
        
        textMath = new JTextField();
        textMath.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textMath.setColumns(10);
        textMath.setBounds(124, 126, 160, 48);
        frame.getContentPane().add(textMath);
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScore();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnInput.setBounds(12, 184, 100, 48);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnDelete.setBounds(124, 184, 100, 48);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 242, 420, 189);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable(); // JTable 생성
        
        model = new DefaultTableModel(null, COLUMN_NAMES); // 컬럼 이름만 갖는 테이블 모델 생성
        
        table.setModel(model); // 테이블 모델을 테이블에 세팅.
        
        scrollPane.setViewportView(table);
    }
    
    private void deleteRow() {
        // 테이블에서 삭제하기 위해서 선택된 행(row) 인덱스를 찾음.
        int index = table.getSelectedRow();
        if (index == -1) { // 테이블에서 선택된 행이 없는 경우
            JOptionPane.showMessageDialog(frame, 
                    "삭제할 행을 먼저 선택하세요.", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 행 인덱스를 사용해서 테이블 모델에서 행을 삭제.
        int confirm = JOptionPane.showConfirmDialog(frame, 
                index + "번째 행을 정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) { // 다이얼로그에서 Yes를 클릭했을 때
            model.removeRow(index);
        }
        
    }
    
    private void inputScore() {
        // 3개의 JTextField에서 읽은 문자열을 정수(int)로 변환
        int korean = 0;
        int english = 0;
        int math = 0;
        try {
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, 
                    "입력값은 반드시 정수여야 합니다.", 
                    "입력 오류", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            clearAllTextFields();
        }
        
        // 입력값들을 사용해서 Score 객체 생성
        Score score = new Score(korean, english, math);
        
        // 테이블의 행(row)에 추가할 데이터를 1차원 배열로 만듦.
        Object[] rowData = {
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.sum(),
                score.average(),
        };
        
        // row data를 테이블 모델에 추가
        model.addRow(rowData);
        
    }
    
    private void clearAllTextFields() {
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
    
}
