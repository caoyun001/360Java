CREATE TABLE t_company 
(
   c_id                 INT          AUTO_INCREMENT,
   shrot_name           VARCHAR(10),
   is_famous            VARCHAR(10) COMMENT '是否名企： 0.不是  1.是',
   STATUS               VARCHAR(10) COMMENT '状态：0.禁用 1.启用',
   remark               VARCHAR(100),
   CONSTRAINT PK_T_COMPANY PRIMARY KEY clustered (c_id)
);