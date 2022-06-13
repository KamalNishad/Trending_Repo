package devkamal.trendingrepo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import devkamal.trendingrepo.R
import devkamal.trendingrepo.model.TrendingRepoModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class TrendingRepoAdapter(val context: Context, var activityList: MutableList<TrendingRepoModel>) : RecyclerView.Adapter<TrendingRepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_cust_trending_repo, parent, false)
        return ViewHolder(view)
    }

    public fun updateResult(activityList: MutableList<TrendingRepoModel>){
        this.activityList = activityList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TrendingRepoAdapter.ViewHolder, position: Int) {
        var itemViewModel = activityList[position]
        holder.tvTitle.text =itemViewModel.title
        holder.tvDescription.text =itemViewModel.description
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
    }
}