package com.zrh.image.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrh.image.domain.User;
import com.zrh.image.entity.dto.UserDTO;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<UserDTO> getUser();
}
