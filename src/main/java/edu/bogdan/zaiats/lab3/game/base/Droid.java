package edu.bogdan.zaiats.lab3.game.base;

public abstract class Droid {
    protected int health;

    public Droid(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
