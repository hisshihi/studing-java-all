package org.example.taskOop;

public class Mage extends Hero{
    public Mage(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " struck the enemy with lightning speed with a destructive spell in " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
