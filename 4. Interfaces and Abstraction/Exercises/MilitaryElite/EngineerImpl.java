package InterfacesAndAbstraction.Exercises.MilitaryElite;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer
{
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corps)
    {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair)
    {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs()
    {
        return repairs;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Repairs:");

        for(Repair repair : repairs)
        {
            output.append(System.lineSeparator()).append("  ").append(repair.toString());
        }

        return output.toString();
    }
}