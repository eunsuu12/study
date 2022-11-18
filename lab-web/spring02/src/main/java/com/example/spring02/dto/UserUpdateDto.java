package com.example.spring02.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserUpdateDto {
    private Integer id;
    private String password;
    private String email;
}
