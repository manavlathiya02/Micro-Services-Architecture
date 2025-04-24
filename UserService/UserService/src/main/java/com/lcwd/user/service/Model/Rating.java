package com.lcwd.user.service.Model;

public class Rating {
    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private int rating;
    private String remark;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Rating(Integer ratingId, Integer userId, Integer hotelId, int rating, String remark, Hotel hotel) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.remark = remark;
        this.hotel = hotel;
    }

    public Rating() {
    }

    private Hotel hotel;

    public Rating(Integer ratingId, Integer userId, Integer hotelId, int rating, String remark) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                ", rating=" + rating +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
