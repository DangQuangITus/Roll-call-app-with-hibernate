create database if not exists DiemDanh character set 'utf8' collate 'utf8_unicode_ci';
use DiemDanh;

create table if not exists GiaoVu
(
MaGV varchar(10) not null primary key,
TenGV varchar(45),
Password varchar(45),
TenDangNhapgiaovu varchar(45)
)engine = innoDB default charset=utf8 collate = utf8_unicode_ci;

create table if not exists MonHoc 
(
MaMH varchar(10) not null primary key,
TenMH varchar(45),
MaGV varchar(10),
constraint FK1 foreign key (MaGV) references GiaoVu(MaGV)
)engine = innoDB default charset=utf8 collate = utf8_unicode_ci;

create table if not exists ThoiKhoaBieu
(
MaMH varchar(10) not null,
TenMH varchar(45) not null,
NgayBatDau date,
NgayKetThuc date,
ThuTrongTuan varchar(10),
GioBatDau varchar(10),
GioKetThuc varchar(10),
TenPhongHoc varchar(10),
constraint primary key (MaMH, TenMH)
)engine = innoDB default charset=utf8 collate = utf8_unicode_ci;


create table if not exists SinhVien
(
MSSV varchar(10) not null primary key,
TenSV varchar(45),
Password varchar(45)
)engine = innoDB default charset=utf8 collate = utf8_unicode_ci;

create table if not exists BangDiemDanh
(
MaMH varchar(10),
MSSV varchar(10),
TuanCoMat varchar(50),
TuanVangMat varchar(50),
constraint primary key (MaMH, MSSV),
constraint FK2 foreign key (MaMH) references MonHoc(MaMH),
constraint FK3 foreign key (MSSV) references SinhVien(MSSV)
)engine = innoDB default charset=utf8 collate = utf8_unicode_ci;


insert giaovu (MaGV,TenGV,Password,TenDangNhap) values ('GV001','Trần Duy Quang','tdquangfit','tdquang');

load data local infile '.\\ChuongTrinhDiemDanh\\ss.txt' into table sinhvien fields terminated by ';';





