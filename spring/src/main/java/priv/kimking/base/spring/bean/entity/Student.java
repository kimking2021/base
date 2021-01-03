package priv.kimking.base.spring.bean.entity;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * <p>
 *
 * @author kim
 * @date 2020/10/27
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -2088281526481179972L;

    private int id;
    private String name;
    private int age;

    public Student() {
        System.out.println("Student() invoke...");
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("Student(id, name, age) invoke...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("student post-construct invoke...");
    }

    public void init() {
        System.out.println("student init method invoke...");
    }

    public void destroy() {
        System.out.println("student destroy method invoke...");
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
