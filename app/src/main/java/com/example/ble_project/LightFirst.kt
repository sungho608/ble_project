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
<<<<<<< HEAD
                binding.toggleDepth.setSwitchTextAppearance(activity, R.style.SwitchTextAppearance)

                binding.ivDepth.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvDepth.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.toggleDepth.setSwitchTextAppearance(activity, R.style.SwitchTextAppearance2)
=======
                binding.depthOn.visibility = View.VISIBLE
                binding.depthOff.visibility = View.INVISIBLE
                binding.ivDepth.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvDepth.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.depthOn.visibility = View.INVISIBLE
                binding.depthOff.visibility = View.VISIBLE
>>>>>>> 37c5e07c2459eabff31790c57462269bd3a93f1a
                binding.ivDepth.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvDepth.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleLightning.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.ivLightning.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvLightning.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.ivLightning.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvLightning.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleCamera.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.ivCamera.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvCamera.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.ivCamera.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvCamera.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        binding.toggleSync.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, _ ->
            if(buttonView.isChecked){
                binding.ivSync.setColorFilter(Color.parseColor("#0066ff"))
                binding.tvSync.setTextColor(Color.parseColor("#0066ff"))
            } else {
                binding.ivSync.setColorFilter(Color.parseColor("#cccccc"))
                binding.tvSync.setTextColor(Color.parseColor("#cccccc"))
            }
        })

        return binding.root
    }

}