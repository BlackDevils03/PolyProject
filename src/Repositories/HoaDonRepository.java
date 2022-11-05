/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
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
public class HoaDonRepository implements IQLHoaDon {

    String SQL_GETALL = "SELECT [Id]\n"
            + "      ,[IdKH]\n"
            + "      ,[IdNV]\n"
            + "      ,[Ma]\n"
            + "      ,[NgayTao]\n"
            + "      ,[NgayThanhToan]\n"
            + "      ,[NgayShip]\n"
            + "      ,[NgayNhan]\n"
            + "      ,[TinhTrang]\n"
            + "      ,[TenNguoiNhan]\n"
            + "      ,[DiaChi]\n"
            + "      ,[Sdt]\n"
            + "  FROM [dbo].[HoaDon]";
    String SQL_INSERT = "INSERT INTO [dbo].[HoaDon]\n"
            + "           ([IdKH]\n"
            + "           ,[IdNV]\n"
            + "           ,[Ma]\n"
            + "           ,[NgayTao]\n"
            + "           ,[NgayThanhToan]\n"
            + "           ,[NgayShip]\n"
            + "           ,[NgayNhan]\n"
            + "           ,[TinhTrang]\n"
            + "           ,[TenNguoiNhan]\n"
            + "           ,[DiaChi]\n"
            + "           ,[Sdt])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?,?,?,?,?)";
    String SQL_DELETE = "DELETE FROM [dbo].[HoaDon]\n"
            + "      WHERE Id = ?";
    String SQL_UPDATE = "UPDATE [dbo].[HoaDon]\n"
            + "   SET [Id] = ?\n"
            + "      ,[IdKH] = ?\n"
            + "      ,[IdNV] = ?\n"
            + "      ,[Ma] = ?\n"
            + "      ,[NgayTao] = ?\n"
            + "      ,[NgayThanhToan] = ?\n"
            + "      ,[NgayShip] = ?\n"
            + "      ,[NgayNhan] = ?\n"
            + "      ,[TinhTrang] = ?\n"
            + "      ,[TenNguoiNhan] = ?\n"
            + "      ,[DiaChi] = ?\n"
            + "      ,[Sdt] = ?\n"
            + " WHERE Id = ?";
    String SQL_GETONE = "SELECT [Id]\n"
            + "      ,[IdKH]\n"
            + "      ,[IdNV]\n"
            + "      ,[Ma]\n"
            + "      ,[NgayTao]\n"
            + "      ,[NgayThanhToan]\n"
            + "      ,[NgayShip]\n"
            + "      ,[NgayNhan]\n"
            + "      ,[TinhTrang]\n"
            + "      ,[TenNguoiNhan]\n"
            + "      ,[DiaChi]\n"
            + "      ,[Sdt]\n"
            + "  FROM [dbo].[HoaDon]"
            + "Where Id = ?";

    private List<HoaDon> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<HoaDon> listNV = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(2));
                NhanVien nv = new NhanVien(rs.getString(3));
                listNV.add(new HoaDon(rs.getString(1),
                        kh, nv, rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12)));
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HoaDon> getALL() {
        return getselectSQL(SQL_GETALL);
    }

    @Override
    public boolean save(HoaDon hd) {
        hd.setId(null);
        if (DBConnection.Excute(SQL_INSERT, hd.getIdKH().getId(),hd.getIdNV().getId(),hd.getMa(),hd.getNgayTao(),hd.getNgayThanhToan(),hd.getNgayShip(),hd.getNgayNhan(),hd.getTinhTrang(),hd.getTenNguoiNhan(),hd.getDiaChi(),hd.getSdt()) > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(HoaDon hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(HoaDon hd) {
        if (DBConnection.Excute(SQL_DELETE, hd.getId()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<HoaDon> getOne(HoaDon hd) {
        return getselectSQL(SQL_GETONE, hd.getId());
    }
}
