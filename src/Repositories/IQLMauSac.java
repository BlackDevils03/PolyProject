/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLMauSac {
    public List<MauSac> getall();
    MauSac finone(String ma);
}
