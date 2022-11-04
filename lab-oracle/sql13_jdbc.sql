-- JDBC(Java Database Connectivity):
-- Java 프로그램에서 데이터베이스 시스템에 접속해서 SQL(select/insert/update/delete) 문장을 실행.

-- 블로그 테이블: BLOGS
--  BLOG_NO: 블로그 글 번호. number(4). PK.
--  TITLE: 블로그 글 제목. varchar2(100 char). NN.
--  CONTENT: 블로그 글 내용(본문). varchar2(1000 char). NN. 
--  AUTHOR: 블로그 글 작성자. varchar2(100 char). NN.
--  CREATED_DATE: 블로그 글 작성 시간. timestamp. 기본값= 시스템 현재 시간.
--  MODIFIED_DATE: 블로그 글 수정 시간. timestamp. 기본값= 시스템 현재 시간.

create table BLOGS(
    BLOG_NO         number(4)
                    CONSTRAINT blogs_blog_no_pk primary key,
    TITLE           varchar2(100 char)
                    constraint blogs_title_nn not null,
    CONTENT         varchar2(1000 char)
                    constraint blogs_content_nn not null,
    AUTHOR          varchar2(100 char)
                    constraint blogs_author_nn not null,
    CREATED_DATE    timestamp default sysdate,
    MODIFIED_DATE   timestamp default sysdate
);

select * from blogs;

-- 테이블 편집(alter table):
-- BLOGS 테이블 오른쪽 클릭 -> 편집 -> BLOGS_NO 컬럼 선택 -> ID 열 -> 유형: 열 시퀀스 -> 확인.
-- 시퀀스(sequence): 자동으로 생성되는 (연속된) 숫자(1, 2, 3, ...)
-- BLOGS 테이블에 데이터를 저장(insert)할 때 PK에 시퀀스가 자동으로 저장되도록 하기 위해서.

insert into blogs (title, content, author)
values ('테스트','새 블로그 작성 테스트','admin');

select * from blogs;

-- 글번호 2번의 글의 제목과 내용을 수정하고 수정 날짜 컬럼을 시스템 현재 시간으로 업데이트.
insert into blogs (title, content, author)
values ('테스트2','!#$%#$^#$%^$%%$@#%*','은수');

update blogs set
    title= '수정 테스트',
    content= '룰룰',
    modified_date= sysdate
where blog_no= 2;

commit;

select * from blogs order by blog_no desc;