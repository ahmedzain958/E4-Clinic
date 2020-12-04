package com.example.e4clinic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.Clinic
import kotlinx.android.synthetic.main.clinic_visit_item.view.*

class ClinicsAdapter(private val clinicsItemOnClickListener: ClinicsItemOnClickListener,
                     private val clinicsFeedbackOnClickListener: ClinicsFeedbackOnClickListener) :
    RecyclerView.Adapter<ClinicsAdapter.ClinicsViewHolder>() {
    val mClinics = ArrayList<Clinic>()

    interface ClinicsItemOnClickListener {
        fun onClickedClinic(clinic: Clinic)
    }
    interface ClinicsFeedbackOnClickListener {
        fun feedBack(clinic: Clinic)
    }
    class ClinicsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val txtDoctorName = itemView.txt_doctor_name
        val txtVisitTime = itemView.txt_visit_time
        val txtAddress = itemView.txt_address
        val txtStatus = itemView.txt_status
        val cardviewFeedback = itemView.cardview_feedback

        fun bind(clinic: Clinic) {
            txtDoctorName.text = clinic.doctorName
            txtVisitTime.text = clinic.visitTime
            txtAddress.text = clinic.address
            txtStatus.text = clinic.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.clinic_visit_item, parent, false)
        return ClinicsViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ClinicsViewHolder, position: Int) {
        holder.bind(mClinics[position])
        holder.txtDoctorName.setOnClickListener {
            clinicsItemOnClickListener.onClickedClinic(mClinics[position])
        }
        holder.cardviewFeedback.setOnClickListener {
            clinicsFeedbackOnClickListener.feedBack(mClinics[position])
        }
    }


    override fun getItemCount(): Int = mClinics.size
    fun setItems(clinicsList: List<Clinic>) {
        this.mClinics.clear()
        this.mClinics.addAll(clinicsList)
        notifyDataSetChanged()
    }
}