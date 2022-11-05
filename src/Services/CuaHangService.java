/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.CuaHang;
import Repositories.CuaHangRepository;
import Repositories.IQLCuaHang;
import Utilities.DBConnection;
import ViewModels.QLCuaHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class CuaHangService implements IQLCuaHangService {

    private IQLCuaHang iqlch = new CuaHangRepository();

    @Override
    public String getone(String ten) {
        return iqlch.getone(ten);
    }

    @Override
    public List<QLCuaHang> getALL() {
        List<QLCuaHang> listch = new ArrayList<>();
        var x = iqlch.getall();
        for (CuaHang ch : x) {
            listch.add(new QLCuaHang(ch.getId(), ch.getMa(), ch.getTen(),
                     ch.getDiaChi(), ch.getThanhPho(), ch.getQuocGia()));
        }
        return listch;
    }
    
    public static void main(String[] args) {
        List<QLCuaHang> listch = new CuaHangService().getALL();
        for (QLCuaHang qLCuaHang : listch) {
            System.out.println(qLCuaHang.toString());
        }
    }

    @Override
    public boolean save(QLCuaHang qlch) {
        return iqlch.save(new CuaHang(null, qlch.getMa(), qlch.getTen(), qlch.getDiaChi(), qlch.getThanhPho(), qlch.getQuocGia()));
    }

    @Override
    public boolean update(QLCuaHang qlch) {
return iqlch.update(new CuaHang(qlch.getId(), qlch.getMa(), qlch.getTen(), qlch.getDiaChi(), qlch.getThanhPho(), qlch.getQuocGia()));
    }

    @Override
    public boolean remove(String id) {
        return iqlch.remove(id);
    }
}
