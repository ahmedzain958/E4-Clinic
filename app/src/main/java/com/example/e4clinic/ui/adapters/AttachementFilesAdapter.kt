package com.example.e4clinic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4clinic.R
import com.example.e4clinic.models.Client
import kotlinx.android.synthetic.main.attachement_file_layout.view.*
import kotlinx.android.synthetic.main.item_client_layout.view.*

class AttachementFilesAdapter(val mAttachementsList:List<Int> =
                                  listOf<Int>(R.drawable.img_user, R.drawable.img_user, R.drawable.img_user,R.drawable.img_user, R.drawable.img_user, R.drawable.img_user)) :
    RecyclerView.Adapter<AttachementFilesAdapter.AttachementFilesViewHolder>() {

    class AttachementFilesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(int: Int) {
            itemView.img_attachement.setBackgroundResource(int)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AttachementFilesAdapter.AttachementFilesViewHolder =
        AttachementFilesAdapter.AttachementFilesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.attachement_file_layout, parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: AttachementFilesAdapter.AttachementFilesViewHolder,
        position: Int
    ) =
        holder.bind(mAttachementsList[position])


    override fun getItemCount(): Int = mAttachementsList.size

}