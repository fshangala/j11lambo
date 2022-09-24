package com.example.j11lambo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.j11menu,menu)

        //model!!.connected.observe(this){
        //    if (it){
        //        menu.getItem(1).setIcon(R.mipmap.reset_green_round)
        //    } else {
        //        menu.getItem(1).setIcon(R.mipmap.reset_red_round)
        //    }
        //}

        return super.onCreateOptionsMenu(menu)
    }
}