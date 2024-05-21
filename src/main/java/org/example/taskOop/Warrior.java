package org.example.taskOop;

public class Warrior extends Hero{
    public Warrior(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " hits the enemy with a sword in " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
