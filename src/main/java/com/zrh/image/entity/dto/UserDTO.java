package com.zrh.image.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDTO {
    private long id;
    private String name;
    private String password;
    private String gender;
    private int age;
    private String role;
    private int status;
    private String phone;
    private String address;
}
