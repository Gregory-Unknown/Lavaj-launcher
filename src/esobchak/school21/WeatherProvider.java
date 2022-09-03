package esobchak.school21;

import esobchak.school21.flyable.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int id = Math.abs(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());
        return weather[id % 4];
    }
}
