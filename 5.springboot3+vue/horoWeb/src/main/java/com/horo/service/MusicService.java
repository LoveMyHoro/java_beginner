package com.horo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.horo.pojo.Music;
import com.horo.utils.Result;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

public interface MusicService {
	Result addMusic(String title, String url);

	Result getMusicList();

	Result getAllMusic();

	Result searchMusic(String keyword) throws JsonProcessingException, UnsupportedEncodingException;


}
