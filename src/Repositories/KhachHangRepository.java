/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Utilities.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 *
 * @author congh
 */
public class KhachHangRepository implements IQlKhachHang {

    String SQL_Detele = "DELETE FROM [dbo].[KhachHang]\n"
            + "      WHERE Id = ?";
    String SQL_INSERT = "INSERT INTO [dbo].[KhachHang]\n"
            + "           ([Ma]\n"
            + "           ,[Ten]\n"
            + "           ,[TenDem]\n"
            + "           ,[Ho]\n"
            + "           ,[NgaySinh]\n"
            + "           ,[Sdt]\n"
            + "           ,[DiaChi]\n"
            + "           ,[ThanhPho]\n"
            + "           ,[QuocGia]\n"
            + "           ,[MatKhau])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?,?,?,?)";
    String SQL_GETALL = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "      ,[TenDem]\n"
            + "      ,[Ho]\n"
            + "      ,[NgaySinh]\n"
            + "      ,[Sdt]\n"
            + "      ,[DiaChi]\n"
            + "      ,[ThanhPho]\n"
            + "      ,[QuocGia]\n"
            + "      ,[MatKhau]\n"
            + "  FROM [dbo].[KhachHang]";
    String SQL_GETONE = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "      ,[TenDem]\n"
            + "      ,[Ho]\n"
            + "      ,[NgaySinh]\n"
            + "      ,[Sdt]\n"
            + "      ,[DiaChi]\n"
            + "      ,[ThanhPho]\n"
            + "      ,[QuocGia]\n"
            + "      ,[MatKhau]\n"
            + "  FROM [dbo].[KhachHang]\n"
            + "  where Id = ?";
    String SQL_CHECK = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "      ,[TenDem]\n"
            + "      ,[Ho]\n"
            + "      ,[NgaySinh]\n"
            + "      ,[Sdt]\n"
            + "      ,[DiaChi]\n"
            + "      ,[ThanhPho]\n"
            + "      ,[QuocGia]\n"
            + "      ,[MatKhau]\n"
            + "  FROM [dbo].[KhachHang]\n"
            + "  where Ma = ?";
    String SQL_UPDATE = "UPDATE [dbo].[KhachHang]\n"
            + "   SET [Ma] = ?\n"
            + "      ,[Ten] = ?\n"
            + "      ,[TenDem] = ?\n"
            + "      ,[Ho] = ?\n"
            + "      ,[NgaySinh] = ?\n"
            + "      ,[Sdt] = ?\n"
            + "      ,[DiaChi] = ?\n"
            + "      ,[ThanhPho] = ?\n"
            + "      ,[QuocGia] = ?\n"
            + "      ,[MatKhau] = ?\n"
            + " WHERE Id = ?";

    private List<KhachHang> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(SQL_GETALL);
            List<KhachHang> listcv = new ArrayList<>();
            while (rs.next()) {

                listcv.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<KhachHang> getall() {
        return getselectSQL(SQL_GETALL);
    }

    @Override
    public boolean add(KhachHang kh) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean update(KhachHang kh) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setObject(11, kh.getId());
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.getDiaChi());
            ps.setObject(8, kh.getThanhPho());
            ps.setObject(9, kh.getQuocGia());
            ps.setObject(10, kh.getMatKhau());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean delete(KhachHang kh) {
        if (DBConnection.Excute(SQL_Detele, kh.getId()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public KhachHang getone(KhachHang kh) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareCall(SQL_GETONE)) {
            ps.setObject(1, kh.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

               return  new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public String Check(String s) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareCall(SQL_CHECK)) {
            ps.setObject(1, s);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return "Khách hàng";
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    

    public static void main(String[] args) {
//        List<KhachHang> listkh = new KhachHangRepository().getall();
//        for (KhachHang khachHang : listkh) {
//            System.out.println(khachHang.toString());
//        }
//        System.out.println(new KhachHangRepository().add(new KhachHang(null, "2", "2", "2", "2", "2002-04-11", "2", "2", "2", "2", "2")));
        KhachHang kh = new KhachHang("0A56B33E-EB73-4F93-93C2-725E88ABC90A");
        System.out.println(new KhachHangRepository().getone(kh));
        
    }
}
