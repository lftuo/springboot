package com.example.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每过3秒执行
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println("现在时间：" + dataFormat.format(new Date()));
    }
}