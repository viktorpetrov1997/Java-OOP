package softuni.Lab.rpg_lab;

public interface Weapon
{
    void attack(Target target);
    int getAttackPoints();
    int getDurabilityPoints();
}
