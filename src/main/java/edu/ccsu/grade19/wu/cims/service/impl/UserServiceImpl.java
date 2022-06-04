package edu.ccsu.grade19.wu.cims.service.impl;

import edu.ccsu.grade19.wu.cims.domain.po.User;
import edu.ccsu.grade19.wu.cims.repository.UserMapper;
import edu.ccsu.grade19.wu.cims.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Haixin Wu
 * @since 2022-06-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
