package com.horo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName BeanImportSelector
 * @Author iove
 * @Date 2024/11/20 下午9:52
 * @Version 1.0
 * @Description TODO springboot会通过@Import注解自动调用selectImports方法。将类的bean对象全部注入ioc容器
 **/

public class BeanImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//String[]{}可以放多个全类名
		return new String[]{"com.horo.config.BeanConfig"};
	}
}
