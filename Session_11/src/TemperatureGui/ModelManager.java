package TemperatureGui;

public class ModelManager implements Model
{
 private TemperatureList temperatureList;
 public ModelManager()
 {
 temperatureList = new TemperatureList();
 }

 @Override
 public void addTemperature(int value)
 {
 Temperature temperature = new Temperature(value);
 this.temperatureList.addTemperature(temperature);
 }

 @Override
 public Temperature getLastInsertedTemperature()
 {
 return temperatureList.getTemperature(0);
 }

 public TemperatureList getAllTemperatures()
 {
 return temperatureList;
 }

 // and maybe other methods...(but not relevant for this system)
}