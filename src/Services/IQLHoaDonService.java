/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLHoaDon;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLHoaDonService {
    List<QLHoaDon> getALL();
    boolean save(QLHoaDon qlhd);
    boolean update(QLHoaDon qlhd);
    boolean delete(QLHoaDon qlhd);
    boolean getone(QLHoaDon qlhd);
}
