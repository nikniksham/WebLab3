package org.nikolausus;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


@ManagedBean(name = "glavniy", eager = true)
@ApplicationScoped
public class GlavniyPoDate {
    @EJB
    UpravBob upravBob;
    String test = "TASGSADG SAF AS";
    List<ResOfHitEntity> data = null;
    String dataString = "";

    UIPanel resultsPanel;

    float x;
    float y;
    float r = 1;

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public List<ResOfHitEntity> getData() {
        return data;
    }

    public void setData(List<ResOfHitEntity> data) {
        this.data = data;
    }

    public UIPanel getResultsPanel() {
        return resultsPanel;
    }

    public void setResultsPanel(UIPanel resultPanel) {
        this.resultsPanel = resultPanel;
    }

    public void updateData() {
        this.data = upravBob.getListResOfHitEntity();
        Collections.reverse(data);
        StringBuilder stb = new StringBuilder();
        for (Iterator<ResOfHitEntity> it = data.iterator(); it.hasNext();) {
            ResOfHitEntity resOfHit = (ResOfHitEntity) it.next();
            stb.append(resOfHit.getX() + " " + resOfHit.getY() + " " + resOfHit.getR() + " " + resOfHit.isRes() + " " + resOfHit.getEx_at() + " " + resOfHit.getEx_ti());
            if (it.hasNext()) {
                stb.append("|");
            }
        }
        dataString = stb.toString();
    }

    public void clearData() {
        upravBob.deleteResOfHit();
        this.updateData();
    }

    public void addNewData() {
        long scriptStartTime = System.nanoTime();
        ResOfHitEntity resOfHit = new ResOfHitEntity();
        resOfHit.setX(this.x);
        resOfHit.setY(this.y);
        resOfHit.setR(this.r);
        resOfHit.setRes((x <= 0 && y >= 0 && (x * x + y * y) <= r / 2 * r / 2) || (x >= 0 && y >= 0 && x <= r / 2 && y <= r) || (x >= 0 && y <= 0 && r >= x - y));
        resOfHit.setEx_at(new Timestamp(new java.util.Date().getTime()));
        resOfHit.setEx_ti((int) (System.nanoTime() - scriptStartTime));

        upravBob.saveResOfHit(resOfHit);

        this.updateData();
    }

}
