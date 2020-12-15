package com.khangse616.crawlapisendo.DTO;

public class OptionDTO {

    private int id;
    private String value;
    private int attribute;

    public OptionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public OptionDTO(int id, String value, int attribute) {
        this.id = id;
        this.value = value;
        this.attribute = attribute;
    }
}
