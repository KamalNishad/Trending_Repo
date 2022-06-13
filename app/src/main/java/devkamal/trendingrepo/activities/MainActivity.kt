package devkamal.trendingrepo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import devkamal.trendingrepo.R
import devkamal.trendingrepo.adapter.TrendingRepoAdapter
import devkamal.trendingrepo.databinding.ActivityMainBinding
import devkamal.trendingrepo.model.TrendingRepoModel

class MainActivity : AppCompatActivity() {

    private var mBinding:ActivityMainBinding?=null
    private var trendingRepoAdapter:TrendingRepoAdapter?=null
    private var list:MutableList<TrendingRepoModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init(){
        trendingRepoAdapter = TrendingRepoAdapter(this,list)
        mBinding?.rview?.layoutManager = LinearLayoutManager(this)
        mBinding?.rview?.itemAnimator = DefaultItemAnimator()
        mBinding!!.rview.adapter = trendingRepoAdapter
    }
}