package com.geek.sampletoolbaranimation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.sampletoolbaranimation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val animation = AnimationUtils.loadAnimation(this,R.anim.search_explode).apply {
            duration = 400
            interpolator = AccelerateInterpolator()
        }
        val deExplodeAnimation = AnimationUtils.loadAnimation(this,R.anim.de_explode).apply {
            duration = 600
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.searchBtn.setOnClickListener {
            binding.searchBtn.visibility = View.GONE
            binding.SearchView.startAnimation(animation){
                binding.SearchView.visibility = View.VISIBLE
            }
        }

        binding.backBtn.setOnClickListener {
            binding.SearchView.startAnimation(deExplodeAnimation){
                binding.SearchView.visibility = View.GONE
                binding.searchBtn.visibility = View.VISIBLE
            }
        }
    }
}