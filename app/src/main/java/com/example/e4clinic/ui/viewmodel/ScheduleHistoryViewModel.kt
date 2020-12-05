package com.example.e4clinic.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Client
import com.example.e4clinic.repository.ScheduleHistoryRepository
import com.example.e4clinic.ui.core.BaseViewModel

class ScheduleHistoryViewModel  @ViewModelInject constructor(
    private val scheduleHistoryRepository: ScheduleHistoryRepository
) : BaseViewModel() {
    private val _history: MutableLiveData<List<Any>> = MutableLiveData()
    val history: LiveData<List<Any>>
        get() = _history

    fun getHistory() {
        _history.value = scheduleHistoryRepository.getScheduleHistory().value
    }


}