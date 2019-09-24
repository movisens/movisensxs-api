package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
     * @return The participant
     */
    public Integer getParticipantId() {
        return participantId;
    }

    /**
     * @param Participant The participant
     */
    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    /**
     * @return The trigger
     */
    public String getTrigger() {
        return trigger;
    }

    /**
     * @param Trigger The trigger
     */
    public void setTrigger(String Trigger) {
        this.trigger = Trigger;
    }

    /**
     * @return The triggerCounter
     */
    public Integer getTriggerCounter() {
        return triggerCounter;
    }

    /**
     * @param TriggerCounter The Trigger_counter
     */
    public void setTriggerCounter(Integer TriggerCounter) {
        this.triggerCounter = TriggerCounter;
    }

    /**
     * @return The form
     */
    public String getForm() {
        return form;
    }

    /**
     * @param Form The form
     */
    public void setForm(String Form) {
        this.form = Form;
    }

    /**
     * @return The formStartDate
     */
    public String getFormStartDate() {
        return formStartDate;
    }

    /**
     * @param FormStartDate The Form_start_date
     */
    public void setFormStartDate(String FormStartDate) {
        this.formStartDate = FormStartDate;
    }

    /**
     * @return The formFinishDate
     */
    public String getFormFinishDate() {
        return formFinishDate;
    }

    /**
     * @param FormFinishDate The Form_finish_date
     */
    public void setFormFinishDate(String FormFinishDate) {
        this.formFinishDate = FormFinishDate;
    }

    /**
     * @return The formUploadDate
     */
    public String getFormUploadDate() {
        return formUploadDate;
    }

    /**
     * @param FormUploadDate The Form_upload_date
     */
    public void setFormUploadDate(String FormUploadDate) {
        this.formUploadDate = FormUploadDate;
    }

    /**
     * @return The missing
     */
    public Missing getMissing() {
        return missing;
    }

    /**
     * @param Missing The missing
     */
    public void setMissing(Missing missing) {
        this.missing = missing;
    }

    @Override
    public String toString() {
        return "Result{" +
                "participantId=" + participantId +
                ", trigger='" + trigger + '\'' +
                ", triggerCounter=" + triggerCounter +
                ", form='" + form + '\'' +
                ", formStartDate='" + formStartDate + '\'' +
                ", formFinishDate='" + formFinishDate + '\'' +
                ", formUploadDate='" + formUploadDate + '\'' +
                ", missing=" + missing +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (participantId != null ? !participantId.equals(result.participantId) : result.participantId != null)
            return false;
        if (trigger != null ? !trigger.equals(result.trigger) : result.trigger != null) return false;
        if (triggerCounter != null ? !triggerCounter.equals(result.triggerCounter) : result.triggerCounter != null)
            return false;
        if (form != null ? !form.equals(result.form) : result.form != null) return false;
        if (formStartDate != null ? !formStartDate.equals(result.formStartDate) : result.formStartDate != null)
            return false;
        if (formFinishDate != null ? !formFinishDate.equals(result.formFinishDate) : result.formFinishDate != null)
            return false;
        if (formUploadDate != null ? !formUploadDate.equals(result.formUploadDate) : result.formUploadDate != null)
            return false;
        if (missing != result.missing) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = participantId != null ? participantId.hashCode() : 0;
        result = 31 * result + (trigger != null ? trigger.hashCode() : 0);
        result = 31 * result + (triggerCounter != null ? triggerCounter.hashCode() : 0);
        result = 31 * result + (form != null ? form.hashCode() : 0);
        result = 31 * result + (formStartDate != null ? formStartDate.hashCode() : 0);
        result = 31 * result + (formFinishDate != null ? formFinishDate.hashCode() : 0);
        result = 31 * result + (formUploadDate != null ? formUploadDate.hashCode() : 0);
        result = 31 * result + (missing != null ? missing.hashCode() : 0);
        return result;
    }
}