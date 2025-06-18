/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkinn.model;

import java.util.Date;
/**
 *
 * @author saura
 */
public class Review {
    private int reviewId;
    private int userId;
    private String reviewText;
    private Date reviewDate;
    
    public int getReviewId() { return reviewId; }
    public void setReviewId(int reviewId) { this.reviewId = reviewId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getReviewText() { return reviewText; }
    public void setReviewText(String reviewText) { this.reviewText = reviewText; }
    public Date getReviewDate() { return reviewDate; }
    public void setReviewDate(Date reviewDate) { this.reviewDate = reviewDate; }
}
