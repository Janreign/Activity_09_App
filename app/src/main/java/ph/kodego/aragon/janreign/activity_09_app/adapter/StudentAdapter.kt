package ph.kodego.aragon.janreign.activity_09_app.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.kodego.aragon.janreign.activity_09_app.dao.StudentDAO
import ph.kodego.aragon.janreign.activity_09_app.dao.StudentDAOSQLImpl
import ph.kodego.aragon.janreign.activity_09_app.databinding.StudentItemBinding
import ph.kodego.aragon.janreign.activity_09_app.model.Student

class StudentAdapter (var students: ArrayList<Student>, var activity: Activity)
    : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(),
    Filterable {

    var filteredStudents: List <Student> = ArrayList<Student>()
    var all_records = ArrayList<Student>()

    fun addStudent (student: Student){
        students.add(0,student)
        notifyItemInserted(0)
    }


    fun removeStudent(position: Int){
        students.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateStudents(newStudents: ArrayList<Student>) {
        students.clear()
        students.addAll(newStudents)
        notifyDataSetChanged()
    }

//    fun filterStudent(searchString: String){
//        var newSet = students.filter {it.lastName.contains(searchString)}
//        students.clear()
//        students.addAll(newSet)
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        return students.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewtype: Int
    ): StudentAdapter.StudentViewHolder {

        //new added code
        all_records.clear()
        all_records.addAll(students)

        val itemBinding = StudentItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return StudentViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder,
                                  position: Int){
        holder.bindStudent(students[position])
    }

    inner class StudentViewHolder(private val itemBinding: StudentItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        var student = Student()

        init {
            itemView.setOnClickListener(this)
        }

        fun bindStudent(student: Student) {
            this.student = student

            itemBinding.studentName.text = "${student.lastName}, ${student.firstName}"
//            itemBinding.btnDeleteRow.setOnClickListener {
//                Snackbar.make(
//                    itemBinding.root,
//                    "Delete by button",
//                    Snackbar.LENGTH_SHORT
//                ).show()
//                var dao: StudentDAO = StudentDAOSQLImpl(activity.applicationContext)
//                dao.deleteStudent(student.id)
//                removeStudent(adapterPosition)
//            }
//               itemBinding.placeholder.setImageResource(student.img)
        }
        override fun onClick(v: View?) {
            Snackbar.make(itemBinding.root,
                "${student.lastName}, ${student.firstName}",
                Snackbar.LENGTH_SHORT
            ).show()
//            removeStudent(adapterPosition)
//            customDialog()
//            showCustomDialogue().show()// to call custom dialog
        }
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}

/////////Dave code
//        @SuppressLint("NotifyDataSetChanged")
//        fun showCustomDialogue(): Dialog {
//            return activity?.let {
//                var customDialogBinding: DialogueUpdateStudentBinding =
//                    DialogueUpdateStudentBinding.inflate(activity.layoutInflater)
//                val builder = AlertDialog.Builder(it)
//
//                with(customDialogBinding) {
//                    studentLastnameUpdate.setText(student.lastName)
//                    studentFirstnameUpdate.setText(student.firstName)
//                }
//
//                with(builder){
//                    setView(customDialogBinding.root)
//                    setPositiveButton("Update",
//                        DialogInterface.OnClickListener { dialog, id -> //to sign in the user
//                            var dao:StudentDAO = StudentDAOSQLImpl(activity.applicationContext)// this code gives access to the database
//
//
//                            student.lastName = customDialogBinding.studentLastnameUpdate.text.toString()
//                            student.firstName = customDialogBinding.studentFirstnameUpdate.text.toString()
//                            dao.updateStudent(student.id, student)// to know who is the student
//
//                            updateStudents(dao.getStudents())
//                            notifyItemChanged(adapterPosition)
//                        })
//                    setNegativeButton("Cancel",
//                        DialogInterface.OnClickListener { dialog, id ->
////                              getDialog().Cancel()
//                        })
//
//                    builder.create()
//                }
//            } ?: throw IllegalStateException("Activity cannot be null")
//        }
//    }
//
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val searchString = constraint.toString()
//
//                if(searchString.trim().length == 0){
//                    all_records
//                }else {
//                    filteredStudents = students.filter {it.lastName.contains(searchString)}
//                }
//                return FilterResults().apply { values = filteredStudents }
//            }
//
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                filteredStudents = if (results!!.values == null) {
//                    all_records
//                    ArrayList()
//                }else {
//                    results.values as ArrayList<Student>
//                }
//                notifyDataSetChanged()
//            }
//        }
//    }
//}

