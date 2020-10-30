package com.example.demo;

public class AllegatiMetadatiSystem {
    private String name;
    private String field;

    public AllegatiMetadatiSystem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "AllegatiMetadatiSystem{" +
                "name='" + name + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
