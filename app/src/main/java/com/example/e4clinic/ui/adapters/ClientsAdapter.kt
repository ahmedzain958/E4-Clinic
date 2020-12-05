package com.example.e4clinic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.Client
import kotlinx.android.synthetic.main.item_client_layout.view.*

class ClientsAdapter(private val onNewPlanClicked: () -> Unit) :
    RecyclerView.Adapter<ClientsAdapter.ClientsViewHolder>() {
    private val mClientsList = ArrayList<Client>()

    class ClientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(client: Client, onNewPlanClicked: () -> Unit) {
            itemView.txt_doctor_name.text = client.clientName
            itemView.locationTxt.text = client.clientCity
            itemView.doctorEmailTxt.text = client.email
            itemView.doctorPhoneTxt.text = client.mobile
            itemView.cardview_newPlane.setOnClickListener {
                onNewPlanClicked()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientsViewHolder =
        ClientsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_client_layout, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ClientsViewHolder, position: Int) =
        holder.bind(mClientsList[position], onNewPlanClicked)


    override fun getItemCount(): Int = mClientsList.size
    fun setItems(clientsList: List<Client>) {
        this.mClientsList.clear()
        this.mClientsList.addAll(clientsList)
        notifyDataSetChanged()
    }
}