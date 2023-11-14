
 --them value khachhang mau vao
INSERT INTO KhachHang(maKH,tenKH,email,dienThoai,toChuc) values('230001',N'Võ Phước Hậu','vohau115@gmail.com','0899530610',0)
INSERT INTO KhachHang(maKH,tenKH,email,dienThoai,toChuc) values('231002',N'Công ty TNHH Uy Vũ','vovuCompany@gmail.com','0899530600',1)
--them value hopdong mau vao
--khachhang1
INSERT INTO HopDong(maHD,maKH,tenHD,ngayBatDau,ngayKetThucDukien,trangThai,donGia) values('0511202301','230001',N'Hợp đồng gia công chén sứ','2023-11-05','2023-12-05',N'chờ xác nhận',15000000.0)
INSERT INTO HopDong(maHD,maKH,tenHD,ngayBatDau,ngayKetThucDukien,trangThai,donGia) values('0511202302','230001',N'Hợp đồng gia công ly sứ','2023-11-05','2024-1-05',N'chờ xác nhận',20000000.0)
INSERT INTO HopDong(maHD,maKH,tenHD,ngayBatDau,ngayKetThucDukien,trangThai,donGia) values('0511202303','230001',N'Hợp đồng gia công tô sứ','2023-11-05','2024-1-05',N'chờ xác nhận',30000000.0)
--khachhang2
INSERT INTO HopDong(maHD,maKH,tenHD,ngayBatDau,ngayKetThucDukien,trangThai,donGia) values('0511202304','231002',N'Hợp đồng gia công bình gốm sứ','2023-11-05','2024-2-05',N'chờ xác nhận',50000000.0)
-- them value sanpham mau
--hopdong 1
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202301','051120230101',N'Chén sứ viền xanh lam',500,5000.0)
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202301','051120230102',N'Chén sứ họa tiết hình rồng',500,6000.0)
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202301','051120230103',N'Chén sứ viền cam',500,4000.0)
--hopdong 2
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202302','051120230201',N'ly sứ viền xanh lam',1000,4000.0)
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202302','051120230202',N'ly sứ họa tiết hình rồng',1000,6000.0)
--hopdong 3
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202303','051120230301',N'tô sứ viền cam',500,4000.0)
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202303','051120230302',N'tô sứ viền xanh lam',500,5000.0)
--hopdong 4
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202304','051120230401',N'bình sứ họa tiết thanh hoa',500,6000.0)
INSERT INTO SanPham(maHD,maSP,tenSP,soLuong,donGia) values('0511202304','051120230402',N'bình sứ viền cam',500,4000.0)


-- bộ phận
INSERT INTO BoPhan (maBP, tenBP) VALUES ('HC01', N'Kế toán');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('HC02', N'Kỹ thuật');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('HC03', N'Quản lý');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('HC04', N'Nhân sự');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('HC05', N'Tiếp thị');

INSERT INTO BoPhan (maBP, tenBP) VALUES ('SX01', N'Kiểm tra chất lượng');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('SX02', N'Giao hàng và Vận chuyển');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('SX03', N'Lưu trữ và Logistik');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('SX04', N'đóng gói');
INSERT INTO BoPhan (maBP, tenBP) VALUES ('SX05', N'in ấn');

-- nhân viên
-- thay lại bằng path đến assets của dự án
INSERT INTO NhanVien (maNV, maBP, tenNV, gioiTinh, ngaySinh, ngayBatDauLam, CCCD, luongCoBan, phuCap, trangThai, dienThoai, hinhAnh)
VALUES 
    ('NV1810001', 'HC01', N'Lê Thị Bích', 1, '1992-08-25', '2018-03-15', '000022221111', 5000000.0, 1000000.0, 1, '0123456789', (SELECT BulkColumn FROM OPENROWSET(BULK N'E:\programming\JAVA\manage-salary-product\src\assets\images\avatarNV\nv2.jpg', SINGLE_BLOB) as ImageData));
INSERT INTO NhanVien (maNV, maBP, tenNV, gioiTinh, ngaySinh, ngayBatDauLam, CCCD, luongCoBan, phuCap, trangThai, dienThoai, hinhAnh)
VALUES 
    ('NV2010001', 'HC02', N'Đỗ Văn Tấn', 1, '1996-08-25', '2020-06-20', '111100002222', 7000000.0, 1000000.0, 1, '9876543210', (SELECT BulkColumn FROM OPENROWSET(BULK N'E:\programming\JAVA\manage-salary-product\src\assets\images\avatarNV\nv1.jpg', SINGLE_BLOB) as ImageData));

