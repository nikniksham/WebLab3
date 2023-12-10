package org.nikolausus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;


@Stateless
public class ResOfHitDaoImpl implements ResOfHitDao {
    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;


    @Override
    public List<ResOfHitEntity> getAllResOfHit() {
        return entityManager.createQuery("from ResOfHitEntity").getResultList();
    }

    @Override
    public void saveResOfHit(ResOfHitEntity resOfHit) {
        entityManager.persist(resOfHit);
    }

    @Override
    public void deleteAllResOfHit() {
        for (Iterator<ResOfHitEntity> it = this.getAllResOfHit().iterator(); it.hasNext();) {
            ResOfHitEntity resOfHit = (ResOfHitEntity) it.next();
            entityManager.remove(resOfHit);
        }
    }
}