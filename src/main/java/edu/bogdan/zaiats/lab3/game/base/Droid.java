package edu.bogdan.zaiats.lab3.game.base;

public class Droid  implements Vulnerable{
    protected final int maxHealth;
    protected int health;


    public Droid(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
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

        if ( this.health > this.maxHealth){
            this.health = maxHealth;
        }
    }

    @Override
    public int getHealth() {
        return this.health;
    }
}
