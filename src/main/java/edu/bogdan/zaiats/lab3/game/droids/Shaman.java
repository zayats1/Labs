package edu.bogdan.zaiats.lab3.game.droids;

import edu.bogdan.zaiats.lab3.game.base.CanHeal;
import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.base.Vulnerable;

public class Shaman extends Droid implements CanHeal {
   private final int healthBoost;

    public Shaman(int health, int health_boost) {
        super(health);
        this.healthBoost = health_boost;
    }

    @Override
    public void heal(Vulnerable target) {
        if (this.equals(target)){
            return;
        }
        target.receiveHealth(healthBoost);
    }


    @Override
    public String toString() {
        return "Shaman{" +
                "health=" + health +
                '}';
    }
}
