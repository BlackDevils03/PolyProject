/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Services.IQLSanPhamService;
import Services.SanPhamService;
import java.math.BigDecimal;

/**
 *
 * @author congh
 */
public class QLChiTietSP {

    private String id;
    private QLSanPham idSp;
    private QLNSX idNSX;
    private QLMauSac idMauSac;
    private QLDongSP idDongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public QLChiTietSP() {
    }

    public QLChiTietSP(String id) {
        this.id = id;
    }

    public QLChiTietSP(String id, QLSanPham idSp, QLNSX idNSX, QLMauSac idMauSac, QLDongSP idDongSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.idSp = idSp;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public QLSanPham getIdSp() {
        return idSp;
    }

    public void setIdSp(QLSanPham idSp) {
        this.idSp = idSp;
    }

    public QLNSX getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(QLNSX idNSX) {
        this.idNSX = idNSX;
    }

    public QLMauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(QLMauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public QLDongSP getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(QLDongSP idDongSP) {
        this.idDongSP = idDongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "QLChiTietSP{" + "id=" + id + ", idSp=" + idSp + ", idNSX=" + idNSX + ", idMauSac=" + idMauSac + ", idDongSP=" + idDongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

    public Object[] torow() {
        return new Object[]{id, idSp.getId(), idNSX.getId(), idMauSac.getId(), idDongSP.getId(), namBH, moTa, soLuongTon, giaNhap, giaBan};
    }

    public Object[] torowBH(int i) {
        String s = "";
        String s1 = "";
        IQLSanPhamService iqlsps = new SanPhamService();
        for (QLSanPham qLSanPham : iqlsps.getall()) {
            if (qLSanPham.getId().equals(idSp.getId())) {
                s = qLSanPham.getTen();
                s1 = qLSanPham.getMa();
            }
        }
        return new Object[]{ i,s1, s, namBH, moTa, soLuongTon, giaNhap, giaBan};
    }
}
