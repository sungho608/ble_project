package com.example.ble_project

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.example.ble_project.databinding.LightFirstBinding

class LightFirst : Fragment(){
    private var mBinding:LightFirstBinding?= null
    private val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = LightFirstBinding.inflate(inflater,container,false)

        binding.toggleDepth.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.toggleDepth.setThumbResource(R.drawable.switch_thumb_orange)
                binding.ivDepth.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvDepth.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.toggleDepth.setThumbResource(R.drawable.switch_thumb_white)
                binding.ivDepth.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvDepth.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleLightning.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.toggleLightning.setThumbResource(R.drawable.switch_thumb_orange)
                binding.ivLightning.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvLightning.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.toggleLightning.setThumbResource(R.drawable.switch_thumb_white)
                binding.ivLightning.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvLightning.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleCamera.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.toggleCamera.setThumbResource(R.drawable.switch_thumb_orange)
                binding.ivCamera.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvCamera.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.toggleCamera.setThumbResource(R.drawable.switch_thumb_white)
                binding.ivCamera.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvCamera.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleSync.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.toggleSync.setThumbResource(R.drawable.switch_thumb_orange)
                binding.ivSync.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvSync.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.toggleSync.setThumbResource(R.drawable.switch_thumb_white)
                binding.ivSync.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvSync.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.viewAlloff.setOnClickListener {
            binding.viewAlloff.isSelected = binding.viewAlloff.isSelected != true
            if(binding.viewAlloff.isSelected == true){
                binding.ivAlloff.setColorFilter(Color.parseColor("#5A67E7"))
                binding.tvOff.setTextColor(Color.parseColor("#5A67E7"))
            }else{
                binding.ivAlloff.setColorFilter(Color.parseColor("#E0E0E0"))
                binding.tvOff.setTextColor(Color.parseColor("#E0E0E0"))
            }
        }
        binding.viewAllendo.setOnClickListener {
            binding.viewAllendo.isSelected = binding.viewAllendo.isSelected != true
            if(binding.viewAllendo.isSelected == true){
                binding.ivAllendo.setColorFilter(Color.parseColor("#5A67E7"))
                binding.tvAllendo.setTextColor(Color.parseColor("#5A67E7"))
            }else{
                binding.ivAllendo.setColorFilter(Color.parseColor("#E0E0E0"))
                binding.tvAllendo.setTextColor(Color.parseColor("#E0E0E0"))
            }
        }
        binding.viewAllon.setOnClickListener {
            binding.viewAllon.isSelected = binding.viewAllon.isSelected != true
            if(binding.viewAllon.isSelected == true){
                binding.ivAllon.setColorFilter(Color.parseColor("#5A67E7"))
                binding.tvAllon.setTextColor(Color.parseColor("#5A67E7"))
            }else{
                binding.ivAllon.setColorFilter(Color.parseColor("#E0E0E0"))
                binding.tvAllon.setTextColor(Color.parseColor("#E0E0E0"))
            }
        }


        return binding.root
    }

}