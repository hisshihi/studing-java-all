package org.example;

import org.example.generics.List;
import org.example.generics.weapon.Bow;
import org.example.generics.weapon.Sword;
import org.example.generics.weapon.Wand;
import org.example.taskOop.*;

public class Main {
    public static void main(String[] args) {

        Mage<Wand> mage = new Mage<>("Hiss", 20);
        mage.setWeapon(new Wand());

        Archer<Bow> archer = new Archer<>("Arina", 10);
        archer.setWeapon(new Bow());

        Warrior<Sword> warrior = new Warrior<>("Ivan", 13);
        warrior.setWeapon(new Sword());

        printWeaponDamage(mage);

    }

    public static void printWeaponDamage(Hero<Wand> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }
}