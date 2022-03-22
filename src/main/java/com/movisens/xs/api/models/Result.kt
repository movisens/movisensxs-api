package com.movisens.xs.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class Result {
    /**
     * @return The participant
     */
    /**
     * @param Participant The participant
     */
    @SerializedName("Participant")
    @Expose
    var participantId: Int? = null
    /**
     * @return The trigger
     */
    /**
     * @param Trigger The trigger
     */
    @SerializedName("Trigger")
    @Expose
    var trigger: String? = null
    /**
     * @return The triggerCounter
     */
    /**
     * @param TriggerCounter The Trigger_counter
     */
    @SerializedName("Trigger_counter")
    @Expose
    var triggerCounter: Int? = null
    /**
     * @return The form
     */
    /**
     * @param Form The form
     */
    @SerializedName("Form")
    @Expose
    var form: String? = null
    /**
     * @return The formStartDate
     */
    /**
     * @param FormStartDate The Form_start_date
     */
    @SerializedName("Form_start_date")
    @Expose
    var formStartDate: String? = null
    /**
     * @return The formFinishDate
     */
    /**
     * @param FormFinishDate The Form_finish_date
     */
    @SerializedName("Form_finish_date")
    @Expose
    var formFinishDate: String? = null
    /**
     * @return The formUploadDate
     */
    /**
     * @param FormUploadDate The Form_upload_date
     */
    @SerializedName("Form_upload_date")
    @Expose
    var formUploadDate: String? = null
    /**
     * @return The missing
     */
    /**
     * @param Missing The missing
     */
    @SerializedName("Missing")
    @Expose
    var missing: Missing? = null

    enum class Missing {
        @SerializedName("Ignored")
        IGNORED, @SerializedName("Dismissed")
        DISMISSED, @SerializedName("Incomplete")
        INCOMPLETE, @SerializedName("Canceled_by_new_alarm")
        CANCELED_BY_NEW_ALARM
    }

    override fun toString(): String {
        return "Result{" +
                "participantId=" + participantId +
                ", trigger='" + trigger + '\'' +
                ", triggerCounter=" + triggerCounter +
                ", form='" + form + '\'' +
                ", formStartDate='" + formStartDate + '\'' +
                ", formFinishDate='" + formFinishDate + '\'' +
                ", formUploadDate='" + formUploadDate + '\'' +
                ", missing=" + missing +
                '}'
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Result

        if (participantId != other.participantId) return false
        if (trigger != other.trigger) return false
        if (triggerCounter != other.triggerCounter) return false
        if (form != other.form) return false
        if (formStartDate != other.formStartDate) return false
        if (formFinishDate != other.formFinishDate) return false
        if (formUploadDate != other.formUploadDate) return false
        if (missing != other.missing) return false

        return true
    }

    override fun hashCode(): Int {
        var result = participantId ?: 0
        result = 31 * result + (trigger?.hashCode() ?: 0)
        result = 31 * result + (triggerCounter ?: 0)
        result = 31 * result + (form?.hashCode() ?: 0)
        result = 31 * result + (formStartDate?.hashCode() ?: 0)
        result = 31 * result + (formFinishDate?.hashCode() ?: 0)
        result = 31 * result + (formUploadDate?.hashCode() ?: 0)
        result = 31 * result + (missing?.hashCode() ?: 0)
        return result
    }
}