package org.nikolausus;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIPanel;
import java.util.List;


@ManagedBean(name = "hranitel", eager = true)
@ApplicationScoped
@Getter
@Setter
public class Hranitel {
    private List<ResOfHitEntity> data = null;
    private String dataString = "";
    private float x;
    private float y;
    private float r = 1;
}
