package com.horo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BeanController
 * @Author iove
 * @Date 2024/11/20 下午7:56
 * @Version 1.0
 * @Description TODO
 **/
@RestController
public class BeanController {
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
