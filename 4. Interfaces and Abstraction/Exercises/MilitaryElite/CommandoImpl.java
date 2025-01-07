package InterfacesAndAbstraction.Exercises.MilitaryElite;

import java.util.*;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando
{
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corps)
    {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public void completeMission()
    {
        for(Mission mission : missions)
        {
            mission.setState();
        }
    }

    @Override
    public void addMission(Mission mission)
    {
        missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions()
    {
        return missions;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Missions:");

        for(Mission mission: missions)
        {
            output.append(System.lineSeparator()).append("  ").append(mission.toString());
        }

        return output.toString();
    }
}
