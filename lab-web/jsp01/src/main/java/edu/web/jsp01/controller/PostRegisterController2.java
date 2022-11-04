package edu.web.jsp01.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp01.domain.Post;

/**
 * Servlet implementation class PostRegisterController
 */
@WebServlet(name="postRegisterController2", urlPatterns={"/post/read"})
public class PostRegisterController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostRegisterController2() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("postRegisterController2.doGet() 호출");
	    
	    // View(JSP페이지)로 "forward" 이동
        request.getRequestDispatcher("/WEB-INF/post/read.jsp")
        .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("postRegisterController2.doPost() 호출");
	    
	    //요청 객체의 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        
        // 요청 파라미터 값 찾기
        ArrayList<Post> list= new ArrayList<>();
        
        Integer id= Integer.parseInt(request.getParameter("id"));
        String title= request.getParameter("title");
        String content= request.getParameter("content");
        LocalDateTime createTime= LocalDateTime.parse(request.getParameter("createTime"));
        System.out.println(createTime);
        
        Post post= new Post(id, title, content, createTime);
        list.add(post);
        
        // 포스트 정보를 View(JSP)에 전달하기 위해서
        request.setAttribute("list", list);
        
        // View(JSP)로 이동(forward)
        request.getRequestDispatcher("/WEB-INF/post/read.jsp")
            .forward(request, response);
        
	}

}
