package edu.bogdan.zaiats.lab3.game.droids

import edu.bogdan.zaiats.lab3.game.base.CanAttack
import edu.bogdan.zaiats.lab3.game.base.CanHeal
import edu.bogdan.zaiats.lab3.game.base.Droid
import edu.bogdan.zaiats.lab3.game.base.Vulnerable

class Imposter(private var health: Int,private val healthBoost: Int) : Droid(health), CanAttack, CanHeal {
    override fun attack(target: Vulnerable?) {
        if (this == target){
            return;
        }
        val damage = (target?.health ?: 0) / (1..4).random()
        target?.receiveDamage(damage)
    }

    override fun heal(target: Vulnerable?) {
        if (this == target){
            return;
        }
        var health = 45 / (1..45).random()
        target?.receiveHealth(health)

    }

    override fun toString(): String {
        return "Shaman{" +
                "health=" + health +
                '}'
    }
}