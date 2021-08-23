package com.example.projet2ad

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.projet2ad.databinding.ActivityFaqscrollingBinding

class FAQScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaqscrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("FAQ")
        binding = ActivityFaqscrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.FAQ.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}