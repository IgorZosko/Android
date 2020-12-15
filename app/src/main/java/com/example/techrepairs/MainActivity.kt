package com.example.techrepairs

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.view.MenuItem
import android.view.Menu
import com.example.techrepairs.addtech.AddTechFragment
import com.example.techrepairs.techlist.TechListFragment
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        Timber.i("onCreate Called");
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main,  TechListFragment())
                    .commit();
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean  {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_tech -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, AddTechFragment()).commit()
            R.id.action_about -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, AboutFragment()).commit()
            R.id.terms_using -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, UsingTermsFragment()).commit()
        }
        return super.onOptionsItemSelected(item);
    }
}