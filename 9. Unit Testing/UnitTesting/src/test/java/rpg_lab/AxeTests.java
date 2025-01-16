package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import softuni.rpg_lab.Axe;
import softuni.rpg_lab.Dummy;

public class AxeTests
{
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;


    @Test
    public void weaponLosesDurabilityAfterAttack()
    {
        // Arrange: Create a weapon with durability 10 and a dummy with health and durability 10.
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);

        // Act: Attack the dummy, which should reduce the weapon's durability by 1.
        axe.attack(dummy);

        // Assert: Verify that the weapon's durability has decreased to 9.
        Assert.assertEquals(9, axe.getDurabilityPoints());
        // Assert.assertEquals("Wrong value of durability", 8, axe.getDurabilityPoints());
        // Throw error message if durability is wrong

        // Assert.assertTrue(axe.getDurabilityPoints() == 9); Another way of checking the value of durability
    }

    @Test(expected = IllegalStateException.class)
    public void shouldReturnExceptionWhenAttackingWithABrokenWeapon()
    {
        // Arrange: Create a weapon with only 1 durability point
        Axe axe = new Axe(10, 1);
        Dummy dummy = new Dummy(10, 10);

        // Act: Attack until durability is depleted
        axe.attack(dummy);
        axe.attack(dummy); // Expect IllegalStateException
    }
}
