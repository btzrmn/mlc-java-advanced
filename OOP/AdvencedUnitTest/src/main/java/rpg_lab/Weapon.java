package rpg_lab;

public interface Weapon {

    public int getAttackPoints();
    public int getDurabilityPoints();
    public void attack(Target target);
}
