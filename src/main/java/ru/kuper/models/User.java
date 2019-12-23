package ru.kuper.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    public User() {
    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
        autos = new ArrayList<Auto>();
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    @Override
    public String toString() {
        return "models.user{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age +'}';
    }


    public String showInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("models.user{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age +'}');
        if (!autos.isEmpty())
            sb.append("Автомобили:");
            for (Auto auto: autos) {
                sb.append(" " + auto.toString() + ";");
            }
        return sb.toString();
    }
}

