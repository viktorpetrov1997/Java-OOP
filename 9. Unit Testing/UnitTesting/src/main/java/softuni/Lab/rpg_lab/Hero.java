package softuni.Lab.rpg_lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hero
{
    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    public Hero(String name, Weapon weapon)
    {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.inventory = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public int getExperience()
    {
        return this.experience;
    }

    public Weapon getWeapon()
    {
        return this.weapon;
    }

    public Iterable<Weapon> getInventory()
    {
        return Collections.unmodifiableList(inventory);
    }

    public void attack(Target target)
    {
        this.weapon.attack(target);

        if(target.isDead())
        {
            this.experience += target.giveExperience();
            Weapon loot = target.dropLoot();
            if(loot != null)
            {
                this.inventory.add(loot);
            }
        }
    }
}
