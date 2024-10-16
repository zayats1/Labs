package edu.bogdan.zaiats.lab3.game.base;

public interface Vulnerable {
    void receiveDamage(int damage);

    void receiveHealth(int health);

    int getHealth();
}

