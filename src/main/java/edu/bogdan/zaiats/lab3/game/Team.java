package edu.bogdan.zaiats.lab3.game;

import edu.bogdan.zaiats.lab3.game.base.CanAttack;
import edu.bogdan.zaiats.lab3.game.base.CanHeal;
import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.base.Vulnerable;
import edu.bogdan.zaiats.lab3.game.droids.Imposter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.IntStream.range;

public class Team {
    private final String name;
    private ArrayList<Droid> team;
    private final Random random = new Random();

    public Team(String name, List<Droid> team) {
        this.team = new ArrayList<>(team);
        this.name = name;
    }

    public int count() {
        return team.size();
    }

    public Droid getMember(int index) {
        return team.get(index);
    }

    public void interact(int idx, Droid second) {
        var first = team.get(idx);
        if (second == null) {
            return;
        }

        boolean areTeammates = team.contains(second);

        switch (first) {
            case Imposter sus -> {
                if (areTeammates) {
                    var chance25 = random.nextInt(4) == 0;
                    if (chance25) {
                        sus.attack(second);
                    } else {
                        sus.heal(second);
                    }
                } else {
                    sus.attack(second);
                }
            }
            case CanAttack attacker -> {
                if (!areTeammates) {
                    attacker.attack(second);
                }
            }
            case CanHeal shaman -> {
                if (areTeammates) {
                    shaman.heal(second);
                }
            }
            default -> {
            }
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String  toString(){
        return  this.getName() + "\n" + this.team.toString()
                .replace("},","},\n")
                .replace('[',' ')
                .replace(']',' ');
    }

    public void cleanCorpses() {
            this.team.removeIf(droid -> droid.getHealth() == 0 );
    }
}
