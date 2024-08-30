package com.esmanureral.girisekrani

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmanureral.girisekrani.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences //bu tanımlama sayesinde MainKayıtOl classında yaptığımız
    //bilgiler.xml ine ulaşabiliriz.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)//Artık erişebiliriz.


        binding.btnGirisYap.setOnClickListener {
            if(binding.girisKullaniciAdi.text.isNotEmpty()&& binding.girisParola.text.isNotEmpty()){
                var kayitliKullanici=preferences.getString("Kullanıcı:","")
                var kayitliParola=preferences.getString("Parola:","")


                //Karşılaştırma yapacağımız için ilk Kayıt Ol clasımızdaki bilgileri değişkene attık.
                var girisKullanici=binding.girisKullaniciAdi.text.toString()
                var girisParola=binding.girisParola.text.toString()

                if((kayitliKullanici==girisKullanici)&&(kayitliParola==girisParola)){

                    //giriş yap butonuna tıklandığında ve girilen bilgiler
                    // uyuştuğunda MainHosgeliniz sınıfın tasarımı açılacak.
                    intent= Intent(applicationContext,MainHosgeldiniz::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext,"Giriş Bilgileri Hatalı :(",Toast.LENGTH_LONG).show()
                }

            }
            else{
                Toast.makeText(applicationContext,"Gerekli bilgileri giriniz.",Toast.LENGTH_LONG).show()
            }
        }

        binding.btnKayitOl.setOnClickListener {
            //kayıt ol butonuna tıklandığında MainKayitOl sınıfın tasarımı açılacak.
            intent=Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        }
    }
}