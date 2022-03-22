package com.movisens.xs.api.models

import com.google.gson.annotations.Expose
import com.movisens.xs.api.models.Monitoring.MonitoringType

class MonitoringAlert(
    probandId: Long,
    date: String,
    name: String,
    message: String,
    includeInMail: Boolean,
    @field:Expose val isWarning: Boolean = false
) : Monitoring(probandId, date, MonitoringType.ALERT, name, message, includeInMail)