package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogDetailFrame extends JFrame {
    
    public interface OnBlogUpdateListener {
        void onBlogUpdated();
    }
    
    private OnBlogUpdateListener listener;
    
    private Component parent;
    private Integer blogNo;
    private BlogDaoImpl dao;

    private JPanel contentPane;
    private JTextField textBlogNo;
    private JTextField textTitle;
    private JTextArea textContent;
    private JTextField textAuthor;
    private JTextField textCreatedDate;
    private JTextField textModifiedDate;

    /**
     * Launch the application.
     */
    public static void newBlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogDetailFrame frame = new BlogDetailFrame(parent, blogNo, listener);
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
    public BlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        this.listener = listener; // 블로그 글 업데이트 결과를 통지할 수 있는 메서드를 가지고 있는 객체.
        
        this.parent = parent; // 부모 컴포넌트 객체 저장.
        this.blogNo = blogNo; // 상세보기/수정할 블로그 글 번호.
        this.dao = BlogDaoImpl.getInstance();
        
        initialize(); // UI 컴포넌트 생성, 초기화.
        
        initializeBlogData(); // JTextField, JTextArea의 내용을 DB에서 검색한 내용으로 채움.
    }
    
    private void initializeBlogData() {
        Blog blog = dao.select(blogNo);
        if (blog != null) {
            textBlogNo.setText(blog.getBlogNo().toString());
            textTitle.setText(blog.getTitle());
            textContent.setText(blog.getContent());
            textAuthor.setText(blog.getAuthor());
            textCreatedDate.setText(blog.getCreatedDate().toString());
            textModifiedDate.setText(blog.getModifiedDate().toString());
        }
    }
    
    private void initialize() {
        setTitle("블로그 상세 보기");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX(); // 부모 컴포넌트 x 좌표
        int y = parent.getY(); // 부모 컴포넌트 y 좌표
        setBounds(x, y, 400, 800);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblBlogNo = new JLabel("번호");
        lblBlogNo.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblBlogNo.setBounds(12, 10, 360, 40);
        contentPane.add(lblBlogNo);
        
        textBlogNo = new JTextField();
        textBlogNo.setEditable(false);
        textBlogNo.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textBlogNo.setBounds(12, 60, 360, 40);
        contentPane.add(textBlogNo);
        textBlogNo.setColumns(10);
        
        JLabel lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblTitle.setBounds(12, 110, 360, 40);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textTitle.setColumns(10);
        textTitle.setBounds(12, 160, 360, 40);
        contentPane.add(textTitle);
        
        JLabel lblContent = new JLabel("내용");
        lblContent.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblContent.setBounds(12, 210, 360, 40);
        contentPane.add(lblContent);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 260, 360, 120);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 24));
        scrollPane.setViewportView(textContent);
        
        JLabel lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblAuthor.setBounds(12, 390, 360, 40);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textAuthor.setEditable(false);
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 440, 360, 40);
        contentPane.add(textAuthor);
        
        JLabel lblCreatedDate = new JLabel("작성 시간");
        lblCreatedDate.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblCreatedDate.setBounds(12, 490, 360, 40);
        contentPane.add(lblCreatedDate);
        
        textCreatedDate = new JTextField();
        textCreatedDate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textCreatedDate.setEditable(false);
        textCreatedDate.setColumns(10);
        textCreatedDate.setBounds(12, 540, 360, 40);
        contentPane.add(textCreatedDate);
        
        JLabel lblModifiedDate = new JLabel("최종 업데이트 시간");
        lblModifiedDate.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        lblModifiedDate.setBounds(12, 590, 360, 40);
        contentPane.add(lblModifiedDate);
        
        textModifiedDate = new JTextField();
        textModifiedDate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textModifiedDate.setEditable(false);
        textModifiedDate.setColumns(10);
        textModifiedDate.setBounds(12, 640, 360, 40);
        contentPane.add(textModifiedDate);
        
        JButton btnUpdate = new JButton("수정 완료");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBlog();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnUpdate.setBounds(12, 690, 360, 40);
        contentPane.add(btnUpdate);
    }
    
    private void updateBlog() {
        // 수정할 title, content 읽음.
        String title = textTitle.getText();
        String content = textContent.getText();
        if (title.equals("") || content.equals("")) {
            JOptionPane.showMessageDialog(this, 
                    "제목과 내용은 반드시 입력되어야 합니다.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // dao.update() 호출.
        Blog blog = new Blog(blogNo, title, content, null, null, null);
        int result = dao.update(blog);
        
        if (result == 1) {
            JOptionPane.showMessageDialog(this, 
                    blogNo + "번 블로그 업데이트 성공");
            // DetailFrame은 닫음.
            dispose();
            // BlogMain에게 업데이트 성공을 알려줌.
            listener.onBlogUpdated();
        } else {
            JOptionPane.showMessageDialog(this, 
                    blogNo + "번 블로그 업데이트 실패");
        }
        
    }

}
