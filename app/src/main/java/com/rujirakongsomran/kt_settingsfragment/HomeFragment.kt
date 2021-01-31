package com.rujirakongsomran.kt_settingsfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.rujirakongsomran.kt_settingsfragment.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fabSettings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        loadSettings()
    }

    private fun loadSettings() {
        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        val signature = sp.getString("signature", "")
        val reply = sp.getString("reply", "")
        val sync = sp.getBoolean("sync", true)
        val notification = sp.getBoolean("notifications", false)
        val volume = sp.getInt("volume_notification", 0)

        binding.tvSignature.text = "Signature: $signature"
        binding.tvReply.text = "Default reply: $reply"
        binding.tvSync.text = "Sync: $sync"
        binding.tvNotifications.text = "Disable notification: $notification"
        binding.pbVolume.setProgress(volume, true)
    }

}