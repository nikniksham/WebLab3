package org.nikolausus;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "resOfHit")
@Getter
@Setter
public class ResOfHitEntity {

    @Id
    @Column(name = "res_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "x")
    private float x;
    @Column(name = "y")
    private float y;
    @Column(name = "r")
    private float r;
    @Column(name = "res")
    private boolean res;
    @Column(name = "ex_at")
    private Timestamp ex_at;
    @Column(name = "ex_ti")
    private int ex_ti;
}