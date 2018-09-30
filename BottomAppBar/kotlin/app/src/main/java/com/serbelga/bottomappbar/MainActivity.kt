package com.serbelga.bottomappbar

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottomAppBar)
        initListeners()
    }

    private fun initListeners() {
        switchScreenButton.setOnClickListener {
            fab.hide(object : FloatingActionButton.OnVisibilityChangedListener(){
                override fun onShown(fab: FloatingActionButton?) {
                    super.onShown(fab)
                }

                override fun onHidden(fab: FloatingActionButton?) {
                    super.onHidden(fab)
                    textView.text = "Secondary screen"
                    bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                    bottomAppBar.replaceMenu(R.menu.bottomappbar_menu_secondary)
                    fab?.setImageDrawable(getDrawable(R.drawable.ic_twotone_check_24px))
                    fab?.show()
                }
            })
            bottomAppBar.navigationIcon = null
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu_primary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> toast("Menu clicked!")
            R.id.search -> toast("Search clicked!")
        }
        return true
    }

    fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }
}
