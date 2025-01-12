package Reflection.Exercises.BarracksWarsANewFactory;

import Reflection.Exercises.BarracksWarsANewFactory.core.Engine;
import Reflection.Exercises.BarracksWarsANewFactory.core.factories.UnitFactoryImpl;
import Reflection.Exercises.BarracksWarsANewFactory.data.UnitRepository;
import Reflection.Exercises.BarracksWarsANewFactory.interfaces.Repository;
import Reflection.Exercises.BarracksWarsANewFactory.interfaces.UnitFactory;

public class Main
{
    public static void main(String[] args)
    {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
