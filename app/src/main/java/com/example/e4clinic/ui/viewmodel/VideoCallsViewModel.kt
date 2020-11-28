package com.example.e4clinic.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4VideoCall.repository.VideoCallsRepository
import com.example.e4clinic.models.VideoCall
import com.example.e4clinic.ui.core.BaseViewModel

class VideoCallsViewModel @ViewModelInject constructor(
    private val VideoCallsRepository: VideoCallsRepository
) : BaseViewModel() {
    private val _VideoCalls: MutableLiveData<List<VideoCall>> = MutableLiveData()
    val VideoCalls: LiveData<List<VideoCall>>
        get() = _VideoCalls

    fun getVideoCalls() {
        _VideoCalls.value = VideoCallsRepository.getVideoCalls().value
    }


}