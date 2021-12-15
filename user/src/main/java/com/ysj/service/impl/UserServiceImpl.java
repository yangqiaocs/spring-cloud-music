package com.ysj.service.impl;

import com.ysj.entity.User;
import com.ysj.mapper.UserMapper;
import com.ysj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author ysj
 * @since 2021-11-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
