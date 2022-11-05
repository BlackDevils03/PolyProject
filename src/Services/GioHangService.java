/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.GioHang;
import Repositories.GioHangRepository;
import Repositories.IQLGioHang;
import ViewModels.QLGioHang;
import ViewModels.QLHoaDon;
import ViewModels.QLKhachHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class GioHangService implements IQLGioHangService{
    IQLGioHang iqlgh = new GioHangRepository();
    @Override
    public List<QLGioHang> getALL() {
        List<QLGioHang> listgh = new ArrayList<>();
        var x = iqlgh.getALL();
        for (GioHang gh : x) {
            QLKhachHang qlkh = new QLKhachHang(gh.getIdKH().getId());
            QLNhanVien qlnv = new QLNhanVien(gh.getIdNV().getId());
            listgh.add(new QLGioHang(gh.getId(), qlkh, qlnv, gh.getMa(), gh.getNgayTao(), gh.getNgayThanhToan(),gh.getTinhTrang(), gh.getTenNguoiNhan(), gh.getDiaChi(), gh.getSdt()));
        }
        return listgh;
    }
    
}
