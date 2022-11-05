/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.SanPham;
import Utilities.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 *
 * @author congh
 */
public class SanPhamRepository implements IQLSanPham {

    private String SQL_GETALL = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "  FROM [dbo].[SanPham]";
    private String SQL_INSERT = "INSERT INTO [dbo].[SanPham]\n"
            + "           ([Ma]\n"
            + "           ,[Ten])\n"
            + "     VALUES\n"
            + "           (?,?)";
    private String SQL_UPDATE = "UPDATE [dbo].[SanPham]\n"
            + "   SET [Ma] = ?\n"
            + "      ,[Ten] = ?\n"
            + " WHERE Id = ?";
    private String SQL_REMOVE = "DELETE FROM [dbo].[SanPham]\n"
            + "      WHERE Id = ?";
    private String SQL_GETONE = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "  FROM [dbo].[SanPham]\n"
            + "  where Ma = ?";

    private List<SanPham> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<SanPham> listcv = new ArrayList<>();
            while (rs.next()) {
                listcv.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPham> getall() {
        List<SanPham> listSP = new ArrayList<>();
        return getselectSQL(SQL_GETALL);
    }

    @Override
    public boolean save(SanPham sp) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
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
    public boolean update(SanPham sp) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setObject(3, sp.getId());
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
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
    public boolean remove(String id) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_REMOVE)) {
            ps.setObject(1, id);
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
    public SanPham findOne(String ma) {
     try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_GETONE)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<SanPham> listSP = new ArrayList<>();
        listSP = new SanPhamRepository().getall();
        for (SanPham sanPham : listSP) {
            System.out.println(sanPham.toString());
        }
//System.out.println(new SanPhamRepository().update(new SanPham("1d723fd47d1a","ps1","íadas")));
System.out.println(new SanPhamRepository().remove("B08BB04E-1EDC-4D14-970C-12115192F69D"));
//System.out.println(new SanPhamRepository().findOne(ma));
    }
}
