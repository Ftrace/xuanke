package com.fyh.xuanke.controller.api;

import com.fyh.xuanke.VO.UserVO;
import com.fyh.xuanke.base.controller.BaseApiController;
import com.fyh.xuanke.base.result.Result;
import com.fyh.xuanke.base.result.ResultCode;
import com.fyh.xuanke.controller.RegisterController;
import com.fyh.xuanke.model.User;
import com.fyh.xuanke.service.UserService;
import com.fyh.xuanke.util.MD5Util;
import com.fyh.xuanke.util.UUIDUtil;
import com.fyh.xuanke.util.ValidateCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class LoginApiController extends BaseApiController {

    private static Logger log = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login")
    public Result<Object> login(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult, HttpSession session, Model model, String code, HttpServletResponse response){
        log.info("-------------------"+user.getPassword());
        if(bindingResult.hasErrors()){
            return Result.failure();
        }
//        String sessionCode = (String) session.getAttribute("code");
//        if(!StringUtils.equalsAnyIgnoreCase(code,sessionCode)){//忽略验证码大小写
//            model.addAttribute("message","验证码不正确");
//            return Result.failure();
//
//
//        }

        //用户是否存在
        UserVO dbuser = userService.getUser(user.getUsername());
       if(dbuser !=null){
           String inputPassword = MD5Util.inputToDb(user.getPassword(),dbuser.getDbflag());
           if(dbuser.getPassword().equals(inputPassword)){
               //保存session
//               session.setAttribute("user",temp);

               //将User信息存入redis
               String token = UUIDUtil.getUUID();
               userService.saveUserToRedisByToken(dbuser,token);
               Cookie cookie = new Cookie("token",token);
               cookie.setMaxAge(3600);
               cookie.setPath("/");
               response.addCookie(cookie);


               return Result.success();
           }else{
               return Result.failure(ResultCode.USER_LOGIN_ERROR);
           }
       }else {
           return Result.failure(ResultCode.USER_LOGIN_ERROR);
       }

    }


//    /**
//     * 响应验证码页面
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping(value = "/validateCode")
//    public String  validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
//      //设置响应的类型格式为图片格式
//      response.setContentType("image/jpeg");
//
//      //禁止图像缓存
//        response.setHeader("Pragma","no-cache");
//        response.setHeader("Cache-Control","no-cache");
//        response.setDateHeader("Expires",0);//在代理服务器禁止缓冲
//
//        HttpSession session = request.getSession();
//
//        ValidateCode validateCode = new ValidateCode(120,34,5,100);
//        session.setAttribute("code", validateCode.getCode());
//        validateCode.write(response.getOutputStream());
//        return null;
//    }
}
