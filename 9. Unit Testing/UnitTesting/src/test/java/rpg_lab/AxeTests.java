package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import softuni.Lab.rpg_lab.Axe;
import softuni.Lab.rpg_lab.Dummy;

public class AxeTests
{
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects()
    {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void weaponLosesDurabilityAfterAttack()
    {
        // Arrange: Create a weapon with durability 10 and a dummy with health and durability 10.
        // Axe axe = new Axe(10, 1);
        // Dummy dummy = new Dummy(20, 10);
        // We can set up the objects here as well not just in the initializeTestObjects method

        // Act: Attack the dummy, which should reduce the weapon's durability by 1.
        axe.attack(dummy);

        // Assert: Verify that the weapon's durability has decreased to 0.
        Assert.assertEquals(0, axe.getDurabilityPoints());

        // Assert.assertEquals("Durability did not decrease correctly after attack", EXPECTED_DURABILITY, axe.getDurabilityPoints());
        // Throw error message if durability is wrong

        // Assert.assertTrue(axe.getDurabilityPoints() == 0);
        // Another way of checking the value of durability
    }

    @Test(expected = IllegalStateException.class)
    public void shouldReturnExceptionWhenAttackingWithABrokenWeapon()
    {
        // Arrange: Create a weapon with only 1 durability point
        // Axe axe = new Axe(10, 1);
        // Dummy dummy = new Dummy(20, 10);

        // Act: Attack until durability is depleted
        axe.attack(dummy);
        axe.attack(dummy); // Expect IllegalStateException
    }
}
