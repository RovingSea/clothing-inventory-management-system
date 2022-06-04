package edu.ccsu.grade19.wu.cims.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.ccsu.grade19.wu.cims.domain.po.User;
import edu.ccsu.grade19.wu.cims.service.UserService;
import edu.ccsu.grade19.wu.cims.utility.http.RestResponse;
import edu.ccsu.grade19.wu.cims.utility.http.SystemCode;
import edu.ccsu.grade19.wu.cims.utility.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.util.NestedServletException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Haixin Wu
 * @since 2022-06-01
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam String account,
                        @RequestParam String password) {
        Exception loginException = null;
        RestResponse<Map<String, String>> response = null;

        try {
            User user = findUser(account);
            if (checkPassword(user, password)) {
                Map<String, String> tokenMap = new HashMap<>();
                String token = createToken(account);
                tokenMap.put("token", token);
                response = RestResponse.ok(tokenMap);
            }
        } catch (Exception ex) {
            loginException = ex;
            response = new RestResponse<>(SystemCode.AuthError);
        } catch (Throwable err) {
            loginException = new NestedServletException("登陆时，系统内部错误", err);
        } finally {
            if (loginException != null) {
                log.error("用户[{}]登陆时有误，原因是：{}", account, loginException.getMessage());
            }
        }
        return response;
    }

    private User findUser(String account) throws RuntimeException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        User target = userService.getOne(queryWrapper);
        if (target != null) {
            return target;
        } else {
            throw new RuntimeException("数据库中不存在账号[" + account + "]");
        }
    }

    private Boolean checkPassword(User user, String password) throws RuntimeException {
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            throw new RuntimeException("用户[" + user.getAccount() + "]输入的密码错误");
        }
    }

    private String createToken(String account) {
        return TokenUtil.createToken(account);
    }

    @PostMapping("/changePwd")
    @ResponseBody
    public Object changePwd(@RequestHeader("auth") String token,
                            @RequestParam String oldPwd,
                            @RequestParam String newPwd) {
        Exception changePwdException = null;
        RestResponse<String> response = null;
        String account = null;

        try {
            account = TokenUtil.getUserInfoFromToken(token);
            User user = findUser(account);
            if (oldPwd.equals(user.getPassword())) {
                user.setPassword(newPwd);
                userService.updateById(user);
                response = RestResponse.ok();
            } else {
                throw new RuntimeException("老密码输入错误");
            }
        } catch (Exception ex) {
            changePwdException = ex;
            response = RestResponse.failure();
        } catch (Throwable err) {
            changePwdException = new NestedServletException("修改密码时，系统内部错误", err);
        } finally {
            if (changePwdException != null) {
                log.error("用户[{}]修改密码时有误，原因是：{}", account, changePwdException.getMessage());
            }
        }
        return response;
    }
}