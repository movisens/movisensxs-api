package com.movisens.xs.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.movisens.xs.api.models.Proband.ProbandStatus
import com.movisens.xs.api.models.Proband
import java.util.*

class Proband {
    @Expose
    var id: Int? = null

    @Expose
    var startDate: Date? = null

    @Expose
    var endDate: Date? = null

    @Expose
    var coupleURL: String? = null

    @Expose
    var coupleDate: Date? = null

    @Expose
    var currentVersion: String? = null

    @Expose
    var status: ProbandStatus? = null

    enum class ProbandStatus {
        @SerializedName("running")
        RUNNING, @SerializedName("paused")
        PAUSED, @SerializedName("uncoupled")
        UNCOUPLED, @SerializedName("unknown")
        UNKNOWN, @SerializedName("finished")
        FINISHED
    }

    override fun toString(): String {
        return "Proband{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", coupleURL='" + coupleURL + '\'' +
                ", coupleDate=" + coupleDate +
                ", currentVersion='" + currentVersion + '\'' +
                ", status='" + status + '\'' +
                '}'
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Proband

        if (id != other.id) return false
        if (startDate != other.startDate) return false
        if (endDate != other.endDate) return false
        if (coupleURL != other.coupleURL) return false
        if (coupleDate != other.coupleDate) return false
        if (currentVersion != other.currentVersion) return false
        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (startDate?.hashCode() ?: 0)
        result = 31 * result + (endDate?.hashCode() ?: 0)
        result = 31 * result + (coupleURL?.hashCode() ?: 0)
        result = 31 * result + (coupleDate?.hashCode() ?: 0)
        result = 31 * result + (currentVersion?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        return result
    }
}