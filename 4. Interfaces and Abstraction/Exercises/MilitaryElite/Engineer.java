package InterfacesAndAbstraction.Exercises.MilitaryElite;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier
{
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
