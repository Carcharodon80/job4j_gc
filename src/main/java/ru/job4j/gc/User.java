package ru.job4j.gc;


public class User {
    private int age;
    private String name;
    static int k = 0;


    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        k++;
        System.out.println("User removed : " + k);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            User user2 = new User(30, "N" + i);
        }
    }
}
