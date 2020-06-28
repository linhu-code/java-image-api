package com.zrh.image.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private String name;
    private String password;
    private String gender;
    private int age;
    private String role;
    private int status;
    private String phone;
    private String address;
}
