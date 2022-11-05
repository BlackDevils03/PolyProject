/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.CuaHang;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLCuaHang {
    String getone(String ten);
    List<CuaHang> getall();
    boolean save(CuaHang cv);
    boolean update(CuaHang cv);
    boolean remove(String i);
}
