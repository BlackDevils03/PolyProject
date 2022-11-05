/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonChiTietRepository;
import Repositories.IQLHoaDonChiTiet;
import ViewModels.QLChiTietSP;
import ViewModels.QLHoaDon;
import ViewModels.QLHoaDonChiTiet;
import ViewModels.QLSanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class HoaDonChiTietService implements IQLHoaDonChiTietService{
private IQLHoaDonChiTiet iqlhdct = new HoaDonChiTietRepository();
    @Override
    public List<QLHoaDonChiTiet> getALL() {
        var x = iqlhdct.getALL();
         List<QLHoaDonChiTiet> Listhdct = new ArrayList<>();
         for (HoaDonChiTiet hdct : x) {
             QLChiTietSP qlctsp = new QLChiTietSP(hdct.getIdChiTiet().getId());
             QLHoaDon qlhd = new QLHoaDon(hdct.getIdhoaDon().getId());
            Listhdct.add(new QLHoaDonChiTiet(qlhd, qlctsp, hdct.getSoLuong(), hdct.getDonGia()));
        }
         return Listhdct;
    }

    @Override
    public boolean save(QLHoaDonChiTiet qlhdct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(QLHoaDonChiTiet qlhdct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(QLHoaDonChiTiet qlhdct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public QLHoaDonChiTiet getone(String s) {
        var x = iqlhdct.getone(s);
        QLChiTietSP qlctsp = new QLChiTietSP(x.getIdChiTiet().getId());
             QLHoaDon qlhd = new QLHoaDon(x.getIdhoaDon().getId());
        return new QLHoaDonChiTiet(qlhd, qlctsp, x.getSoLuong(), x.getDonGia());
    }
    
}
