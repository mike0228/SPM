package cn.edu.njust.dev.ses.main.model;

import java.util.Date;

public class UserSession {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.session_id
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer sessionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.token
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.expires
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    private Date expires;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.session_id
     *
     * @return the value of user_token.session_id
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getSessionId() {
        return sessionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.session_id
     *
     * @param sessionId the value for user_token.session_id
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.token
     *
     * @return the value of user_token.token
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.token
     *
     * @param token the value for user_token.token
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.uid
     *
     * @return the value of user_token.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.uid
     *
     * @param uid the value for user_token.uid
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.expires
     *
     * @return the value of user_token.expires
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public Date getExpires() {
        return expires;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.expires
     *
     * @param expires the value for user_token.expires
     *
     * @mbg.generated Wed Dec 11 17:09:53 CST 2019
     */
    public void setExpires(Date expires) {
        this.expires = expires;
    }
}