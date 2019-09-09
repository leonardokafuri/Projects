drop database if exists member;
create database if not exists member;
use member;

grant select, insert, delete, update 
on member.* 
to 'event' identified by 'event123';

CREATE TABLE if not exists Member
( MemberID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  FirstName CHAR(35) NOT NULL,
  LastName CHAR(35) not null,
  Email CHAR(35) not null,
  Cell  CHAR(10) NOT NULL,
  Password CHAR(20) NOT NULL 
);