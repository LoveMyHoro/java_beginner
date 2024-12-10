package com.horo.controller;

import com.horo.pojo.User;
import jakarta.ws.rs.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Author iove
 * @Date 2024/10/18 上午9:40
 * @Version 1.0
 * @Description TODO
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping()
    public List<User> getPage(
            @RequestParam(required = false,defaultValue = "1") Integer page,
            @RequestParam(required = false,defaultValue = "11") Integer size
    ) {
        System.out.println("page:"+page+"size:"+size);
        return null;
    }
    @PostMapping
    public User add(@RequestBody User user) {
        return user;
    }
    @GetMapping("{id}")
    public User detail(@PathVariable Integer id) {
        return null;
    }
    @PutMapping
    public User update(@RequestBody User user) {
        return user;
    }
    @DeleteMapping("{id}")
    public User delete(@PathVariable Integer id) {
        return null;
    }
    @GetMapping("search")
    public List<User> Search(String keyWord,@RequestParam(required = false,defaultValue = "1")int page,
                             @RequestParam(required = false,defaultValue = "11")int size) {
        return null;
    }

}
