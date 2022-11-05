/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLSanPham {
    List<SanPham> getall();
    boolean save(SanPham sp);
    boolean update(SanPham sp);
    boolean remove(String id);
    SanPham findOne(String ma);
}
