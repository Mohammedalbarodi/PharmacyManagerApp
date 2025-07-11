package com.mohammedalbarodi.pharmacymanagerapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammedalbarodi.pharmacymanagerapp.R
import com.mohammedalbarodi.pharmacymanagerapp.data.model.User

class UsersAdapter(
    private var userList: List<User>,
    private val onItemClick: ((User) -> Unit)? = null
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUsername: TextView = itemView.findViewById(R.id.tvUsername)
        val tvRole: TextView = itemView.findViewById(R.id.tvUserRole)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(userList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvUsername.text = user.username
        holder.tvRole.text = user.role
    }

    override fun getItemCount(): Int = userList.size

    fun updateData(newUsers: List<User>) {
        userList = newUsers
        notifyDataSetChanged()
    }
}
