/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Repositories.HoaDonRepository;
import Repositories.IQLHoaDon;
import ViewModels.QLHoaDon;
import ViewModels.QLKhachHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class HoaDonService implements IQLHoaDonService{
    IQLHoaDon iqlhd = new HoaDonRepository();
    @Override
    public List<QLHoaDon> getALL() {
        List<QLHoaDon> listhd = new ArrayList<>();
        var x = iqlhd.getALL();
        for (HoaDon hd : x) {
            QLKhachHang qlkh = new QLKhachHang(hd.getIdKH().getId());
            QLNhanVien qlnv = new QLNhanVien(hd.getIdNV().getId());
            listhd.add(new QLHoaDon(hd.getId(), qlkh, qlnv, hd.getMa(), hd.getNgayTao(), hd.getNgayThanhToan(), hd.getNgayShip(),hd.getNgayNhan(), hd.getTinhTrang(), hd.getTenNguoiNhan(), hd.getDiaChi(), hd.getSdt()));
        }
        return listhd;
    }

    @Override
    public boolean save(QLHoaDon qlhd) {
        KhachHang qljh = new KhachHang(qlhd.getIdKH().getId());
        NhanVien qlnv = new NhanVien(qlhd.getIdNV().getId());
        return iqlhd.save(new HoaDon(qlhd.getId(), qljh, qlnv, qlhd.getMa(), qlhd.getNgayTao()
                , qlhd.getNgayThanhToan(), qlhd.getNgayShip(),qlhd.getNgayNhan(), qlhd.getTinhTrang()
                , qlhd.getTenNguoiNhan(), qlhd.getDiaChi(), qlhd.getSdt()));
    }

    @Override
    public boolean update(QLHoaDon qlhd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(QLHoaDon qlhd) {
        return iqlhd.delete(new HoaDon(qlhd.getId()));
    }

    @Override
    public boolean getone(QLHoaDon qlhd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
