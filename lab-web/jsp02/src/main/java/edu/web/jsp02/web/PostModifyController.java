package edu.web.jsp02.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostModifyController
 */
@Slf4j
@WebServlet(name = "postModifyController", urlPatterns = { "/post/modify" })
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PostService postService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostModifyController() {
        postService= PostServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet()");
		
		Integer id= Integer.valueOf(request.getParameter("id"));
		log.info("id= {}", id);
		
		Post post= postService.read(id);
		log.info("post= {}", post);
		
		request.setAttribute("post", post);
		request.getRequestDispatcher("/WEB-INF/post/modify.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   log.info("doPost()");
        
        Integer id = Integer.valueOf(request.getParameter("id"));
        String title= request.getParameter("title");
        String content= request.getParameter("content");
        Post entity= Post.builder()
                .id(id).title(title).content(content)
                .build();
        
        int result = postService.update(entity);
        log.info("update result = {}", result);
        
        response.sendRedirect("/jsp02/post/detail?id="+id);
	}

}
