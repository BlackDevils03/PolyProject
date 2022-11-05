/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import Repositories.ChucVuRepository;
import Repositories.IQLChucVu;
import ViewModels.QLChucVu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class ChucVuService implements IQLChucVuService {

    private IQLChucVu iqlcv = new ChucVuRepository();

    @Override
    public String getone(String ten) {
        return iqlcv.getone(ten);
    }

    @Override
    public List<QLChucVu> getall() {
        List<QLChucVu> listQLCV = new ArrayList<>();
        var x = iqlcv.getAll();
        for (ChucVu chucVu : x) {
            listQLCV.add(new QLChucVu(chucVu.getId(), chucVu.getMa(), chucVu.getTen()));
        }
        return listQLCV;
    }

    public String checkCV(String ma) {
        return iqlcv.checkCV(ma);
    }

    public static void main(String[] args) {
        System.out.println(new ChucVuService().checkCV("sfsdfsd"));
    }

    @Override
    public boolean add(QLChucVu qlcv) {
        qlcv.setId(null);
        return iqlcv.add(new ChucVu(qlcv.getId(), qlcv.getMa(), qlcv.getTen()));
    }

    @Override
    public boolean delete(String id) {
        return iqlcv.delete(id);
    }

    @Override
    public boolean update(QLChucVu qlcv) {
         return iqlcv.update(new ChucVu(qlcv.getId(), qlcv.getMa(), qlcv.getTen()));
    }
}
