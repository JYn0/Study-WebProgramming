# JSP

## day1333



<http://servlets.com/> - com.oreilly.servlet - [**cos-20.08.zip**] - cos.jar

```SQL
CREATE SEQUENCE PSEQ INCREMENT BY 1 START WITH 100
시작은 100이고 1증가, PSEQ 자동적으로 1씩 증가
INSERT INTO T_PRODUCT VALUES(PSEQ.NEXTVAL,'K1',1000, SYSDATE, 'a.jpg')
INSERT INTO T_PRODUCT VALUES(PSEQ.NEXTVAL,'K2',1000, SYSDATE, 'a.jpg')
INSERT INTO T_PRODUCT VALUES(PSEQ.NEXTVAL,'K3',1000, SYSDATE, 'a.jpg')
DELETE FROM T_PRODUCT
DROP SEQUENCE PSEQ
```

enctype="multipart/form-data" => 파일을 서버로 전송

