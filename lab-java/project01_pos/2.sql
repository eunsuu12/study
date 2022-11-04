--------------------------------------------------------
--  파일이 생성됨 - 수요일-10월-19-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SOLDLIST
--------------------------------------------------------

  CREATE TABLE "SCOTT"."SOLDLIST" 
   (	"SNO" NUMBER(4,0), 
	"TNO" NUMBER(4,0), 
	"MENUNAME" VARCHAR2(100 BYTE), 
	"COUNT" NUMBER(4,0), 
	"TOTALCOST" NUMBER(20,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SCOTT.SOLDLIST
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Trigger PAYMENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SCOTT"."PAYMENT_TRG" 
BEFORE INSERT ON SOLDLIST 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.SNO IS NULL THEN
      SELECT PAYMENT_SEQ.NEXTVAL INTO :NEW.SNO FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SCOTT"."PAYMENT_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table SOLDLIST
--------------------------------------------------------

  ALTER TABLE "SCOTT"."SOLDLIST" MODIFY ("TOTALCOST" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SOLDLIST" MODIFY ("COUNT" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SOLDLIST" MODIFY ("MENUNAME" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SOLDLIST" MODIFY ("TNO" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."SOLDLIST" MODIFY ("SNO" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SOLDLIST
--------------------------------------------------------

  ALTER TABLE "SCOTT"."SOLDLIST" ADD CONSTRAINT "PAYMENT_FK1" FOREIGN KEY ("MENUNAME")
	  REFERENCES "SCOTT"."MENU" ("MENUNAME") ENABLE;
  ALTER TABLE "SCOTT"."SOLDLIST" ADD CONSTRAINT "PAYMENT_SNO_FK" FOREIGN KEY ("SNO")
	  REFERENCES "SCOTT"."TABLEINFO" ("SNO") ENABLE;
