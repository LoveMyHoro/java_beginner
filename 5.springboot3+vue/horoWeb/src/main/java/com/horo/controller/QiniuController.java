package com.horo.controller;

/**
 * @ClassName QiniuController
 * @Author iove
 * @Date 2024/11/15 下午7:23
 * @Version 1.0
 * @Description TODO 这个是向七牛oss存储数据
 **/

import com.horo.service.MusicService;
import com.horo.utils.QiniuUtils;
import com.horo.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class QiniuController {
	@Autowired
	private MusicService musicService;
	@Autowired
	private QiniuUtils qiniuUtils;
	@PostMapping("/upload2")
	public Result uploadImg(MultipartFile file) throws IOException {
		String username=file.getOriginalFilename();
		String url= qiniuUtils.saveFile(file);
		System.out.println(file.getOriginalFilename());
		musicService.addMusic(username,url);
		return Result.ok(url);
	}
}


