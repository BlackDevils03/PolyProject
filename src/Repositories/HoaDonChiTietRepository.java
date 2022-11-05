/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChITietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;


/**
 *
 * @author congh
 */


public class HoaDonChiTietRepository implements IQLHoaDonChiTiet {

    String SQL_GETALL = "SELECT [IdHoaDon]\n"
            + "      ,[IdChiTietSP]\n"
            + "      ,[SoLuong]\n"
            + "      ,[DonGia]\n"
            + "  FROM [dbo].[HoaDonChiTiet]";
    String SQL_INSERT = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
            + "           ([IdHoaDon]\n"
            + "           ,[IdChiTietSP]\n"
            + "           ,[SoLuong]\n"
            + "           ,[DonGia])\n"
            + "     VALUES\n"
            + "           (?,?,?,?)";

    String SQL_UPDATE = "UPDATE [dbo].[HoaDonChiTiet]\n"
            + "   SET [IdHoaDon] = ?\n"
            + "      ,[IdChiTietSP] = ?\n"
            + "      ,[SoLuong] = ?\n"
            + "      ,[DonGia] = ?\n"
            + " WHERE IdHoaDon = ?";

    String SQL_DELETE = "DELETE FROM [dbo].[HoaDonChiTiet]\n"
            + "      WHERE IdHoaDon = ?";
    String SQL_GETONE = "SELECT [IdHoaDon]\n"
            + "      ,[IdChiTietSP]\n"
            + "      ,[SoLuong]\n"
            + "      ,[DonGia]\n"
            + "  FROM [dbo].[HoaDonChiTiet]"
            + "Where IdHoaDon = ?";

    private List<HoaDonChiTiet> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<HoaDonChiTiet> listNV = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1));
                ChITietSP ctsp = new ChITietSP(rs.getString(2));
                listNV.add(new HoaDonChiTiet(hd, ctsp, rs.getInt(3), rs.getBigDecimal(4)));
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HoaDonChiTiet> getALL() {
        return getselectSQL(SQL_GETALL);
    }

    @Override
    public boolean save(HoaDonChiTiet hdct) {
        if (DBConnection.Excute(SQL_INSERT, hdct.getIdhoaDon()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(HoaDonChiTiet hdct) {
        if (DBConnection.Excute(SQL_UPDATE, hdct.getIdhoaDon(), hdct) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(HoaDonChiTiet hdct) {
        if (DBConnection.Excute(SQL_DELETE, hdct.getIdhoaDon()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public HoaDonChiTiet getone(String s) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_GETONE)) {
            ps.setObject(1, s);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1));
                ChITietSP ctsp = new ChITietSP(rs.getString(2));
                return new HoaDonChiTiet(hd, ctsp, rs.getInt(3), rs.getBigDecimal(4));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
