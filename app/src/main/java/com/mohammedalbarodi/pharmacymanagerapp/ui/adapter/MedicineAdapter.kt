package com.mohammedalbarodi.pharmacymanagerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohammedalbarodi.pharmacymanagerapp.R
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine

class MedicineAdapter(
    private val onItemClick: ((Medicine) -> Unit)? = null
) : ListAdapter<Medicine, MedicineAdapter.MedicineViewHolder>(MedicineDiffCallback()) {

    inner class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvMedicineName)
        val tvCompany: TextView = itemView.findViewById(R.id.tvMedicineCompany)
        val tvPrice: TextView = itemView.findViewById(R.id.tvMedicinePrice)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvMedicineQuantity)

        init {
            itemView.setOnClickListener {
                val medicine = getItem(adapterPosition)
                onItemClick?.invoke(medicine)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = getItem(position)
        holder.tvName.text = medicine.name
        holder.tvCompany.text = medicine.company
        holder.tvPrice.text = String.format("%.2f", medicine.price)
        holder.tvQuantity.text = medicine.quantity.toString()
    }

    class MedicineDiffCallback : DiffUtil.ItemCallback<Medicine>() {
        override fun areItemsTheSame(oldItem: Medicine, newItem: Medicine): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Medicine, newItem: Medicine): Boolean {
            return oldItem == newItem
        }
    }
}
