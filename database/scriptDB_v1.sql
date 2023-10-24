CREATE DATABASE QuanLyLSP
use QuanLyLSP

CREATE TABLE BoPhan (
	maBP VARCHAR(20) PRIMARY KEY, 
	tenBP VARCHAR(30), 
)

CREATE TABLE NhanVien (
    maNV VARCHAR(20) PRIMARY KEY,
	maBP VARCHAR(20),
    tenNV VARCHAR(30),
    gioiTinh BIT,
    ngaySinh DATE,
    ngayBatDauLam DATE,
    CCCD VARCHAR(30),
    luongCoBan FLOAT(10),
    phuCap FLOAT(10),
    trangThai BIT,
    dienThoai VARCHAR(20),
    hinhAnh VARBINARY(MAX), 
	FOREIGN KEY (maBP) REFERENCES BoPhan(maBP)
);

CREATE TABLE BangDanhGia (
	maBDG VARCHAR(20) PRIMARY KEY,
    nam INT,
    maNV VARCHAR(20),
    diemChuyenCan FLOAT,
    diemThaiDo FLOAT,
    diemHieuSuat FLOAT,
    bac CHAR,
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);

CREATE TABLE PhieuChamCongHanhChinh (
	maPCCHC VARCHAR(20),
    Ngay DATE,
    maNV VARCHAR(20),
    vang BIT,
    diTre BIT,
    gioTangCa INT,
    tienPhat FLOAT(10),
    noiDungPhat VARCHAR(20),
    PRIMARY KEY (maPCCHC),
	FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);

CREATE TABLE TaiKhoan (
    maNV VARCHAR(20),
    userName VARCHAR(30),
    matKhau VARCHAR(30),
    vaiTro INT,
    trangThai BIT,
    PRIMARY KEY (maNV),
	CONSTRAINT PK_userName UNIQUE (userName),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);

CREATE TABLE CongNhan (
    maCN VARCHAR(20) PRIMARY KEY,
	maBP VARCHAR(20),
    tenCN VARCHAR(30),
    gioiTinh BIT,
    ngaySinh DATE,
    ngayBatDauLam DATE,
    CCCD VARCHAR(30),
    trangThai BIT,
    choPhanCong BIT,
    hinhAnh VARBINARY(MAX), 
	FOREIGN KEY (maBP) REFERENCES BoPhan(maBP)
);

CREATE TABLE KhachHang (
    maKH VARCHAR(20) PRIMARY KEY,
    tenKH VARCHAR(30),
    toChuc BIT,
    email VARCHAR(50),
    dienThoai VARCHAR(20),
    hinhAnh VARBINARY(MAX)
);

CREATE TABLE HopDong (
    maHD VARCHAR(20) PRIMARY KEY,
    maKH VARCHAR(20),
    tenHD VARCHAR(50),
    donGia FLOAT(10),
    ngayBatDau DATE,
    ngayKetThucDukien DATE,
    trangThai VARCHAR(20),
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH)
);

CREATE TABLE SanPham (
    maSP VARCHAR(20) PRIMARY KEY,
    maHD VARCHAR(20),
    tenSP VARCHAR(30),
    soLuong INT,
    donGia FLOAT(10),
    hinhAnh VARBINARY(MAX),
    FOREIGN KEY (maHD) REFERENCES HopDong(maHD)
);

CREATE TABLE CongDoan (
    maCD VARCHAR(20) PRIMARY KEY,
    maSP VARCHAR(20),
	maBP VARCHAR(20),
    tenCD VARCHAR(30),
    donGia FLOAT(10),
    trangThai BIT,
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP),
	FOREIGN KEY (maBP) REFERENCES BoPhan(maBP)
);

CREATE TABLE CongDoanTienQuyet (
    maCDTQ VARCHAR(20),
	maCD VARCHAR(20),
    soLuongToiThieu INT,
	PRIMARY KEY (maCD, maCDTQ),
    FOREIGN KEY (maCDTQ) REFERENCES CongDoan(maCD),
    FOREIGN KEY (maCD) REFERENCES CongDoan(maCD)
);

CREATE TABLE ChiTietPhanCong (
	maCTPC VARCHAR(20),
    maCD VARCHAR(20),
    maCN VARCHAR(20),
    ngay DATE,
    soLuongCDGiao INT,
    PRIMARY KEY (maCTPC),
    FOREIGN KEY (maCD) REFERENCES CongDoan(maCD),
    FOREIGN KEY (maCN) REFERENCES CongNhan(maCN)
);

CREATE TABLE PhieuLuong (
	maPL VARCHAR(20) PRIMARY KEY,
    thang INT,
    nam INT,
    maNV VARCHAR(20),
    maCN VARCHAR(20),
    phat FLOAT(10),
    luong FLOAT(10),
    thuong FLOAT(10),
    soNgayLam INT,
    luongThucNhan FLOAT(10),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
    FOREIGN KEY (maCN) REFERENCES CongNhan(maCN)
);

CREATE TABLE PhieuChamCongCongNhan (
	maPCCCN VARCHAR(20) PRIMARY KEY,
	maCTPC VARCHAR(20), 
    soLuongCD INT,
    soLuongCDTangCa INT,
    tienPhat FLOAT(10),
    noiDungPhat VARCHAR(255),
	FOREIGN KEY (maCTPC) REFERENCES ChiTietPhanCong(maCTPC)
);
