package com.tsmin.bottomnavi

import android.icu.text.IDNA.Info
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.tsmin.bottomnavi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationItemSelect()
    }

    private fun navigationItemSelect() {
        changeFragment(InfoFragment())
        binding.bottomNavigation.run {
            selectedItemId = R.id.info
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home -> changeFragment(HomeFragment())
                    R.id.info -> changeFragment(InfoFragment())
                    R.id.setting -> changeFragment(SettingFragment())
                }
                true
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}