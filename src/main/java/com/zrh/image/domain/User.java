package com.zrh.image.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
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