-- công nhân
INSERT INTO CongNhan (maCN, maBP, tenCN, gioiTinh, ngaySinh, ngayBatDauLam, CCCD, trangThai, choPhanCong, dienThoai, hinhAnh)
VALUES 
    ('CN210001', 'SX02', N'Nguyễn Văn Bạch', 1, '1990-01-15', '2021-05-01', '222211110000', 1, 1, '1357924680', (SELECT BulkColumn FROM OPENROWSET(BULK N'E:\programming\JAVA\manage-salary-product\src\assets\images\avatarCN\cn1.jpg', SINGLE_BLOB) as ImageData));
INSERT INTO CongNhan (maCN, maBP, tenCN, gioiTinh, ngaySinh, ngayBatDauLam, CCCD, trangThai, choPhanCong, dienThoai, hinhAnh)
VALUES 
    ('CN200002', 'SX05', N'Đỗ Nhật Anh', 1, '1999-01-15', '2020-05-01', '111122220000', 1, 1, '2468013579', (SELECT BulkColumn FROM OPENROWSET(BULK N'E:\programming\JAVA\manage-salary-product\src\assets\images\avatarCN\cn2.jpg', SINGLE_BLOB) as ImageData));



-- công đoạn 
-- Công đoạn cho sản phẩm 051120230101
INSERT INTO CongDoan (maCD, maSP, maBP, tenCD, donGia, trangThai, soLuongChuanBi, soLuongChuanBiToiThieu, soLuongHoanThanh)
VALUES
('05112023010101', '051120230101', 'SX01', N'Gia công nền chén', 1000.0, 1, 50, 30, 120),
('05112023010102', '051120230101', 'SX02', N'Sơn viền xanh lam', 2000.0, 1, 50, 30, 120),
('05112023010103', '051120230101', 'SX03', N'Kiểm tra chất lượng', 500.0, 1, 50, 30, 120)

-- Công đoạn cho sản phẩm 051120230201
INSERT INTO CongDoan (maCD, maSP, maBP, tenCD, donGia, trangThai, soLuongChuanBi, soLuongChuanBiToiThieu, soLuongHoanThanh)
VALUES
('05112023010201', '051120230102', 'SX01', N'Kiểm tra sản phẩm', 1000.0, 1, 80, 60, 240),
('05112023010202', '051120230102', 'SX02', N'Đóng gói', 2000.0, 1, 80, 60, 240),
('05112023010203', '051120230102', 'SX03', N'Vận chuyển', 500.0, 1, 80, 60, 240)
-- Công đoạn cho sản phẩm 051120230301
INSERT INTO CongDoan (maCD, maSP, maBP, tenCD, donGia, trangThai, soLuongChuanBi, soLuongChuanBiToiThieu, soLuongHoanThanh)
VALUES
('05112023010301', '051120230103', 'SX01', N'Kiểm tra sản phẩm', 1500.0, 1, 70, 50, 220),
('05112023010302', '051120230103', 'SX02', N'Giao hàng', 2500.0, 1, 70, 50, 220),
('05112023010303', '051120230103', 'SX03', N'Đóng gói', 600.0, 1, 70, 50, 220)
-- Thêm 7 công đoạn khác cho sản phẩm 0511202303 tại đây

-- Công đoạn cho sản phẩm 051120230401
INSERT INTO CongDoan (maCD, maSP, maBP, tenCD, donGia, trangThai, soLuongChuanBi, soLuongChuanBiToiThieu, soLuongHoanThanh)
VALUES
('05112023020101', '051120230201', 'SX01', N'Kiểm tra sản phẩm', 2000.0, 1, 90, 70, 280),
('05112023020102', '051120230201', 'SX02', N'Đóng gói', 3000.0, 1, 90, 70, 280),
('05112023020103', '051120230201', 'SX03', N'Giao hàng', 700.0, 1, 90, 70, 280)

