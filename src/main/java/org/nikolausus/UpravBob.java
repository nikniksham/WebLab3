package org.nikolausus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class UpravBob {
    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;

    public void saveResOfHit(ResOfHitEntity resOfHit){
        entityManager.persist(resOfHit);
    }

    public List<ResOfHitEntity> getListResOfHitEntity() {
        return entityManager.createQuery("from ResOfHitEntity").getResultList();
    }

}