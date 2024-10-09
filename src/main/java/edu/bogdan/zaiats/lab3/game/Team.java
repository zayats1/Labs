package edu.bogdan.zaiats.lab3.game;

import edu.bogdan.zaiats.lab3.game.base.CanAttack;
import edu.bogdan.zaiats.lab3.game.base.CanHeal;
import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.base.Vulnerable;
import edu.bogdan.zaiats.lab3.game.droids.Imposter;

import java.util.List;
import java.util.Random;

public class Team {
    List<Droid> team;
    Random random = new Random();

    public Team(List<Droid> team) {
        this.team = team;
    }

    public  void interract(int idx, Droid second) {
        var first = team.get(idx);
        if (!(second instanceof Vulnerable)) {
            return;
        }

        boolean areTeammates = team.contains(second);

        switch (first) {
            case Imposter sus -> {
               if (areTeammates){
                   var chance25 = random.nextInt(4) == 0;
                   if (chance25) {
                      sus.attack((Vulnerable) second);
                   } else {
                       sus.heal((Vulnerable) second);
                   }
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
                return;
            }
        }
    }
}
