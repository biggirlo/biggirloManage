package com.biggirlo.base.service;

import com.biggirlo.base.mapper.BaseMapper;
import com.biggirlo.base.util.DataTablesParam;
import com.biggirlo.system.model.SysUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.base.select.SelectOneMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 * 基础服务类
 *
 * @author 王雁欣
 * create on 2017/8/30 0:50
 *
 */
public class BaseService<T,M> {

    @Autowired
    protected BaseMapper<T> mapper;

    /**
     * 根据 id 查询 model
     * @param id
     * @return
     */
    public T selectById(M id){
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record
     * @return
     */
    public List<T> select(T record){
        return mapper.select(record);
    }

    /**
     * 查询全部结果
     * @return
     */
    public List<T> selectAll(){
        return this.select(null);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record
     * @return
     */
    public T selectOne(T record){
        return mapper.selectOne(record);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record
     * @return
     */
    public int selectCount(T record){
        return mapper.selectCount(record);
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record
     * @return
     */
    public int insert(T record){
        return mapper.insert(record);
    }

    /**
     * 保存一个列表
     * spring boot 不支持通用mapper的insertList接口,这里只做小批量的插入,大批量的插入请自行写sql
     * @param list
     * @return
     */
    public int insertList(List<T> list){
        int count = 0;
        for(T t:list){
            count += mapper.insert(t);
        }
        //return mapper.insertList(list);
        return count;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record
     * @return
     */
    public int  updateAllById(T record){
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 根据主键更新属性不为null的值
     * @param record
     * @return
     */
    public int update(T record){
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除 支持批量
     * @param args
     * @return
     */
    public int deletes(M... args){
        List<T> tt  = new ArrayList<>();
        mapper.insertList(tt);
        return mapper.delectByPrimaryKeys("1");
        /*int count = 0;
        for(M m : args)
            count += mapper.deleteByPrimaryKey(m);
        return count;*/
    }

    public int deleteObjs(T... args){
        //return system.delete(args);
        int count = 0;
        /*for(T t : args)
            count += mapper.delete(t);*/
        return count;
    }

    /**
     * 返回datables数据结果
     * @param param
     */
    public DataTablesParam selectByDatetable(DataTablesParam param, T obj){

        //启动分页
        PageHelper.startPage(param.getStart(), param.getLength());
        Map<String,Object> result = new HashMap<>();
        PageInfo<T> page = new PageInfo<T>(mapper.select(obj));
        param.setRecordsTotal(page.getTotal());
        param.setRecordsFiltered(page.getTotal());
        param.setData( page.getList());
        return param;
    }
}
