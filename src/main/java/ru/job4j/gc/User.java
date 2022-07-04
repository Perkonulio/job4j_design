package ru.job4j.gc;
import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class User {
    private String name;
    private String secondName;
    private int age;

    public User(String name, String secondName, int age) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        sizeOf(new User("provided", "pedro", 12));
    }
}
