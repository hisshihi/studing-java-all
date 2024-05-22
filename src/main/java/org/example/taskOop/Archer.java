package org.example.taskOop;

import org.example.generics.weapon.RangeWeapon;

public class Archer<T extends RangeWeapon> extends Hero<T>{
    public Archer(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " shoots a bow in " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
