package esobchak.school21.flyable;

import esobchak.school21.Logger;
import esobchak.school21.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN" -> {
                coordinatesFunc(0, 10, 2);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a jetplane, its sunny.");
            }
            case "RAIN" -> {
                coordinatesFunc(0, 5, 0);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a jetplane, its raining.");
            }
            case "FOG" -> {
                coordinatesFunc(0, 1, 0);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a jetplane, its foggy.");
            }
            case "SNOW" -> {
                coordinatesFunc(0, 0, -7);
                Logger.getLogger().addLoggerLine(prefix() + ": I'm a jetplane, its snowing.");
            }
            default -> Logger.getLogger().addLoggerLine(prefix() + ": I'm a jetplane, weather tower unresponsive");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0){
            this.coordinates.setHeight(0);
            Logger.getLogger().addLoggerLine(prefix() + " landing.");
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public void setType() {
        this.type = "JetPlane";
    }
}
