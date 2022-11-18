package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.User;
import com.example.spring02.dto.UserCreateDto;
import com.example.spring02.dto.UserUpdateDto;
import com.example.spring02.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserMapper userMapper;
    
//    List<User> selectOrderByIdDesc();
    public List<User> read(){
        return userMapper.selectOrderByIdDesc();
    }
    
//    int insert(UserCreateDto dto);
    public int create(UserCreateDto dto) {
        log.info("create(dto= {})", dto);
        return userMapper.insert(dto);
    }
    
//    User selectById(Integer id);
    public User read(Integer id) {
        return userMapper.selectById(id);
    }
    
//    int updatePwAndEmailById(UserUpdateDto dto);
    public int update(UserUpdateDto dto) {
        log.info("update(dto= {})", dto);
        return userMapper.updatePwAndEmailById(dto);
    }
    
    
//    int deleteById(Integer id);
    public int delete(Integer id) {
        log.info("delete(id= {})", id);
        return userMapper.deleteById(id);
    }
}
