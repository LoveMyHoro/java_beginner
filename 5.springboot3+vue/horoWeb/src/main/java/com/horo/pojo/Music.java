package com.horo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Music
 * @Author iove
 * @Date 2024/11/14 下午9:33
 * @Version 1.0
 * @Description TODO
 **/
@Data
@TableName(value = "music")
public class Music {
	Integer id;
	String url;
	String title;
	Integer userId;
}
