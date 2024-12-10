package com.horo.ioc_01_Bean注解标记和扫描;

import org.springframework.stereotype.Component;

/**
 * projectName: com.atguigu.components
 *
 * description: 普通的组件
 */
//可以指定别名，默认是首字母小写
@Component("component")
public class CommonComponent {
}
