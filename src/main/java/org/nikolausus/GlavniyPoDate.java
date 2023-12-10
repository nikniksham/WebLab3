package org.nikolausus;

import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


@ManagedBean(name = "glavniy", eager = true)
@ApplicationScoped
@Getter
@Setter
public class GlavniyPoDate {
    @EJB
    private ResOfHitDaoImpl resOfHitDao;
    @ManagedProperty(value="#{hranitel}")
    private Hranitel hranitel;

    public void updateData() {
        List<ResOfHitEntity> data = resOfHitDao.getAllResOfHit();
        Collections.reverse(data);
        hranitel.setData(data);
        StringBuilder stb = new StringBuilder();
        for (Iterator<ResOfHitEntity> it = data.iterator(); it.hasNext();) {
            ResOfHitEntity resOfHit = (ResOfHitEntity) it.next();
            stb.append(resOfHit.getX() + " " + resOfHit.getY() + " " + resOfHit.getR() + " " + resOfHit.isRes() + " " + resOfHit.getEx_at() + " " + resOfHit.getEx_ti());
            if (it.hasNext()) {
                stb.append("|");
            }
        }
        hranitel.setDataString(stb.toString());
        System.out.println(hranitel.getData().size());
        System.out.println(hranitel.getDataString());
    }

    public void clearData() {
        resOfHitDao.deleteAllResOfHit();
        this.updateData();
    }

    public void addNewData() {
        long scriptStartTime = System.nanoTime();
        ResOfHitEntity resOfHit = new ResOfHitEntity();
        float x = hranitel.getX(), y = hranitel.getY(), r = hranitel.getR();
        resOfHit.setX(x);
        resOfHit.setY(y);
        resOfHit.setR(r);
        resOfHit.setRes((x <= 0 && y >= 0 && (x * x + y * y) <= r / 2 * r / 2) || (x >= 0 && y >= 0 && x <= r / 2 && y <= r) || (x >= 0 && y <= 0 && r >= x - y));
        resOfHit.setEx_at(new Timestamp(new java.util.Date().getTime()));
        resOfHit.setEx_ti((int) (System.nanoTime() - scriptStartTime));

        resOfHitDao.saveResOfHit(resOfHit);

        this.updateData();
    }

}
