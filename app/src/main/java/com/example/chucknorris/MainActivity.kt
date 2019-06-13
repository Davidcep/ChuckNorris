package com.example.chucknorris


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.chucknorris.Adapter.FactAdapter
import com.example.chucknorris.Data.Fact
import com.example.chucknorris.ViewModels.FactViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var facts = mutableListOf<Fact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Views
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = FactAdapter(mutableListOf())


        val model = ViewModelProviders.of(this).get(FactViewModel::class.java)
        model.getFacts()?.observe(this, Observer {

            val v: ViewModel
            //Update UI
            var factAdapter = rv.adapter as FactAdapter
            factAdapter.data?.clear()
            factAdapter.data = it as MutableList<Fact>
            factAdapter.notifyDataSetChanged()
        })
    }
}
