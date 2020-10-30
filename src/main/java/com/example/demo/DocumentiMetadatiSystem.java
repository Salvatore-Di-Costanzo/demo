package com.example.demo;

public class DocumentiMetadatiSystem {
    private String name;
    private String field;

    public DocumentiMetadatiSystem() {
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
        return "DocumentiMetadatiSystem{" +
                "name='" + name + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
