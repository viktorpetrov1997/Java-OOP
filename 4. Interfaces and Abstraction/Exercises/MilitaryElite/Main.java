package InterfacesAndAbstraction.Exercises.MilitaryElite;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, PrivateImpl> soldiers = new TreeMap<>(Comparator.reverseOrder());

        String input = scanner.nextLine();
        while(!input.equals("End"))
        {
            String[] inputData = input.split(" ");

            String typeOfSoldier = inputData[0];
            int id = Integer.parseInt(inputData[1]);
            String firstName = inputData[2];
            String lastName = inputData[3];

            if(typeOfSoldier.equals("Private"))
            {
                double salary = Double.parseDouble(inputData[4]);
                PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                System.out.println(priv);
                soldiers.putIfAbsent(id, priv);
            }
            else if(typeOfSoldier.equals("LieutenantGeneral"))
            {
                double salary = Double.parseDouble(inputData[4]);

                LieutenantGeneralImpl lieutenantGeneral =
                        new LieutenantGeneralImpl(id, firstName, lastName, salary);

                for(Map.Entry<Integer, PrivateImpl> soldier : soldiers.entrySet())
                {
                    for(int i = 5; i < inputData.length; i++)
                    {
                        int newPrivateId = Integer.parseInt(inputData[i]);
                        if(soldier.getKey() == newPrivateId)
                        {
                            lieutenantGeneral.addPrivate(soldier.getValue());
                        }
                    }
                }
                System.out.println(lieutenantGeneral);
            }
            else if(typeOfSoldier.equals("Engineer"))
            {
                double salary = Double.parseDouble(inputData[4]);
                String corps = inputData[5];

                if(corps.equals(Corp.Airforces.toString()) || corps.equals(Corp.Marines.toString()))
                {
                    Corp corp = Corp.valueOf(corps);
                    Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corp);

                    for(int i = 6; i < inputData.length; i += 2)
                    {
                        Repair repair = new Repair(inputData[i], Integer.parseInt(inputData[i + 1]));
                        engineer.addRepair(repair);
                    }

                    System.out.println(engineer);
                }
            }
            else if(typeOfSoldier.equals("Commando"))
            {
                double salary = Double.parseDouble(inputData[4]);
                String corps = inputData[5];

                if(corps.equals(Corp.Airforces.toString()) || corps.equals(Corp.Marines.toString()))
                {
                    Commando commando = new CommandoImpl(id, firstName, lastName, salary, Corp.valueOf(corps));

                    for(int i = 6; i < inputData.length; i += 2)
                    {
                        if(inputData[i + 1].equals(State.inProgress.toString())
                                || inputData[i + 1].equals(State.finished.toString()))
                        {
                            Mission mission = new Mission(inputData[i], State.valueOf(inputData[i + 1]));
                            commando.addMission(mission);
                        }
                    }

                    System.out.println(commando);
                }
            }
            else if(typeOfSoldier.equals("Spy"))
            {
                String codeNumber = inputData[4];
                Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);
                System.out.println(spy);
            }

            input = scanner.nextLine();
        }
    }
}
