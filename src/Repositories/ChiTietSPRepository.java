/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.ChITietSP;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
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
public class ChiTietSPRepository implements IQLCHiTietSP {

    private String SQL_getALL = "SELECT [Id]\n"
            + "      ,[IdSP]\n"
            + "      ,[IdNsx]\n"
            + "      ,[IdMauSac]\n"
            + "      ,[IdDongSP]\n"
            + "      ,[NamBH]\n"
            + "      ,[MoTa]\n"
            + "      ,[SoLuongTon]\n"
            + "      ,[GiaNhap]\n"
            + "      ,[GiaBan]\n"
            + "  FROM [dbo].[ChiTietSP]";
    private String SQL_GetOne = "SELECT [Id]\n"
            + "      ,[IdSP]\n"
            + "      ,[IdNsx]\n"
            + "      ,[IdMauSac]\n"
            + "      ,[IdDongSP]\n"
            + "      ,[NamBH]\n"
            + "      ,[MoTa]\n"
            + "      ,[SoLuongTon]\n"
            + "      ,[GiaNhap]\n"
            + "      ,[GiaBan]\n"
            + "  FROM [dbo].[ChiTietSP]\n"
            + "  where Id = ?";
    private String SQL_remove = "DELETE FROM [dbo].[ChiTietSP]\n"
            + "      WHERE Id = ?";
    private String SQL_update = "UPDATE [dbo].[ChiTietSP]\n"
            + "   SET [IdSP] = ?,[IdNsx] = ?,[IdMauSac] = ?,[IdDongSP] = ?,[NamBH] = ?,[MoTa] = ?,[SoLuongTon] = ?,[GiaNhap] = ?,[GiaBan] = ?\n"
            + " WHERE Id = ?";
    private String SQL_save = "INSERT INTO [dbo].[ChiTietSP]\n"
            + "           ([IdSP]\n"
            + "           ,[IdNsx]\n"
            + "           ,[IdMauSac]\n"
            + "           ,[IdDongSP]\n"
            + "           ,[NamBH]\n"
            + "           ,[MoTa]\n"
            + "           ,[SoLuongTon]\n"
            + "           ,[GiaNhap]\n"
            + "           ,[GiaBan])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?,?,?)";

    private List<ChITietSP> getselectSQL(String sql, Object... arg) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, arg);
            List<ChITietSP> listcv = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(2));
                NSX nsx = new NSX(rs.getString(3));
                MauSac ms = new MauSac(rs.getString(4));
                DongSP dsp = new DongSP(rs.getString(5));
                listcv.add(new ChITietSP(rs.getString(1), sp,
                        nsx, ms, dsp,
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getBigDecimal(9), rs.getBigDecimal(10)));
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<ChITietSP> GetAll() {
        List<ChITietSP> listcv = new ArrayList<>();
        return getselectSQL(SQL_getALL);
    }

    @Override
    public int save(ChITietSP ctsp) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_save)) {
            ps.setObject(1, ctsp.getIdSp().getId());
            ps.setObject(2, ctsp.getIdNSX().getId());
            ps.setObject(3, ctsp.getIdMauSac().getId());
            ps.setObject(4, ctsp.getIdDongSP().getId());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuongTon());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());
            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    @Override
    public int update(ChITietSP ctsp) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_update)) {
            ps.setObject(10,ctsp.getId());
            ps.setObject(1, ctsp.getIdSp().getId());
            ps.setObject(2, ctsp.getIdNSX().getId());
            ps.setObject(3, ctsp.getIdMauSac().getId());
            ps.setObject(4, ctsp.getIdDongSP().getId());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuongTon());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());
            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    @Override
    public int remove(String ma) {
        return DBConnection.Excute(SQL_remove, ma);
    }

    @Override
    public ChITietSP getone(ChITietSP ctsp) {
        try (Connection con = DBConnection.openDbConnection();
                PreparedStatement ps = con.prepareStatement(SQL_GetOne)) {
            ps.setObject(1, ctsp.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(2), null, null);
                NSX nsx = new NSX(rs.getString(3), null, null);
                MauSac ms = new MauSac(rs.getString(4), null, null);
                DongSP dsp = new DongSP(rs.getString(5), null, null);
                ctsp = new ChITietSP(rs.getString(1), sp,
                        nsx, ms, dsp,
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getBigDecimal(9), rs.getBigDecimal(10));
            }
            return ctsp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        ChITietSP ctsp = new ChITietSP("A5C882FC-7834-4EE7-A581-0018DFEA9565", null, null, null, null, 0, null, 0, 0, 0);
        List<ChITietSP> sP = new ChiTietSPRepository().GetAll();
//        System.out.println(new ChiTietSPRepository().remove(ctsp.getId()));
//        System.out.println(sP.toString());
        for (ChITietSP chITietSP : sP) {
            System.out.println(chITietSP.toString());
        }
    }
}
