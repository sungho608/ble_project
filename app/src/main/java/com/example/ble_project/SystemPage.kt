package com.example.ble_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ble_project.databinding.SystemPageBinding

class SystemPage : AppCompatActivity(){
    private var mBinding: SystemPageBinding? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = SystemPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}