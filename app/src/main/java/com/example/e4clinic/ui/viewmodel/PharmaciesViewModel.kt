package com.example.e4clinic.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Clinic
import com.example.e4clinic.models.Pharmacy
import com.example.e4clinic.repository.PharmaciesRepository
import com.example.e4clinic.ui.core.BaseViewModel

class PharmaciesViewModel @ViewModelInject constructor(
    private val pharmaciesRepository: PharmaciesRepository
) : BaseViewModel() {
    private val _pharmacies: MutableLiveData<List<Pharmacy>> = MutableLiveData()
    val pharmacies: LiveData<List<Pharmacy>>
        get() = _pharmacies

    fun getPharmacies() {
        _pharmacies.value = pharmaciesRepository.getPharmacies().value
    }


}