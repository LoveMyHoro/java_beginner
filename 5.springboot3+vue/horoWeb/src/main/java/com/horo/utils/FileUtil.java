package com.horo.utils;

import java.util.Arrays;

public class FileUtil {

    // 示例代码 - 以调整isFileAllowed为例
    public static boolean isFileAllowed(String fileExt) {
        // 确保包含音乐文件的扩展名
        String[] allowedExtensions = { "jpg", "jpeg", "png", "gif", "mp3", "wav", "mp4" }; // 这里添加你需要的扩展名
        return Arrays.asList(allowedExtensions).contains(fileExt);
    }
}
