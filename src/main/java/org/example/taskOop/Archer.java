package org.example.taskOop;

public class Archer extends Hero{
    public Archer(String name, int damage) {
        super(name, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println(getName() + " shoots a bow in " + enemy.getName());
        enemy.takeDamage(getDamage());
    }
}
