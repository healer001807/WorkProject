package com.vv.huttolstudy.clone;

import cn.hutool.core.clone.Cloneable;

/**
 * @author kw
 * @program WorkProject
 * @description 克隆：实现Cloneable接口，需重写clone()方法
 * @create 2023 - 11 - 18 16:13
 **/
public class CarCloneable<T> implements Cloneable<Car> {
    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
