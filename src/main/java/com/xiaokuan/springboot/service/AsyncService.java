package com.xiaokuan.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Async  //告诉spring这是一个异步方法  结果立即响应
    public void hello(){
        try {
            Thread.sleep(3000); //睡眠3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中....");
    }
}
