package org.nikolausus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
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

    public void deleteResOfHit() {
        for (Iterator<ResOfHitEntity> it = this.getListResOfHitEntity().iterator(); it.hasNext();) {
            ResOfHitEntity resOfHit = (ResOfHitEntity) it.next();
            entityManager.remove(resOfHit);
        }
    }

}