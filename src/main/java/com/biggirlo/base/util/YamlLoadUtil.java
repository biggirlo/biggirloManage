package com.biggirlo.base.util;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 *
 * \基础控制器
 *
 * @author 王雁欣
 * create on 2017/8/30 0:50
 *
 */
public class YamlLoadUtil {

    //static Logger LOGGER = LogManager.getLogger(YamlLoadUtil.class);

    /**
     * 获取ymal加载类
     * @param resources
     * @return
     */
    public static PropertySource getYamlLoad(String resources) {
        //读取配置信息
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        YamlPropertySourceLoader yamlLoader = new YamlPropertySourceLoader();
        PropertySource propertySource = null;
        try {
            propertySource = yamlLoader.load("application",resolver.getResource(resources), null);
        } catch (IOException e) {
            //LOGGER.info("加载 application.yml 配置文件失败");
            e.printStackTrace();
        }

        return propertySource;
    }
}
