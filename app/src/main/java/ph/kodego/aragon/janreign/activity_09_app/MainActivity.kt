package ph.kodego.aragon.janreign.activity_09_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.aragon.janreign.activity_09_app.adapter.StudentAdapter
import ph.kodego.aragon.janreign.activity_09_app.dao.StudentDAO
import ph.kodego.aragon.janreign.activity_09_app.dao.StudentDAOSQLImpl
import ph.kodego.aragon.janreign.activity_09_app.databinding.ActivityMainBinding
import ph.kodego.aragon.janreign.activity_09_app.model.Student

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
private lateinit var studentAdapter: StudentAdapter
private var students: ArrayList<Student> = ArrayList()
private lateinit var itemTouchHelper: ItemTouchHelper
private lateinit var dao: StudentDAO

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    dao = StudentDAOSQLImpl(applicationContext) // OUTPUT when you run the app, the last line will be shown
    students = dao.getStudents()
    students = dao.getStudentsByLastNameAndFirstName("Marco","Valmores") //last line will be shown

    studentAdapter = StudentAdapter(students, this)
    binding.list.layoutManager = LinearLayoutManager(applicationContext)
//        binding.list.layoutManager = GridLayoutManager(applicationContext, 2)
    binding.list.adapter = studentAdapter

    students = dao.getStudents()
    studentAdapter.updateStudents(students)

}

fun init() {
    students.add(Student("Dave", "Navor", R.drawable.placeholder))
    students.add(Student("Victor", "Yu", R.drawable.placeholder))
    students.add(Student("JP", "Soriano", R.drawable.placeholder))
    students.add(Student("CJ", "Tronco", R.drawable.placeholder))
    students.add(Student("Rene", "Palma", R.drawable.placeholder))
    students.add(Student("Joni", "James", R.drawable.placeholder))
    students.add(Student("Janreign", "Aragon", R.drawable.placeholder))
    students.add(Student("John Rey", "Balais", R.drawable.placeholder))
    students.add(Student("James Nico", "Rara", R.drawable.placeholder))
    students.add(Student("Pat Ivee", "Lee", R.drawable.placeholder))
    students.add(Student("Rene", "Palma", R.drawable.placeholder))
    students.add(Student("Matthew", "Mottos", R.drawable.placeholder))
}

}

