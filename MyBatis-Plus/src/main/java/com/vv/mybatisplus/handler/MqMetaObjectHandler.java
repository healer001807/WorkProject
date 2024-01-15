package com.vv.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 01 - 15 20:37
 **/
@Component
public class MqMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入前调用，需要再字段加@TableField(fill = FieldFill.INSERT_UPDATE)注解
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter("createTime") && metaObject.getValue("createTime") != null) {
            metaObject.setValue("createTime", new Date());
        }
    }
    /**
     * 更新前调用，需要再字段加@TableField(fill = FieldFill.INSERT_UPDATE)注解
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
