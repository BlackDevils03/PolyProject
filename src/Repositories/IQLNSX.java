/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLNSX {
    List<NSX> getALL ();
    NSX finone(String ma);
    boolean save(NSX nsx );
    boolean delete(NSX nsx);
}
