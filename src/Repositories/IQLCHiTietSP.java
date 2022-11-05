/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.ChITietSP;
import java.util.List;

/**
 *
 * @author congh
 */
public interface IQLCHiTietSP {
    List<ChITietSP> GetAll();
    int save(ChITietSP ctsp);
    int update(ChITietSP ctsp);
    int remove(String ma);
    ChITietSP getone(ChITietSP ctsp);
}
