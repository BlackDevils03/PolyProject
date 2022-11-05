/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import Repositories.IQLSanPham;
import Repositories.SanPhamRepository;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class SanPhamService implements IQLSanPhamService {

    private IQLSanPham iqlsp = new SanPhamRepository();

    @Override
    public QLSanPham getone(String ma) {
        var x = iqlsp.findOne(ma);
        return new QLSanPham(x.getId(), x.getMa(), x.getTen());
    }
    public boolean save(QLSanPham qlsp ){
        SanPham sp = new SanPham(qlsp.getId(), qlsp.getMa(), qlsp.getTen());
       return iqlsp.save(sp);
    }
    public List<QLSanPham> getall(){
        var x = iqlsp.getall();
        List<QLSanPham> listRt = new ArrayList<>();
        for (SanPham sanPham : x) {
         listRt.add(new QLSanPham(sanPham.getId(), sanPham.getMa(), sanPham.getTen()));
        }
        return listRt;
    }
    public boolean remove(String ma){
        return iqlsp.remove(ma);
    }

    @Override
    public boolean update(QLSanPham qlsp) {
         SanPham sp = new SanPham(qlsp.getId(), qlsp.getMa(), qlsp.getTen());
         return iqlsp.update(sp);
    }
}
