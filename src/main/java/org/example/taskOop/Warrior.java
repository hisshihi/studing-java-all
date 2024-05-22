package org.example.taskOop;

import org.example.generics.weapon.MeleeWeapon;

public class Warrior<T extends MeleeWeapon> extends Hero<T>{
    public Warrior(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " hits the enemy with a sword in " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
