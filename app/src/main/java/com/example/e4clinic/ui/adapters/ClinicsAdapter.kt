package com.example.e4clinic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.Clinic
import kotlinx.android.synthetic.main.clinic_visit_item.view.*

class ClinicsAdapter(private val clinicsItemOnClickListener: ClinicsItemOnClickListener) :
    RecyclerView.Adapter<ClinicsAdapter.ClinicsViewHolder>() {
     val mClinics = ArrayList<Clinic>()

    interface ClinicsItemOnClickListener {
        fun onClickedClinic(clinic: Clinic)
    }

    class ClinicsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {


        fun bind(clinic: Clinic) {
            itemView.txt_doctor_name.text = clinic.doctorName
            itemView.txt_visit_time.text = clinic.visitTime
            itemView.txt_address.text = clinic.address
            itemView.txt_status.text = clinic.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.clinic_visit_item, parent, false)
        return ClinicsViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ClinicsAdapter.ClinicsViewHolder, position: Int) {
        holder.bind(mClinics[position])
        holder.itemView.setOnClickListener {
            clinicsItemOnClickListener.onClickedClinic(mClinics[position])
        }

    }


    override fun getItemCount(): Int = mClinics.size
    fun setItems(clinicsList: List<Clinic>) {
        this.mClinics.clear()
        this.mClinics.addAll(clinicsList)
        notifyDataSetChanged()
    }
}