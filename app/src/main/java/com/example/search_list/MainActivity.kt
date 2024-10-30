package com.example.search_list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class SinhVien(
    val number: String,
    val name: String
)

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private lateinit var studentList: List<SinhVien>
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo danh sách sinh viên
        studentList = listOf(SinhVien("20190001", "Nguyen Van A"),
            SinhVien("20190002", "Tran Thi B"),
            SinhVien("20190003", "Le Van C"),
            SinhVien("20190004", "Pham Minh D"),
            SinhVien("20190005", "Nguyen Thi E"),
            SinhVien("20200001", "Nguyen Van F"),
            SinhVien("20200002", "Tran Thi G"),
            SinhVien("20200003", "Le Van H"),
            SinhVien("20200004", "Pham Minh I"),
            SinhVien("20200005", "Nguyen Thi J"),
            SinhVien("20210001", "Nguyen Van K"),
            SinhVien("20210002", "Tran Thi L"),
            SinhVien("20210003", "Le Van M"),
            SinhVien("20210004", "Pham Minh N"),
            SinhVien("20210005", "Nguyen Thi O"),
            SinhVien("20220001", "Nguyen Van P"),
            SinhVien("20220002", "Tran Thi Q"),
            SinhVien("20220003", "Le Van R"),
            SinhVien("20220004", "Pham Minh S"),
            SinhVien("20225605", "Nguyen Tuan Dat"),
            SinhVien("20230001", "Nguyen Van U"),
            SinhVien("20230002", "Tran Thi V"),
            SinhVien("20230003", "Le Van W"),
            SinhVien("20230004", "Pham Minh X"),
            SinhVien("20230005", "Nguyen Thi Y"),

            // Thêm sinh viên khác nếu cần
        )

        editText = findViewById(R.id.Number)
        recyclerView = findViewById(R.id.listView)

        // Khởi tạo RecyclerView và Adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter(studentList)
        recyclerView.adapter = adapter

        // Thêm TextWatcher cho ô tìm kiếm
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchStudents(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // Hàm tìm kiếm sinh viên
    private fun searchStudents(query: String) {
        val filteredList = if (query.length > 2) {
            studentList.filter {
                it.name.contains(query, ignoreCase = true) || it.number.contains(query, ignoreCase = true)
            }
        } else {
            studentList
        }

        adapter.updateList(filteredList)
    }
}
