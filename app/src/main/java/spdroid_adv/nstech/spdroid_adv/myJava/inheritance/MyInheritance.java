package spdroid_adv.nstech.spdroid_adv.myJava.inheritance;

/**
 * Created by webwerks on 28/4/17.
 */

public class MyInheritance {
    public static void main(String...args){
        Animal animal = new Dog();
        animal.moving();
        animal.dummy();

        ((new Dog())).dummyCHild();
    }
}
