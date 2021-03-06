package com.example;

import com.example.learning.db.model.User;
import com.example.learning.service.TestServiceImpl;
import com.example.learning.tasks.asynctasks.Task;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootLearningApplication.class)
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class SpringBootLearningApplicationTests {

    @Autowired
    private Task task;

    /**
     * 由于Spring Boot的starter模块提供了自动化配置，所以在引入了spring-boot-starter-mail依赖之后，
     * 会根据配置文件中的内容去创建JavaMailSender实例，因此我们可以直接在需要使用的地方直接@Autowired来引入邮件发送对象。
     */
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
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
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

    /**
     * 带上附件、或是使用邮件模块等。这个时候我们就需要使用MimeMessage来设置复杂一些的邮件内容
     *
     * @throws Exception
     */
    @Test
    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("643198195@qq.com");
        helper.setTo("714103813@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");
        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/img/test.png"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);
        mailSender.send(mimeMessage);
    }

    /**
     * 除了发送附件之外，我们在邮件内容中可能希望通过嵌入图片等静态资源，让邮件获得更好的阅读体验，而不是从附件中查看具体图片，
     * 下面的测试用例演示了如何通过MimeMessageHelper实现在邮件正文中嵌入静态资源。
     * <p>
     * 这里需要注意的是addInline函数中资源名称weixin需要与正文中cid:weixin对应起来
     */
    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("643198195@qq.com");
        helper.setTo("714103813@qq.com");
        helper.setSubject("主题：嵌入静态资源");
//		StringBuffer sb = new StringBuffer();
//		sb.append("<h1>大标题-h1</h1>")
//				.append("<p style='color:#F00'>红色字</p>")
//				.append("<p style='text-align:right'>右对齐</p>");
//		helper.setText(sb.toString(), true);
        /**
         * 第二个参数指定发送的是HTML格式,同时cid:是固定的写法
         */
        helper.setText("<html><body><img src=\"cid:test\" ></body></html>", true);
        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/img/test.png"));
        helper.addInline("test", file);
        mailSender.send(mimeMessage);
    }

    /**
     * 创建模板邮件
     * 在resources 下 创建templates 下面创建 template.vm 文件
     * <p>
     * 关于模板邮件，SpringBoot 原本是支持 velocity，在 1.4 版本后又抛弃了 velocity，暂时只支持 freemaker。
     *
     * @throws Exception
     */
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;  //自动注入

    @Test
    public void sendTemplateMail() throws Exception {
        MimeMessage message = null;
        message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("643198195@qq.com");
        helper.setTo("714103813@qq.com");
        helper.setSubject("主题：模板邮件");
        Map<String, Object> model = new HashMap();
        model.put("username", "zhaoqicheng");
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("template.vm");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        helper.setText(html, true);
        mailSender.send(message);
    }

    @Autowired
    private TestServiceImpl redisService;

    @Test
    public void testPutRedis() throws Exception {
        User user = new User();
        user.setUserName("zhaoqicheng");
        this.redisService.put(redisService.getRedisKey(),user);
    }

    @Test
    public void testGetRedis() throws Exception {
        Object o = this.redisService.get(redisService.getRedisKey());
    }



}
