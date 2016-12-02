/*=======================================================================================================*/
/*                                                                                                       */
/*                                        医享网络接口转换系统建库建表sql                                         */
/*                                                                                                       */
/*                                                                                                       */
/*========================================创建数据库 2015-07-02 start =======================================*/
/*修改数据库最大链接数*/
set GLOBAL max_connections=300;
/*创建用户*/
CREATE USER 'yx129_interfaces'@'localhost' IDENTIFIED BY 'Yixiang129&*(_';
/*创建数据库*/
CREATE DATABASE IF NOT EXISTS yx129_interfaces DEFAULT CHARSET UTF8 COLLATE UTF8_GENERAL_CI;
/*授权*/
GRANT ALL PRIVILEGES ON *.* TO 'root'@'183.6.161.130' IDENTIFIED BY 'Yixiang129!@#$;' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON yx129_interfaces.* TO 'yx129_interfaces'@'183.6.161.130' IDENTIFIED BY 'Yixiang129&*(_' WITH GRANT OPTION;
/*刷新系统权限表*/
FLUSH PRIVILEGES;
/*修改数据包大小为10M*/
set global max_allowed_packet=1048576*10;
/*========================================创建数据库 2015-07-02 end =========================================*/

/*========================================创建表 2015-07-02 start ==========================================*/
/*==============================================================*/
/* Table: INTERFACES_DEPARTMENT         科室                                                           */
/*==============================================================*/
drop table if exists INTERFACES_DEPARTMENT;
create table INTERFACES_DEPARTMENT
(
   ID                   varchar(32) not null comment '主键ID',
   BRANCH_CODE          varchar(100) comment '医院代码,医院没有分院则返回空字符串',
   BRANCH_NAME          varchar(100) comment '医院名称,医院没有分院则返回空字符串',
   DEPT_CODE            varchar(100) comment '科室代码',
   DEPT_NAME            varchar(100) comment '科室名称',
   DEPT_TELEPHONE       varchar(100) comment '科室电话',
   DEPT_DESCRIPTION     varchar(1000) comment '科室介绍',
   DEPT_LOCATION        varchar(1000) comment '科室位置描述',
   PARENT_DEPT_CODE     varchar(100) comment '父科室代码,0表示没有父科室',
   primary key (ID)
);
/*==============================================================*/
/* Table: INTERFACES_MEDICALCARD         诊疗卡                                                       */
/*==============================================================*/
drop table if exists INTERFACES_MEDICALCARD;
create table INTERFACES_MEDICALCARD
(
   ID                    varchar(32) not null comment '主键ID',
   PAT_ID                varchar(100) comment '患者唯一标识',
   PAT_TYPE              varchar(100) comment '患者类型,1：成人,2：儿童',
   PAT_NAME              varchar(100) comment '姓名',
   PAT_CARD_TYPE         varchar(100) comment '诊疗卡类型',
   PAT_CARD_NO           varchar(100) comment '诊疗卡号码',
   PAT_ID_TYPE           varchar(100) comment '证件类型,1:二代身份证,2:港澳居民身份证,3:台湾居民身份证,4:护照,5:士官证',
   PAT_ID_NO             varchar(100) comment '证件号码,患者类型为“2”儿童时，该项允许为空',
   PAT_SEX               varchar(100) comment '性别,M：男，F：女',
   PAT_BIRTH             varchar(100) comment '出生日期',
   PAT_ADDRESS           varchar(100) comment '地址',
   PAT_MOBILE            varchar(100) comment '电话',
   GUARD_NAME            varchar(100) comment  '联系人姓名,患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回',
   GUARD_ID_TYPE         varchar(100) comment '联系人证件类型, 患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回',
   GUARD_ID_NO           varchar(100) comment '联系人证件号码,患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回',
   GUARD_MOBILE			 varchar(100) comment '联系人电话',
   GUARD_ADDRESS		 varchar(1000) comment '联系人地址',
   primary key (ID)
);
/*==============================================================*/
/* Table: INTERFACES_ORDERREG_MEDICALCARD         挂号诊疗信息                                                       */
/*==============================================================*/
drop table if exists INTERFACES_ORDERREG_MEDICALCARD;
create table INTERFACES_ORDERREG_MEDICALCARD
(
   ID                   varchar(32) not null comment '主键ID',
   LOCK_ID				varchar(100)  comment '锁号ID',
   LOCK_DATE			datetime	  comment '锁号时间',
   PAT_ID               varchar(100) comment '患者主键',
   PAT_TYPE              varchar(100) comment '患者类型,1：成人,2：儿童',
   PAT_NAME              varchar(100) comment '姓名',
   PAT_SEX               varchar(100) comment '性别,M：男，F：女',
   PAT_BIRTH             varchar(100) comment '出生日期',
   PAT_ADDRESS           varchar(100) comment '地址',
   PAT_MOBILE            varchar(100) comment '电话',
   PAT_CARD_TYPE          varchar(100) comment '诊疗卡类型,1:院内诊疗卡,2:社保卡,3:医保卡,4:区域健康卡(健康卡也是该编号),5:身份证, 6:市民卡,7:患者唯一标识(patientId),8:临时诊疗卡,9:医疗证,10:银联卡',
   PAT_CARD_NO            varchar(100) comment '诊疗卡号码',
   PAT_ID_TYPE            varchar(100) comment '证件类型,1:二代身份证,2:港澳居民身份证,3:台湾居民身份证,4:护照',
   PAT_ID_NO              varchar(100) comment '证件号码,患者类型为“2”儿童时，该项允许为空',
   GUARD_NAME            varchar(100) comment '监护人姓名,患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回',
   GUARD_ID_TYPE          varchar(100) comment '监护人证件类型, 患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回',
   GUARD_ID_NO            varchar(100) comment '监护人证件号码,患者类型为“1”成人时，该项允许为空,患者类型为“2”儿童时，该项必须返回',
   HAS_MEDICARE          varchar(100) comment '是否绑定医保,未知：0,绑定：1,未绑定：2',
   primary key (ID)
);
/*==============================================================*/
/* Table: INTERFACES_REGISTERDOCTOR         医生                                                          */
/*==============================================================*/
drop table if exists INTERFACES_REGISTERDOCTOR;
create table INTERFACES_REGISTERDOCTOR
(
   ID                   varchar(32) not null comment '主键ID',
   BRANCH_CODE           varchar(100) comment '医院代码,医院没有分院则返回空字符串',
   BRANCH_NAME           varchar(100) comment '医院名称,医院没有分院则返回空字符串',
   DEPT_CODE             varchar(100) comment '科室代码',
   DEPT_NAME             varchar(100) comment '科室名称',
   DOCTOR_CODE           varchar(100) comment '医生代码,若只存在医生代码或只存在医生工号，则两者返回相同的值',
   DOCTOR_NO             varchar(100) comment '医生工号',
   DOCTOR_NAME           varchar(100) comment '医生名称',
   DOCTOR_SEX            varchar(100) comment '医生性别',
   DOCTOR_BIRTH          varchar(100) comment '出生日期',
   DOCTOR_TELEPHONE      varchar(100) comment '医生电话',
   DOCTOR_SKILL          varchar(1000) comment '医生擅长',
   DOCTOR_INTRODUTION    varchar(1000) comment '医生简介',
   DOCTOR_TITLE          varchar(100) comment '医生职称',
   PICTURE              varchar(1000) comment '照片,可供外网访问的url路径(要jpg，200X200px以上大小，最好是生活照（医生自己觉得自己最满意的照片）。如果没有，工作照也可以)',
   primary key (ID)
);


