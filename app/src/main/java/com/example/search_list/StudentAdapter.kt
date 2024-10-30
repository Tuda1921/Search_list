package com.example.search_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private var students: List<SinhVien>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentName: TextView = view.findViewById(R.id.studentName)
        val studentId: TextView = view.findViewById(R.id.studentId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.studentName.text = student.name
        holder.studentId.text = student.number
    }

    override fun getItemCount() = students.size

    // Hàm để cập nhật danh sách
    fun updateList(newList: List<SinhVien>) {
        students = newList
        notifyDataSetChanged()
    }
}
