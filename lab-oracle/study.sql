delete from MENU 
where menuname='메뉴10' and no >= 
    all(
        select no
        from menu
        where menuname='메뉴10'
    );
    
    ROLLBACK;
    
select sum(totalcost)
from menu;

insert into tableinfo
(tno) values (1);

insert into menu
(menuname, unitcost)
values('메뉴14', 11000);

delete from saleslist;
delete from tableinfo;


commit;

select unitcost
from menu
where menuname like '메뉴3' or menuname like '메뉴5';

insert into payment
(sno, tno, menuname, count, totalcost)
values (1, 1, '메뉴10', 4, 4*(select unitcost from menu where menuname like '메뉴10'));

select sum(totalcost)
from payment
where sno=1 and tno=1;

select * from menu;

update menu set unitcost= 8500
where menuname like '메뉴8';

select menuname,
(select content from blogs where blog_no=1) 
from menu
where unitcost=27000;

insert into soldlist
values (17,1,'메뉴1',1, 44000);


select * from soldlist join menu on SOLDLIST.MENUNAME= MENU.MENUNAME ;

select * from tableinfo where tno=2;

select SOLDLIST.MENUNAME, MENU.UNITCOST, count(SOLDLIST.COUNT), sum(SOLDLIST.TOTALCOST)
from SOLDLIST join MENU 
on SOLDLIST.MENUNAME= MENU.MENUNAME 
where soldlist.sno=(select max(sno) from soldlist where tno=2) and soldlist.tno=2
group by SOLDLIST.MENUNAME, MENU.UNITCOST;

select SOLDLIST.MENUNAME, MENU.UNITCOST, 
count(SOLDLIST.COUNT), sum(SOLDLIST.TOTALCOST) 
from SOLDLIST join MENU 
on SOLDLIST.MENUNAME= MENU.MENUNAME 
where SOLDLIST.SNO=(select max(SNO) from SOLDLIST where TNO=2) 
and SOLDLIST.TNO= 2 
group by SOLDLIST.MENUNAME, MENU.UNITCOST;

select max(sno) from tableinfo where tno= 2;

select menuname from menu where menuname like '메뉴1';
select unitcost from menu where menuname like '메뉴1';

select SOLDLIST.MENUNAME, MENU.UNITCOST, count(SOLDLIST.COUNT), sum(SOLDLIST.TOTALCOST) from SOLDLIST join MENU on SOLDLIST.MENUNAME= MENU.MENUNAME where SOLDLIST.SNO=(select max(SNO) from SOLDLIST where TNO=2) and SOLDLIST.TNO= 2 group by SOLDLIST.MENUNAME, MENU.UNITCOST;

insert into SOLDLIST (SNO, TNO, MENUNAME, COUNT, TOTALCOST) values ((select max(sno) from tableinfo where tno= 1), 1, (select menuname from menu where menuname like '메뉴1'), 1, (select unitcost from menu where menuname like '메뉴1'));

select SOLDLIST.MENUNAME, MENU.UNITCOST, count(SOLDLIST.COUNT), sum(SOLDLIST.TOTALCOST) from SOLDLIST join MENU on SOLDLIST.MENUNAME= MENU.MENUNAME where SOLDLIST.SNO=(select max(SNO) from SOLDLIST where TNO=1) and SOLDLIST.TNO= 1 group by SOLDLIST.MENUNAME, MENU.UNITCOST;

select SOLDLIST.MENUNAME, MENU.UNITCOST, count(SOLDLIST.COUNT), sum(SOLDLIST.TOTALCOST) from SOLDLIST join MENU on SOLDLIST.MENUNAME= MENU.MENUNAME where SOLDLIST.SNO=(select max(SNO) from SOLDLIST where TNO=2) and SOLDLIST.TNO= 2 group by SOLDLIST.MENUNAME, MENU.UNITCOST;

select * from tableinfo where sno=(select max(sno) from soldlist where tno=2) and tno= 2;
update TABLEINFO set ENTTIME= sysdate
where enttime is null and SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5;
update TABLEINFO set ENTTIME= sysdate where ENTTIME is null and SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5;

select * from TABLEINFO where SNO=(select max(SNO) from SOLDLIST where TNO=2) and TNO= 2;

update TABLEINFO set ENTTIME= sysdate where ENTTIME is null and SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5;

update tableinfo
set staytime= sysdate
where SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5;

update tableinfo 
set staytime= 
Round((to_date(sysdate, 'hh24:mi')-
to_date(select enttime from tableinfo 
where SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5), 'hh24:mi'))*24*60)
where SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5;

update tableinfo
set staytime= (select enttime from tableinfo where SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5)
where SNO=(select max(SNO) from SOLDLIST where TNO=5) and TNO= 5;

update tableinfo set ptotal=? where enttime is not null and sno=(select max(sno) from soldlist where tno=?) and tno= ?;

insert into payment(sno)
values (197);

update payment set pcash=50000
where sno=
(select max(sno)
from tableinfo
where tno=2);

 insert into tableinfo(tno, sdate) values (3, '2022-10-28 (금)');
 insert into payment(sno) values(select max(sno) from soldlist where tno=3);