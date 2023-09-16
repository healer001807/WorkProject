package com.vv.mybatisflex.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author kw
 * @since 2023-09-13
 */
public class CouponTableDef extends TableDef {

    /**
     * 
     */
    public static final CouponTableDef coupon = new CouponTableDef();

    /**
     * 券序列号
     */
    public final QueryColumn couponSeq = new QueryColumn(this, "coupon_seq");

    /**
     * 用户手机号
     */
    public final QueryColumn userPhone = new QueryColumn(this, "user_phone");

    /**
     * 创建时间
     */
    public final QueryColumn createTime = new QueryColumn(this, "create_time");

    /**
     * 更新时间
     */
    public final QueryColumn updateTime = new QueryColumn(this, "update_time");

    /**
     * 券模板
     */
    public final QueryColumn templateSeq = new QueryColumn(this, "template_seq");

    /**
     * 券状态 0-未使用 1-已使用
     */
    public final QueryColumn couponStatus = new QueryColumn(this, "coupon_status");

    /**
     * 所有字段。
     */
    public final QueryColumn allColumns = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] defaultColumns = new QueryColumn[]{couponSeq, userPhone, templateSeq, couponStatus, createTime, updateTime};

    public CouponTableDef() {
        super("", "t_coupon");
    }

}
