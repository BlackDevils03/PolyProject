/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChITietSP;
import java.util.List;
import ViewModels.QLChiTietSP;

/**
 *
 * @author congh
 */
public interface IQLChiTietSPService {

    List<QLChiTietSP> GetAll();

    int save(QLChiTietSP ctsp);

    int update(QLChiTietSP ctsp);

    int remove(String ma);

    QLChiTietSP getone(QLChiTietSP ctsp);
}
