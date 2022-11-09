package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.dto.PostUpdateDto;

public interface PostService {

    public List<Post> read();
    public int create(PostCreateDto dto);
    public Post read(Integer id);
    public int delete(Integer id);
    public int update(PostUpdateDto dto);
    public List<Post> search(String type, String keyword);
}
