-- #오라클 함수(function)
-- (1) 단일 행 함수:
--      행(row)이 하나씩 함수의 argument로 전달되고,
--      행 마다 하나씩 결과가 리턴되는 함수.

-- (2) 다중 행 함수(그룹 함수):
--      여러개의 행(row)이 한꺼번에 함수의 argument로 전달되서,
--      하나의 결과가 리턴되는 함수.
--      (예) 통계 관련 함수들:
--      count, sum, avg, max, min, variance(분산), stddev(표준편차)

-- 단일 행 함수과 그룹 함수는 동시에 select 할 수 없음!

-- #단일 행 함수의 예:
-- 문자열을 소문자로 바꾸기.
select lower(ename) from emp;

-- 날짜 타입 데이터를 원하는 문자열 포맷으로 출력하기.
select hiredate, to_char(hiredate, 'YYYY-MM-DD')
from emp;

-- nvl(컬럼, value): 컬럼이 null이면 value 리턴,
--      null이 아니면 원래 값 리턴.
-- nvl2(컬럼, value1, value2):
--      컬럼이 null이 아니면 value1 리턴,
--      null이면 value2 리턴.
select comm, nvl(comm, -1), nvl2(comm, comm, -1)
from emp;

-- #다중행 함수(그룹 함수)
-- count(컬럼): null이 아닌 행의 개수를 리턴.
select count(*), count(mgr), count(comm)
from emp;

select count(*) from emp; -- 테이블 행 개수.

-- #통계 함수: 합계, 평균, 최댓값, 최솟값, 분산, 표준편차
select sum(sal), avg(sal), max(sal), variance(sal), stddev(sal)
from emp;

--  그룹별 통계
-- 부서(번호)별 급여의 최댓값.
select max(sal) from emp where deptno= 10;
select max(sal) from emp where deptno= 20;
select max(sal) from emp where deptno= 30;

select deptno, max(sal)
from emp
group by deptno
order by deptno;

-- 부서별 급여 평균.
select deptno as "부서번호", 
    round(avg(sal),2) as "급여 평균"
from emp
group by deptno
order by deptno;

-- 아래의 모든 문제에서 소수점은 반올림해서 2자리까지 표시.
-- Ex. 부서별 급여의 평균, 표준편차를 출력. 부서번호 오름차순 정렬.
select deptno as "부서번호", 
    round(avg(sal),2) as "급여 평균", 
    round(stddev(sal),2) as "표준편차"
from emp
group by deptno
order by deptno;

-- Ex. 직무별 직원수, 급여의 최댓값, 최솟값, 평균 검색.
-- 직무 오름차순 정렬
select job as "직무", 
    count(job) as "직원수", 
    max(sal) as "급여 최댓값", 
    min(sal) as "급여 최솟값", 
    round(avg(sal),2) as "급여 평균"
from emp
group by job
order by job;

-- Ex. 부서별, 직무별 부서번호, 직무, 직원수, 급여 평균 검색
-- 정렬 순서는 (1) 부서 번호 (2) 직책 오름차순
select deptno as "부서",
    job as "직무",
    count(*) as "직원수", 
    avg(sal) as "급여 평균"
from emp
group by deptno, job
order by deptno, job;

-- Ex. 입사연도별 사원수 검색. (힌트) to_char(날짜, 포맷) 이용.
select to_char
    (hiredate, 'YYYY') as "입사연도",
    count(*) as "사원수"
from emp 
group by to_char(hiredate, 'YYYY')
order by to_char(hiredate, 'YYYY');


/*
* #select 문장의 순서:
* select 컬럼, ...
* from 테이블
* where (그룹을 묶기 전에 검사할) 조건식
* group by 그룹을 묶어줄 컬럼, ...
* having 그룹을 묶은 다음에 검사할 조건식
* order by 출력 순서를 결정할 컬럼, ...
*/

-- 부서별 부서번호, 급여 평균을 검색.
-- 부서별 급여 평균이 2000 이상인 부서들만 출력.
-- 부서 번호 오름차순 정렬.
select deptno, round(avg(sal),2) as "AVG_SAL"
from emp
group by deptno
having avg(sal)>= 2000
order by deptno;

-- Ex. emp 테이블에서 mgr가 null이 아닌 직원들 중에서
-- 부서별 급여 평균을 검색. 부서 번호 오름차순 출력.
select deptno, round(avg(sal),2) as "AVG_SAL"
from emp
where mgr is not null
group by deptno
order by deptno;

-- Ex. 직책별 사원수를 검색.
-- 직책이 PRESIDENT는 제외.
-- 직책별 사원수가 3명 이상인 경우만 선택.
-- 직책 오름차순 출력.
select job, count(job)
from emp
where job != 'PRESIDENT'
group by job
having count(job)>= 3
order by job;

-- Ex. 입사연도, 부서 번호, 입사연도별 부서별 입사한 사원수 검색.
-- 1980년 제외.
-- 연도별 부서별 사원수가 2명 이상인 경우 선택.
-- 연도 오름차순 출력.
select to_char(hiredate, 'YYYY') as "YEAR", deptno, count(*)
from emp
where to_char(hiredate, 'YYYY')!= '1980'
group by to_char(hiredate, 'YYYY'), deptno
having count(*)>= 2
order by YEAR;




