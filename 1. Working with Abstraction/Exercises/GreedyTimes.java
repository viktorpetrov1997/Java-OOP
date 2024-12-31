package WorkingWithAbstraction.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GreedyTimes
{
    private static String getItemType(String itemName)
    {
        if(itemName.equalsIgnoreCase("Gold"))
        {
            return "Gold";
        }
        else if(itemName.length() >= 4 && itemName.toLowerCase().endsWith("gem"))
        {
            return "Gem";
        }
        else if(itemName.length() == 3)
        {
            return "Cash";
        }
        return null;
    }

    private static boolean canAddToBag(String itemType, long quantity, long gold, long gems, long cash,
                                       long bagCapacity, Map<String, LinkedHashMap<String, Long>> bag)
    {
        if(itemType == null) return false;

        long currentTotal = bag.values().stream()
                .flatMap(m -> m.values().stream())
                .mapToLong(e -> e)
                .sum();

        if(currentTotal + quantity > bagCapacity) return false;

        switch(itemType)
        {
            case "Gold":
                return true;
            case "Gem":
                return gems + quantity <= gold;
            case "Cash":
                return cash + quantity <= gems;
            default:
                return false;
        }
    }

    private static void printBagContents(Map<String, LinkedHashMap<String, Long>> bag)
    {
        bag.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue().values().stream().mapToLong(e -> e).sum(),
                        e1.getValue().values().stream().mapToLong(e -> e).sum()))
                .forEach(entry ->
                {
                    String itemType = entry.getKey();
                    LinkedHashMap<String, Long> items = entry.getValue();
                    long totalQuantity = items.values().stream().mapToLong(e -> e).sum();
                    System.out.printf("<%s> $%d%n", itemType, totalQuantity);

                    items.entrySet().stream()
                            .sorted((e1, e2) ->
                            {
                                int nameComparison = e2.getKey().compareTo(e1.getKey());
                                return nameComparison != 0 ? nameComparison : Long.compare(e1.getValue(), e2.getValue());
                            }).forEach(item ->
                            {
                                System.out.printf("##%s - %d%n", item.getKey(), item.getValue());
                            });
                });
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split(" ");

        for(int i = 0; i < items.length; i += 2)
        {
            String itemName = items[i];
            long quantity = Long.parseLong(items[i + 1]);

            String itemType = getItemType(itemName);

            if(!canAddToBag(itemType, quantity, gold, gems, cash, bagCapacity, bag)) continue;

            bag.putIfAbsent(itemType, new LinkedHashMap<>());
            bag.get(itemType).put(itemName, bag.get(itemType).getOrDefault(itemName, 0L) + quantity);

            if(itemType.equals("Gold"))
            {
                gold += quantity;
            }
            else if(itemType.equals("Gem"))
            {
                gems += quantity;
            }
            else if(itemType.equals("Cash"))
            {
                cash += quantity;
            }
        }

        printBagContents(bag);
    }
}
