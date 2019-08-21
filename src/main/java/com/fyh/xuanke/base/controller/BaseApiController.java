package com.fyh.xuanke.base.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")

//解决跨域
@CrossOrigin(origins = "*",allowCredentials = "true")
public class BaseApiController {
}
