package com.khangse616.crawlapisendo.DTO;

public class RatingDTO {
    private int id;
    private String comment;
    private int star;
    private int user;

    public RatingDTO() {
    }

    public RatingDTO(int id, String comment, int star, int user) {
        this.id = id;
        this.comment = comment;
        this.star = star;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
