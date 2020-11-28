package com.example.e4clinic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.VideoCall
import kotlinx.android.synthetic.main.clinic_visit_item.view.*

class VideoCallsAdapter : RecyclerView.Adapter<VideoCallsAdapter.VideoCallsViewHolder>() {
    private val mVideoCalls = ArrayList<VideoCall>()

    class VideoCallsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(videoCall: VideoCall) {
            itemView.txt_doctor_name.text = videoCall.doctorName
            itemView.txt_visit_time.text = videoCall.visitTime
            itemView.txt_address.text = videoCall.address
            itemView.txt_status.text = videoCall.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoCallsViewHolder =
        VideoCallsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.video_call_item, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VideoCallsViewHolder, position: Int) =
        holder.bind(mVideoCalls[position])


    override fun getItemCount(): Int = mVideoCalls.size
    fun setItems(videocallsList: List<VideoCall>) {
        this.mVideoCalls.clear()
        this.mVideoCalls.addAll(videocallsList)
        notifyDataSetChanged()
    }
}