package edu.java.swing09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppMain09 {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain09 window = new AppMain09();
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
    public AppMain09() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable(); // JTable 생성
        
        // 테이블 데이터 - 2차원 배열
        Object[][] data = {
                {1, "맥북 프로", 400, "IT", 1},
                {2, "갤 폴드", 200, "가전", 10},
                {3, "박카스", 10, "식품", 100}
        };
        
        // 테이블 컬럼 이름 - 1차원 배열
        Object[] colNames = {"상품 번호", "상품 이름", "가격", "카테고리", "재고 수량"};
        
        // 테이블 데이터를 관리하는 DefaultTableModel 객체를 생성.
        DefaultTableModel model = new DefaultTableModel(data, colNames);
        
        // 테이블의 데이터를 관리(추가, 삭제, ...)하는 TableModel을 JTable에 세팅(설정).
        table.setModel(model);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(79);
        
        // JTable을 JScrollPane의 viewport에 설정 - 스크롤 패널 안에 테이블을 넣음.
        scrollPane.setViewportView(table);
    }

}
