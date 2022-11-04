package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

public class BlogCreateFrame extends JFrame {
    
    public interface OnBlogInsertListener {
        void onBlogInserted();
    }

    private OnBlogInsertListener listener;
    private Component parent; // 부모 컴포넌트를 저장하기 위한 필드.
    private BlogDaoImpl dao; // DB 테이블 insert 기능을 가지고 있는 객체.
    
    private JPanel contentPane;
    private JTextField textTitle;
    private JTextField textAuthor;
    private JTextArea textContent;

    /**
     * Launch the application.
     */
    public static void newBlogCreateFrame(Component parent, OnBlogInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogCreateFrame frame = new BlogCreateFrame(parent, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BlogCreateFrame(Component parent, OnBlogInsertListener listener) {
        this.listener = listener;
        this.parent = parent;
        this.dao = BlogDaoImpl.getInstance();
        
        initialize(); // UI 컴포넌트들(JLabel, JTextField, JTextAreat, ...)이 생성, 초기화.
    }
    
    private void initialize() {
        setTitle("새 블로그 글 작성"); // JFrame의 타이틀
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // JFrame의 닫기 버튼 동작 - 현재 창 닫기
        
        int x = parent.getX(); // 부모 창의 x 좌표
        int y = parent.getY(); // 부모 창의 y 좌표
        setBounds(x, y, 400, 600);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblTitle.setBounds(12, 10, 360, 40);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textTitle.setBounds(12, 58, 360, 40);
        contentPane.add(textTitle);
        textTitle.setColumns(10);
        
        JLabel lblContent = new JLabel("내용");
        lblContent.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblContent.setBounds(12, 108, 360, 40);
        contentPane.add(lblContent);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 158, 360, 120);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 24));
        scrollPane.setViewportView(textContent);
        
        JLabel lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblAuthor.setBounds(12, 288, 360, 40);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 338, 360, 40);
        contentPane.add(textAuthor);
        
        JButton btnCreate = new JButton("작성 완료");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewBlogPost();
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnCreate.setBounds(12, 388, 360, 40);
        contentPane.add(btnCreate);
    }
    
    private void createNewBlogPost() {
        // 제목, 내용, 작성자 정보 읽음.
        String title = textTitle.getText();
        String content = textContent.getText();
        String author = textAuthor.getText();
        if (title.equals("") || content.equals("") || author.equals("")) {
            JOptionPane.showMessageDialog(
                    this, // parentComponent -> BlogCreateFrame의 인스턴스 주소.
                    "제목, 내용, 작성자는 반드시 입력되어야 합니다!", // message
                    "Error", // title
                    JOptionPane.ERROR_MESSAGE);
            return; // insert하면 안 됨 -> 메서드 종료
        }
        
        // 제목, 내용, 작성자 -> Blog 객체 생성
        Blog blog = new Blog(null, title, content, author, null, null);
        
        // dao의 insert 메서드를 호출 -> DB에 저장
        int result = dao.insert(blog);
        if (result == 1) { // insert 성공
            JOptionPane.showMessageDialog(this, "새 블로그 글 작성 성공");
            dispose(); // 현재 창 닫기
            
            listener.onBlogInserted();
            
        } else { // insert 실패
            JOptionPane.showMessageDialog(this, 
                    "새 블로그 글 작성 실패", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
