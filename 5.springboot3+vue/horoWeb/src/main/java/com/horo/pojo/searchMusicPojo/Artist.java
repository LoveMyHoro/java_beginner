package com.horo.pojo.searchMusicPojo;

import lombok.Data;

import java.util.List;
@Data
public class Artist {
    private long id;  
    private String name;  
    private String picUrl;  
    private List<String> alias;
    private int albumSize;  
    private long picId;  
    private String fansGroup;  
    private String img1v1Url;  
    private int img1v1;  
    private String trans;  

    // getters and setters  
}  