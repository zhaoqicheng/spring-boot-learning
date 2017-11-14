package com.example.learning.tasks.asynctasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by zhaoqicheng on 2017/11/14.
 *
 * “异步调用”对应的是“同步调用”，同步调用指程序按照定义顺序依次执行，每一行程序都必须等待上一行程序执行完成之后才能执行；
 *  异步调用指程序在顺序执行时，不等待异步调用的语句返回结果就执行后面的程序。
 *
 *  注： @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
 *
 *  为了让@Async注解能够生效，还需要在Spring Boot的主程序中配置@EnableAsync
 *
 *  异步回调:
 *  为了让doTaskOne、doTaskTwo、doTaskThree能正常结束，假设我们需要统计一下三个任务并发执行共耗时多少，
 *  这就需要等到上述三个函数都完成调动之后记录时间，并计算结果。
 *
 *  那么我们如何判断上述三个异步调用是否已经执行完成呢？我们需要使用Future<T>来返回异步调用的结果，就像如下方式改造doTaskOne函数：
 *
 */
@Component
public class Task {

    public static Random random = new Random();

    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
}