package com.example.e4clinic.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Clinic
import com.example.e4clinic.repository.ClinicsRepository
import com.example.e4clinic.ui.core.BaseViewModel

class ClinicsViewModel @ViewModelInject constructor(
    private val clinicsRepository: ClinicsRepository
) : BaseViewModel() {
    private val _clinics: MutableLiveData<List<Clinic>> = MutableLiveData()
    val clinics: LiveData<List<Clinic>>
        get() = _clinics

    fun getClinics() {
        _clinics.value = clinicsRepository.getClinics().value
    }


}