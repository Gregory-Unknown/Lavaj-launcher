package esobchak.school21;

import esobchak.school21.flyable.Flyable;

import java.security.PrivilegedAction;
import java.util.ArrayList;

public abstract class Tower {
    private final ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Logger.getLogger().addLoggerLine("Tower says: " + flyable.prefix() + " registered to weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.getLogger().addLoggerLine("Tower says: " + flyable.prefix() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        ArrayList<Flyable> list = new ArrayList<>(observers);
        for (Flyable f : list) {
            f.updateConditions();
        }
    }
}
