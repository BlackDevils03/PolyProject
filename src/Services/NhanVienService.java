/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Repositories.IQLNhanVien;
import Repositories.NhanVienRepository;
import ViewModels.QLChucVu;
import ViewModels.QLCuaHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class NhanVienService implements IQLNhanVienService {

    private IQLNhanVien iQLnv = new NhanVienRepository();

    @Override
    public List<QLNhanVien> getAll() {
        List<QLNhanVien> ListQLCV = new ArrayList<>();
        var x = iQLnv.getall();

        for (NhanVien nv : x) {
            QLCuaHang ch = new QLCuaHang(nv.getIdCH().getId());
            QLChucVu cv = new QLChucVu(nv.getIdCV().getId());
            ListQLCV.add(new QLNhanVien(nv.getId(), nv.getMa(), nv.getTen(),
                    nv.getTenDem(), nv.getHo(), nv.getGioiTinh(), nv.getNgaySinh(),
                     nv.getDiaChi(), nv.getSdt(), nv.getMatKhau(), ch,
                    cv, nv.getIdGuiBC(), nv.getTrangThai()));
        }
        return ListQLCV;
    }

    @Override
    public boolean checkMa(String tk, String mk) {
        return iQLnv.checkMa(tk, mk);
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienService().checkMa("PH28107", "Huy29062003"));
        List<QLNhanVien> listql = new ArrayList<>();
        listql = new NhanVienService().getAll();
        for (QLNhanVien qLNhanVien : listql) {
            System.out.println(qLNhanVien.toString());
        }
    }

    @Override
    public boolean save(QLNhanVien qlnv) {
        qlnv.setId(null);
        CuaHang ch = new CuaHang(qlnv.getIdCH().getId());
        ChucVu cv = new ChucVu(qlnv.getIdCV().getId());
        var x = iQLnv.save(new NhanVien(qlnv.getId(), qlnv.getMa(), qlnv.getTen(),
                qlnv.getTenDem(), qlnv.getHo(), qlnv.getGioiTinh(),
                qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSdt(),
                qlnv.getMatKhau(), ch, cv, qlnv.getIdGuiBC(), qlnv.getTrangThai()));

        return x;
    }

    @Override
    public boolean delete(String id) {
        return iQLnv.delete(id);
    }

    @Override
    public boolean Update(QLNhanVien qlnv) {
        CuaHang ch = new CuaHang(qlnv.getIdCH().getId());
        ChucVu cv = new ChucVu(qlnv.getIdCV().getId());
        var x = iQLnv.update(new NhanVien(qlnv.getId(), qlnv.getMa(), qlnv.getTen(),
                qlnv.getTenDem(), qlnv.getHo(), qlnv.getGioiTinh(),
                qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSdt(),
                qlnv.getMatKhau(), ch, cv, qlnv.getIdGuiBC(), qlnv.getTrangThai()));

        return x;
    }

    @Override
    public boolean checkTonTai(String tk) {
        return iQLnv.checkTonTai(tk);
    }

    @Override
    public QLNhanVien getone(QLNhanVien qlnv) {
        var x = iQLnv.getone(new NhanVien(qlnv.getId()));
        QLCuaHang qlch = new QLCuaHang(x.getIdCH().getId());
        QLChucVu qlcv = new QLChucVu(x.getIdCV().getId());
        return new QLNhanVien(x.getId(), x.getMa(), x.getTen(),
                x.getTenDem(), x.getHo(), x.getGioiTinh(), x.getNgaySinh(),
                 x.getDiaChi(), x.getSdt(), x.getMatKhau(), qlch,
                qlcv, x.getIdGuiBC(), x.getTrangThai());
    }
}
