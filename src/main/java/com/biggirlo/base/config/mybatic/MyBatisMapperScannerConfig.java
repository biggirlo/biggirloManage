package com.biggirlo.base.config.mybatic;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import com.biggirlo.base.util.YamlLoadUtil;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.xml.bind.PropertyException;
import java.util.Properties;

/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 *
 * mybatic扫描配置
 *
 * @author 王雁欣
 * create on 2017/8/30 0:50
 *
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
class MyBatisMapperScannerConfig {

    //private Logger LOGGER = LogManager.getLogger(MyBatisMapperScannerConfig.class);

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {

        //LOGGER.debug("扫描 Mybatis 配置");

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        try {

            PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");

            if (propertySource.getProperty("mybatis.config.basePackage").toString() == null) {
                throw new PropertyException("缺少 application.yml: mybatis.config.basePackage 属性");
            }

            if (propertySource.getProperty("mybatis.config.mappers").toString() == null) {
                throw new PropertyException("缺少 application.yml: mybatis.config.mappers 属性");
            }

            if (propertySource.getProperty("mybatis.config.identity") == null) {
                throw new PropertyException("缺少 application.yml: mybatis.config.identity 属性");
            }

            mapperScannerConfigurer.setBasePackage(propertySource.getProperty("mybatis.config.basePackage").toString());
            Properties properties = new Properties();
            properties.setProperty("mappers", propertySource.getProperty("mybatis.config.mappers").toString());
            properties.setProperty("IDENTITY", propertySource.getProperty("mybatis.config.identity").toString());
            mapperScannerConfigurer.setProperties(properties);
        } catch (PropertyException e) {
            e.printStackTrace();
        }

        return mapperScannerConfigurer;
    }

}
