package com.khangse616.crawlapisendo.DTO;

public class AttributeDTO {
    private int id;
    private String name;

    public AttributeDTO() {
    }

    public AttributeDTO(int id, String name) {
        this.id = id;
        this.name = name;
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
}
