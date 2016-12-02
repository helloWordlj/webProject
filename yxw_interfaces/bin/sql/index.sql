--索引脚本文件
ALTER TABLE INTERFACES_DEPARTMENT ADD INDEX INDEX_NAME (DEPT_CODE);
ALTER TABLE INTERFACES_MEDICALCARD ADD INDEX INDEX_NAME (PAT_CARD_NO,PAT_CARD_TYPE);
ALTER TABLE INTERFACES_REGINFODETAIL ADD INDEX INDEX_NAME (REG_DATE,BRANCH_CODE,DEPT_CODE,DOCTOR_CODE,TIME_FLAG);
ALTER TABLE INTERFACES_REGISTERDOCTOR ADD INDEX INDEX_NAME (DEPT_CODE,DOCTOR_CODE);
ALTER TABLE INTERFACES_ORDERREG_MEDICALCARD ADD INDEX INDEX_NAME (LOCK_ID);