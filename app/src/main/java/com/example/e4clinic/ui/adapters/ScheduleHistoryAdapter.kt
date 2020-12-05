package com.example.e4clinic.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.Clinic
import com.example.e4clinic.models.Pharmacy
import com.example.e4clinic.models.VideoCall
import kotlinx.android.synthetic.main.clinic_visit_item.view.*
import kotlinx.android.synthetic.main.clinic_visit_item.view.cardview_feedback
import kotlinx.android.synthetic.main.clinic_visit_item.view.txt_address
import kotlinx.android.synthetic.main.clinic_visit_item.view.txt_doctor_name
import kotlinx.android.synthetic.main.clinic_visit_item.view.txt_status
import kotlinx.android.synthetic.main.clinic_visit_item.view.txt_visit_time
import kotlinx.android.synthetic.main.pharmacy_visit_item.view.*
import kotlinx.android.synthetic.main.pharmacy_visit_item.view.btn_cancel
import kotlinx.android.synthetic.main.video_call_item.view.*

class ScheduleHistoryAdapter(private val feedbackSummaryOnClickListener: FeedbackSummaryOnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val mScheduleHistoryList = ArrayList<Any>()
    val CLINIC_TYPE: Int = 0
    val PHARMACY_TYPE: Int = 1
    val VIDEO_CALL_TYPE: Int = 2

    interface FeedbackSummaryOnClickListener {
        fun onClickedFeedback(any: Any)
    }

    class VideoCallsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(videoCall: VideoCall) {
            itemView.txt_doctor_name.text = videoCall.doctorName
            itemView.txt_visit_time.text = videoCall.visitTime
            itemView.txt_status.text = videoCall.status

        }
    }

    class PharmaciesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnCancel = itemView.btn_cancel
        val cardViewFeedback = itemView.cardview_feedback
        val btnFeedbackSummary = itemView.btn_pharmacy_feedback_summary
        fun bind(pharmacy: Pharmacy) {
            itemView.txt_pharmacy.text = pharmacy.pharmacyName
            itemView.txt_visit_time.text = pharmacy.visitTime
            itemView.txt_address.text = pharmacy.address
            itemView.txt_status.text = pharmacy.status
            btnCancel.visibility = View.GONE
            cardViewFeedback.visibility = View.GONE
            btnFeedbackSummary.visibility = View.VISIBLE
        }
    }

    class ClinicsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val txtDoctorName = itemView.txt_doctor_name
        val txtVisitTime = itemView.txt_visit_time
        val txtAddress = itemView.txt_address
        val txtStatus = itemView.txt_status
        val cardViewFeedback = itemView.cardview_feedback
        val btnFeedbackSummary = itemView.btn_clinic_feedback_summary

        fun bind(clinic: Clinic) {
            txtDoctorName.text = clinic.doctorName
            txtVisitTime.text = clinic.visitTime
            txtAddress.text = clinic.address
            txtStatus.text = clinic.status
            cardViewFeedback.visibility = View.GONE
            btnFeedbackSummary.visibility = View.VISIBLE
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (mScheduleHistoryList[position] is Clinic) {
            return CLINIC_TYPE
        } else if (mScheduleHistoryList[position] is Pharmacy) {
            return PHARMACY_TYPE
        } else {
            return VIDEO_CALL_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            CLINIC_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.clinic_visit_item, parent, false)
                return ClinicsViewHolder(
                    view
                )
            }
            PHARMACY_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.pharmacy_visit_item, parent, false)
                return PharmaciesViewHolder(
                    view
                )
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.video_call_item, parent, false)
                return VideoCallsViewHolder(
                    view
                )
            }
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == CLINIC_TYPE) {
            val clinic = mScheduleHistoryList[position] as Clinic
            val clinicViewHolder = holder as ClinicsViewHolder
            clinicViewHolder.btnFeedbackSummary.setOnClickListener {
                feedbackSummaryOnClickListener.onClickedFeedback(clinic)
            }
            return clinicViewHolder.bind(clinic)
        } else if (getItemViewType(position) == PHARMACY_TYPE) {
            val pharmacy = mScheduleHistoryList[position] as Pharmacy
            val pharmaciesViewHolder = holder as PharmaciesViewHolder
            pharmaciesViewHolder.btnFeedbackSummary.setOnClickListener {
                feedbackSummaryOnClickListener.onClickedFeedback(pharmacy)
            }
            return pharmaciesViewHolder.bind(pharmacy)
        } else {
            val videoCall = mScheduleHistoryList[position] as VideoCall
            return (holder as VideoCallsViewHolder).bind(videoCall)
        }
    }

    override fun getItemCount(): Int = mScheduleHistoryList.size
    fun setItems(ScheduleHistoryList: List<Any>) {
        this.mScheduleHistoryList.clear()
        this.mScheduleHistoryList.addAll(ScheduleHistoryList)
        notifyDataSetChanged()
    }
}