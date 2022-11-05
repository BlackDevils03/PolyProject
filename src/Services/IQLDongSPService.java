/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import ViewModels.QLDongSP;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLDongSPService {
    public List<QLDongSP> getall();
    QLDongSP finone(String ma);
}
