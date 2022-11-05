/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.MauSac;
import DomainModels.NSX;
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
public class NSXRepository implements IQLNSX {

    String SQL_GETALL = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "  FROM [dbo].[NSX]";
    String SQL_FINONE = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "  FROM [dbo].[NSX]\n"
            + "  where Ten = ?";
    String SQL_INSERT = "INSERT INTO [dbo].[NSX]\n"
            + "           ([Ma]\n"
            + "           ,[Ten])\n"
            + "     VALUES\n"
            + "           (?,?)";
    String SQL_DELETE = "DELETE FROM [dbo].[NSX]\n"
            + "      WHERE Id = ?";

    private List<NSX> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<NSX> listcv = new ArrayList<>();
            while (rs.next()) {
                listcv.add(new NSX(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<NSX> getALL() {
        return getselectSQL(SQL_GETALL);
    }

    public NSX finone(String ma) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_FINONE)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NSX(rs.getString(1), rs.getString(2), rs.getString(3));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        
        System.out.println(new NSXRepository().save(new NSX(null, "PO)", "Chiu")));
    }

    @Override
    public boolean save(NSX nsx) {
        System.out.println(nsx.toString());
        nsx.setId(null);
        if (DBConnection.Excute(SQL_INSERT, nsx.getMa(),nsx.getTen()) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(NSX nsx) {
        if (DBConnection.Excute(SQL_DELETE, nsx.getId()) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
