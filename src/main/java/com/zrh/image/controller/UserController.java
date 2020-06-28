package com.zrh.image.controller;

import com.zrh.image.domain.User;
import com.zrh.image.entity.vo.UserVO;
import com.zrh.image.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;

    @GetMapping("/getUser")
    public Object getUser() {
        return iUserService.getUser();
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody UserVO userVO) {
        User u = new User();
        u.setName(userVO.getName());
        BeanUtils.copyProperties(userVO, u);
        System.out.println(u);
        return iUserService.save(u);
    }
}
