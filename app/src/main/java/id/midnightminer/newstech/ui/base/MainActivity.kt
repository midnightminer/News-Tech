package id.midnightminer.newstech.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.midnightminer.newstech.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
