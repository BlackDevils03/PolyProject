/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLSanPham;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLSanPhamService {
    QLSanPham getone(String ma);
    boolean save(QLSanPham qlsp );
    List<QLSanPham> getall();
     boolean remove(String ma);
     boolean update(QLSanPham qlsp);
}
