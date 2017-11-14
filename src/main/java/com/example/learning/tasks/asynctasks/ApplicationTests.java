package com.example.learning.tasks.asynctasks;

import com.example.SpringBootLearningApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.Future;

/**
 * Created by zhaoqicheng on 2017/11/14.
 * 测试类
 */
@RunWith(SpringRunner.class) //14.版本之前用的是SpringJUnit4ClassRunner.class
@SpringBootTest(classes = SpringBootLearningApplication.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private Task task;

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void test() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    @Test
    public void testDown() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }


    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("643198195@qq.com");
        message.setTo("714103813@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }
}
