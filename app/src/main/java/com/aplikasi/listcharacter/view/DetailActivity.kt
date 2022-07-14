package com.aplikasi.listcharacter.view

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aplikasi.listcharacter.databinding.ActivityDetailBinding
import com.aplikasi.listcharacter.model.Results
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        initToolbar()
        initView()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = null
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun initView() {
        var data = intent.getSerializableExtra("DATA") as Results

        Glide.with(this).load(data.image).into(binding.image)

        binding.txtName.text = "Name : ${data.name}"
        binding.txtLocation.text = "Location : ${data.location!!.name}"
        binding.txtGender.text = "Gender : ${data.gender}"
        binding.txtOrigin.text = "Origin : ${data.origin!!.name}"
        binding.txtTotalEpisode.text = "Episode : ${data.episode!!.size}"

    }

}