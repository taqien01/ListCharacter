package com.aplikasi.listcharacter.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplikasi.listcharacter.R
import com.aplikasi.listcharacter.adapter.ListCharacterAdapter
import com.aplikasi.listcharacter.databinding.ActivityMainBinding
import com.aplikasi.listcharacter.model.Results
import com.aplikasi.listcharacter.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ListCharacterAdapter.Interface {

    lateinit var binding: ActivityMainBinding

    val vm: MainViewModel by viewModel()

    lateinit var adapter: ListCharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        initView()
        initObserver()
    }

    private fun initObserver() {
        vm.loadingEvent.observe(this, {
            if (it){
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
            }
        })

        vm.errorEvent.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        vm.listEvent.observe(this, {
            showList(it.results!!)
        })
    }

    private fun initView() {
        vm.getData()

        binding.rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    fun showList(list: List<Results>){
        //name, species, status
        adapter = ListCharacterAdapter(list)
        binding.rvList.adapter = adapter
        adapter.notifyDataSetChanged()
        adapter.setInterface(this)
    }

    override fun onClickDetail(item: Results) {
        var i = Intent(this, DetailActivity::class.java)
        i.putExtra("DATA", item)
        startActivity(i)
    }
}