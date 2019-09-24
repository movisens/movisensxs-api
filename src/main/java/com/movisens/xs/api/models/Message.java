package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Message {

    @Expose
    private long id;
    @Expose
    private String creationDate;
    @Expose
    private String message;
    @Expose
    private boolean messageRead;
    @Expose
    private boolean fromProband;
    @Expose
    private String sendingUserEmail;

    /**
     * @return The id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return The creationDate
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate The creationDate
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The messageRead
     */
    public boolean isMessageRead() {
        return messageRead;
    }

    /**
     * @param messageRead The messageRead
     */
    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }

    /**
     * @return The fromProband
     */
    public boolean isFromProband() {
        return fromProband;
    }

    /**
     * @param fromProband The fromProband
     */
    public void setFromProband(boolean fromProband) {
        this.fromProband = fromProband;
    }

    /**
     * @return The sendingUserEmail
     */
    public String getSendingUserEmail() {
        return sendingUserEmail;
    }

    /**
     * @param sendingUserEmail The sendingUserEmail
     */
    public void setSendingUserEmail(String sendingUserEmail) {
        this.sendingUserEmail = sendingUserEmail;
    }

}