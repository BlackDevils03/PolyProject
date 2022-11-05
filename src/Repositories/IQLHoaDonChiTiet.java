/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLHoaDonChiTiet {
    List<HoaDonChiTiet> getALL();
    boolean save(HoaDonChiTiet hdct);
    boolean update(HoaDonChiTiet hdct);
    boolean delete(HoaDonChiTiet hdct);
    HoaDonChiTiet getone(String s);
}
