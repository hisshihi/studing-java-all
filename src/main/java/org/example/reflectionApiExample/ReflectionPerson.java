package org.example.reflectionApiExample;

public class ReflectionPerson {

    private Long id;

    public ReflectionPerson(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ReflectionPerson{" +
                "id=" + id +
                '}';
    }
}
