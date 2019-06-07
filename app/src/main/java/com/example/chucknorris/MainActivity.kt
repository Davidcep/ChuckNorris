package com.example.chucknorris

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.chucknorris.Adapter.FactAdapter
import com.example.chucknorris.Model.Fact
import com.example.chucknorris.Retrofit.ApiFacts
import com.example.chucknorris.Retrofit.Client
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import java.util.*

class MainActivity : AppCompatActivity() {

    private var facts = mutableListOf<Fact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init API
        var retro: Retrofit = Client.getFacts
        var factApi: ApiFacts = retro.create(ApiFacts::class.java)

        //Observer
        var myObserver = getObserver()

        //Observable
        val observable: Observable<Fact> = factApi.facts

        for (i in 0 until 20){
            observable
                .subscribeOn(Schedulers.newThread())
                .subscribe(myObserver)
        }

        //Views
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = FactAdapter(facts)

        this.runOnUiThread(Runnable { rv.adapter!!.notifyDataSetChanged() })
    }

    fun getObserver(): Observer<Fact> {
        return object : Observer<Fact> {
            override fun onComplete() {
                Log.d("test", "RecycledView Updated")
                runOnUiThread(Runnable { rv.adapter!!.notifyDataSetChanged() })
            }

            override fun onSubscribe(d: Disposable) {
                Log.d("test", "Subscribe")
            }

            override fun onNext(t: Fact) {
                Log.d("test", t.id.toString())
               facts.add(t)
            }

            override fun onError(e: Throwable) {
                Log.d("test", "Error")
            }
        }
    }
}
