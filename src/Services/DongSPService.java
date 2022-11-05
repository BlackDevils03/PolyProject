/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import Repositories.DongSPRepository;
import Repositories.IQLDongSP;
import ViewModels.QLDongSP;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class DongSPService implements IQLDongSPService {

    private IQLDongSP iqldsp = new DongSPRepository();

    @Override
    public List<QLDongSP> getall() {
        var x = iqldsp.getall();
        List<QLDongSP> listdsp = new ArrayList<>();
        for (DongSP dongSP : x) {
            listdsp.add(new QLDongSP(dongSP.getId(), dongSP.getMa(), dongSP.getTen()));
        }
        return listdsp;
    }

    @Override
    public QLDongSP finone(String ma) {
        var x = iqldsp.finone(ma);
        return new QLDongSP(x.getId(), x.getMa(), x.getTen());
    }

}
