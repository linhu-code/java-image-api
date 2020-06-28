package com.zrh.image.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zrh.image.domain.User;
import com.zrh.image.entity.dto.UserDTO;

import java.util.List;


public interface IUserService extends IService<User> {
    List<UserDTO> getUser();
}
