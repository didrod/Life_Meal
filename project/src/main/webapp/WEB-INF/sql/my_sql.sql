-- TBL_CONSUMER 만들기 

CREATE TABLE TBL_CONSUMER 
(
  CONSUMER_ID VARCHAR2(50 BYTE) NOT NULL 
, CONSUMER_PW VARCHAR2(60 BYTE) NOT NULL 
, CONSUMER_NAME VARCHAR2(12 BYTE) NOT NULL 
, CONSUMER_PHONE_NUMBER VARCHAR2(12 BYTE) NOT NULL 
, BIRTH DATE NOT NULL 
, CONSUMER_ADRESS VARCHAR2(100 BYTE) NOT NULL 
, CONSUMER_EMAIL VARCHAR2(225 BYTE) NOT NULL 
, CONSUMER_POINT NUMBER DEFAULT 0 NOT NULL 
, CONSTRAINT PK_CONSUMER_ID PRIMARY KEY 
  (
    CONSUMER_ID 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX TBL_CONSUMER_PK ON TBL_CONSUMER (CONSUMER_ID ASC) 
      LOGGING 
      TABLESPACE SYSTEM 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        FREELISTS 1 
        FREELIST GROUPS 1 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE SYSTEM 
PCTFREE 10 
PCTUSED 40 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  FREELISTS 1 
  FREELIST GROUPS 1 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL;

COMMENT ON COLUMN TBL_CONSUMER.CONSUMER_PW IS '보안상의 이유로 해싱(hash)하여 저장한다 bcrypt를 추천한다';
