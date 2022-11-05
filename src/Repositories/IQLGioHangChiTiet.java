/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.GioHangChiTiet;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLGioHangChiTiet {
    List<GioHangChiTiet> getALL();
    boolean save(GioHangChiTiet ghct);
    boolean update(GioHangChiTiet ghct);
    boolean delete(GioHangChiTiet ghct);
    GioHangChiTiet getone(GioHangChiTiet ghct);
}
