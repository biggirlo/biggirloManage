package com.biggirlo.base.mapper.provider;


import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;


/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 *
 *
 * @author 王雁欣
 * create on 2017/8/30 2:07
 */
public class CostomProvider extends MapperTemplate {

    public CostomProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 根据主键批量删除
     * @param ms
     * @return
     */
   public String delectByPrimaryKeys(MappedStatement ms){
       final Class<?> entityClass = this.getEntityClass(ms);
       //获取表的各项属性
       EntityTable table = EntityHelper.getEntityTable(entityClass);

       //开始拼sql
       StringBuilder sql = new StringBuilder();
       sql.append("delete from ");
       sql.append(table.getName());
       sql.append("<where>");
       boolean first = true;
       sql.append(table.getKeyProperties());
       sql.append("=");
       sql.append(" <foreach collection=\"array\" item=\"record\" separator=\",\" >");
       for (EntityColumn column : table.getEntityClassColumns())
           sql.append("#{record} ");
       sql.append("</foreach>");
       sql.append("</where>");
       return sql.toString();
   }


}
