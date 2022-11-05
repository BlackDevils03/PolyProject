/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLGioHangChiTiet;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLGioHangChiTietService {
    List<QLGioHangChiTiet> getALL();
    boolean save(QLGioHangChiTiet qlghct);
    boolean update(QLGioHangChiTiet qlghct);
    boolean delete(QLGioHangChiTiet qlghct);
    
}
