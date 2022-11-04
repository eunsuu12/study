/*
* []: 생략 가능.
DML(Data Manipulation Language): insert, update, delete

insert 테이블이름 [(컬럼, ...)] values (값, ...);

update 테이블이름 set 컬럼= 값, ... [where 조건식];

delete from 테이블이름 [where 조건식];

*/

select * from emp;

-- 사번이 1004인 직원의 급여를 5000으로 업데이트
update emp set sal= 5000; -- 테이블의 모든 sal값을 업데이트.
rollback;

update emp set sal= 5000 
where empno= 1004;

update emp
set job= 'SALESMAN',
    hiredate= to_date('2022/10/06','YYYY/MM/DD')
where empno= 1004;

-- emp테이블에서 'ACCOUNTING'부서에서 일하는 직원들의 급여를 10% 인상.
update emp
set sal= sal*1.1
where deptno =(
    select deptno
    from dept
    where dname= 'ACCOUNTING'
);

select * from emp;

commit;

-- 테이블에서 행 삭제
delete from emp; -- 조건절(where)이 없으면 테이블의 모든 행을 삭제.

rollback; --> delete는 rollback이 가능한 DML. truncate table은 rollback이 불가능한 DDL.

-- 사번이 1004인 직원의 레코드(행)을 삭제
delete from emp
where empno= 1004;
