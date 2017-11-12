package com.biggirlo.base.mapper.custom;


import org.apache.ibatis.annotations.DeleteProvider;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;

/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 *
 * @author 王雁欣
 * create on 2017/8/30 2:01
 * 自定义mapper通用基础接口
 * 根据主键组批量删除
 */
public interface DelectByPrimaryKeysMapper<T> {

   /* @DeleteProvider(
            type = CostomProvider.class,
            method = "dynamicSQL"
    )
    *//**
     * 根据主键组批量删除
     * @param record
     * @return
     *//*
    int delectByPrimaryKeys(Object record);*/
    @DeleteProvider(
            type = BaseDeleteProvider.class,
            method = "dynamicSQL"
    )
    int delete(T var1);
}
