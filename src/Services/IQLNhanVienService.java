/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLNhanVien;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLNhanVienService {
    List<QLNhanVien> getAll();
    boolean checkMa(String tl,String mk);
    boolean save(QLNhanVien qlnv);
    boolean delete(String id);
    boolean Update(QLNhanVien qlnv);
    boolean checkTonTai(String tk);
    QLNhanVien getone(QLNhanVien qlnv);
}
