package com.example.loginuidesign.Model;

public class ReviewItem {
    private String userName;
    private double userRating;
    private String dateOfPost;
    private String review;

    public ReviewItem(String userName, double userRating, String dateOfPost, String review) {
        this.userName = userName;
        this.userRating = userRating;
        this.dateOfPost = dateOfPost;
        this.review = review;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public String getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(String dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
