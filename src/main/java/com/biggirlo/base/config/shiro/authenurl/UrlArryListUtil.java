/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.base.config.shiro.authenurl;

import com.biggirlo.system.model.SysHandle;
import com.biggirlo.system.model.SysMenu;
import com.biggirlo.system.service.SysHandleService;
import com.biggirlo.system.service.SysMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 王雁欣
 * create on 2017/11/22 22:03 
 */
@Component
public class UrlArryListUtil implements ApplicationListener<ContextRefreshedEvent> {
    Logger logg= Logger.getLogger(UrlArryListUtil.class);

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysHandleService sysHandleService;

    private UrlArryListUtil(){
    }

    private static UrlArryListUtil urlArryListUtil = null;
    //静态工厂方法
    public static synchronized  UrlArryListUtil getInstance() {
        return urlArryListUtil;
    }

    private List<URL> urls = new ArrayList<>();

    public  List<URL> getUrls() {
        return urls;
    }

    public void setUrls( List<URL> urls) {
        this.urls = urls;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(urlArryListUtil == null)
            urlArryListUtil = new UrlArryListUtil();
        //获取所有的url和编码
        //获取所有的接口url
        SysMenu sysMenuSearch = new SysMenu();
        sysMenuSearch.setType(2L);
        List<SysMenu> sysMenuList = sysMenuService.select(sysMenuSearch);
        for(SysMenu sysMenu : sysMenuList){
            URL url = new URL();
            url.setCode(sysMenu.getMenuCode());
            url.setUrl(sysMenu.getUrl());
            url.setIsAvailable(1);//暂时默认启用
            urls.add(url);
        }

        //获取所有的操作
        List<SysHandle> sysHandleList = sysHandleService.selectAll();
        for(SysHandle sysHandle:sysHandleList){
            URL url = new URL();
            url.setCode(sysHandle.getHandleCode());
            url.setUrl(sysHandle.getUrl());
            url.setIsAvailable(sysHandle.getIsAvailable());
            urls.add(url);
            }

    }
}
