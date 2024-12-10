package com.horo.header;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HeaderController
 * @Author iove
 * @Date 2024/10/16 下午4:43
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@RequestMapping("header")
@ResponseBody
public class HeaderController {
    @GetMapping("data")
    public String data(@RequestHeader("Host") String host) {
        System.out.println("host: " + host);
        return host;
    }
}
