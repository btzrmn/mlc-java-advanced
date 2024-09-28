package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {
    private static final int TARGET_EXP = 10;
    private static final String HERO_NAME = "luna";

    @Test
    public void attackGainsExperienceIfTargetIsDeath() {
//        Target fakeTarget = new Target() {
//            public int getHealth() {
//                return 0;
//            }
//            public void takeAttack(int attackPoints) {
//            }
//            public int giveExperience() {
//                return TARGET_EXP;
//            }
//            public boolean isDead() {
//                return true;
//            }
//        };
//
//        Weapon fakeWeapon = new Weapon() {
//            public int getAttackPoints() {
//                return 10;
//            }
//            public int getDurabilityPoints() {
//                return 0;
//            }
//            public void attack(Target target) {
//            }
//        };
//        Hero hero = new Hero(HERO_NAME, fakeWeapon);
//        hero.attack(fakeTarget);
//        Assert.assertEquals("wrong experience", TARGET_EXP,hero.getExperience());

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EXP);
        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);

        Assert.assertEquals("Wrong experience", TARGET_EXP,
                hero.getExperience());

    }
}
