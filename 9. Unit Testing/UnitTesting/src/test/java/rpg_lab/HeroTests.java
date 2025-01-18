package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import softuni.Lab.rpg_lab.Hero;
import softuni.Lab.rpg_lab.Target;
import softuni.Lab.rpg_lab.Weapon;

import java.util.List;

public class HeroTests
{
    private static final String HERO_NAME = "Hero";
    private static final int TARGET_XP = 10;

    @Test
    public void heroGainsExperienceIfTargetDies()
    {
        Target fakeTarget = new Target()
        {
            @Override
            public void takeAttack(int attackPoints) { }

            @Override
            public int getHealth() { return 0; }

            @Override
            public int giveExperience() { return TARGET_XP; }

            @Override
            public boolean isDead() { return true; }

            @Override
            public Weapon dropLoot() { return null; }
        };

        Weapon fakeWeapon = new Weapon()
        {
            @Override
            public void attack(Target target) { }

            @Override
            public int getAttackPoints() { return 10; }

            @Override
            public int getDurabilityPoints() { return 0; }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Hero did not gain the correct amount of XP", TARGET_XP, hero.getExperience());
    }

    @Test
    public void heroReceivesLootWhenTargetDies()
    {
        // Arrange
        Weapon mockWeapon = Mockito.mock(Weapon.class);
        Target mockTarget = Mockito.mock(Target.class);
        Weapon lootWeapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero(HERO_NAME, mockWeapon);

        Mockito.when(mockTarget.isDead()).thenReturn(true);
        Mockito.when(mockTarget.giveExperience()).thenReturn(10);
        Mockito.when(mockTarget.dropLoot()).thenReturn(lootWeapon);

        // Act
        hero.attack(mockTarget);

        // Assert
        Assert.assertTrue("Hero inventory should contain the dropped loot weapon",
                ((List<Weapon>) hero.getInventory()).contains(lootWeapon));
    }

    /*
    * Alternative test method for checking if the hero receives loot when the target dies:

    @Test
    public void heroReceivesLootWhenTargetDies()
    {
        // Arrange
        Weapon weapon = new Axe(10, 10);
        Hero hero = new Hero(HERO_NAME, weapon);

        // Create a dummy with health, experience, and possible loot
        Dummy dummy = new Dummy(10, 10); // Health is 10 to ensure it goes to down to 0 and the dummy dies after being hit
        dummy.addLoot(new Axe(5, 5)); // Add loot to the dummy

        // Act
        hero.attack(dummy);

        // Assert
        Weapon expectedLoot = dummy.dropLoot();
        Assert.assertTrue("Hero inventory should contain the dropped loot weapon",
                ((List<Weapon>) hero.getInventory()).contains(expectedLoot));
    }
    */
}
