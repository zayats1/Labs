package edu.bogdan.zaiats.lab3.main;

import edu.bogdan.zaiats.lab3.game.Team;
import edu.bogdan.zaiats.lab3.game.factory.DroidTypes;

import static edu.bogdan.zaiats.lab3.game.factory.DroidFactory.makeDroid

import java.util.List;

class Main {
    final int ROUNDS = 6;
    public static void main(String[] args) {

        var team1 =  new Team(List.of(
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.IMPOSTER),
                makeDroid(DroidTypes.SHAMAN),
                makeDroid(DroidTypes.SHAMAN),
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.BATTLE)
        ));
        var team2 = new Team(List.of(
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.SHAMAN),
                makeDroid(DroidTypes.SHAMAN),
                makeDroid(DroidTypes.IMPOSTER),
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.BATTLE),
                makeDroid(DroidTypes.BATTLE)
        ));

      // TODO
    }
}