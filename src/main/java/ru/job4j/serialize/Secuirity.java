package ru.job4j.serialize;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "secur")
@XmlAccessorType(XmlAccessType.FIELD)
public class Secuirity {

    @XmlAttribute
    private boolean sex;
    private int strength;
    private Contact contact;
    @XmlElementWrapper(name = "achivos")
    private String[] achievements;

    public Secuirity() {
        super();
    }

    public Secuirity(boolean sex, int strength, Contact contact, String[] achievements) {
        this.sex = sex;
        this.strength = strength;
        this.contact = contact;
        this.achievements = achievements;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String[] getAchievements() {
        return achievements;
    }

    public void setAchievements(String[] achievements) {
        this.achievements = achievements;
    }
}
