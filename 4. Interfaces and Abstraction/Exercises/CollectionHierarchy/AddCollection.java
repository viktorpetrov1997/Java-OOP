package InterfacesAndAbstraction.Exercises.CollectionHierarchy;

public class AddCollection extends Collection implements Addable
{
    @Override
    public int add(String item)
    {
        if(items.size() < maxSize)
        {
            items.add(item);
        }
        return items.indexOf(item);
    }
}
