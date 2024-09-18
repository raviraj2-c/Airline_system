insert into flightdetails value("Airindia","1234","Delhi","Nagpur");
insert into flightdetails value("Airindia","1235","Delhi","Pune");
insert into flightdetails value("Airindia","1236","Pune","Nagpur");
insert into flightdetails value("Airindia","1237","Nagpur","Pune");
insert into flightdetails value("Airindia","1238","Delhi","Bihar");
insert into flightdetails value("Airindia","1239","Bihar","Nagpur");
insert into flightdetails value("Airindia","1214","Bihar","Pune");
insert into flightdetails value("Airindia","1224","Nagpur","Bihar");
insert into flightdetails value("Airindia","1274","Bihar","Delhi");

 
create table reservation (PNR varchar(15), TIC varchar(15), name varchar(50),aadher varchar(50), nationality varchar(50), gender varchar(50), flightname varchar(50), flightcode varchar(50), src varchar(50), des varchar(50), datevarchar varchar(50));
create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), fcode varchar(20), ddate varchar(30));

select * from cancel;
 select * from reservation;
 select * from passenger;
 select * from flightdetails;
  select * from login;