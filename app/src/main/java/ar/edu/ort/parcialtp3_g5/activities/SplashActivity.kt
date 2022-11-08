package ar.edu.ort.parcialtp3_g5.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import ar.edu.ort.parcialtp3_g5.R
import android.content.Intent
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_TIME_OUT:Long = 2000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            , SPLASH_TIME_OUT)
    }

}