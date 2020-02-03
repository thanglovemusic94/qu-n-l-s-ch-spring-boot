
-- bookmanagement
--user: sa
--pass:1234



create table category (
	idcategory varchar(5) not null,
	namecategory nvarchar(30) not null,
	constraint PK_category primary key (idcategory)
)

create table book (
	id int IDENTITY not null,
	idcategory varchar(5) not null,
	name nvarchar(30) not null,
	img nvarchar(30) null,
	tacgia nvarchar(20) not null,
	theloai nvarchar(30) not null,
	nxb nvarchar(20) not null,
	ngay nvarchar(15) not null,
	chitiet nvarchar(100) not null,
	constraint PK_book primary key (id),
	constraint FK_book_category foreign key (idcategory) references category(idcategory)
)

create table manager (
	idmanager varchar(5) not null,
	pass varchar(10) not null,
	ten nvarchar(20) not null,
	namsinh varchar(4) not null,
	email varchar(20) not null,
	sdt varchar(10) not null,
	diachi nvarchar(30) not null,
	constraint PK_manager primary key (idmanager)
)

-- bảng danh mục sách
insert into category values (N'VH',N'Văn học')
insert into category values (N'TLGT',N'Tâm lý - Giới tính')
insert into category values (N'NT',N'Ngôn tình')

-- Bang Manager
insert into manager values (N'MAN01',N'12345', N'Công Lương', N'1996', N'luongntc@gmail.com', N'0396270296', N'Hà Nội')
insert into manager values (N'MAN02',N'54321', N'Đức Long', N'1990', N'longhd@gmail.com', N'0973535353', N'Ninh Bình')
insert into manager values (N'MAN03',N'99999', N'Minh Tường',N'1999', N'minhtuong@gmail.com', N'0346372729', N'Hà Nội')

-- bảng danh sách các sách
insert into book values (N'VH',N'Chuyện lính Tây Nam','Chuyen_linh_Tay_Nam.png',N'Trung Sỹ',N'Tiểu thuyết',N'Văn Học','22/05/2019',N'Nguyen Cong Luong')
insert into book values (N'VH',N'Thượng lĩnh án','Thuong_linh_an.png',N'Phàm Nhất Bình',N'TIểu thuyết',N'Văn Học','22/05/2019',N'Chi tiết sách Thượng Lĩnh án')
insert into book values (N'VH',N'Ngôi nhà tranh','ngoi_nha_tranh.png',N'Tào Văn Hiên',N'Tiểu thuyết',N'Phụ Nữ','17/05/2019',N'Chi tiết sách Ngôi nhà tranh')
insert into book values (N'VH',N'Lửa biên thủy','lua_bien_thuy.png',N'Rae Carson',N'Tiểu thuyết',N'Văn Học','27/05/2019',N'Chi tiết sách Lửa biên thủy')
insert into book values (N'VH',N'Gút thủy triều','Gut_thuy_trieu.png',N'Helen Dunmore',N'Tiểu thuyết',N'Văn Học','25/05/2019',N'')
insert into book values (N'VH',N'Số đỏ','so_do.png',N'Vũ Trọng Phụng',N'Tiểu thuyết',N'Văn Học','05/03/2019',N'')
insert into book values (N'VH',N'Xác phàm','xac_pham.png',N'Nguyễn Đình Tú',N'Tiểu thuyết',N'Văn Học','05/03/2019',N'')
insert into book values (N'VH',N'Người nhặt linh hồn','ng_nhat_linh_hon.png',N'Nhóm 4.0',N'Tiểu thuyết',N'Thông tin và TT','20/04/2019',N'')

