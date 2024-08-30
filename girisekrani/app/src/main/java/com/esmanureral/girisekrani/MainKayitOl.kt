package com.esmanureral.girisekrani

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmanureral.girisekrani.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    lateinit var binding: ActivityMainKayitOlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main_kayit_ol)
        binding= ActivityMainKayitOlBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //Kaydet butonuna tıklandğında
        binding.btnKaydet.setOnClickListener {
            var kullaniciBilgisi=binding.kayitKullaniciAdi.text.toString()
            var kullaniciParola=binding.kayitParola.text.toString()


            //bilgiler.xml dosyasına kaydediyor.
            var sharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)

            //bilgileri ekleme,güncellemek ve silmek  için editor gerekiyor.
            var editor=sharedPreferences.edit()

            //veri eklemek
            editor.putString("Kullanıcı:","$kullaniciBilgisi").apply()
            editor.putString("Parola:","$kullaniciParola").apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı :)",Toast.LENGTH_LONG).show()
            //Kayıt edildiğinde "Kayıt Başarılı :)" mesajını verir.LENGHT_LONG : mesajın
            //ekranda uzun kalmasını sağlar.
            binding.kayitKullaniciAdi.text.clear()
            binding.kayitParola.text.clear()







        }






        binding.btnGiriseDon.setOnClickListener {
            //girişe dön butonuna tıklandıpında MainActivity açılacak.
            intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }



    }
}