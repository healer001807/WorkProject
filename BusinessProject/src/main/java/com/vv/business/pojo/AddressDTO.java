package com.vv.business.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author kw
 * @program WorkProject
 * @description 地址实体
 * @create 2023 - 07 - 12 20:52
 **/
@Data
@Builder(toBuilder = true)
public class AddressDTO {
    /**
     * 编码
     */
    private Integer id;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 市编码
     */
    private String addressCode;
    /**
     * 市名称
     */
    private String addressName;
    /**
     * 状态 0-正常 1-停用 2-删除
     */
    private Integer addressState;
    /**
     * 级次id 0:省/自治区/直辖市 1:市级 2:县级
     */
    private Integer addressLevel;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除状态 0-否 1-是
     */
    private Integer deleteStatus;
}
