/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChITietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import Repositories.GioHangChiTietRepository;
import Repositories.IQLGioHang;
import Repositories.IQLGioHangChiTiet;
import Utilities.DBConnection;
import ViewModels.QLChiTietSP;
import ViewModels.QLGioHang;
import ViewModels.QLGioHangChiTiet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author congh
 */
public class GioHangChiTietService implements IQLGioHangChiTietService {
IQLGioHangChiTiet iqlghct = new GioHangChiTietRepository();
    @Override
    public List<QLGioHangChiTiet> getALL() {
        var x = iqlghct.getALL();
        List<QLGioHangChiTiet> listghct = new ArrayList<>();
        for (GioHangChiTiet gioHangChiTiet : x) {
            QLGioHang qlgh = new QLGioHang(gioHangChiTiet.getIdGioHang().getId());
            QLChiTietSP qlctsp = new QLChiTietSP(gioHangChiTiet.getIdChiTiietSP().getId());
            listghct.add(new QLGioHangChiTiet(qlgh, qlctsp, gioHangChiTiet.getSoLuong(), gioHangChiTiet.getDonGia(), gioHangChiTiet.getDonGiaKhiGiam()));
        }
        return listghct;
    }

    @Override
    public boolean save(QLGioHangChiTiet qlghct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(QLGioHangChiTiet qlghct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(QLGioHangChiTiet qlghct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
