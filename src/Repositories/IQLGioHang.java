/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.GioHang;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLGioHang {
    List<GioHang> getALL();
    boolean save(GioHang gh);
    boolean update(GioHang gh);
    boolean remove(GioHang gh);
    List<GioHang> getone(GioHang gh);
}
