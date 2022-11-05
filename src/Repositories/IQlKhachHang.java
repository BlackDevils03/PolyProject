/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQlKhachHang {
    List<KhachHang> getall();
    boolean add(KhachHang kh);
    boolean update(KhachHang kh);
    boolean delete(KhachHang kh);
    KhachHang getone(KhachHang kh);
    String Check(String s);
    
}
