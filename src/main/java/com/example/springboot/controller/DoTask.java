package com.example.springboot.controller;

import com.example.springboot.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("tasks")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("test1")
    public String test1() throws InterruptedException {

        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask11();
        Future<Boolean> c = asyncTask.doTask11();

        while (!a.isDone() || !b.isDone() || !c.isDone()){
            if (a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }

        long end = System.currentTimeMillis();
        String times = "任务总耗时："+(end-start)+" 毫秒";
        System.out.println(times);
        return times;
    }

}
