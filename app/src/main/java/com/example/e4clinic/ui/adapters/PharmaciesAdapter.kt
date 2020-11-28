package com.example.e4clinic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.Pharmacy
import kotlinx.android.synthetic.main.clinic_visit_item.view.txt_address
import kotlinx.android.synthetic.main.clinic_visit_item.view.txt_status
import kotlinx.android.synthetic.main.clinic_visit_item.view.txt_visit_time
import kotlinx.android.synthetic.main.pharmacy_visit_item.view.*

class PharmaciesAdapter : RecyclerView.Adapter<PharmaciesAdapter.PharmaciesViewHolder>() {
    private val mPharmacies = ArrayList<Pharmacy>()

    class PharmaciesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pharmacy: Pharmacy) {
            itemView.txt_pharmacy_name.text = pharmacy.pharmacyName
            itemView.txt_visit_time.text = pharmacy.visitTime
            itemView.txt_address.text = pharmacy.address
            itemView.txt_status.text = pharmacy.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmaciesViewHolder =
        PharmaciesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.pharmacy_visit_item, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PharmaciesViewHolder, position: Int) =
        holder.bind(mPharmacies[position])


    override fun getItemCount(): Int = mPharmacies.size
    fun setItems(pharmaciesList: List<Pharmacy>) {
        this.mPharmacies.clear()
        this.mPharmacies.addAll(pharmaciesList)
        notifyDataSetChanged()
    }
}