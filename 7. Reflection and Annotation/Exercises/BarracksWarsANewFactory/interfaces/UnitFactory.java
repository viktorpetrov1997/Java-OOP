package Reflection.Exercises.BarracksWarsANewFactory.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory
{
    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}