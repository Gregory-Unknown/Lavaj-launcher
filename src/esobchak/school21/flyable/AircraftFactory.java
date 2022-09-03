package esobchak.school21.flyable;

import esobchak.school21.ErrorException;
import esobchak.school21.MD5Encryption;

import java.security.NoSuchAlgorithmException;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws NoSuchAlgorithmException, ErrorException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Helicopter") || MD5Encryption.checkEncrypt("Helicopter", type))
            return new Helicopter(name, coordinates);
        else if (type.equals("JetPlane") || MD5Encryption.checkEncrypt("JetPlane", type))
            return new JetPlane(name, coordinates);
        else if (type.equals("Baloon") || MD5Encryption.checkEncrypt("Baloon", type))
            return new Baloon(name, coordinates);
        else throw new ErrorException("EXCEPTION: Unknown type: \"" + type + "\" or wrong md5 hash");
    }
}
