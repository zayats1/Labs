package edu.bogdan.zaiats.lab3.game.droids;

import edu.bogdan.zaiats.lab3.game.base.CanHeal;
import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.base.Vulnerable;

public class Shaman extends Droid implements CanHeal, Vulnerable {
    int health;
    public Shaman(int health) {
        this.health = health;
    }

    @Override
    public void heal(Vulnerable target) {
      target.receiveHealth(45);
    }

    @Override
    public void receiveDamage(int damage) {
          this.health -= damage;
          if (this.health < 0){
              this.health = 0;
        }
    }

    @Override
    public void receiveHealth(int health) {
        this.health += health;
    }

    @Override
    public int getHealth() {
        return this.health;
    }
}
