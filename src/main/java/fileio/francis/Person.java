package fileio.francis;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private int age;
    private String sex;
    private String name;

    public Person(int age, String sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && getSex().equals(person.getSex()) && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getSex(), getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
