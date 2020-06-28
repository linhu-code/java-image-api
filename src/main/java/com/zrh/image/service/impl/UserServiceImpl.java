package com.zrh.image.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrh.image.domain.User;
import com.zrh.image.entity.dto.UserDTO;
import com.zrh.image.mapper.UserMapper;
import com.zrh.image.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private final UserMapper userMapper;

    public List<UserDTO> getUser() {
        return userMapper.getUser();
    }

}
