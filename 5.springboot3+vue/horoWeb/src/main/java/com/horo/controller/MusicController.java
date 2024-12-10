package com.horo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.horo.service.MusicService;
import com.horo.utils.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName MusicController
 * @Author iove
 * @Date 2024/11/14 下午9:39
 * @Version 1.0
 * @Description TODO
 **/    
@CrossOrigin
@RestController
@RequestMapping("/music")
public class MusicController {
	@Autowired
	private MusicService musicService;
	@PostMapping("/upload")
	public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("文件上传");
		String extension= file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		if(!extension.equals(".mp3")){
			System.out.println(extension);
			return Result.error("只能上传音乐文件！");
		}
		String title=file.getOriginalFilename().replace(".mp3","");
		String url = FileUploadController.upload(file);
		System.out.println("文件地址："+url);
		Result result=musicService.addMusic(title,url);
		return result;
	}

	/**
	 * 2.获取用户云端的音乐列表
	 * @return
	 */
	@PostMapping("/getMusicList")
	public Result getById(){
		Result result=musicService.getMusicList();
		System.out.println("获取音乐列表成功");
		return result;
	}

	/**
	 * 3.获取所有用户的存储的云端音乐
	 * @return
	 */
	@GetMapping("/getAll")
	public Result getAll(){
		Result result=musicService.getAllMusic();
		return result;
	}

	/**
	 * 4.根据关键词搜索音乐
	 * @param keyword
	 * @return
	 * @throws JsonProcessingException
	 * @throws UnsupportedEncodingException
	 */

	@GetMapping("search")
	public Result serach(String keyword) throws JsonProcessingException, UnsupportedEncodingException {
		System.out.println("搜索歌曲");
		Result result=musicService.searchMusic(keyword);
		System.out.println(result.getData().toString().length());
		return result;
	}

}
