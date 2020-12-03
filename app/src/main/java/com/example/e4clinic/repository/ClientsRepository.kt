package com.example.e4clinic.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Client
import javax.inject.Inject

class ClientsRepository @Inject constructor() {
    fun getClients(): LiveData<List<Client>> {
        val pharmaciesList = arrayListOf(
            Client(
                "Ahmed Karim",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Karim Ahmed",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Ahmed Karim",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Karim Ahmed",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Ahmed Karim",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Karim Ahmed",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Ahmed Karim",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Karim Ahmed",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Ahmed Karim",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            ),
            Client(
                "Karim Ahmed",
                "El-Shrouq",
                "ahmed.karim@gmail.com",
                "022-100 200 5423"
            )
        )
        val liveData: MutableLiveData<List<Client>> =
            MutableLiveData<List<Client>>(pharmaciesList)
        return liveData
    }
}