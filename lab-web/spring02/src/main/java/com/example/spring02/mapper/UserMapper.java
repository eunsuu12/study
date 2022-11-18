package com.example.spring02.mapper;

import java.util.List;

import com.example.spring02.domain.User;
import com.example.spring02.dto.UserCreateDto;
import com.example.spring02.dto.UserUpdateDto;

public interface UserMapper {
    
    List<User> selectOrderByIdDesc();
    int insert(UserCreateDto dto);
    User selectById(Integer id);
    int updatePwAndEmailById(UserUpdateDto dto);
    int deleteById(Integer id);
    
}
