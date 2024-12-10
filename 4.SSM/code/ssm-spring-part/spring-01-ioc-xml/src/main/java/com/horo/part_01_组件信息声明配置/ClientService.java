package com.horo.part_01_组件信息声明配置;

public class ClientService {
  //静态工厂
  private static ClientService clientService = new ClientService();
  private ClientService() {}
  public static ClientService createInstance() {

    return clientService;
  }
}