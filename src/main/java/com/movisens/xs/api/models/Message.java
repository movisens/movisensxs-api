package com.movisens.xs.api.models;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

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
	 * 
	 * @return The id
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * 
	 * @param creationDate
	 *            The creationDate
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * 
	 * @return The message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 *            The message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return The messageRead
	 */
	public boolean isMessageRead() {
		return messageRead;
	}

	/**
	 * 
	 * @param messageRead
	 *            The messageRead
	 */
	public void setMessageRead(boolean messageRead) {
		this.messageRead = messageRead;
	}

	/**
	 * 
	 * @return The fromProband
	 */
	public boolean isFromProband() {
		return fromProband;
	}

	/**
	 * 
	 * @param fromProband
	 *            The fromProband
	 */
	public void setFromProband(boolean fromProband) {
		this.fromProband = fromProband;
	}

	/**
	 * 
	 * @return The sendingUserEmail
	 */
	public String getSendingUserEmail() {
		return sendingUserEmail;
	}

	/**
	 * 
	 * @param sendingUserEmail
	 *            The sendingUserEmail
	 */
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