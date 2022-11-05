/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChITietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import Utilities.DBConnection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author congh
 */
public class GioHangChiTietRepository implements IQLGioHangChiTiet {

    String SQL_GETALL = "SELECT [IdGioHang]\n"
            + "      ,[IdChiTietSP]\n"
            + "      ,[SoLuong]\n"
            + "      ,[DonGia]\n"
            + "      ,[DonGiaKhiGiam]\n"
            + "  FROM [dbo].[GioHangChiTiet]";
    String SQL_INSERT = "INSERT INTO [dbo].[GioHangChiTiet]\n"
            + "           ([IdGioHang]\n"
            + "           ,[IdChiTietSP]\n"
            + "           ,[SoLuong]\n"
            + "           ,[DonGia]\n"
            + "           ,[DonGiaKhiGiam])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?)";
    String SQL_UPDATE = "UPDATE [dbo].[GioHangChiTiet]\n"
            + "   SET [IdGioHang] = ?\n"
            + "      ,[IdChiTietSP] = ?\n"
            + "      ,[SoLuong] = ?\n"
            + "      ,[DonGia] = ?\n"
            + "      ,[DonGiaKhiGiam] = ?\n"
            + " WHERE IdGioHang = ?";
    String SQL_DELETE = "DELETE FROM [dbo].[GioHangChiTiet]\n"
            + "      WHERE IdChiTietSP = ?";
 private List<GioHangChiTiet> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<GioHangChiTiet> listNV = new ArrayList<>();
            while (rs.next()) {
                GioHang gh = new GioHang(rs.getString(1));
                ChITietSP ctsp = new ChITietSP(rs.getString(2));
                listNV.add(new GioHangChiTiet(gh, ctsp, rs.getInt(3), rs.getBigDecimal(4), rs.getBigDecimal(5)));
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<GioHangChiTiet> getALL() {
        return getselectSQL(SQL_GETALL);
    }

    @Override
    public boolean save(GioHangChiTiet ghct) {
        if (DBConnection.Excute(SQL_GETALL, ghct.getIdGioHang(),ghct.getIdChiTiietSP(),ghct.getSoLuong(),ghct.getDonGiaKhiGiam(),ghct.getDonGia()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(GioHangChiTiet ghct) {
        if (DBConnection.Excute(SQL_UPDATE, ghct.getIdGioHang(),ghct.getIdChiTiietSP(),ghct.getSoLuong(),ghct.getDonGiaKhiGiam(),ghct.getDonGia()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(GioHangChiTiet ghct) {
        if (DBConnection.Excute(SQL_DELETE, ghct.getIdGioHang()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GioHangChiTiet getone(GioHangChiTiet ghct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
