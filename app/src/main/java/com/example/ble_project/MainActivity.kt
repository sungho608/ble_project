package com.example.ble_project

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSeekBar
import com.example.ble_project.databinding.ActivityMainBinding
import java.text.DecimalFormat


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
                binding.tvBrightNum.setText(brightNum.toString() + "")
            }
        })

        binding.btnBrightDown.setOnClickListener(View.OnClickListener {
            if(brightNum > 0){
                brightNum--
                binding.tvBrightNum.setText(brightNum.toString() + "")
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