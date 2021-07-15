package com.example.ble_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ble_project.databinding.ActivityFirstPageBinding

class FirstPageActivity : AppCompatActivity() {
    private var mBinding: ActivityFirstPageBinding?= null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelectProduct.setOnClickListener {
            val intent:Intent = Intent(this,MainActivity::class.java)
            intent.putExtra("firstFrag",0)
            startActivity(intent)
        }
        binding.btnSelectProduct2.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("secondFrag",1)
            startActivity(intent)

        }
        binding.ibtnSetting.setOnClickListener {
            val intent = Intent(this,SystemPage::class.java)
            startActivity(intent)
        }

    }
}