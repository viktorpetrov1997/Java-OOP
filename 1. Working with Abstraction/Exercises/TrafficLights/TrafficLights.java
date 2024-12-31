package WorkingWithAbstraction.Exercises.TrafficLights;

public class TrafficLights
{
    private Color color;

    public TrafficLights(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void changeColor()
    {
        if(this.color == Color.RED)
        {
            this.color = Color.GREEN;
        }
        else if(this.color == Color.GREEN)
        {
            this.color = Color.YELLOW;
        }
        else if(this.color == Color.YELLOW)
        {
            this.color = Color.RED;
        }
    }
}
