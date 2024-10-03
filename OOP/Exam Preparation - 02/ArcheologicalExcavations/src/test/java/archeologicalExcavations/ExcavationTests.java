package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private final String DEFAULT_EXCAVATION_NAME = "Pyramid";
    private final int DEFAULT_EXCAVATION_CAPACITY = 3;
    private final String DEFAULT_ARCH_NAME = "John";
    private final double DEFAULT_ARCH_ENERGY = 60d;

    private Excavation excavation;
    private Archaeologist archaeologist;

    @Before
    public void init() {
        excavation = new Excavation(DEFAULT_EXCAVATION_NAME, DEFAULT_EXCAVATION_CAPACITY);
        archaeologist = new Archaeologist(DEFAULT_ARCH_NAME, DEFAULT_ARCH_ENERGY);
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionWhenNameIsEmptyString() {
        Excavation excavation1 = new Excavation("  ", DEFAULT_EXCAVATION_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenNegativeCapacity() {
        Excavation excavation1 = new Excavation(DEFAULT_EXCAVATION_NAME, -1);
    }

    @Test
    public void zeroArchCountWhenNoArchAdded() {
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test
    public void archCountWhenArchAdded() {
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(DEFAULT_EXCAVATION_NAME, excavation.getName());
    }

    @Test
    public void getCapacityTest() {
        Assert.assertEquals(DEFAULT_EXCAVATION_CAPACITY, excavation.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchThrowExceptionWhenExcavationCapacityFull() {
        Archaeologist archaeologist1 = new Archaeologist(DEFAULT_ARCH_NAME + "1", DEFAULT_ARCH_ENERGY);
        Archaeologist archaeologist2 = new Archaeologist(DEFAULT_ARCH_NAME + "2", DEFAULT_ARCH_ENERGY);
        Archaeologist archaeologist3 = new Archaeologist(DEFAULT_ARCH_NAME + "3", DEFAULT_ARCH_ENERGY);
        Archaeologist archaeologist4 = new Archaeologist(DEFAULT_ARCH_NAME + "4", DEFAULT_ARCH_ENERGY);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        excavation.addArchaeologist(archaeologist4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchThrowExceptionWhenNameIsAlreadyExist() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void addArchSuccessful() {
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void removeUserWhenUserExist() {
        excavation.addArchaeologist(archaeologist);
        Assert.assertTrue(excavation.removeArchaeologist(DEFAULT_ARCH_NAME));
    }

    @Test
    public void removeUserWhenUserDoesntExist() {
        Assert.assertFalse(excavation.removeArchaeologist(DEFAULT_ARCH_NAME));
    }
}
