package com.horo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.horo.pojo.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MusicMapper{
	void addMusic(@Param("url") String url, String title, Integer userId);

	List<Map> getMusicList(Integer userId);

	List<Map> getAllMusic();

	List<Music> getMusicByTitle(String title,Integer userId);
}
