CREATE TABLE t_company 
(
   c_id                 INT          AUTO_INCREMENT,
   shrot_name           VARCHAR(10),
   is_famous            VARCHAR(10) COMMENT '�Ƿ����� 0.����  1.��',
   STATUS               VARCHAR(10) COMMENT '״̬��0.���� 1.����',
   remark               VARCHAR(100),
   CONSTRAINT PK_T_COMPANY PRIMARY KEY clustered (c_id)
);