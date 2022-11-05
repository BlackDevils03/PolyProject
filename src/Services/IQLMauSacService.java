/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLMauSac;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLMauSacService {
    List<QLMauSac> getall();
    QLMauSac finone(String ma);
}
