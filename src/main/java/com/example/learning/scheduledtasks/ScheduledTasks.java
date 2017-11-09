package com.example.learning.scheduledtasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaoqicheng on 2017/11/9.
 * <p>
 * 入门
 *
 * 需要现在spring boot 启动类中添加@EnableScheduling 来发现定时任务
 *
 * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
 * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 * @Scheduled(cron="") ：通过cron表达式定义规则
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
