package com.horo.json;

import com.horo.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.PrintService;

/**
 * @ClassName jsonController
 * @Author iove
 * @Date 2024/10/16 上午10:21
 * @Version 1.0
 * @Description TODO
 **/
@Controller
@ResponseBody
public class jsonController {
    @RequestMapping("/json/data")
    public String data(@RequestBody Person person){
        System.out.println("person:"+person);
        return person.toString();
    }
}
