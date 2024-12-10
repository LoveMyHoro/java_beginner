package com.horo.part_01_组件信息声明配置;

public class DefaultServiceLocator {
    //非静态工厂
    private static ClientServiceImpl clientService= new ClientServiceImpl();
    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
}