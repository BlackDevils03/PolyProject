/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import Repositories.IQLMauSac;
import Repositories.MauSacRepository;
import ViewModels.QLMauSac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class MauSacService implements IQLMauSacService{
    private IQLMauSac iqlms = new  MauSacRepository();
    public List<QLMauSac> getall(){
        List<QLMauSac> listms = new ArrayList<>();
        var x = iqlms.getall();
        for (MauSac mauSac : x) {
            listms.add(new QLMauSac(mauSac.getId(), mauSac.getMa(), mauSac.getTen()));
        }
        return listms;
    }

    @Override
    public QLMauSac finone(String ma) {
var x = iqlms.finone(ma);
return new QLMauSac(x.getId(), x.getMa(), x.getTen());
        }
}
