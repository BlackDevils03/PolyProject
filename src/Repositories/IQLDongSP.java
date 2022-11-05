/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.DongSP;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLDongSP {
    public List<DongSP> getall();
    DongSP finone(String ma);
}
