package com.vv.mybatisflex.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author kw
 * @since 2023-09-13
 */
public class CouponTemplateTableDef extends TableDef {

    /**
     * 
     */
    public static final CouponTemplateTableDef couponTemplate = new CouponTemplateTableDef();

    
    public final QueryColumn createTime = new QueryColumn(this, "create_time");

    
    public final QueryColumn updateTime = new QueryColumn(this, "update_time");

    
    public final QueryColumn templateSeq = new QueryColumn(this, "template_seq");

    
    public final QueryColumn deleteStatus = new QueryColumn(this, "delete_status");

    
    public final QueryColumn templateName = new QueryColumn(this, "template_name");

    /**
     * 所有字段。
     */
    public final QueryColumn allColumns = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] defaultColumns = new QueryColumn[]{templateSeq, templateName, createTime, updateTime, deleteStatus};

    public CouponTemplateTableDef() {
        super("", "t_coupon_template");
    }

}
