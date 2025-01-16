package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import softuni.rpg_lab.Dummy;

public class DummyTests
{
    @Test
    public void dummyLosesHealthAfterAttack()
    {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(5);

        Assert.assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowAnExceptionIfDeadDummyIsAttacked()
    {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(10);
        dummy.takeAttack(10);
    }

    @Test
    public void deadDummyCanGiveExperience()
    {
        Dummy dummy = new Dummy(0, 10);

        dummy.giveExperience();
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCannotGiveExperience()
    {
        Dummy dummy = new Dummy(10, 10);

        dummy.giveExperience();
    }
}
