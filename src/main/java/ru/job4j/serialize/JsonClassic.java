package ru.job4j.serialize;

import java.util.Arrays;

public class JsonClassic {
    private boolean boo;
    private int age;
    private Contact contact;
    private String[] mass;

    public JsonClassic() {
        super();
    }

    public JsonClassic(boolean boo, int age, Contact contact, String[] mass) {
        this.boo = boo;
        this.age = age;
        this.contact = contact;
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "JsonClassic{"
                + "boo=" + boo
                + ", age=" + age
                + ", contact=" + contact
                + ", mass=" + Arrays.toString(mass)
                + '}';
    }

    public boolean isBoo() {
        return boo;
    }

    public void setBoo(boolean boo) {
        this.boo = boo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String[] getMass() {
        return mass;
    }

    public void setMass(String[] mass) {
        this.mass = mass;
    }

    /*boo : false,
     * age : 45,
     * contact : {"zipcode" : "555"},
     * "mass" : ["1","2"]
     */
}
