<!-- /*** -->
<!--  * @author 2014140053 谢辉 -->
<!--  *xox回合制对战游戏_加强版 -->
<!--  */ -->

create database xox;

use xox;

create table xox_user(
xu_id int not null auto_increment PRIMARY KEY,
xu_username nvarchar(20) not null,
xu_password char(16) not null
)ENGINE=MyISAM  DEFAULT CHARSET=utf8; 

create table xox_historylog(
xh_id int not null auto_increment PRIMARY KEY,
xh_uid int not null,
xh_myhero nvarchar(20) not null,
xh_foehero nvarchar(20) not null,
xh_result int not null,
xh_Time datetime NOT NULL,
foreign key(xh_uid) references xox_user(xu_id)  
)ENGINE=MyISAM  DEFAULT CHARSET=utf8; 
