package edu.bogdan.zaiats.lab3.game.droids;

import edu.bogdan.zaiats.lab3.game.base.CanAttack;
import edu.bogdan.zaiats.lab3.game.base.Droid;
import edu.bogdan.zaiats.lab3.game.base.Vulnerable;

public class BattleDroid extends Droid implements Vulnerable, CanAttack {
    private final int damage;
    private int health;
    public BattleDroid(int health, int damage) {
        this.damage = damage;
        this.health = health;
    }

    @Override
    public void attack(Vulnerable target) {
         target.receiveDamage(this.damage);
    }

    @Override
    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
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
