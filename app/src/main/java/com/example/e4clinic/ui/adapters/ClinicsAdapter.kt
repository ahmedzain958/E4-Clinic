package com.example.e4clinic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.Clinic
import kotlinx.android.synthetic.main.clinic_visit_item.view.*

class ClinicsAdapter(private val mClinics: List<Clinic>) :
    RecyclerView.Adapter<ClinicsAdapter.ClinicsViewHolder>() {


    class ClinicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(clinic: Clinic) {
            itemView.txt_doctor_name.text = clinic.doctorName
            itemView.txt_visit_time.text = clinic.visitTime
            itemView.txt_address.text = clinic.address
            itemView.txt_status.text = clinic.status
            itemView.txt_status.text = clinic.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicsViewHolder =
        ClinicsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.clinic_visit_item, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ClinicsViewHolder, position: Int) =
        holder.bind(mClinics[position])


    override fun getItemCount(): Int = mClinics.size
}