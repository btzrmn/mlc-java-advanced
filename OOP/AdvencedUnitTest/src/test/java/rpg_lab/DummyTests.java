package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTests {
    private static final int EXP = 10;
    private static final int HEALTH = 10;
    private static final int DEATH_HEALTH = 0;
    private static final int ATTACK_MID = 4;
    private static final int ATTACK_HIGH = 10;
    private static final int ATTACK_AFTER_HEALTH = 6;
    private Dummy dummy;
    private Dummy dummyDeath;

    @Before
    public void createDummy() {
        dummy = new Dummy(HEALTH, EXP);
        dummyDeath = new Dummy(DEATH_HEALTH, EXP);
    }

    @Test
    public void attackedTargetLoosesHealth() {
        // Act
        dummy.takeAttack(ATTACK_MID);
        // Assert
        Assert.assertEquals(ATTACK_AFTER_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void attackedTargetDeath() {
        // Act
        dummyDeath.takeAttack(ATTACK_HIGH);
    }

    @Test
    public void giveExperienceDeath() {
        // Act
        Assert.assertEquals("wrong exp", EXP, dummyDeath.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void giveExperienceUndeath() {
        dummy.giveExperience();
    }
}
