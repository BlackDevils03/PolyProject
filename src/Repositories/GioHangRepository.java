/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.GioHang;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author congh
 */
public class GioHangRepository implements IQLGioHang {

    String SQL_GETALL = "SELECT [Id]\n"
            + "      ,[IdKH]\n"
            + "      ,[IdNV]\n"
            + "      ,[Ma]\n"
            + "      ,[NgayTao]\n"
            + "      ,[NgayThanhToan]\n"
            + "      ,[TenNguoiNhan]\n"
            + "      ,[DiaChi]\n"
            + "      ,[Sdt]\n"
            + "      ,[TinhTrang]\n"
            + "  FROM [dbo].[GioHang]";
    String SQL_INSERT = "INSERT INTO [dbo].[GioHang]\n"
            + "           ([IdKH]\n"
            + "           ,[IdNV]\n"
            + "           ,[Ma]\n"
            + "           ,[NgayTao]\n"
            + "           ,[NgayThanhToan]\n"
            + "           ,[TenNguoiNhan]\n"
            + "           ,[DiaChi]\n"
            + "           ,[Sdt]\n"
            + "           ,[TinhTrang])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?)";
    String SQL_UPDATE = "UPDATE [dbo].[GioHang]\n"
            + "   SET [IdKH] = ?\n"
            + "      ,[IdNV] = ?\n"
            + "      ,[Ma] = ?\n"
            + "      ,[NgayTao] = ?\n"
            + "      ,[NgayThanhToan] = ?\n"
            + "      ,[TenNguoiNhan] = ?\n"
            + "      ,[DiaChi] = ?\n"
            + "      ,[Sdt] = ?\n"
            + "      ,[TinhTrang] = ?\n"
            + " WHERE Id = ?";
    String SQL_DELETE = "DELETE FROM [dbo].[GioHang]\n"
            + "      WHERE Id = ?";
    String SQL_GETONE = "SELECT [Id]\n"
            + "      ,[IdKH]\n"
            + "      ,[IdNV]\n"
            + "      ,[Ma]\n"
            + "      ,[NgayTao]\n"
            + "      ,[NgayThanhToan]\n"
            + "      ,[TenNguoiNhan]\n"
            + "      ,[DiaChi]\n"
            + "      ,[Sdt]\n"
            + "      ,[TinhTrang]\n"
            + "  FROM [dbo].[GioHang]"
            + "Where Id = ?";
     private List<GioHang> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<GioHang> listNV = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(2));
                NhanVien nv = new NhanVien(rs.getString(3));
                listNV.add(new GioHang(rs.getString(1), kh, nv, rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     

    @Override
    public List<GioHang> getALL() {
        return getselectSQL(SQL_GETALL);
    }

    @Override
    public boolean save(GioHang gh) {
        gh.setId(null);
        if (DBConnection.Excute(SQL_INSERT, gh) > 0) {
            return true;
        } else {
           return false;
        }
    }

    @Override
    public boolean update(GioHang gh) {
        if (DBConnection.Excute(SQL_UPDATE, gh) > 0) {
            return true;
        } else {
           return false;
        }
    }

    @Override
    public boolean remove(GioHang gh) {
        if (DBConnection.Excute(SQL_DELETE, gh.getId()) > 0) {
            return true;
        } else {
           return false;
        }
    }

    @Override
    public List<GioHang> getone(GioHang gh) {
        return getselectSQL(SQL_GETONE, gh.getId());
    }
}
