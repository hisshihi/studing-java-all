package org.example;

import org.example.taskOop.*;

public class Main {
    public static void main(String[] args) {

        Hero warrior = new Warrior("Ivan", 15);
        Mage mage = new Mage("Hiss", 35);
        Hero archer = new Archer("Arina", 23);

        Mage.Owl owl = mage.new Owl("Karasik", 11);

        Enemy enemy = new Enemy("KTK", 100);

        attackEnemy(enemy, warrior, mage, archer);

    }

    public static void attackEnemy(Enemy enemy, Hero... heroes) {
        while (enemy.isAlive()) {
            for (Hero hero : heroes) {
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                    System.out.println();
                }
            }
        }
    }
}