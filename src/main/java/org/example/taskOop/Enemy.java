package org.example.taskOop;

public class Enemy implements Mortal {

    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) {
        if (isAlive() && getHealth() <= damage) {
            health = 0;
            System.out.println(getName() + " is dead!");
        } else {
            this.health -= Math.min(health, damage);
            System.out.println(name + " received damage " + damage + ". Left " + getHealth());
        }

    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
