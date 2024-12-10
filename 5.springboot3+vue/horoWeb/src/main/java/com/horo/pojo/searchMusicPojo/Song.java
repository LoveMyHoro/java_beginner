package com.horo.pojo.searchMusicPojo;

import lombok.Data;

import java.util.List;
@Data
public class Song {
    private long id;  
    private String name;
    private String picPath;
    private List<Artist> artists;
    private Album album;  
    private long duration;  
    private int copyrightId;  
    private int status;  
    private List<String> alias;  
    private int rtype;  
    private int ftype;  
    private long mvid;  
    private int fee;  
    private String rUrl;  
    private long mark;


    // getters and setters  
}  