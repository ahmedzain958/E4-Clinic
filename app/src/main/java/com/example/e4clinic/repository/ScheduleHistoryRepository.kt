package com.example.e4clinic.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Clinic
import com.example.e4clinic.models.Pharmacy
import com.example.e4clinic.models.VideoCall
import javax.inject.Inject

class ScheduleHistoryRepository @Inject constructor() {
    fun getScheduleHistory(): LiveData<List<Any>> {
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
        val videoCallsList = arrayListOf(
            VideoCall(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            ),
            VideoCall(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            ),
            VideoCall(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            ),
            VideoCall(
                "Ahmed Karim",
                "09:30 PM - 10:00 PM",
                "43 Nakhla moteey st , Nasr City",
                "Confirm"
            )

        )
        val list = concatenate(clinicsList, pharmaciesList, videoCallsList)
        val liveData: MutableLiveData<List<Any>> = MutableLiveData<List<Any>>(list)
        return liveData
    }

    fun <T> concatenate(vararg lists: List<T>): List<T> {
        return listOf(*lists).flatten()
    }
}