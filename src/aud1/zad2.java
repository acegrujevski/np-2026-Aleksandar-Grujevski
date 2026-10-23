package aud1;

import java.util.ArrayList;
import java.util.List;

abstract class Alien {
    private int health; // 0=dead, 100=full strength
    private String name;

    public Alien(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public abstract int getDamage();

    @Override
    public String toString() {
        return "Alien{" +
                "health=" + health +
                ", name='" + name + '\'' +
                ", damage='" + this.getDamage() + '\'' +
                '}';
    }
}

class snakeAlien extends Alien {
    public snakeAlien(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 10;
    }
}

class orgeAlien extends Alien {
    public orgeAlien(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 6;
    }
}

class marshmallowManAlien extends Alien{
    public marshmallowManAlien(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return 1;
    }
}

class AlienPack {

    private List<Alien> aliens = new ArrayList<>();

    public void addAlien(Alien alien){
        aliens.add(alien);
    }

    public int calculateDamage(){
        int total = 0;
        for (Alien alien : aliens) total += alien.getDamage();
        return total;
    }

}

class Tester{
    public static void main(String[] args) {
        AlienPack alienPack = new AlienPack();

        Alien alien1 = new snakeAlien(69,"Alien1");
        Alien alien2 = new orgeAlien(69,"Alien2");
        Alien alien3 = new marshmallowManAlien(69,"Alien3");

        alienPack.addAlien(alien1);
        alienPack.addAlien(alien2);
        alienPack.addAlien(alien3);

        System.out.println(alien1);
        System.out.println(alien2);
        System.out.println(alien3);

        System.out.println(alienPack.calculateDamage());
    }
}
