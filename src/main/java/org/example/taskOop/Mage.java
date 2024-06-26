package org.example.taskOop;

import org.example.generics.weapon.MagicWeapon;
import org.example.generics.weapon.Weapon;

// Устанавливаем, что наш маг может сражаться только тем оружем которые имплементятся от магического оружия
public class Mage<T extends MagicWeapon> extends Hero<T> {

    private Owl owl;
    public Mage(String name, int damage) {
        super(name, damage);
        this.owl = new Owl("Puglia", 7);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " struck the enemy with lightning speed with a destructive spell in " + enemy.getName());
        owl.attackEnemy(enemy);
    }

//    Внутренний класс

//    Также к вложенному классу можно применить модификатор доступа

    /*
    * Тут мы можем обращаться к классу в который вложен этот класс
    * */
    public class Owl {
        private String name;
        private int damage;

    public Owl(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public void attackEnemy(Enemy enemy) {
        enemy.takeDamage(damage + Mage.this.getDamage());
        System.out.println(name + " and " + Mage.this.getName() + " deal joint damage");
    }
}
}
