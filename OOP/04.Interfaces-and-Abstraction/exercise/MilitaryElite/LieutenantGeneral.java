package oop04.exercise.MilitaryElite;

import java.util.Collection;

public interface LieutenantGeneral extends Private {
    Collection<Soldier> getPrivates();

    void addPrivate(Soldier priv);
}
