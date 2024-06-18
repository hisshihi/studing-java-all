package org.example.reflectionApiExample;

import java.io.Serializable;

public class ReflectionUser extends ReflectionPerson implements Serializable, Comparable<ReflectionUser> {

    private String name;

    public ReflectionUser(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public int compareTo(ReflectionUser o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReflectionUser{" +
                "id=" + getId() + // Добавляем вывод id
                ", name='" + name + '\'' +
                '}';
    }
}
