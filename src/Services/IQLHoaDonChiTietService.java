/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLHoaDonChiTiet;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLHoaDonChiTietService {
    List<QLHoaDonChiTiet> getALL();
    boolean save(QLHoaDonChiTiet qlhdct);
    boolean update(QLHoaDonChiTiet qlhdct);
    boolean delete(QLHoaDonChiTiet qlhdct);
    QLHoaDonChiTiet getone(String s);
}
