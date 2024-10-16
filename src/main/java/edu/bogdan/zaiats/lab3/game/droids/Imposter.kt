package edu.bogdan.zaiats.lab3.game.droids

import edu.bogdan.zaiats.lab3.game.base.CanAttack
import edu.bogdan.zaiats.lab3.game.base.CanHeal
import edu.bogdan.zaiats.lab3.game.base.Droid
import edu.bogdan.zaiats.lab3.game.base.Vulnerable

class Imposter(private var health: Int) : Droid(), Vulnerable, CanAttack, CanHeal {
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
        this.health = health
    }

    override fun attack(target: Vulnerable?) {
        val damage = (target?.health ?: 0) / (1..4).random()
        target?.receiveDamage(damage)
    }

    override fun heal(target: Vulnerable?) {
        var health = 45 / (1..45).random()
        target?.receiveHealth(health)
    }

    override fun toString(): String {
        return "Shaman{" +
                "health=" + health +
                '}'
    }
}