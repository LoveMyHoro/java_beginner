package com.horo.part_05_FactoryBean特性和使用;

import org.springframework.beans.factory.FactoryBean;
//<JavaBean>表示FactoryBean的类型
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    String name;
    public JavaBeanFactoryBean(String name) {
        this.name=name;
    }
    @Override
    public JavaBean getObject() throws Exception {
        JavaBean javaBean=new JavaBean();
        javaBean.setName(this.name);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
