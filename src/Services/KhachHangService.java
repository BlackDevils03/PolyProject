/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import Repositories.IQlKhachHang;
import Repositories.KhachHangRepository;
import ViewModels.QLKhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class KhachHangService implements IQLKhachHangService {

    private IQlKhachHang iqkh = new KhachHangRepository();

    @Override
    public List<QLKhachHang> getall() {
        List<QLKhachHang> listkh = new ArrayList<>();
        var x = iqkh.getall();
        for (KhachHang kh : x) {
            listkh.add(new QLKhachHang(kh.getId(), kh.getTen(), kh.getTenDem(), kh.getTenDem(),
                    kh.getHo(), kh.getNgaySinh(), kh.getSdt(), kh.getDiaChi(),
                    kh.getThanhPho(), kh.getQuocGia(), kh.getMatKhau()));
        }
        return listkh;
    }

    @Override
    public boolean save(QLKhachHang qlkh) {
        qlkh.setId(null);
        return iqkh.add(new KhachHang(qlkh.getId(), qlkh.getMa(), qlkh.getTen(), qlkh.getTenDem(), qlkh.getHo(),
                qlkh.getNgaySinh(), qlkh.getSdt(), qlkh.getDiaChi(), qlkh.getThanhPho(), qlkh.getQuocGia(), qlkh.getMatKhau()));
    }

    @Override
    public boolean update(QLKhachHang qlkh) {
        return iqkh.update(new KhachHang(qlkh.getId(), qlkh.getMa(), qlkh.getTen(), qlkh.getTenDem(), qlkh.getHo(),
                qlkh.getNgaySinh(), qlkh.getSdt(), qlkh.getDiaChi(), qlkh.getThanhPho(), qlkh.getQuocGia(), qlkh.getMatKhau()));
    }

    @Override
    public boolean delete(QLKhachHang qlkh) {
        return iqkh.delete(new KhachHang(qlkh.getId()));
    }

    @Override
    public QLKhachHang getone(QLKhachHang qlkh) {
        var kh = iqkh.getone(new KhachHang(qlkh.getId()));
        return new QLKhachHang(kh.getId(), kh.getTen(), kh.getTenDem(), kh.getTenDem(),
                kh.getHo(), kh.getNgaySinh(), kh.getSdt(), kh.getDiaChi(),
                kh.getThanhPho(), kh.getQuocGia(), kh.getMatKhau());

    }

    @Override
    public String Check(String s) {
        return iqkh.Check(s);
    }

}
