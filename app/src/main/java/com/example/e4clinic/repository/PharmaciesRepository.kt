package com.example.e4clinic.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Clinic
import com.example.e4clinic.models.Pharmacy
import javax.inject.Inject

class PharmaciesRepository @Inject constructor() {
    fun getPharmacies(): LiveData<List<Pharmacy>> {
        val pharmaciesList = arrayListOf(
            Pharmacy(
                "El-ezaby Pharmacy",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "New"
            ),
            Pharmacy(
                "El-ezaby Pharmacy",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "New"
            ),
            Pharmacy(
                "El-ezaby Pharmacy",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "New"
            ),
            Pharmacy(
                "El-ezaby Pharmacy",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "New"
            )

        )
        val liveData: MutableLiveData<List<Pharmacy>> = MutableLiveData<List<Pharmacy>>(pharmaciesList)
        return liveData
    }
}