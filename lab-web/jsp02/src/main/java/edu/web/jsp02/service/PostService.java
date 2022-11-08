package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;

public interface PostService {

    public List<Post> read();
    public int create(PostCreateDto dto);
    public Post read(Integer id);
    public int delete(Integer id);
    public int update(Post entity);
    
}
