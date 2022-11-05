/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.QLNSX;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLNSXService {
    List<QLNSX> getALL ();
    QLNSX finone(String ma);
    boolean save(QLNSX qlnsx);
    boolean delete(QLNSX qlnsx);
    
}
