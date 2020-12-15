package com.khangse616.crawlapisendo.DTO;

public class CategoriesProductDTO {
    private int category_level1_id;
    private String category_level1_name;
    private String category_level1_path;
    private int category_level2_id;
    private String category_level2_name;
    private String category_level2_path;
    private int category_level3_id;
    private String category_level3_name;
    private String category_level3_path;

    public CategoriesProductDTO() {
    }

    public CategoriesProductDTO(int category_level1_id, String category_level1_name, String category_level1_path, int category_level2_id, String category_level2_name, String category_level2_path, int category_level3_id, String category_level3_name, String category_level3_path) {
        this.category_level1_id = category_level1_id;
        this.category_level1_name = category_level1_name;
        this.category_level1_path = category_level1_path;
        this.category_level2_id = category_level2_id;
        this.category_level2_name = category_level2_name;
        this.category_level2_path = category_level2_path;
        this.category_level3_id = category_level3_id;
        this.category_level3_name = category_level3_name;
        this.category_level3_path = category_level3_path;
    }

    public int getCategory_level1_id() {
        return category_level1_id;
    }

    public void setCategory_level1_id(int category_level1_id) {
        this.category_level1_id = category_level1_id;
    }

    public String getCategory_level1_name() {
        return category_level1_name;
    }

    public void setCategory_level1_name(String category_level1_name) {
        this.category_level1_name = category_level1_name;
    }

    public String getCategory_level1_path() {
        return category_level1_path;
    }

    public void setCategory_level1_path(String category_level1_path) {
        this.category_level1_path = category_level1_path;
    }

    public int getCategory_level2_id() {
        return category_level2_id;
    }

    public void setCategory_level2_id(int category_level2_id) {
        this.category_level2_id = category_level2_id;
    }

    public String getCategory_level2_name() {
        return category_level2_name;
    }

    public void setCategory_level2_name(String category_level2_name) {
        this.category_level2_name = category_level2_name;
    }

    public String getCategory_level2_path() {
        return category_level2_path;
    }

    public void setCategory_level2_path(String category_level2_path) {
        this.category_level2_path = category_level2_path;
    }

    public int getCategory_level3_id() {
        return category_level3_id;
    }

    public void setCategory_level3_id(int category_level3_id) {
        this.category_level3_id = category_level3_id;
    }

    public String getCategory_level3_name() {
        return category_level3_name;
    }

    public void setCategory_level3_name(String category_level3_name) {
        this.category_level3_name = category_level3_name;
    }

    public String getCategory_level3_path() {
        return category_level3_path;
    }

    public void setCategory_level3_path(String category_level3_path) {
        this.category_level3_path = category_level3_path;
    }
}
