package com.example.te

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.te.api.Person

class PersonAdapter(private var people: List<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImage: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        val nameText: TextView = itemView.findViewById(R.id.textViewName)
        val emailText: TextView = itemView.findViewById(R.id.textViewEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        val fullName = "${person.firstName ?: ""} ${person.lastName ?: ""}".trim()
        holder.nameText.text = fullName
        holder.emailText.text = person.email ?: ""
    }

    override fun getItemCount(): Int = people.size

    fun updateData(newPeople: List<Person>) {
        people = newPeople
        notifyDataSetChanged()
    }

}
