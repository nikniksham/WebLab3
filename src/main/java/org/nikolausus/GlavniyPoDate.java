package org.nikolausus;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;


@ManagedBean(name = "glavniy", eager = true)
@ApplicationScoped
public class GlavniyPoDate {
    @EJB
    UpravBob upravBob;
    String test = "TASGSADG SAF AS";
    List<ResOfHitEntity> data = null;
    UIPanel resultsPanel;

    float x;
    float y;
    float r;

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
        this.updData();
        test = "!!!!!!!!!";
    }

    public void addNewData() {
        ResOfHitEntity resOfHit = new ResOfHitEntity();
        resOfHit.setX(this.x);
        resOfHit.setY(this.y);
        resOfHit.setR(this.r);
        resOfHit.setRes(true);
        resOfHit.setEx_at(new Timestamp(new java.util.Date().getTime()));
        resOfHit.setEx_ti(6);

        upravBob.saveResOfHit(resOfHit);

        this.updData();
    }

    private void updData() {
        this.data = upravBob.getListResOfHitEntity();
        Collections.reverse(data);
    }

}
