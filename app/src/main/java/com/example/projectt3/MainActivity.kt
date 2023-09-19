package com.example.projectt3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var inputPanjang: EditText
    private lateinit var hasil: TextView
    private lateinit var btn: Button

    companion object {
        private const val HASIL = "hasil"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputPanjang = findViewById(R.id.ippanjang)
        inputLebar = findViewById(R.id.iplebar)
        inputTinggi = findViewById(R.id.iptinggi)
        btn = findViewById(R.id.btn_hitung)
        hasil = findViewById(R.id.hasil)
        btn.setOnClickListener(::onClick)

        if (savedInstanceState != null) {
            val textResult = savedInstanceState.getString(HASIL)
            hasil.text = textResult
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(HASIL, hasil.text.toString())
    }

    fun onClick(view: View?) {
        if (view?.id == R.id.btn_hitung) {
            val panjang = inputPanjang.text.toString().trim()
            val lebar = inputLebar.text.toString().trim()
            val tinggi = inputTinggi.text.toString().trim()
            var check = false


            if(panjang.isEmpty()){
                check = true
                inputPanjang.error = "Wajib di isi"
            }
            if(lebar.isEmpty()){
                check = true
                inputLebar.error = "Wajib di isi"
            }
            if(tinggi.isEmpty()){
                check = true
                inputTinggi.error = "Wajib di isi"
            }
            if(!check){
                val volume = panjang.toDouble()*lebar.toDouble()*tinggi.toDouble()
                hasil.text = volume.toString() + " cm"
            }else{
                hasil.text = "Hasil eror, Silahkan isi semua kolom!"
            }
        }
    }
}
