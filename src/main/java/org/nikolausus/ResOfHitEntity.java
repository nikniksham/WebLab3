package org.nikolausus;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "resOfHit")
public class ResOfHitEntity {

    @Id
    @Column(name = "res_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "x")
    private int x;
    @Column(name = "y")
    private int y;
    @Column(name = "r")
    private int r;
    @Column(name = "res")
    private boolean res;
    @Column(name = "ex_at")
    private Timestamp ex_at;
    @Column(name = "ex_ti")
    private int ex_ti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public Timestamp getEx_at() {
        return ex_at;
    }

    public void setEx_at(Timestamp ex_at) {
        this.ex_at = ex_at;
    }

    public int getEx_ti() {
        return ex_ti;
    }

    public void setEx_ti(int ex_ti) {
        this.ex_ti = ex_ti;
    }
}