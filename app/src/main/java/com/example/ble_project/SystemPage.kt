package com.example.ble_project

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.ble_project.databinding.SystemPageBinding

class SystemPage : AppCompatActivity(){
    private var mBinding: SystemPageBinding? = null
    private val binding get() = mBinding!!
    private var brightNum: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = SystemPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var decorView = window.decorView
        var uiOption = window.decorView.systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) uiOption = uiOption or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) uiOption = uiOption or View.SYSTEM_UI_FLAG_FULLSCREEN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) uiOption = uiOption or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        decorView.setSystemUiVisibility(uiOption)

        binding.lightCountUp.setOnClickListener(View.OnClickListener {
            if(brightNum < 5){
                brightNum++
                binding.tvLightCount.text = brightNum.toString()
            }
        })

        binding.lightCountDown.setOnClickListener(View.OnClickListener {
            if(brightNum > 1){
                brightNum--
                binding.tvLightCount.text = brightNum.toString()
            }
        })

        binding.toggleCamera.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.toggleCamera.setThumbResource(R.drawable.switch_thumb_orange)
                binding.tvCameraOn.visibility = View.VISIBLE
                binding.tvCameraOff.visibility = View.INVISIBLE
            } else {
                binding.toggleCamera.setThumbResource(R.drawable.switch_thumb_white)
                binding.tvCameraOn.visibility = View.INVISIBLE
                binding.tvCameraOff.visibility = View.VISIBLE
            }
        })

        binding.toggleAutoIlluminance.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.toggleAutoIlluminance.setThumbResource(R.drawable.switch_thumb_orange)
                binding.tvAutoIlluminanceOn.visibility = View.VISIBLE
                binding.tvAutoIlluminanceOff.visibility = View.INVISIBLE
            } else {
                binding.toggleAutoIlluminance.setThumbResource(R.drawable.switch_thumb_white)
                binding.tvAutoIlluminanceOn.visibility = View.INVISIBLE
                binding.tvAutoIlluminanceOff.visibility = View.VISIBLE
            }
        })

    }
}