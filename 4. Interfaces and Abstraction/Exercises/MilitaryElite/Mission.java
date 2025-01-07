package InterfacesAndAbstraction.Exercises.MilitaryElite;

public class Mission
{
    private String codeName;
    private State state;

    public Mission(String codeName, State state)
    {
        this.codeName = codeName;
        this.state = State.valueOf(state.toString());
    }

    public void setState()
    {
        this.state = State.finished;
    }

    public State getState()
    {
        return state;
    }

    @Override
    public String toString()
    {
        return String.format("Code Name: %s State: %s", codeName, state);
    }
}
