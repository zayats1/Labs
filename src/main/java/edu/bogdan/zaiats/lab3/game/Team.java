package edu.bogdan.zaiats.lab3.game;

import edu.bogdan.zaiats.lab3.game.base.CanAttack;
import edu.bogdan.zaiats.lab3.game.base.CanHeal;
import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.base.Vulnerable;
import edu.bogdan.zaiats.lab3.game.droids.Imposter;

import java.util.List;
import java.util.Random;

public class Team {
    private final String name;
    private List<Droid> team;
    private final Random random = new Random();

    public Team(String name, List<Droid> team) {
        this.team = team;
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
        if (!(second instanceof Vulnerable)) {
            return;
        }

        boolean areTeammates = team.contains(second);

        switch (first) {
            case Imposter sus -> {
                if (areTeammates) {
                    var chance25 = random.nextInt(4) == 0;
                    if (chance25) {
                        sus.attack((Vulnerable) second);
                    } else {
                        sus.heal((Vulnerable) second);
                    }
                } else {
                    sus.attack((Vulnerable) second);
                }
            }
            case CanAttack attacker -> {
                if (!areTeammates) {
                    attacker.attack((Vulnerable) second);
                }
            }
            case CanHeal shaman -> {
                if (areTeammates) {
                    shaman.heal((Vulnerable) second);
                }
            }
            default -> {
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public void cleanCorpses() {
        this.team = this.team.stream().filter(droid -> droid instanceof Vulnerable)
                .filter(droid -> ((Vulnerable) droid).getHealth() > 0).toList();
    }

}
