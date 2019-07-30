package com.movisens.xs.api.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

	@SerializedName("Participant")
	@Expose
	private Integer participantId;
	@SerializedName("Trigger")
	@Expose
	private String trigger;
	@SerializedName("Trigger_counter")
	@Expose
	private Integer triggerCounter;
	@SerializedName("Form")
	@Expose
	private String form;
	@SerializedName("Form_start_date")
	@Expose
	private String formStartDate;
	@SerializedName("Form_finish_date")
	@Expose
	private String formFinishDate;
	@SerializedName("Form_upload_date")
	@Expose
	private String formUploadDate;
	@SerializedName("Missing")
	@Expose
	private Missing missing;

	public enum Missing {
		@SerializedName("Ignored") IGNORED,
		@SerializedName("Dismissed") DISMISSED,
		@SerializedName("Incomplete") INCOMPLETE,
		@SerializedName("Canceled_by_new_alarm") CANCELED_BY_NEW_ALARM
	}

	/**
	 * 
	 * @return The participant
	 */
	public Integer getParticipantId() {
		return participantId;
	}

	/**
	 * 
	 * @param Participant
	 *            The participant
	 */
	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	/**
	 * 
	 * @return The trigger
	 */
	public String getTrigger() {
		return trigger;
	}

	/**
	 * 
	 * @param Trigger
	 *            The trigger
	 */
	public void setTrigger(String Trigger) {
		this.trigger = Trigger;
	}

	/**
	 * 
	 * @return The triggerCounter
	 */
	public Integer getTriggerCounter() {
		return triggerCounter;
	}

	/**
	 * 
	 * @param TriggerCounter
	 *            The Trigger_counter
	 */
	public void setTriggerCounter(Integer TriggerCounter) {
		this.triggerCounter = TriggerCounter;
	}

	/**
	 * 
	 * @return The form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * 
	 * @param Form
	 *            The form
	 */
	public void setForm(String Form) {
		this.form = Form;
	}

	/**
	 * 
	 * @return The formStartDate
	 */
	public String getFormStartDate() {
		return formStartDate;
	}

	/**
	 * 
	 * @param FormStartDate
	 *            The Form_start_date
	 */
	public void setFormStartDate(String FormStartDate) {
		this.formStartDate = FormStartDate;
	}

	/**
	 * 
	 * @return The formFinishDate
	 */
	public String getFormFinishDate() {
		return formFinishDate;
	}

	/**
	 * 
	 * @param FormFinishDate
	 *            The Form_finish_date
	 */
	public void setFormFinishDate(String FormFinishDate) {
		this.formFinishDate = FormFinishDate;
	}

	/**
	 * 
	 * @return The formUploadDate
	 */
	public String getFormUploadDate() {
		return formUploadDate;
	}

	/**
	 * 
	 * @param FormUploadDate
	 *            The Form_upload_date
	 */
	public void setFormUploadDate(String FormUploadDate) {
		this.formUploadDate = FormUploadDate;
	}

	/**
	 * 
	 * @return The missing
	 */
	public Missing getMissing() {
		return missing;
	}

	/**
	 * 
	 * @param Missing
	 *            The missing
	 */
	public void setMissing(Missing missing) {
		this.missing = missing;
	}

}