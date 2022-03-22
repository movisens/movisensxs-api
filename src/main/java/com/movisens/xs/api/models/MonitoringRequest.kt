package com.movisens.xs.api.models

import com.google.gson.annotations.Expose
import java.util.ArrayList

class MonitoringRequest {
    @Expose
    private val data: MutableList<Monitoring> = mutableListOf()

    fun add(monitoring: Monitoring) {
        data.add(monitoring)
    }

    fun addAll(monitorings: List<Monitoring>) {
        data.addAll(monitorings)
    }

    fun getData(): List<Monitoring> {
        return data
    }
}