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
public class QLHoaDonChiTiet {
    private QLHoaDon idhoaDon;
    private QLChiTietSP idChiTietSP;
    private int soLuong;
    private BigDecimal donGia;

    public QLHoaDonChiTiet() {
    }

    public QLHoaDonChiTiet(QLHoaDon idhoaDon, QLChiTietSP idChiTietSP, int soLuong, BigDecimal donGia) {
        this.idhoaDon = idhoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public QLHoaDon getIdhoaDon() {
        return idhoaDon;
    }

    public void setIdhoaDon(QLHoaDon idhoaDon) {
        this.idhoaDon = idhoaDon;
    }

    public QLChiTietSP getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(QLChiTietSP idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
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
        return "QLHoaDonChiTiet{" + "idhoaDon=" + idhoaDon + ", idChiTietSP=" + idChiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    public Object[] ToRow(){
            return new Object[]{idhoaDon,idChiTietSP,donGia,soLuong};
    }

}
