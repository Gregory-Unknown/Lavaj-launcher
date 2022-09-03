package esobchak.school21;

import esobchak.school21.flyable.AircraftFactory;
import esobchak.school21.flyable.Flyable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ParseFile {
    private final WeatherTower weatherTower = new WeatherTower();
    private int cntTotalSim;

    public int getCntTotalSim() {
        return cntTotalSim;
    }

    public WeatherTower getWeatherTower() {
        return weatherTower;
    }

    public void parseScenario(String path) throws IOException, ErrorException, NoSuchAlgorithmException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();
        if (line == null)
            throw new ErrorException("EXCEPTION: The scenario file could not be read or is empty.");
        if (!isNumber(line.split(" ")[0]))
            throw new ErrorException("EXCEPTION: The scenario file is in the wrong format.");
        try {
            cntTotalSim = Integer.parseInt(line.split(" ")[0]);
            if (cntTotalSim <= 0)
                throw new ErrorException("EXCEPTION: The simulation count is not valid.");
        } catch (NumberFormatException e) {
            throw new ErrorException("EXCEPTION: Wrong simulations count.");
        }

        while ((line = bufferedReader.readLine()) != null) {
            try {
                Flyable flyable = AircraftFactory.newAircraft(
                        line.split(" ")[0],
                        line.split(" ")[1],
                        Integer.parseInt(line.split(" ")[2]),
                        Integer.parseInt(line.split(" ")[3]),
                        Integer.parseInt(line.split(" ")[4])
                );
                weatherTower.register(flyable);
                flyable.registerTower(weatherTower);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ErrorException("EXCEPTION: Wrong numbers in line");
            } catch (NumberFormatException e) {
                throw new NumberFormatException(e.getMessage());
            } catch (ErrorException e) {
                throw new ErrorException("EXCEPTION: Unknown type or wrong md5 hash");
            }
        }
        bufferedReader.close();
    }

    public static boolean isNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            if(!Character.isDigit(string.charAt(i)))
                return false;
        }
        return true;
    }
}