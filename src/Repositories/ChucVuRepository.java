/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import Utilities.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author congh
 */
public class ChucVuRepository implements IQLChucVu {

    static String SQL_Select = "SELECT [Id]\n"
            + "  FROM [dbo].[ChucVu]\n"
            + "  where Ten like ?";
    static String SQL_SELECT_ALL = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "  FROM [dbo].[ChucVu]";

    static String SQL_CHECKCV = "SELECT cv.Ten  FROM [dbo].[NhanVien] as nv \n"
            + "join ChucVu as cv on cv.Id = nv.IdCV \n"
            + "where nv.Ma like ?";

    private List<ChucVu> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<ChucVu> listcv = new ArrayList<>();
            while (rs.next()) {
                listcv.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private ChucVu getselectSQLone(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3));
                return cv;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getone(String ten) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_Select)) {
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

    public String checkCV(String ma) {

        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_CHECKCV)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String check = rs.getString(1);
                return check;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new ChucVuRepository().checkCV("123e"));
    }

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> listcv = new ArrayList<>();
        return getselectSQL(SQL_SELECT_ALL);
    }
    @Override
    public boolean add(ChucVu cv) {
        try {
            Connection cn = DBConnection.openDbConnection();
            String sql = "INSERT INTO ChucVu(Ma,Ten) VALUES(?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            ps.execute();
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return false;

    }

    @Override
    public boolean update(ChucVu cv) {
        try {
            Connection cn = DBConnection.openDbConnection();
            String sql = "UPDATE ChucVu SET Ma = ? , Ten = ? WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(3, cv.getId());
            ps.setString(1, cv.getMa());
            ps.setString(2, cv.getTen());
            
            ps.execute();
            if (ps.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try {
            Connection cn = DBConnection.openDbConnection();
            String sql = "DELETE FROM ChucVu WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
