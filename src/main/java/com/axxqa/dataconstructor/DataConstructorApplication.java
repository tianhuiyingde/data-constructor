package com.axxqa.dataconstructor;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@MapperScan("com.axxqa.dataconstructor.mapper")
public class DataConstructorApplication {

    //修改启动日志文案
    private static final Logger LOG= LoggerFactory.getLogger(DataConstructorApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(DataConstructorApplication.class, args);
        SpringApplication app= new SpringApplication(DataConstructorApplication.class);
        Environment env=app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("访问地址：\thttp://127.0.0.1/{}",env.getProperty("server.port"));
    }

}
