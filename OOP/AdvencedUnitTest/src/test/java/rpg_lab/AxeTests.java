package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTests {

    @Test
    public void weaponAttacksLosesDurability() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);
        axe.attack(dummy);
//        Assert.assertTrue(axe.getDurabilityPoints() == 9);
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        // Arrange
        Axe axe = new Axe(10, 1);
        Dummy dummy = new Dummy(10, 10);
        // Act
        axe.attack(dummy);
        axe.attack(dummy);
    }
}
