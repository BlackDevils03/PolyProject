/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NSX;
import Repositories.IQLNSX;
import Repositories.NSXRepository;
import ViewModels.QLNSX;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author congh
 */
public class NSXService implements IQLNSXService{
private IQLNSX iqlnsx = new NSXRepository();
    @Override
    public List<QLNSX> getALL() {
        List<QLNSX> list = new ArrayList<>();
        var x = iqlnsx.getALL();
        for (NSX nsx : x) {
            list.add(new QLNSX(nsx.getId(),nsx.getMa(), nsx.getTen()));
        }
        return list;
    }

    @Override
    public QLNSX finone(String ma) {
var x = iqlnsx.finone(ma);
return new QLNSX(x.getId(), x.getMa(), x.getTen());
    }

    @Override
    public boolean save(QLNSX qlnsx) {
        qlnsx.setId(null);
        System.out.println(qlnsx.toString());
        return iqlnsx.save(new NSX(qlnsx.getId(),qlnsx.getMa(), qlnsx.getTen()));
        
    }

    @Override
    public boolean delete(QLNSX qlnsx) {
        return iqlnsx.delete(new NSX(qlnsx.getId()));
    }
    public static void main(String[] args) {
        System.out.println(new NSXService().save(new QLNSX(null, "PO)", "Chiu")));
    }
}
