package InterfacesAndAbstraction.Exercises.MilitaryElite;

import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral
{
    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary)
    {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((first, second) -> second.getId() - first.getId());
    }

    @Override
    public void addPrivate(Private priv)
    {
        privates.add(priv);
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Privates:");

        for(Private priv : privates)
        {
            output.append(System.lineSeparator()).append("  ").append(priv);
        }

        return output.toString();
    }
}
