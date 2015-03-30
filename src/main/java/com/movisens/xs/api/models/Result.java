package com.movisens.xs.api.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Result {

	@Expose
	private Integer Participant;
	@Expose
	private Integer Device;
	@Expose
	private String Trigger;
	@SerializedName("Trigger_counter")
	@Expose
	private Integer TriggerCounter;
	@Expose
	private String Form;
	@SerializedName("Form_start_date")
	@Expose
	private String FormStartDate;
	@SerializedName("Form_finish_date")
	@Expose
	private String FormFinishDate;
	@SerializedName("Form_upload_date")
	@Expose
	private String FormUploadDate;
	@Expose
	private String Missing;

	/**
	 * 
	 * @return The Participant
	 */
	public Integer getParticipant() {
		return Participant;
	}

	/**
	 * 
	 * @param Participant
	 *            The Participant
	 */
	public void setParticipant(Integer Participant) {
		this.Participant = Participant;
	}

	/**
	 * 
	 * @return The Device
	 */
	public Integer getDevice() {
		return Device;
	}

	/**
	 * 
	 * @param Device
	 *            The Device
	 */
	public void setDevice(Integer Device) {
		this.Device = Device;
	}

	/**
	 * 
	 * @return The Trigger
	 */
	public String getTrigger() {
		return Trigger;
	}

	/**
	 * 
	 * @param Trigger
	 *            The Trigger
	 */
	public void setTrigger(String Trigger) {
		this.Trigger = Trigger;
	}

	/**
	 * 
	 * @return The TriggerCounter
	 */
	public Integer getTriggerCounter() {
		return TriggerCounter;
	}

	/**
	 * 
	 * @param TriggerCounter
	 *            The Trigger_counter
	 */
	public void setTriggerCounter(Integer TriggerCounter) {
		this.TriggerCounter = TriggerCounter;
	}

	/**
	 * 
	 * @return The Form
	 */
	public String getForm() {
		return Form;
	}

	/**
	 * 
	 * @param Form
	 *            The Form
	 */
	public void setForm(String Form) {
		this.Form = Form;
	}

	/**
	 * 
	 * @return The FormStartDate
	 */
	public String getFormStartDate() {
		return FormStartDate;
	}

	/**
	 * 
	 * @param FormStartDate
	 *            The Form_start_date
	 */
	public void setFormStartDate(String FormStartDate) {
		this.FormStartDate = FormStartDate;
	}

	/**
	 * 
	 * @return The FormFinishDate
	 */
	public String getFormFinishDate() {
		return FormFinishDate;
	}

	/**
	 * 
	 * @param FormFinishDate
	 *            The Form_finish_date
	 */
	public void setFormFinishDate(String FormFinishDate) {
		this.FormFinishDate = FormFinishDate;
	}

	/**
	 * 
	 * @return The FormUploadDate
	 */
	public String getFormUploadDate() {
		return FormUploadDate;
	}

	/**
	 * 
	 * @param FormUploadDate
	 *            The Form_upload_date
	 */
	public void setFormUploadDate(String FormUploadDate) {
		this.FormUploadDate = FormUploadDate;
	}

	/**
	 * 
	 * @return The Missing
	 */
	public String getMissing() {
		return Missing;
	}

	/**
	 * 
	 * @param Missing
	 *            The Missing
	 */
	public void setMissing(String Missing) {
		this.Missing = Missing;
	}

}