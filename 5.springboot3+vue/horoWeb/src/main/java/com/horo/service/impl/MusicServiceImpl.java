package com.horo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horo.mapper.MusicMapper;
import com.horo.pojo.Music;
import com.horo.pojo.searchMusicPojo.MusicSearchResult;
import com.horo.pojo.searchMusicPojo.Song;
import com.horo.service.MusicService;
import com.horo.utils.Result;
import com.horo.utils.ThreadLocalUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MusicServiceImpl
 * @Author iove
 * @Date 2024/11/14 下午9:37
 * @Version 1.0
 * @Description TODO
 **/
@Service
public class MusicServiceImpl implements MusicService {
	@Autowired
	private MusicMapper musicMapper;
	@Override
	public Result addMusic(String title, String url) {
		Integer userId=ThreadLocalUtil.get();
		List<Music> musicList=musicMapper.getMusicByTitle(title,userId);
		if(musicList.size()!=0){
			return Result.error("该音乐文件云端已存在!");
		}
		System.out.println("url:"+url);
		System.out.println("title:"+title);
		System.out.println("userId:"+userId);
		musicMapper.addMusic(url,title,userId);
		return Result.ok(url);
	}

	@Override
	public Result getMusicList() {
		Integer userId=ThreadLocalUtil.get();
		List<Map>musicList=musicMapper.getMusicList(userId);
		return Result.ok(musicList);
	}

	@Override
	public Result getAllMusic() {
		List<Map>allList=musicMapper.getAllMusic();
		return Result.ok(allList);
	}

	/**
	 * 搜索音乐
	 * @param keyword
	 * @return
	 * 以下是检索音乐时返回的json数据的岑层次结构
	 *result
	 * ├── songs
	 * │   ├── song (第1首歌曲)
	 * │   │   ├── id
	 * │   │   ├── name
	 * │   │   ├── artists
	 * │   │   │   ├── artist (第1位艺术家)
	 * │   │   │   │   ├── id
	 * │   │   │   │   ├── name
	 * │   │   │   │   ├── ... (其他艺术家属性)
	 * │   │   │   └── ... (更多艺术家)
	 * │   │   ├── album
	 * │   │   │   ├── id
	 * │   │   │   ├── name
	 * │   │   │   ├── artist
	 * │   │   │   │   ├── id
	 * │   │   │   │   ├── name
	 * │   │   │   │   ├── ... (其他艺术家属性)
	 * │   │   ├── ... (其他歌曲属性)
	 * │   └── ... (更多歌曲)
	 * ├── hasMore
	 * └── songCount
	 */
	/**详细的内容
	 * {
	 *   "result": {
	 *     "songs": [
	 *       {
	 *         "id": "song_id",
	 *         "name": "song_name",
	 *         "artists": [
	 *           {
	 *             "id": "artist_id",
	 *             "name": "artist_name",
	 *             "img1v1Url": "artist_image_url"
	 *           },
	 *           // 可以有多个艺术家
	 *         ],
	 *         "album": {
	 *           "id": "album_id",
	 *           "name": "album_name",
	 *           "artist": {
	 *             "id": "artist_id",
	 *             "name": "artist_name",
	 *             "img1v1Url": "artist_image_url"
	 *           },
	 *           "publishTime": "publish_time",
	 *           "picId": "album_cover_id"
	 *         },
	 *         "duration": "song_duration",
	 *         "alias": ["song_alias"],
	 *         "fee": "song_fee"
	 *       },
	 *       // 后续还有更多歌曲对象
	 *     ],
	 *     "hasMore": "boolean",
	 *     "songCount": "total_songs"
	 *   },
	 *   "code": "response_code"
	 * }
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper; // 用于解析JSON

	@Override
	public Result<MusicSearchResult> searchMusic(String keyword) throws JsonProcessingException, UnsupportedEncodingException {
		String url = "https://music.163.com/api/search/get";
		System.out.println("keyword:" + keyword);
		//用于处理url
		String finalUrl = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("s", keyword)
				.queryParam("type", 1) // type 1 for music
				.queryParam("offset", 0)
				.queryParam("limit", 15)
				.build(false)
				.toUriString();

		System.out.println(finalUrl);
		//RestTemplate是Spring框架提供的一个用于访问REST服务的客户端类。
		//getForEntity(String url, Class<T> responseType)是RestTemplate类的一个方法，用于发送一个HTTP GET请求
		// 到指定的URL，并期望返回一个指定类型的响应体。ResponseEntity<String>
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(finalUrl, String.class);
		String responseBody = responseEntity.getBody();

		if (responseBody == null) {
			return Result.error("No response received from the server.");
		}
		//ObjectMapper objectMapper这是一个Jackson库的类，用于处理JSON数据。
		//readTree方法将JSON字符串（responseBody）解析为一个JsonNode对象，这个对象代表了JSON文档的根节点。
		JsonNode rootNode = objectMapper.readTree(responseBody);
		//path方法用于获取根节点下的"result"子节点,再将其转化为JsonNode对象
		JsonNode resultNode = rootNode.path("result");
		//这次是result路径下的songs
		JsonNode songsNode = resultNode.path("songs");

		//自定义的类，用于存储解析后的音乐搜索结果。
		MusicSearchResult searchResult = new MusicSearchResult();
		//1.convertValue方法将JSON节点songsNode转换为Java对象列表。这里使用了getTypeFactory()
		// .constructCollectionType(List.class, Song.class)来指定转换的目标类型是一个Song对象的List。
		List<Song> songs = objectMapper.convertValue(songsNode, objectMapper.getTypeFactory().constructCollectionType(List.class, Song.class));
		for(Song song :songs){
			String songDetailUrl="https://music.163.com/api/song/detail";
			String songId="["+song.getId()+"]";
			String finalSongDetailUrl=UriComponentsBuilder.fromHttpUrl(songDetailUrl)
					.queryParam("ids",songId)
					.build(false)
					.toUriString();
			ResponseEntity<String>songDetailResponseEntity = restTemplate.getForEntity(finalSongDetailUrl, String.class);
			String songDetailResponseBody = songDetailResponseEntity.getBody();
			System.out.println("这是在循环里面："+songDetailResponseBody);
			if (songDetailResponseBody != null) {
				JsonNode songDetailRootNode = objectMapper.readTree(songDetailResponseBody);
				JsonNode songsDetailNode = songDetailRootNode.path("songs");
				if(songsDetailNode.isArray()&&songsDetailNode.size()!=0){
					JsonNode songDetailJsonNode = songsDetailNode.get(0);
					JsonNode albumPicUrlNode = songDetailJsonNode.path("album").path("picUrl");
					System.out.println("albumPicUrlNode:"+albumPicUrlNode);
					if(!albumPicUrlNode.isMissingNode()){
						String newAlbumPicUrl=albumPicUrlNode.asText();
						song.setPicPath(newAlbumPicUrl);
					}
				}
			}
		}
		searchResult.setSongs(songs);
		//从"result"节点中获取"hasMore"键的值，并将其转换为布尔值，然后设置到MusicSearchResult对象的hasMore属性中。
		searchResult.setHasMore(resultNode.path("hasMore").asBoolean());
		//从"result"节点中获取"songCount"键的值，并将其转换为整数，然后设置到MusicSearchResult对象的songCount属性中。
		searchResult.setSongCount(resultNode.path("songCount").asInt());

		return Result.ok(searchResult);
	}


}
