/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Utilities.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

/**
 *
 * @author congh
 */
public class NhanVienRepository implements IQLNhanVien {

    String SQL_getselectAll = "SELECT [Id],[Ma],[Ten],[TenDem],[Ho],[GioiTinh],[NgaySinh],[DiaChi],[Sdt],[MatKhau],[IdCH],[IdCV],[IdGuiBC],[TrangThai]\n"
            + "  FROM [dbo].[NhanVien]";
    String SQL_getselecOne = "SELECT [Id],[Ma],[Ten],[TenDem],[Ho],[GioiTinh],[NgaySinh],[DiaChi],[Sdt],[MatKhau],[IdCH],[IdCV],[IdGuiBC],[TrangThai]\n"
            + "  FROM [dbo].[NhanVien]"
            + "Where Id = ?";
    String SQL_checkMA = "SELECT [Id] FROM [dbo].[NhanVien] where Ma like ? and MatKhau like ?";
    String SQL_checktontai = "SELECT [Id] FROM [dbo].[NhanVien] where Ma like ?";
    String SQL_INSERTINTO = "INSERT INTO [dbo].[NhanVien]\n"
            + "           ([Ma]\n"
            + "           ,[Ten]\n"
            + "           ,[TenDem]\n"
            + "           ,[Ho]\n"
            + "           ,[GioiTinh]\n"
            + "           ,[NgaySinh]\n"
            + "           ,[DiaChi]\n"
            + "           ,[Sdt]\n"
            + "           ,[MatKhau]\n"
            + "           ,[IdCH]\n"
            + "           ,[IdCV]\n"
            + "           ,[IdGuiBC]\n"
            + "           ,[TrangThai])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String SQL_UPDATE = "UPDATE [dbo].[NhanVien]\n"
            + "   SET [Ma] = ?\n"
            + "      ,[Ten] = ?\n"
            + "      ,[TenDem] = ?\n"
            + "      ,[Ho] = ?\n"
            + "      ,[GioiTinh] = ?\n"
            + "      ,[NgaySinh] = ?\n"
            + "      ,[DiaChi] = ?\n"
            + "      ,[Sdt] =?\n"
            + "      ,[MatKhau] = ?\n"
            + "      ,[IdCH] = ?\n"
            + "      ,[IdCV] = ?\n"
            + "      ,[IdGuiBC] = ?\n"
            + "      ,[TrangThai] = ?\n"
            + " WHERE Id like  ?";
    String SQL_DELETE = "DELETE FROM [dbo].[NhanVien]\n"
            + "      WHERE Id like ?";

    private List<NhanVien> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<NhanVien> listNV = new ArrayList<>();
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString(12));
                CuaHang ch = new CuaHang(rs.getString(11));
                listNV.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        ch, cv, rs.getString(13), rs.getInt(14)));
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<NhanVien> getall() {
        List<NhanVien> listNV = new ArrayList<>();
        return getselectSQL(SQL_getselectAll);
    }

    public static void main(String[] args) {
        List<NhanVien> listNV = new ArrayList<>();
        listNV = new NhanVienRepository().getall();
        for (NhanVien nhanVien : listNV) {
            System.out.println(nhanVien.toString());
        }
//        System.out.println(new NhanVienRepository().checkMa("PH28107", "Huy29062003"));
    }

    public boolean checkMa(String tk, String Mk) {

        try {
            ResultSet rs = DBConnection.getDataFromQuery(SQL_checkMA, tk, Mk);
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    public boolean checkTonTai(String tk) {

        try {
            ResultSet rs = DBConnection.getDataFromQuery(SQL_checktontai, tk);
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean save(NhanVien nv) {
//        nv.setNgaySinh(null);
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_INSERTINTO)) {
            Date date = Date.valueOf(nv.getNgaySinh());
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, date);
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSdt());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getIdCH().getId());
            ps.setObject(11, nv.getIdCV().getId());
            ps.setObject(12, nv.getIdGuiBC());
            ps.setObject(13, nv.getTrangThai());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean update(NhanVien nv) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            Date date = Date.valueOf(nv.getNgaySinh());
            ps.setObject(14, nv.getId());
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, date);
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSdt());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getIdCH().getId());
            ps.setObject(11, nv.getIdCV().getId());
            ps.setObject(12, nv.getIdGuiBC());
            ps.setObject(13, nv.getTrangThai());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean delete(String id) {
//        nv.setNgaySinh(null);
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
            ps.setObject(1, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    public NhanVien getone(NhanVien nv){
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_getselecOne)) {
            ps.setObject(1, nv.getId());
            ResultSet  rs = ps.executeQuery();
            if (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString(12));
                CuaHang ch = new CuaHang(rs.getString(11));
                return new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        ch, cv, rs.getString(13), rs.getInt(14));
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
