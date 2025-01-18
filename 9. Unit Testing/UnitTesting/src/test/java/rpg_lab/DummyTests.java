package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import softuni.Lab.rpg_lab.Dummy;

public class DummyTests
{
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 5;

    private Dummy dummy;

    @Before
    public void setUpDummy()
    {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthAfterAttack()
    {
        // Act
        dummy.takeAttack(ATTACK_POINTS);

        // Assert
        Assert.assertEquals("Dummy health should decrease after being attacked", DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowAnExceptionIfDeadDummyIsAttacked()
    {
        // Act
        dummy.takeAttack(DUMMY_HEALTH); // Dummy is now dead
        dummy.takeAttack(ATTACK_POINTS); // Attempting a second attack should throw an exception
    }

    @Test
    public void deadDummyCanGiveExperience()
    {
        // Arrange
        Dummy deadDummy = new Dummy(0, DUMMY_EXPERIENCE);

        // Act
        int experience = deadDummy.giveExperience();

        // Assert
        Assert.assertEquals("Dead dummy should give correct experience points", DUMMY_EXPERIENCE, experience);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCannotGiveExperience()
    {
        // Act
        dummy.giveExperience(); // Alive dummy should throw an exception when asked for experience
    }
}
