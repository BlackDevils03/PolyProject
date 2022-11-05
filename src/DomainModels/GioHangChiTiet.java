/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author congh
 */
public class GioHangChiTiet {
    private GioHang idGioHang;
    private ChITietSP idChiTiietSP;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(GioHang idGioHang, ChITietSP idChiTiietSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idChiTiietSP = idChiTiietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHang getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(GioHang idGioHang) {
        this.idGioHang = idGioHang;
    }

    public ChITietSP getIdChiTiietSP() {
        return idChiTiietSP;
    }

    public void setIdChiTiietSP(ChITietSP idChiTiietSP) {
        this.idChiTiietSP = idChiTiietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    
    @Override
    public String toString() {
        return "GioHangChiTiet{" + "idGioHang=" + idGioHang + ", idChiTiietSP=" + idChiTiietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donGiaKhiGiam=" + donGiaKhiGiam + '}';
    }
    
    
}
