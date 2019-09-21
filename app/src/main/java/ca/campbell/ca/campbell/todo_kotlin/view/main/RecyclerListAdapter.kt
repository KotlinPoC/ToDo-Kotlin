package ca.campbell.ca.campbell.todo_kotlin.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import ca.campbell.todo_kotlin.R
import ca.campbell.tudo_kotlin.model.ToDoItem
import kotlinx.android.synthetic.main.todo_item.*

/*
* RecyclerView will show to do items, users may add / remove
* so adapter carries a MutableList<ToDoItem> representing the data
* to be shown in the RecyclerView
 */
class RecyclerListAdapter (private val items: MutableList<ToDoItem>) :
        RecyclerView.Adapter<RecyclerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
    class ViewHolder(override val containerView: View) // override from layout container
      : RecyclerView.ViewHolder(containerView), LayoutContainer {

        /*     // ViewHolder stores views it needs, only calls findViewById() once
        val tvTitle = listItemView.findViewById(R.id.tvTitle) as TextView
        val cbDone = listItemView.findViewById(R.id.cbDone) as CheckBox

        fun bindItem(toDoItem: ToDoItem)  {
                // bind an item to the views
                tvTitle.text = toDoItem.title
                cbDone.isChecked =  false
            }
         */
        // using kotlinx. extensions don't need findViewById directly
        fun bindItem(toDoItem: ToDoItem) {
            tvTitle.text = toDoItem.title
            cbDone.isChecked = false
        }
    }

}