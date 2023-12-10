package org.nikolausus;
import java.util.List;

public interface ResOfHitDao {

    public List<ResOfHitEntity> getAllResOfHit();

    public void saveResOfHit(ResOfHitEntity resOfHit);

    public void deleteAllResOfHit();

}