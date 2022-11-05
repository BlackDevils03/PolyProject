/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChITietSP;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Repositories.ChiTietSPRepository;
import Repositories.IQLCHiTietSP;
import ViewModels.QLChiTietSP;
import ViewModels.QLDongSP;
import ViewModels.QLMauSac;
import ViewModels.QLNSX;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class ChiTietSPService implements IQLChiTietSPService {

    private IQLCHiTietSP iqlchtsp = new ChiTietSPRepository();

    @Override
    public List<QLChiTietSP> GetAll() {
        var x = iqlchtsp.GetAll();
        List<QLChiTietSP> listQLCT = new ArrayList<>();
        for (ChITietSP ctp : x) {
            QLSanPham qlsp = new QLSanPham(ctp.getIdSp().getId());
            QLNSX qlnsx = new QLNSX(ctp.getIdNSX().getId());
            QLMauSac qlms = new QLMauSac(ctp.getIdMauSac().getId());
            QLDongSP qldsp = new QLDongSP(ctp.getIdDongSP().getId());
            listQLCT.add(new QLChiTietSP(ctp.getId(), qlsp, qlnsx, qlms,
                     qldsp, ctp.getNamBH(), ctp.getMoTa(), ctp.getSoLuongTon(), ctp.getGiaNhap(), ctp.getGiaBan()));
        }
        return listQLCT;
    }

    @Override
    public int save(QLChiTietSP ctsp) {
        ctsp.setId(null);
        SanPham sp = new SanPham(ctsp.getIdSp().getId(), null, null);
        NSX nsx = new NSX(ctsp.getIdNSX().getId(), null, null);
        MauSac ms = new MauSac(ctsp.getIdMauSac().getId(), null, null);
        DongSP dsp = new DongSP(ctsp.getIdDongSP().getId(), null, null);
        var x = iqlchtsp.save(new ChITietSP(ctsp.getId(), sp, nsx, ms, dsp,
                 ctsp.getNamBH(), ctsp.getMoTa(), ctsp.getSoLuongTon(), ctsp.getGiaNhap(), ctsp.getGiaBan()));
        return x;
    }

    @Override
    public int update(QLChiTietSP ctsp) {

        SanPham sp = new SanPham(ctsp.getIdSp().getId(), null, null);
        NSX nsx = new NSX(ctsp.getIdNSX().getId(), null, null);
        MauSac ms = new MauSac(ctsp.getIdMauSac().getId(), null, null);
        DongSP dsp = new DongSP(ctsp.getIdDongSP().getId(), null, null);
        var x = iqlchtsp.update(new ChITietSP(ctsp.getId(), sp, nsx, ms, dsp,
                 ctsp.getNamBH(), ctsp.getMoTa(), ctsp.getSoLuongTon(), ctsp.getGiaNhap(), ctsp.getGiaBan()));
        return x;
    }

    @Override
    public int remove(String ma) {
        return iqlchtsp.remove(ma);
    }



    public static void main(String[] args) {
        List<ChITietSP> list = new ChiTietSPRepository().GetAll();
        for (ChITietSP chITietSP : list) {
            System.out.println(chITietSP.toString());
        }
        QLChiTietSP lChiTietSP = new QLChiTietSP("4595FE7C-A418-4B33-A9F3-D5D56E6C53A0");
        System.out.println(new ChiTietSPService().getone(lChiTietSP));
    }

    @Override
    public QLChiTietSP getone(QLChiTietSP ctsp) {
        ChITietSP citsp = new ChITietSP(ctsp.getId());
        var x = iqlchtsp.getone(citsp);
        QLSanPham qlsp = new QLSanPham(x.getIdSp().getId());
        QLNSX qlnsx = new QLNSX(x.getIdNSX().getId());
        QLMauSac qlms = new QLMauSac(x.getIdMauSac().getId());
        QLDongSP qldsp = new QLDongSP(x.getIdDongSP().getId());
        return new QLChiTietSP(x.getId(), qlsp, qlnsx, qlms,
                 qldsp, x.getNamBH(), x.getMoTa(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan());
    }

}
