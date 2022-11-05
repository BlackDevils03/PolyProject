/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLCuaHang;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLCuaHangService {
    String getone(String ten);
    List<QLCuaHang> getALL();
    boolean save(QLCuaHang qlch);
    boolean update(QLCuaHang qlch);
    boolean remove(String id);
}
