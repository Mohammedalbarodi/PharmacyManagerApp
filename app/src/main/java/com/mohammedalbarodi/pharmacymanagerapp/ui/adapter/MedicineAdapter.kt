package com.mohammedalbarodi.pharmacymanagerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammedalbarodi.pharmacymanagerapp.R
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Medicine

class MedicineAdapter(
    private var medicinesList: List<Medicine>,
    private val onItemClick: ((Medicine) -> Unit)? = null
) : RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvMedicineName)
        val tvCompany: TextView = itemView.findViewById(R.id.tvMedicineCompany)
        val tvPrice: TextView = itemView.findViewById(R.id.tvMedicinePrice)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvMedicineQuantity)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(medicinesList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicinesList[position]
        holder.tvName.text = medicine.name
        holder.tvCompany.text = medicine.company
        holder.tvPrice.text = String.format("%.2f", medicine.price)
        holder.tvQuantity.text = medicine.quantity.toString()
    }

    override fun getItemCount(): Int = medicinesList.size

    fun updateData(newMedicines: List<Medicine>) {
        medicinesList = newMedicines
        notifyDataSetChanged()
    }
}
