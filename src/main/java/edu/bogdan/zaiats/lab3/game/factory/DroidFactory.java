package edu.bogdan.zaiats.lab3.game.factory;

import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.droids.BattleDroid;
import edu.bogdan.zaiats.lab3.game.droids.Imposter;
import edu.bogdan.zaiats.lab3.game.droids.Shaman;

public class DroidFactory {
    public static Droid makeDroid(DroidTypes type) {
        return switch (type) {
            case BATTLE -> new BattleDroid(450, 20);
            case SHAMAN -> new Shaman(450, 15);
            case IMPOSTER -> new Imposter(640,15);
        };
    }
}
