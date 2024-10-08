package edu.bogdan.zaiats.lab3.main;

import edu.bogdan.zaiats.lab3.game.droids.BattleDroid;
import edu.bogdan.zaiats.lab3.game.droids.Imposter;
import edu.bogdan.zaiats.lab3.game.droids.Shaman;
import edu.bogdan.zaiats.lab3.game.factory.DroidFactory;

class Main {
    public static void main(String[] args) {
       var r2d2 = new BattleDroid(46,60);
       var chopper = new BattleDroid(12,10);
       var imposter = new Imposter(64);
       var shaman = new Shaman(45);

        r2d2.attack(imposter);
        chopper.attack(r2d2);
        System.out.println(imposter.getHealth());
        System.out.println(r2d2.getHealth());
        shaman.heal(r2d2);
        System.out.println(r2d2.getHealth());
    }
}