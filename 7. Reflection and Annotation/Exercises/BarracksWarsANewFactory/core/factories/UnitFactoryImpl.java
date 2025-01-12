package Reflection.Exercises.BarracksWarsANewFactory.core.factories;

import Reflection.Exercises.BarracksWarsANewFactory.interfaces.UnitFactory;
import Reflection.Exercises.BarracksWarsANewFactory.interfaces.Unit;

public class UnitFactoryImpl implements UnitFactory
{
	private static final String UNITS_PACKAGE_NAME = "Reflection.Exercises.BarracksWarsANewFactory.models.units.";

	@Override
	public Unit createUnit(String unitType)
	{
		try
		{
			Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			return (Unit) unitClass.getDeclaredConstructor().newInstance();
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException("Invalid unit type: " + unitType, e);
		}
	}
}
