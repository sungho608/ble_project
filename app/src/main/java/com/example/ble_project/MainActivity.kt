package com.example.ble_project

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import com.example.ble_project.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    val max : Int = 5
    val min : Int = 1
    val step : Int = 1
    private var brightNum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBrightUp.setOnClickListener(View.OnClickListener {
            if(brightNum < 5){
                brightNum++
                binding.tvBrightnum.setText(brightNum.toString() + "")
            }
        })

        binding.btnBrightDown.setOnClickListener(View.OnClickListener {
            if(brightNum > 0){
                brightNum--
                binding.tvBrightnum.setText(brightNum.toString() + "")
            }
        })

        binding.btnLight1.setOnClickListener {
            binding.btnLight1.setBackgroundResource(R.drawable.btn_select_light)
            binding.btnLight1.setTextColor(Color.parseColor("#ffffff"))

            binding.btnLight2.setBackgroundResource(R.drawable.btn_not_selected_light)
            binding.btnLight2.setTextColor(Color.parseColor("#cccccc"))
            setFrag(1)
        }

        binding.btnLight2.setOnClickListener {
            binding.btnLight2.setBackgroundResource(R.drawable.btn_select_light)
            binding.btnLight2.setTextColor(Color.parseColor("#ffffff"))

            binding.btnLight1.setBackgroundResource(R.drawable.btn_not_selected_light)
            binding.btnLight1.setTextColor(Color.parseColor("#cccccc"))
            setFrag(2)
        }

        binding.toggleDepth.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(buttonView.isChecked == true){
                binding.toggleDepth.setTextColor(Color.parseColor("#ff8933"))
                binding.ivDepth.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvDepth.setTextColor(Color.parseColor("#0066ff"))
            } else {

                binding.ivDepth.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvDepth.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleLightning.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(buttonView.isChecked == true){
                binding.ivLightning.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvLightning.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.ivLightning.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvLightning.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleCamera.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(buttonView.isChecked == true){
                binding.ivCamera.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvCamera.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.ivCamera.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvCamera.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleSync.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(buttonView.isChecked == true){
                binding.ivSync.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvSync.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.ivSync.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvSync.setTextColor(Color.parseColor("#cccccc"))
            }
        })

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


    }

    private fun setFrag(fragNum : Int){
        val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
        when(fragNum){
            0->{ft.replace(R.id.frame1,LightFirst()).commit()}
            1->{ft.replace(R.id.frame2,LightSecond()).commit()}
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