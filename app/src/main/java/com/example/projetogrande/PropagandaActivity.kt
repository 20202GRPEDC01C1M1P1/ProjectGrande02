package com.example.projetogrande

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_propaganda.*

class PropagandaActivity : AppCompatActivity() {

    private lateinit var anuncioInter: InterstitialAd

    private fun requestNewInterstitial() {
        val adRequest = AdRequest.Builder().build()
        anuncioInter.loadAd(adRequest)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propaganda)

        MobileAds.initialize(this) {
        }

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        anuncioInter = InterstitialAd(this)
        anuncioInter.adUnitId = getString(R.string.interstitial_id)
        anuncioInter.adListener = object: AdListener(){
            override fun onAdClosed() {
                requestNewInterstitial()
            }
        }
        requestNewInterstitial()
    }
}