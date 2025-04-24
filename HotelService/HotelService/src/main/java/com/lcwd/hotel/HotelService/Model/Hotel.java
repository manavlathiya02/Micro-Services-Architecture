package com.lcwd.hotel.HotelService.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_ratings")

public class Hotel {
    @Id
    private Integer id;
    private String name;
    private String location;
    private String about;

    public Hotel() {
    }

    public Hotel(Integer id, String name, String location, String about) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.about = about;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
