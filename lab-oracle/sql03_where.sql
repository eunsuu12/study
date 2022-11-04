-- 30번 부서에서 근무하는 직무가 'SALES'로 시작하는 직원들의
-- 사번, 이름, 급여, 부서번호, 직무를 검색.
-- 사번 오름차순으로 정렬.
select empno, ename, sal, deptno, job
from emp
where deptno= 30 and job like 'SALES%'
order by empno;

-- 20번, 30번 부서에서 근무하고 급여가 2000을 초과하는 직원들의
-- 사번, 부서번호, 이름, 급여를 검색.
-- (1) 부서 번호, (2) 사번 오름차순 정렬.
select empno, deptno, ename, sal
from emp
where deptno in (20, 30) and sal > 2000
-- where (deptno= 20 or deptno= 30) and sal > 2000
order by deptno, empno;


-- 수당이 null이고, 매니저가 있고, 직무가 'MANAGER'또는 'CLERK'인 직원들의
-- 모든 컬럼을 검색. 사번 오름차순 출력.
select *
from emp
where comm is null
    and mgr is not null
    and job in('MANAGER', 'CLERK')
    -- and (job= 'MANAGER' or job= 'CLERK')
order by empno;