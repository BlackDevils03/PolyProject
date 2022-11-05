/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChucVu;
import ViewModels.QLChucVu;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLChucVuService {
    String getone(String ten);
    List<QLChucVu> getall();
    String checkCV(String ma);
    boolean add(QLChucVu qlcv);
    boolean delete(String id);
    boolean update(QLChucVu qlcv);
}
