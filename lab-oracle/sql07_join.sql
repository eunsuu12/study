/*
조인(join): 2개 이상의 테이블에서 검색하는 것.

join 문법:
1) ANSI 표준 문법:
    select 컬럼, ...
    from 테이블1 join종류 테이블2 on join조건;
2) Oracle 문법:
    select 컬럼, ...
    from 테이블1, 테이블2, ...
    where join조건;
    
join 종류:
1) inner join
2) outer join
    (1) left outer join
    (2) right outer join
    (3) full outer join
join 종류를 말할 때 inner, outer는 생략 가능.    
*/

-- 사번, 이름, 부서번호, 부서이름 검색
-- 1) ANSI 표준
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp inner join dept
    on emp.deptno= dept.deptno
order by dname;

-- 2) Oracle 문법
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp, dept
where emp.deptno= dept.deptno
order by dname;

-- left/right/full outer join의 차이점:
insert into emp (empno, ename, deptno)
values (1004, '오쌤', 50);

commit; -- 테이블 변경 내용을 영구 저장.

-- 사번, 이름, 부서번호, 부서이름 - left outer join
-- 왼쪽 테이블에서 등장하는 부서번호(10, 20, 30, 50)가 검색.
-- 1) ANSI 표준
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e left outer join dept d
    on e.deptno= d.deptno
order by e.deptno;

-- 2) Oracle 문법
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno= d.deptno(+)
order by e.deptno;

-- 사번, 이름, 부서번호, 부서이름 - right outer join 
-- 1) ANSI 표준
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e right outer join dept d
    on e.deptno= d.deptno
order by e.deptno;

-- 2) Oracle 문법
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno(+)= d.deptno
order by e.deptno;

-- 사번, 이름, 부서번호, 부서이름 - full outer join 
-- 1) ANSI 표준
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e full outer join dept d
    on e.deptno= d.deptno
order by e.deptno;

-- 2) Oracle 문법
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno= d.deptno(+) -- left join
union -- 합집합
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno(+)= d.deptno -- right join
order by dname;

-- 사번, 부서이름, 이름, 급여를 검색. inner join
-- 급여가 2000 이상인 직원들을 검색. 출력 순서는 급여의 내림차순.
-- 1) ANSI 표준
select e.empno, d.dname, e.ename, e.sal
from emp e inner join dept d
    on e.deptno= d.deptno
where sal>= 2000
order by sal desc;

-- 2) Oracle 문법
select e.empno, d.dname, e.ename, e.sal
from emp e, dept d
where e.deptno= d.deptno
    and sal>= 2000
order by sal desc;

-- # self-join: 같은 테이블에서 join을 하는 것.
-- 사번, 이름, 매니저 사번, 매니저 이름을 검색
-- 1) ANSI 표준
select e.empno as"사번", e.ename as"이름",
    m.empno as"매니저 사번", m.ename as"매니저 이름"
from emp e inner join emp m
    on e.mgr= m.empno;
    
-- 2) Oracle 문법
select e.empno as"사번", e.ename as"이름",
    m.empno as"매니저 사번", m.ename as"매니저 이름"
from emp e, emp m
where e.mgr= m.empno;

-- 위의 inner join 결과와 left/right/full outer join의 결과를 비교
-- left join:
select e.empno as"사번", e.ename as"이름",
    m.empno as"매니저 사번", m.ename as"매니저 이름"
from emp e left outer join emp m
    on e.mgr= m.empno;
    
-- right join:
select e.empno as"사번", e.ename as"이름",
    m.empno as"매니저 사번", m.ename as"매니저 이름"
from emp e right outer join emp m
    on e.mgr= m.empno;

-- full join:
select e.empno as"사번", e.ename as"이름",
    m.empno as"매니저 사번", m.ename as"매니저 이름"
from emp e full outer join emp m
    on e.mgr= m.empno;
    

-- Non-equal join: join 조건식이 부등식이 되는 경우.
-- 사번, 이름, 급여, 급여등급 검색.
select e.empno, e. ename, e.sal, s.grade
from emp e join salgrade s 
    on e.sal between s.losal and s.hisal;

-- 부서 이름, 부서 위치, 부서의 직원수를 검색.(inner join)
select d.dname, d.loc, count(*)
from dept d, emp e
where d.deptno= e.deptno
group by d.dname, d.loc;

-- 부서번호, 부서이름, 부서의 사원수, 부서의 급여 최솟값, 최댓값을 검색.(inner join)
select d.deptno, d.dname, count(*), min(e.sal), max(e.sal)
from dept d, emp e
where d.deptno= e.deptno
group by d.deptno, d.dname;

-- # 3개의 테이블을 join
-- 급여가 3000 이상인 직원이름, 부서위치, 급여, 급여등급을 검색
select e.ename, d.loc, e.sal, s.grade
from emp e
    join dept d
        on e.deptno= d.deptno
    join salgrade s
        on e.sal between s.losal and s.hisal
where e.sal>= 3000
order by e.sal desc;

-- 부서번호, 부서이름, 사번, 이름, 매니저사번, 매니저 이름, 급여, 급여등급 검색.
-- 출력 순서: (1) 부서번호 오름차순, (2) 사번 오름차순
-- 1) ANSI 표준
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr,
    e2.ename as"MGR_NAME", e1.sal, s.grade
from dept d
    join emp e1
        on d.deptno= e1.deptno
    join emp e2
        on e1.mgr= e2.empno
    join salgrade s
        on e1.sal between s.losal and s.hisal
order by d.deptno, e1.empno;

-- 2) Oracle 문법
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr,
    e2.ename as"MGR_NAME", e1.sal, s.grade
from dept d, emp e1, emp e2, salgrade s
where d.deptno= e1.deptno 
    and e1.mgr= e2.empno
    and e1.sal between s.losal and s.hisal
order by d.deptno, e1.empno;
