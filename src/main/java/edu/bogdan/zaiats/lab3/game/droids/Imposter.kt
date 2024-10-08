package edu.bogdan.zaiats.lab3.game.droids

import edu.bogdan.zaiats.lab3.game.base.Droid
import edu.bogdan.zaiats.lab3.game.base.Vulnerable

class Imposter(private var health:Int) : Droid(health), Vulnerable {
    override fun getHealth(): Int {
        return this.health
    }
    override fun receiveDamage(damage: Int) {
        this.health -= damage
        if (this.health < 0) {
            this.health = 0
        }
    }

    override fun receiveHealth(health: Int) {
        this.health = health;
    }
}