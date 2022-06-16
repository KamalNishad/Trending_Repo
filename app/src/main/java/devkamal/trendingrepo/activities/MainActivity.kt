package devkamal.trendingrepo.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import devkamal.trendingrepo.R
import devkamal.trendingrepo.adapter.TrendinRepoItemAdapter
import devkamal.trendingrepo.api.ApiClient
import devkamal.trendingrepo.databinding.ActivityMainBinding
import devkamal.trendingrepo.model.TrendingRepoModel
import devkamal.trendingrepo.model.TrendingRepoModelItem
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {

    private var TAG:String="MainActivity"
    private var mBinding:ActivityMainBinding?=null

    private var trendingRepoModelItemList:MutableList<TrendingRepoModelItem>?= mutableListOf()
    private var trendingRepoItemAdapter: TrendinRepoItemAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getTrendingRepo()
        init()
    }

    private fun init(){
        Log.d(TAG,"trendingRepoModelItemSIZE :"+trendingRepoModelItemList?.size);
        trendingRepoItemAdapter = trendingRepoModelItemList?.let { TrendinRepoItemAdapter(this, it) }
        mBinding?.rview?.layoutManager = LinearLayoutManager(this)
        mBinding?.rview?.itemAnimator = DefaultItemAnimator()
        mBinding!!.rview.adapter = trendingRepoItemAdapter
    }

    private fun getTrendingRepo(){
        val call: Call<TrendingRepoModel> = ApiClient.getClient.getTrendingRepoList()
        call.enqueue(object : Callback<TrendingRepoModel> {
            override fun onResponse(call: Call<TrendingRepoModel>, response: retrofit2.Response<TrendingRepoModel>) {
                Log.d(TAG,"res :$response");
                when {
                    response.code()==200 -> {
                        //trendingRepoModel = response.body()!!
                        trendingRepoModelItemList = response.body()
                        Log.d(TAG,"trendingRepoModelItemList :"+Gson().toJson(trendingRepoModelItemList));
                        trendingRepoItemAdapter?.updateResult(trendingRepoModelItemList!!)
                    }
                    response.code()==400 -> {
                        Toast.makeText(this@MainActivity,"400 Bad Request",Toast.LENGTH_SHORT).show()
                    }
                    response.code()==404 -> {
                        Toast.makeText(this@MainActivity,"404 Not Found",Toast.LENGTH_SHORT).show()
                    }
                    response.code()==500 -> {
                        Toast.makeText(this@MainActivity,"Internal Sever Error",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<TrendingRepoModel>, t: Throwable) {
                Log.d(TAG,"ERROR :$t");
            }
        })
    }
}