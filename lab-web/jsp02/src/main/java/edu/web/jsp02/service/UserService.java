package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserCreateDto;
import edu.web.jsp02.dto.UserUpdateDto;

public interface UserService {
    public List<User> read();
    public int create(UserCreateDto dto);
    public User read(Integer id);
    public int update(UserUpdateDto dto);
}
