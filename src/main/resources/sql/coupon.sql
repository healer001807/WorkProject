create table vv_work.t_coupon
(
    coupon_seq    varchar(64) not null primary key comment '券序列号',
    user_phone    varchar(12) not null comment '用户手机号',
    template_seq  varchar(32) not null comment '券模板',
    coupon_status varchar(12) not null default 0 comment '券状态 0-未使用 1-已使用',
    create_time   date comment '创建时间',
    update_time   date comment '更新时间'
);