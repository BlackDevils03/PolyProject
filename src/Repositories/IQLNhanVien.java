/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLNhanVien {

    List<NhanVien> getall();

    boolean checkMa(String mk, String tk);

    boolean save(NhanVien nv);

    boolean update(NhanVien nv);

    boolean delete(String id);

    boolean checkTonTai(String tk);
    
    NhanVien getone(NhanVien nv);
}
