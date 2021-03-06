package com.example.demo;

public class AllegatiMetadatiCustom {
    private String name;
    private String field;

    public AllegatiMetadatiCustom() {

    }

    public AllegatiMetadatiCustom(String name, String field) {
        this.name = name;
        this.field = field;
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
        return "AllegatiMetadatiCustom{" +
                "name='" + name + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
