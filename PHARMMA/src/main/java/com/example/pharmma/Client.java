package com.example.pharmma;

public class Client {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private double phoneNbr;

    public Client() {
    }

    public Client(int id, String name, String lastname, int age, double phoneNbr) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phoneNbr = phoneNbr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(double phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", phoneNbr=" + phoneNbr +
                '}';
    }
}