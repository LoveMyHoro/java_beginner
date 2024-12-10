package com.horo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.awt.image.ImageConsumer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommonImportSelector
 * @Author iove
 * @Date 2024/10/31 下午6:20
 * @Version 1.0
 * @Description TODO 这个类主要是用于将导入外部bean的配置类的地址集中到一起，提供@Import注解导入到容器中
 **/

public class CommonImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> imports = new ArrayList<>();
        InputStream is=CommonImportSelector.class.getClassLoader().getResourceAsStream("common.imports");
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String line=null;
        try {
            while((line=br.readLine())!=null){
                imports.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return imports.toArray(new String[0]);
    }
}
