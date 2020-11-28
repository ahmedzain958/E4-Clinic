package com.example.e4VideoCall.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e4clinic.models.VideoCall
import javax.inject.Inject

class VideoCallsRepository @Inject constructor() {
    fun getVideoCalls(): LiveData<List<VideoCall>> {
        val VideoCallsList = arrayListOf(
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
        val liveData: MutableLiveData<List<VideoCall>> = MutableLiveData<List<VideoCall>>(VideoCallsList)
        return liveData
    }
}