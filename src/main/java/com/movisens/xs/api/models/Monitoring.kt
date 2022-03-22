package com.movisens.xs.api.models

import com.google.gson.annotations.Expose

open class Monitoring(
    @field:Expose var probandId: Long,
    @field:Expose var date: String,
    @field:Expose var type: MonitoringType,
    @field:Expose var name: String,
    @field:Expose var message: String,
    @field:Expose var includeInMail: Boolean = false
) {
    enum class MonitoringType {
        COMPLIANCE, ALERT
    }
}