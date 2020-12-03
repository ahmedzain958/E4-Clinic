package com.example.e4clinic.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.Client
import com.example.e4clinic.repository.ClientsRepository
import com.example.e4clinic.ui.core.BaseViewModel

class CientViewModel @ViewModelInject constructor(
    private val clientsRepository: ClientsRepository
) : BaseViewModel() {
    private val _clients: MutableLiveData<List<Client>> = MutableLiveData()
    val clients: LiveData<List<Client>>
        get() = _clients

    fun getClients() {
        _clients.value = clientsRepository.getClients().value
    }
}