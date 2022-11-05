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
public class HoaDonChiTiet {
    private HoaDon idhoaDon;
    private ChITietSP idChiTiet;
    private int soLuong;
    private BigDecimal donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon idhoaDon, ChITietSP idChiTiet, int soLuong, BigDecimal donGia) {
        this.idhoaDon = idhoaDon;
        this.idChiTiet = idChiTiet;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getIdhoaDon() {
        return idhoaDon;
    }

    public void setIdhoaDon(HoaDon idhoaDon) {
        this.idhoaDon = idhoaDon;
    }

    public ChITietSP getIdChiTiet() {
        return idChiTiet;
    }

    public void setIdChiTiet(ChITietSP idChiTiet) {
        this.idChiTiet = idChiTiet;
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

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idhoaDon=" + idhoaDon + ", idChiTiet=" + idChiTiet + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    
    
    
    
}
