package com.horo.pojo.searchMusicPojo;

import lombok.Data;

import java.util.List;
@Data
public class MusicSearchResult {
    private List<Song> songs;
    private boolean hasMore;  
    private int songCount;  

    // getters and setters  
}  