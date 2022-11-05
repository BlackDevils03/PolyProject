/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author congh
 */
public class QLGioHangChiTiet {
    private QLGioHang idGioHang;
    private QLChiTietSP idChiTiietSP;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;
    int i = 0;
    public QLGioHangChiTiet() {
        
    }

    public QLGioHangChiTiet(QLGioHang idGioHang, QLChiTietSP idChiTiietSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idChiTiietSP = idChiTiietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public QLGioHang getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(QLGioHang idGioHang) {
        this.idGioHang = idGioHang;
    }

    public QLChiTietSP getIdChiTiietSP() {
        return idChiTiietSP;
    }

    public void setIdChiTiietSP(QLChiTietSP idChiTiietSP) {
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

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "QLGioHangChiTiet{" + "idGioHang=" + idGioHang + ", idChiTiietSP=" + idChiTiietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donGiaKhiGiam=" + donGiaKhiGiam + ", i=" + i + '}';
    }

    
    public Object[] toRow(){
        double x = Double.parseDouble(String.valueOf(donGia));
        return new Object[]{i++,idGioHang,idChiTiietSP.getId(),soLuong,donGia,x * soLuong};
    }
}
