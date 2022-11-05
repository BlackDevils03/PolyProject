/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import DomainModels.DongSP;
import DomainModels.MauSac;
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
public class DongSPRepository implements IQLDongSP {

    String SQL_GETALL = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "  FROM [dbo].[DongSP]";
    String SQL_FINONE = "SELECT [Id]\n"
            + "      ,[Ma]\n"
            + "      ,[Ten]\n"
            + "  FROM [dbo].[DongSP]\n"
            + "  where Ten = ?";
    private List<DongSP> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<DongSP> listcv = new ArrayList<>();
            while (rs.next()) {
                listcv.add(new DongSP(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public List<DongSP> getall(){
        return getselectSQL(SQL_GETALL);
    }
    public DongSP finone(String ma) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_FINONE)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new DongSP(rs.getString(1), rs.getString(2), rs.getString(3));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
       List<DongSP> listcv = new DongSPRepository().getall();
        for (DongSP dongSP : listcv) {
            System.out.println(dongSP.toString());
        }
    }
}
