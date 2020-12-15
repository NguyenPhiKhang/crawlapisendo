package com.khangse616.crawlapisendo.DTO;

public class CommentDTO {

    private String id;
    private String parent_id;
    private String data;
    private int customer_id;

    public CommentDTO() {
    }

    public CommentDTO(String id, String parent_id, String data, int customer_id) {
        this.id = id;
        this.parent_id = parent_id;
        this.data = data;
        this.customer_id = customer_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
