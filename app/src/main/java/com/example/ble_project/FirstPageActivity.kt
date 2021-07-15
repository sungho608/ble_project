package com.example.ble_project

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ble_project.databinding.ActivityFirstPageBinding

class FirstPageActivity : AppCompatActivity() {
    private var mBinding: ActivityFirstPageBinding?= null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var decorView = window.decorView
        var uiOption = window.decorView.systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) uiOption = uiOption or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) uiOption = uiOption or View.SYSTEM_UI_FLAG_FULLSCREEN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) uiOption = uiOption or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        decorView.setSystemUiVisibility(uiOption)


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