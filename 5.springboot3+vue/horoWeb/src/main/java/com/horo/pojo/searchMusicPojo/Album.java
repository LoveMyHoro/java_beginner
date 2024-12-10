package com.horo.pojo.searchMusicPojo;

import lombok.Data;

@Data
public class Album {
    private long id;  
    private String name;  
    private Artist artist;  
    private long publishTime;  
    private int size;  
    private int copyrightId;  
    private int status;  
    private long picId;  
    private int mark;  

    // getters and setters  
}  