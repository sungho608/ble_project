package com.example.ble_project

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.fragment.app.FragmentTransaction
import com.example.ble_project.databinding.ActivityMainBinding


class  MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    val max : Int = 5
    val min : Int = 1
    val step : Int = 1
    private var brightNum: Int = 1
    private var lightNum = 0

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var decorView = window.decorView
        var uiOption = window.decorView.systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) uiOption = uiOption or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) uiOption = uiOption or View.SYSTEM_UI_FLAG_FULLSCREEN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) uiOption = uiOption or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        decorView.setSystemUiVisibility(uiOption)

        binding.ibSetting.setOnClickListener {
            val intent = Intent(this, SystemPage::class.java)
            startActivity(intent)
        }

        if(intent.hasExtra("firstFrag")){
            lightNum = intent.getIntExtra("firstFrag",0)
        }else if(intent.hasExtra("secondFrag")){
            lightNum = intent.getIntExtra("secondFrag",1)
        }

        setFrag(lightNum)

        binding.seekbarBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                brightNum = progress + 1
                binding.tvBrightnum.text = brightNum.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        binding.btnBrightUp.setOnClickListener(View.OnClickListener {
            if(brightNum < 5){
                brightNum++
                binding.seekbarBrightness.progress = brightNum-1
                binding.tvBrightnum.text = brightNum.toString()
            }
        })

        binding.btnBrightDown.setOnClickListener(View.OnClickListener {
            if(brightNum > 1){
                brightNum--
                binding.seekbarBrightness.progress = brightNum-1
                binding.tvBrightnum.text = brightNum.toString()
            }
        })

        binding.btnLight1.setOnClickListener {
            setFrag(0)
            binding.btnLight1.setBackgroundResource(R.drawable.btn_select_light)
            var drawable1 = resources.getDrawable(R.drawable.ic_gp_product_pressed,theme)
            binding.btnLight1.setCompoundDrawablesWithIntrinsicBounds(drawable1,null,null,null)
            binding.btnLight1.setTextColor(Color.parseColor("#ffffff"))

            binding.btnLight2.setBackgroundResource(R.drawable.btn_not_selected_light)
            var drawable2 = resources.getDrawable(R.drawable.ic_gp_product,theme)
            binding.btnLight2.setCompoundDrawablesWithIntrinsicBounds(drawable2,null,null,null)
            binding.btnLight2.setTextColor(Color.parseColor("#cccccc"))
        }

        binding.btnLight2.setOnClickListener {
            setFrag(1)
            binding.btnLight2.setBackgroundResource(R.drawable.btn_select_light)
            var drawable1 = resources.getDrawable(R.drawable.ic_gp_product_pressed, theme)
            binding.btnLight2.setCompoundDrawablesWithIntrinsicBounds(drawable1, null, null, null)
            binding.btnLight2.setTextColor(Color.parseColor("#ffffff"))

            binding.btnLight1.setBackgroundResource(R.drawable.btn_not_selected_light)
            var drawable2 = resources.getDrawable(R.drawable.ic_gp_product, theme)
            binding.btnLight1.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, null, null)
            binding.btnLight1.setTextColor(Color.parseColor("#cccccc"))
        }


        setSeekBarMax(binding.seekbarBrightness,max)



        binding.btnOne.setOnClickListener {
            onButtonClick(0)
        }
        binding.btnTwo.setOnClickListener {
            onButtonClick(1)
        }
        binding.btnThree.setOnClickListener {
            onButtonClick(2)
        }
        binding.btnFour.setOnClickListener {
            onButtonClick(3)
        }

        binding.btnLightField1.setOnClickListener {
            binding.btnLightField1.isSelected = binding.btnLightField1.isSelected != true
        }
        binding.btnLightField2.setOnClickListener {
            binding.btnLightField2.isSelected = binding.btnLightField2.isSelected != true
        }
        binding.btnLightField3.setOnClickListener {
            binding.btnLightField3.isSelected = binding.btnLightField3.isSelected != true
        }

    }

    private fun setFrag(fragNum : Int){
        val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
        when(fragNum){
            0->{ft.replace(R.id.main_frame,LightFirst()).commit()}
            1->{ft.replace(R.id.main_frame,LightSecond()).commit()}
        }
    }

    fun setSeekBarMax(sb : AppCompatSeekBar, maxValue : Int) {
        sb.max = (maxValue-min)/step
    }

    fun onButtonClick(btnNum:Int){
        when(btnNum){
            0->{
                binding.btnOne.isSelected = binding.btnOne.isSelected != true
                binding.btnTwo.isSelected = false
                binding.btnThree.isSelected = false
                binding.btnFour.isSelected = false
            }
            1->{
                binding.btnTwo.isSelected = binding.btnTwo.isSelected != true
                binding.btnOne.isSelected = false
                binding.btnThree.isSelected = false
                binding.btnFour.isSelected = false
            }
            2->{
                binding.btnThree.isSelected = binding.btnThree.isSelected != true
                binding.btnTwo.isSelected = false
                binding.btnOne.isSelected = false
                binding.btnFour.isSelected = false
            }
            3->{
                binding.btnFour.isSelected = binding.btnFour.isSelected != true
                binding.btnTwo.isSelected = false
                binding.btnThree.isSelected = false
                binding.btnOne.isSelected = false
            }
        }
    }

}