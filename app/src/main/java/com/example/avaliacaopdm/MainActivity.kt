package com.example.avaliacaopdm

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.avaliacaopdm.databinding.ActivityABinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListerners()
        getExtra()
    }

    private fun initListerners(){
        binding.button.setOnClickListener {
            val intent = Intent(this,ActivityB::class.java)
            intent.putExtra("msg", "Activity A para B")
            startActivity(intent)
        }
    }

    private fun getExtra(){
        if(intent.hasExtra("msg")){
            val msg: String = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra("msg", String::class.java) as String
            } else {
                intent.getSerializableExtra("msg") as String
            }

            val result = msg
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show()
        }
    }
}