package com.esmanureral.girisekrani

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmanureral.girisekrani.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {
    lateinit var binding: ActivityMainHosgeldinizBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main_hosgeldiniz)
        binding= ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //xmlden veri çekme işlemi
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)

        var kayitliKullanici=preferences.getString("Kullanıcı:","")
        var kayitliParola=preferences.getString("Parola:","")

        //textviewlere kayıtlı olan bilgiler ekleniyor.

        binding.kullaniciBilgisi.text="Kullanıcı Adı:"+kayitliKullanici.toString()
        binding.kullaniciParola.text="Kullanıcı Parola:"+kayitliParola.toString()


        //Çıkış yap butonuna tıklandığında MainActivity sınıfının tasarımı açılır.
        binding.btnCikisYap.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()

        }


    }
}