insert into book values (N'TLGT',N'Đàn ông','Dan_ong.png',N'Nguyễn Bình Nguyên',N'Tâm lý giới tính',N'Dân Trí','31/10/2018',N'Chi tiết sách Đàn ông')
insert into book values (N'TLGT',N'Cửa tiệm hạnh phúc','cua_tiem_hanh_phuc.png',N'Lê Di',N'Kĩ năng',N'Thanh Niên','22/01/2019',N'Chi tiết sách Cửa tiệm hạnh phúc')
insert into book values (N'TLGT',N'Học cách mỉm cười','hoc_cach_mim_cuoi.png',N'Nguyễn Hoàng Ánh',N'Tâm lý giới tính',N'Lao Động','31/08/2018',N'Chi tiết sách Họ cách mỉm cười')
insert into book values (N'TLGT',N'Ca tụng thân xác','ca_tung_than_xac.png',N'Nguyễn Văn Trung',N'Khoa học xã hội',N'Văn Nghệ','14/08/2018',N'Chi tiết sách ca tụng thân xác')
insert into book values (N'TLGT',N'Tình dục ư?','tinh_duc_u.png',N'Cấn Vân Khánh',N'Tâm lý giới tính',N'Thời Đại','18/01/2019',N'Chi tiết sách Tình dục ư?')
insert into book values (N'TLGT',N'Nhật ký tuổi teen','nhat_ki_tuoi_teen.png',N'Jullia V Taylor',N'Chăm sóc gia đình',N'Dân Trí','26/02/2019',N'Chi tiết sách Nhật kí tuổi teen')
insert into book values (N'TLGT',N'Thời hoàng kim','thoi_hoang_kim.png',N'Vương Tiểu Ba',N'Tâm lý giới tính',N'Văn Học','17/02/2019',N'Chi tiết sách Thời hoàng kim')
insert into book values (N'TLGT',N'Ta yêu nhau','ta_yeu_nhau.png',N'Nhiều tác giả',N'Tâm lý giới tính',N'NXB Trẻ','02/05/2019',N'Chi tiết sách Ta yêu nhau')

insert into book values (N'NT',N'Đám cưới hảo môn','Dam_cuoi_hao_mon.png',N'Anh Vũ Tắm, Trăng',N'Ngôn tình hiện đại',N'Đang cập nhật','03/05/2019',N'Chi tiết sách Đám cưới hào môn')
insert into book values (N'NT',N'Quân hôn chớp nhoáng','quan_hon_chop_nhoang.png',N'Ngư Ca',N'Ngôn tình hiện đại',N'Đang cập nhật','02/05/2019',N'Chi tiết sách Quân hôn chớp nhoáng')
insert into book values (N'NT',N'Thịnh thế hôn nhân','Thinh_the_hon_nhan.png',N'Tam Kim Nguyên Bảo',N'Ngôn tình hiện đại',N'Đang cập nhật','02/05/2019',N'Chi tiết sách Thịnh thế hôn nhân')
insert into book values (N'NT',N'Công tước','Cong_tuoc.png',N'yến Tử Hồi Thời',N'Ngôn tình hiện đại',N'Đang cập nhật','03/05/2019',N'Chi tiết sách Công tước')
insert into book values (N'NT',N'Tình đắng','Tinh_dang.png',N'Thiên hạ thái bình',N'Ngôn tình hiện đại',N'Đang cập nhật','09/09/2018',N'Chi tiết sách Tình đắng')
insert into book values (N'NT',N'Điền viên cẩm tú','Dien_vien_cam_tu.png',N'Mộ Dạ Hàn Phong',N'Cổ trang, xuyên không',N'Đang cập nhật','08/04/2019',N'Chi tiết sách Điền viên cẩm tú')
insert into book values (N'NT',N'Lấy chồng quyền thế','Lay_chong_quyen_the.png',N'Ngư Ca',N'Ngôn tình hiện đại',N'Đang cập nhật','07/11/2018',N'Chi tiết sách Lấy chồng quyền thế')
insert into book values (N'NT',N'Bổ thiên ký','Bo_thien_ki.png',N'Hàn Vũ Ký',N'Cổ trang, xuyên không',N'Đang cập nhật','29/03/2019',N'Chi tiết sách Bộ thiên kí')