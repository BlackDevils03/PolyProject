/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLChucVu {
    String getone(String ten);
    List<ChucVu> getAll();
    String checkCV(String ma);
    boolean update(ChucVu cv);
    boolean delete(String id);
    boolean add(ChucVu cv);
}