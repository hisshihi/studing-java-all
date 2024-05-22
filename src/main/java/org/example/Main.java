package org.example;

import org.example.generics.List;
import org.example.generics.weapon.*;
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

    /*
    * Для того, чтобы принять какой-либо тип оружия нам нужно
    * Создать дженерик который принимает типы наследованные от оружия,
    * то есть параметризация на уровне метода
    * И задать героя который параметризован тем типом оружия, который наседован у метода
    * */
    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }
}