--Chèn Nhân viên
USE [QuanLyLSP]
GO
INSERT [dbo].[NhanVien] ([maNV], [maBP], [tenNV], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [luongCoBan], [phuCap], [trangThai], [dienThoai], [hinhAnh]) VALUES (N'21031001', N'HC03', N'Trần Văn A', 1, CAST(N'2000-10-25' AS Date), CAST(N'2021-01-01' AS Date), N'0000111122223333', 1E+07, 0, 1, N'0123456789', NULL)
GO
INSERT [dbo].[NhanVien] ([maNV], [maBP], [tenNV], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [luongCoBan], [phuCap], [trangThai], [dienThoai], [hinhAnh]) VALUES (N'21031002', N'HC03', N'Trần Văn B', 1, CAST(N'2000-10-25' AS Date), CAST(N'2021-01-01' AS Date), N'0000111122223333', 1E+07, 0, 1, N'0123456789', NULL)
GO
INSERT [dbo].[NhanVien] ([maNV], [maBP], [tenNV], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [luongCoBan], [phuCap], [trangThai], [dienThoai], [hinhAnh]) VALUES (N'21031003', N'HC03', N'Trần Văn C', 1, CAST(N'2000-10-25' AS Date), CAST(N'2021-01-01' AS Date), N'0000111122223333', 1E+07, 0, 1, N'0123456789', NULL)
GO
INSERT [dbo].[NhanVien] ([maNV], [maBP], [tenNV], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [luongCoBan], [phuCap], [trangThai], [dienThoai], [hinhAnh]) VALUES (N'21031004', N'HC03', N'Trần Văn D', 1, CAST(N'2000-10-25' AS Date), CAST(N'2021-01-01' AS Date), N'0000111122223333', 1E+07, 0, 1, N'0123456789', NULL)
GO
INSERT [dbo].[NhanVien] ([maNV], [maBP], [tenNV], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [luongCoBan], [phuCap], [trangThai], [dienThoai], [hinhAnh]) VALUES (N'21031005', N'HC03', N'Trần Văn E', 1, CAST(N'2000-10-25' AS Date), CAST(N'2021-01-01' AS Date), N'0000111122223333', 1E+07, 0, 1, N'0123456789', NULL)
GO
INSERT [dbo].[NhanVien] ([maNV], [maBP], [tenNV], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [luongCoBan], [phuCap], [trangThai], [dienThoai], [hinhAnh]) VALUES (N'21031006', N'HC03', N'Trần Văn F', 1, CAST(N'2000-10-25' AS Date), CAST(N'2021-01-01' AS Date), N'0000111122223333', 1E+07, 0, 1, N'0123456789', NULL)
GO
INSERT [dbo].[NhanVien] ([maNV], [maBP], [tenNV], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [luongCoBan], [phuCap], [trangThai], [dienThoai], [hinhAnh]) VALUES (N'21031007', N'HC03', N'Trần Văn G', 1, CAST(N'2000-10-25' AS Date), CAST(N'2021-01-01' AS Date), N'0000111122223333', 1E+07, 0, 1, N'0123456789', NULL)
GO

--Chèn tài khoản
--TK001: Full quyền
--TK002: QLTK
--TK003: QLNS
--TK004: Thông tin HD & SP
--TK005 SP & CD
--TK006: Tính lương
--TK007: Chấm công
--Password chung: 123456
USE [QuanLyLSP]
GO
INSERT [dbo].[TaiKhoan] ([maNV], [userName], [matKhau], [vaiTro], [trangThai]) VALUES (N'21031001', N'TK001', N'8d969eef6ecad3c2', 1, 1)
GO
INSERT [dbo].[TaiKhoan] ([maNV], [userName], [matKhau], [vaiTro], [trangThai]) VALUES (N'21031002', N'TK002', N'8d969eef6ecad3c2', 2, 1)
GO
INSERT [dbo].[TaiKhoan] ([maNV], [userName], [matKhau], [vaiTro], [trangThai]) VALUES (N'21031003', N'TK003', N'8d969eef6ecad3c2', 3, 1)
GO
INSERT [dbo].[TaiKhoan] ([maNV], [userName], [matKhau], [vaiTro], [trangThai]) VALUES (N'21031004', N'TK004', N'8d969eef6ecad3c2', 4, 1)
GO
INSERT [dbo].[TaiKhoan] ([maNV], [userName], [matKhau], [vaiTro], [trangThai]) VALUES (N'21031005', N'TK005', N'8d969eef6ecad3c2', 5, 1)
GO
INSERT [dbo].[TaiKhoan] ([maNV], [userName], [matKhau], [vaiTro], [trangThai]) VALUES (N'21031006', N'TK006', N'8d969eef6ecad3c2', 6, 1)
GO
INSERT [dbo].[TaiKhoan] ([maNV], [userName], [matKhau], [vaiTro], [trangThai]) VALUES (N'21031007', N'TK007', N'8d969eef6ecad3c2', 7, 1)
GO