/*==============================================================*/
/* Table: INTERFACES_REGINFODETAIL         号源                                                   */
/*==============================================================*/
drop table if exists INTERFACES_REGINFODETAIL;
create table INTERFACES_REGINFODETAIL
(
   ID                    varchar(32) not null comment '主键ID',
   REG_DATE				 varchar(100) comment '号源日期',
   BRANCH_CODE			 varchar(100) comment '分院代码',
   DEPT_CODE			 varchar(100) comment '科室代码',
   DOCTOR_CODE			 varchar(100) comment '医生代码',
   TIME_FLAG             varchar(100) comment '时段,1:上午,2:下午,3:晚上,4:全天',
   HAS_DETAIL_TIME       varchar(100) comment '是否有分时,0:无分时,1:有分时',
   BEGIN_TIME            varchar(100) comment '开始时间,格式：HH24:MI',
   END_TIME              varchar(100) comment '结束时间,格式：HH24:MI',
   WORK_STATUS           varchar(100) comment '出诊状态,1:出诊,2:停诊',
   TOTAL_NUM             varchar(100) comment '号源总数',
   LEFT_NUM              varchar(100) comment '剩余可预约号源数',
   REG_FEE               varchar(100) comment '挂号费,单位:分',
   TREAT_FEE             varchar(100) comment '诊疗费,单位:分',
   WORK_ID               varchar(100) comment '排班ID',
   primary key (ID)
);


/*==============================================================*/
/* Table: INTERFACES_FRIED_DELIVERY         代煎配送                         */
/*==============================================================*/
drop table if exists INTERFACES_FRIED_DELIVERY;
CREATE TABLE INTERFACES_FRIED_DELIVERY (
  ID varchar(32) NOT NULL,
  BRANCH_CODE varchar(100) DEFAULT NULL COMMENT '医院代码',
  MZ_FEE_ID varchar(4000) NOT NULL COMMENT '缴费项唯一标识',
  RECIPE_ID varchar(100) DEFAULT NULL COMMENT '处方单、检查单、检验单、治疗单等ID',
  FRIED varchar(10) DEFAULT NULL COMMENT '是否代煎，0：不代煎，1：代煎',
  DELIVERED varchar(10) DEFAULT NULL COMMENT '是否配送，0：不配送，1：配送',
  PROVINCE varchar(255) DEFAULT NULL COMMENT '省',
  CITY varchar(255) DEFAULT NULL COMMENT '市',
  COUNTY varchar(255) DEFAULT NULL COMMENT '县区',
  ADDRESS varchar(1000) DEFAULT NULL COMMENT '详细地址',
  POSTCODE varchar(255) DEFAULT NULL COMMENT '邮编',
  CONTACTS varchar(255) DEFAULT NULL COMMENT '联系人',
  MOBILE varchar(255) DEFAULT NULL COMMENT '联系人手机',
  TELEPHONE varchar(255) DEFAULT NULL COMMENT '联系人固话',
  CREATE_TIME datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (ID),
  KEY idx_FRIED_DELIVERED_recipe_id (RECIPE_ID),
  KEY idx_FRIED_DELIVERED_mz_fee_id (MZ_FEE_ID(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*========================================创建表 2015-07-02 end ==========================================*/

/*========================================清空表数据 2015-07-02 start ==========================================*/
TRUNCATE TABLE INTERFACES_DEPARTMENT;
TRUNCATE TABLE INTERFACES_MEDICALCARD;
TRUNCATE TABLE INTERFACES_REGINFODETAIL;
TRUNCATE TABLE INTERFACES_REGISTERDOCTOR;
TRUNCATE TABLE INTERFACES_ORDERREG_MEDICALCARD;
/*========================================清空表数据 2015-07-02 end ==========================================*/
