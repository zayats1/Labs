package edu.bogdan.zaiats.lab3.main;

import edu.bogdan.zaiats.lab3.game.Team;
import edu.bogdan.zaiats.lab3.game.factory.DroidTypes;

import java.util.List;
import java.util.Random;

import static edu.bogdan.zaiats.lab3.game.factory.DroidFactory.makeDroid;
import static java.util.stream.IntStream.range;

class Main {
    final static int ROUNDS = 24;

    public static void main(String[] args) {
        var rng = new Random();
        var team1 = new Team(List.of(
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

      for (var i :  range(0, ROUNDS).toArray()) {
            if (team1.count() ==  0 || team2.count() == 0){
                break;
            }
            var first_idx = rng.nextInt(team1.count());
            var second_idx = rng.nextInt(team2.count());
            var first = team1.getMember(first_idx);
            var second = team2.getMember(second_idx);
            team1.interact(first_idx, second);
            team1.interact(second_idx, first);
            team1.interact(first_idx, team1.getMember(rng.nextInt(team1.count())));
            team2.interact(first_idx, team2.getMember(rng.nextInt(team2.count())));

            team1.cleanCorpses();
            team2.cleanCorpses();
        }

        range(0, team1.count()).forEachOrdered(i -> {
            System.out.println(team1.getMember(i));
        });

        range(0, team2.count()).forEachOrdered(i -> {
            System.out.println(team2.getMember(i));
        });
    }
}