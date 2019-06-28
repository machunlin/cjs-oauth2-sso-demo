package com.cjs.sso.controller;

import com.cjs.sso.utils.JacksonHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.Principal;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/userJwt")
    @ResponseBody
    public Object getCurrentUserJwt(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
        log.info("【SecurityOauth2Application】 getCurrentUserJwt authentication={}", JacksonHelper.toJsonString(authentication));

        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header, "bearer ");

//        Claims claims = Jwts.parser().setSigningKey(oAuth2Properties.getJwtSigningKey().getBytes("UTF-8")).parseClaimsJws(token).getBody();
//        String blog = (String) claims.get("blog");
//        log.info("【SecurityOauth2Application】 getCurrentUser1 blog={}", blog);

        return authentication;
    }

    @GetMapping("/user/me")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

}
