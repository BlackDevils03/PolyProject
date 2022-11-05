/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class CuaHangRepository implements IQLCuaHang {

    String SQL_SELECTONE = "SELECT [Id]\n"
            + "  FROM [dbo].[CuaHang]\n"
            + "  where Ten like ?";
    String SQL_SELECTALL = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "      ,[DiaChi]\n"
            + "      ,[ThanhPho]\n"
            + "      ,[QuocGia]\n"
            + "  FROM [dbo].[CuaHang]";
    String SQL_INSERT = "INSERT INTO [dbo].[CuaHang]\n"
            + "           ([Ma]\n"
            + "           ,[Ten]\n"
            + "           ,[DiaChi]\n"
            + "           ,[ThanhPho]\n"
            + "           ,[QuocGia])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?)";
    String SQL_UPDATE = "UPDATE [dbo].[CuaHang]\n"
            + "   SET[Ma] = ?\n"
            + "      ,[Ten] = ?\n"
            + "      ,[DiaChi] = ?\n"
            + "      ,[ThanhPho] = ?\n"
            + "      ,[QuocGia] = ?\n"
            + " WHERE Id like ?";
    String SQL_REMOVE = "DELETE FROM [dbo].[CuaHang]\n"
            + "      WHERE Id like ?";

    public String getone(String ten) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_SELECTONE)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                return id;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    private List<CuaHang> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<CuaHang> listch = new ArrayList<>();
            while (rs.next()) {
                listch.add(new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6)));
            }
            return listch;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean save(CuaHang ch) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            ps.setObject(5, ch.getQuocGia());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean update(CuaHang ch) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setObject(6, ch.getId());
            ps.setObject(1, ch.getMa());
            ps.setObject(2, ch.getTen());
            ps.setObject(3, ch.getDiaChi());
            ps.setObject(4, ch.getThanhPho());
            ps.setObject(5, ch.getQuocGia());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean remove(String id) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_REMOVE)) {
            ps.setObject(1, id);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;

    }

    @Override
    public List<CuaHang> getall() {
        List<CuaHang> listch = new ArrayList<>();
        return getselectSQL(SQL_SELECTALL);
    }

    
}
