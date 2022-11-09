package edu.web.jsp02.web.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostCreateController
 */

@Slf4j
@WebServlet(name = "postCreateController", urlPatterns = { "/post/create" })
public class PostCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PostService postService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostCreateController() {
        postService= PostServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet()");
		
		request.getRequestDispatcher("/WEB-INF/post/create.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doPost()");
		
		// request 객체의 인코딩 타입 설정 -> 한글 처리
        request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미터 분석: title, content, author 값을 찾음.
        String title= request.getParameter("title");
        String content= request.getParameter("content");
        String author= request.getParameter("author");
		
		// PostCreateDto 타입 객체 생성.
        PostCreateDto dto= PostCreateDto.builder()
                .title(title).content(content).author(author)
                .build();
		
		// postService.create(dto) 메서드 호출 --> postDao 호출 --> DB에 저장.
        postService.create(dto);
        
		// 포스트 목록 페이지 이동(redirect).
        response.sendRedirect("/jsp02/post/list"); // 내부 서버로 이동.
	}

}
