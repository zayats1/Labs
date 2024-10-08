package edu.bogdan.zaiats.lab3.game.factory;

import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.droids.BattleDroid;
import edu.bogdan.zaiats.lab3.game.droids.Imposter;
import edu.bogdan.zaiats.lab3.game.droids.Shaman;

public class DroidFactory {
    public Droid makeDroid(DroidTypes type){
       return switch (type){
           case BATTLE -> new BattleDroid(45,4);
           case SHAMAN -> new Shaman(45);
           case IMPOSTER -> new Imposter(64);
       };
    }
}
