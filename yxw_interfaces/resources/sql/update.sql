--数据库更新脚本文件
-------------------------------------2015年6月18日 16:10:59 添加/更新字段  更新人：周鉴斌 start------------------------------------------------------
alter table SYS_PAY_SETTINGS add IS_SUB_PAY int(1) comment '是否子商户支付 0：非子商户 1：子商户';

alter table SYS_PAY_SETTINGS add PARTNER_ID VARCHAR(100) comment '合作者Id 暂时为支付宝使用';

alter table SYS_PAY_SETTINGS add SUB_MCH_ID VARCHAR(100) comment '子商户号';

alter table SYS_PAY_MODE add code varchar(50) comment '支付方式编码';



alter table SYS_MENU add OPTIONAL_ID varchar(32) comment '功能ID';

alter table SYS_MENU add GRAPHICS_ID varchar(32) comment '图文ID';

alter table SYS_MENU add MEUN_TYPE int(1) comment '菜单类型 0：功能 1：图文 2：链接地址';


alter table SYS_PLATFORM_SETTINGS add TOKEN varchar(100) comment 'token值';

alter table SYS_PLATFORM_SETTINGS add WECHAT_ACCOUNT varchar(100) comment '微信公众帐号';

alter table SYS_OPTIONAL add BIZ_CODE int(2) comment '公共页面跳转业务编码 挂号：1  门诊：2 住院：3  检验检查：4';

alter table SYS_ATTACH add ATTACH_ID varchar(32) comment '表单ID';

alter table SYS_ATTACH add ATTACH_TYPE int(2) comment '文件类型 0：图片 1：文档 2：密钥 3：其他';

-------------------------------------2015年6月18日 16:10:59 添加/更新字段  更新人：周鉴斌 end------------------------------------------------------


-------------------------------------2015年6月23日 16:10:59 添加/更新字段  更新人：罗斌 start------------------------------------------------------

alter table SYS_MSG_RULE add THIRD_TYPE int comment '公众平台类型（1微信 2支付宝）';

alter table SYS_MSG_MIXED_METERIAL modify CONTENT varchar(10000) comment '正文';


-------------------------------------2015年6月23日 16:10:59 添加/更新字段  更新人：罗斌 end------------------------------------------------------


