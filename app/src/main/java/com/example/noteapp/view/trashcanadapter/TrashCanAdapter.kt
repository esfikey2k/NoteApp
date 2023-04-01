package com.example.noteapp.view.trashcanadapter


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Delete
import com.example.noteapp.R
import com.example.noteapp.databinding.RecyclerviewRowBinding
import com.example.noteapp.view.room.DeletedNote
import com.example.noteapp.view.room.Note
import com.example.noteapp.view.room.NoteDAO
import com.example.noteapp.view.room.NoteDB




class TrashCanAdapter(val deleteArrayList: ArrayList<DeletedNote>): RecyclerView.Adapter<TrashCanViewHolder>() {

    private lateinit var noteDao: NoteDAO

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrashCanViewHolder {
        val binding= RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TrashCanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return deleteArrayList.size
    }

    override fun onBindViewHolder(holder: TrashCanViewHolder, position: Int) {
        holder.binding.textViewNote.text= deleteArrayList[position].deletedNoteDescription
        holder.binding.textViewTitle.text= deleteArrayList[position].deletedNoteTitle
        holder.binding.textViewDate.text= deleteArrayList[position].deletedNoteDate

        holder.binding.recyclerCardView.setOnClickListener {
            val dialogBinding= LayoutInflater.from(holder.itemView.context).inflate(R.layout.custom_dialog,holder.binding.root,false)
            val myDialog= Dialog(holder.itemView.context)
            myDialog.setContentView(dialogBinding)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()

            val buttonYes= dialogBinding.findViewById<Button>(R.id.buttonYes)
            val buttonNo= dialogBinding.findViewById<Button>(R.id.buttonNo)


            buttonYes.setOnClickListener {

                val noteDb = NoteDB.getInstance(holder.itemView.context)
                noteDao= noteDb.noteDao

                noteDao.insert(
                    Note(
                        noteDescription = deleteArrayList[position].deletedNoteDescription,
                        noteTitle = deleteArrayList[position].deletedNoteTitle,
                        noteDate = deleteArrayList[position].deletedNoteDate
                    )
                )

                noteDao.deletedDelete(
                    DeletedNote(
                        deletedNoteId = deleteArrayList[position].deletedNoteId,
                        deletedNoteDescription = deleteArrayList[position].deletedNoteDescription,
                        deletedNoteTitle = deleteArrayList[position].deletedNoteTitle,
                        deletedNoteDate = deleteArrayList[position].deletedNoteDate
                    )
                )

                deleteArrayList.removeAt(holder.adapterPosition)
                notifyDataSetChanged()
                myDialog.dismiss()

            }

            buttonNo.setOnClickListener {
                myDialog.dismiss()
            }

        }

        holder.binding.recyclerCardView.setOnLongClickListener {

            val noteDb = NoteDB.getInstance(holder.itemView.context)
            noteDao= noteDb.noteDao
            val popupMenu: PopupMenu = PopupMenu(holder.itemView.context,holder.binding.recyclerCardView)
            popupMenu.menuInflater.inflate(R.menu.popup,popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->

                if (item.itemId == R.id.process_delete){

                    noteDao.deletedDelete(
                        DeletedNote(
                            deletedNoteId = deleteArrayList[position].deletedNoteId,
                            deletedNoteDescription = deleteArrayList[position].deletedNoteDescription,
                            deletedNoteDate = deleteArrayList[position].deletedNoteDate,
                            deletedNoteTitle = deleteArrayList[position].deletedNoteTitle
                        )
                    )

                    deleteArrayList.removeAt(holder.adapterPosition)
                    notifyDataSetChanged()

                }
                true
            })
            true
        }
    }
}