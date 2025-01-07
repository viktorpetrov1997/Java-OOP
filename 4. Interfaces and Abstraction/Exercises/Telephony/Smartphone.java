package InterfacesAndAbstraction.Exercises.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable
{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls)
    {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse()
    {
        StringBuilder output = new StringBuilder();
        for(String url : urls)
        {
            if(url.matches("[^\\d]+"))
            {
                output.append("Browsing: ").append(url).append("!").append("\n");
            }
            else
            {
                output.append("Invalid URL!").append("\n");
            }
        }
        return output.toString();
    }

    @Override
    public String call()
    {
        StringBuilder output = new StringBuilder();
        for(String number : numbers)
        {
            if(number.matches("\\d+"))
            {
                output.append("Calling... ").append(number).append("\n");
            }
            else
            {
                output.append("Invalid number!").append("\n");
            }
        }
        return output.toString();
    }
}
