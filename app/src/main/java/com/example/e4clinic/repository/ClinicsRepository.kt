package com.example.e4clinic.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Clinic
import javax.inject.Inject

class ClinicsRepository @Inject constructor() {
    fun getClinics(): LiveData<List<Clinic>> {
        val clinicsList = arrayListOf(
            Clinic(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            ),
            Clinic(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            ),
            Clinic(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            ),
            Clinic(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            )

        )
        val liveData: MutableLiveData<List<Clinic>> = MutableLiveData<List<Clinic>>(clinicsList)
        return liveData
    }
}