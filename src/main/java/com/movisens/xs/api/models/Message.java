package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Message {

    @Expose
    @NotNull
    private long id;
    @Expose
    @NotNull
    private String creationDate;
    @Expose
    @NotNull
    private String message;
    @Expose
    @NotNull
    private boolean messageRead;
    @Expose
    @NotNull
    private boolean fromProband;
    @Expose
    @Nullable
    private String sendingUserEmail;

    @NotNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @NotNull
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @NotNull
    public boolean isMessageRead() {
        return messageRead;
    }

    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }

    @NotNull
    public boolean isFromProband() {
        return fromProband;
    }

    public void setFromProband(boolean fromProband) {
        this.fromProband = fromProband;
    }

    @Nullable
    public String getSendingUserEmail() {
        return sendingUserEmail;
    }

    public void setSendingUserEmail(String sendingUserEmail) {
        this.sendingUserEmail = sendingUserEmail;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", message='" + message + '\'' +
                ", messageRead=" + messageRead +
                ", fromProband=" + fromProband +
                ", sendingUserEmail='" + sendingUserEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (id != message1.id) return false;
        if (messageRead != message1.messageRead) return false;
        if (fromProband != message1.fromProband) return false;
        if (creationDate != null ? !creationDate.equals(message1.creationDate) : message1.creationDate != null)
            return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        if (sendingUserEmail != null ? !sendingUserEmail.equals(message1.sendingUserEmail) : message1.sendingUserEmail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (messageRead ? 1 : 0);
        result = 31 * result + (fromProband ? 1 : 0);
        result = 31 * result + (sendingUserEmail != null ? sendingUserEmail.hashCode() : 0);
        return result;
    }
}