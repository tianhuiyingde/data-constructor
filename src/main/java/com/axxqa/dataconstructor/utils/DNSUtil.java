package com.axxqa.dataconstructor.utils;

import com.axxqa.automation.utils.ConfigUtil;
import com.axxqa.automation.utils.PropertiesUtil;
import io.leopard.javahost.JavaHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author tianhuiying on 2021/6/1.
 * @version 1.0
 */
public class DNSUtil {
    private final static Logger logger = LoggerFactory.getLogger(DNSUtil.class);

    private volatile static DNSUtil instance = null;
    private final static String PROPERTIES_NAME = "./src/main/resources/test_ghost/host.properties";

    private DNSUtil() {
        try {
            String env =  ConfigUtil.getString("env");
            logger.info("*********** 加载dns文件, 环境env:{}, 文件:{} ******** ",env,PROPERTIES_NAME);

            Properties properties = PropertiesUtil.getProperties(PROPERTIES_NAME);
            int count = JavaHost.updateVirtualDns(properties);

            logger.info("加载dns文件成功, 环境env:{}, 文件:{}, count:{}",env,PROPERTIES_NAME,count);
            JavaHost.printAllVirtualDns();// 打印所有虚拟DNS记录
        } catch (Exception e) {
            throw new IllegalStateException("dns 加载出错，请检查host配置");
        }
    }

    public static synchronized DNSUtil initDns(){
        if (instance == null ){
            synchronized (DNSUtil.class) {
                if(instance == null) {
                    instance = new DNSUtil();
                }
            }
        }
        return instance;
    }

}