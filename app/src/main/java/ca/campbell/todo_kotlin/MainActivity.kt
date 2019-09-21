package ca.campbell.todo_kotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ca.campbell.ca.campbell.todo_kotlin.view.main.RecyclerListAdapter
import ca.campbell.tudo_kotlin.model.ToDoItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() =
        // rvTodo is R.id.rvTodo from layout/content_main.xml
        with(rvTodo) {
            adapter = RecyclerListAdapter(sampleDataSetup())  // populate
            layoutManager = LinearLayoutManager(this@MainActivity)   // items LinearLayout
            itemAnimator = DefaultItemAnimator()      // layout niceties (optional)
            addItemDecoration(
                DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            )
        }

    private fun sampleDataSetup() = mutableListOf(
        ToDoItem("Walk the lizard"),
        ToDoItem("Shave the Yak."),
        ToDoItem("Comb the yard."),
        ToDoItem("Win the lottery."))

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
