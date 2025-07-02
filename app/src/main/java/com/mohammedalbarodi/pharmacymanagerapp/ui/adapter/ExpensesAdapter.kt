package com.mohammedalbarodi.pharmacymanagerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammedalbarodi.pharmacymanagerapp.R
import com.mohammedalbarodi.pharmacymanagerapp.data.model.Expense
import java.text.SimpleDateFormat
import java.util.*

class ExpensesAdapter(
    private var expensesList: List<Expense>,
    private val onItemClick: ((Expense) -> Unit)? = null
) : RecyclerView.Adapter<ExpensesAdapter.ExpenseViewHolder>() {

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDescription: TextView = itemView.findViewById(R.id.tvExpenseDescription)
        val tvAmount: TextView = itemView.findViewById(R.id.tvExpenseAmount)
        val tvDate: TextView = itemView.findViewById(R.id.tvExpenseDate)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(expensesList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expensesList[position]
        holder.tvDescription.text = expense.description
        holder.tvAmount.text = String.format("%.2f", expense.amount)

        // تنسيق التاريخ (مثلاً: 01-Jul-2025)
        val sdf = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        holder.tvDate.text = sdf.format(Date(expense.date))
    }

    override fun getItemCount(): Int = expensesList.size

    fun updateData(newExpenses: List<Expense>) {
        expensesList = newExpenses
        notifyDataSetChanged()
    }
}
