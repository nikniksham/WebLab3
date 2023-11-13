package org.nikolausus;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;


@ManagedBean(name = "glavniy", eager = true)
@ApplicationScoped
public class GlavniyPoDate {
    String test = "TASGSADG SAF AS";
    List<ResOfHitEntity> data;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
