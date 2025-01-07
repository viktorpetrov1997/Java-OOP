package InterfacesAndAbstraction.Exercises.CollectionHierarchy;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] addElements = scanner.nextLine().split(" ");
        int removeOperations = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();

        StringBuilder addCollectionResult = new StringBuilder();
        StringBuilder addRemoveCollectionResult = new StringBuilder();
        StringBuilder myListImplResult = new StringBuilder();

        for(String element : addElements)
        {
            addCollectionResult.append(addCollection.add(element)).append(" ");
            addRemoveCollectionResult.append(addRemoveCollection.add(element)).append(" ");
            myListImplResult.append(myListImpl.add(element)).append(" ");
        }

        StringBuilder addRemoveCollectionRemoveResult = new StringBuilder();
        StringBuilder myListImplRemoveResult = new StringBuilder();

        for(int i = 0; i < removeOperations; i++)
        {
            addRemoveCollectionRemoveResult.append(addRemoveCollection.remove()).append(" ");
            myListImplRemoveResult.append(myListImpl.remove()).append(" ");
        }

        System.out.println(addCollectionResult);
        System.out.println(addRemoveCollectionResult);
        System.out.println(myListImplResult);
        System.out.println(addRemoveCollectionRemoveResult);
        System.out.println(myListImplRemoveResult);
    }
}
