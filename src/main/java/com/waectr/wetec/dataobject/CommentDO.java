package com.waectr.wetec.dataobject;

import java.util.Date;

public class CommentDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.comment_id
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    private Integer commentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.comment_sender
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    private Integer commentSender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.comment_article_id
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    private Integer commentArticleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.comment_publc_time
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    private Date commentPublcTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.comment_id
     *
     * @return the value of t_comment.comment_id
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.comment_id
     *
     * @param commentId the value for t_comment.comment_id
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.comment_sender
     *
     * @return the value of t_comment.comment_sender
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public Integer getCommentSender() {
        return commentSender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.comment_sender
     *
     * @param commentSender the value for t_comment.comment_sender
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public void setCommentSender(Integer commentSender) {
        this.commentSender = commentSender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.comment_article_id
     *
     * @return the value of t_comment.comment_article_id
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.comment_article_id
     *
     * @param commentArticleId the value for t_comment.comment_article_id
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.comment_publc_time
     *
     * @return the value of t_comment.comment_publc_time
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public Date getCommentPublcTime() {
        return commentPublcTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.comment_publc_time
     *
     * @param commentPublcTime the value for t_comment.comment_publc_time
     *
     * @mbg.generated Sun May 24 17:28:04 CST 2020
     */
    public void setCommentPublcTime(Date commentPublcTime) {
        this.commentPublcTime = commentPublcTime;
    }
}