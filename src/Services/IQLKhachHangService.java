/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLKhachHang;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLKhachHangService {
    List<QLKhachHang> getall();
    boolean save(QLKhachHang qlkh);
    boolean update(QLKhachHang qlkh);
    boolean delete(QLKhachHang qlkh);
    QLKhachHang getone(QLKhachHang qlkh);
    String Check(String s);
}
