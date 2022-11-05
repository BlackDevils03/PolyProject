/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLHoaDon {
    List<HoaDon> getALL();
    boolean save(HoaDon hd);
    boolean update(HoaDon hd);
    boolean delete (HoaDon hd);
    List<HoaDon> getOne(HoaDon hd);
}
