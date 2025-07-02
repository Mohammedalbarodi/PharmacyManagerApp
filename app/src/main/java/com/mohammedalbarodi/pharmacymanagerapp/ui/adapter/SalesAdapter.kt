package com.mohammedalbarodi.pharmacymanagerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammedalbarodi.pharmacymanagerapp.R
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Sale
import java.text.SimpleDateFormat
import java.util.*

class SalesAdapter(
    private var salesList: List<Sale>,
    private val onItemClick: ((Sale) -> Unit)? = null
) : RecyclerView.Adapter<SalesAdapter.SaleViewHolder>() {

    inner class SaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMedicineName: TextView = itemView.findViewById(R.id.tvSaleMedicineName)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvSaleQuantity)
        val tvTotalPrice: TextView = itemView.findViewById(R.id.tvSaleTotalPrice)
        val tvDate: TextView = itemView.findViewById(R.id.tvSaleDate)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(salesList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sale, parent, false)
        return SaleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SaleViewHolder, position: Int) {
        val sale = salesList[position]

        holder.tvMedicineName.text = sale.medicineName
        holder.tvQuantity.text = sale.quantity.toString()
        holder.tvTotalPrice.text = String.format("%.2f", sale.totalPrice)

        // تحويل التاريخ إلى صيغة قابلة للقراءة
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        holder.tvDate.text = sdf.format(Date(sale.date))
    }

    override fun getItemCount(): Int = salesList.size

    fun updateData(newSales: List<Sale>) {
        salesList = newSales
        notifyDataSetChanged()
    }
}
