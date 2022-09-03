package esobchak.school21.flyable;

import esobchak.school21.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    String prefix();
}
