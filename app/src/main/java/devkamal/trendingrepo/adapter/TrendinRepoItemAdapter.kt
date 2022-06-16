package devkamal.trendingrepo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import devkamal.trendingrepo.R
import devkamal.trendingrepo.model.TrendingRepoModelItem

class TrendinRepoItemAdapter(val context: Context, var activityList: MutableList<TrendingRepoModelItem>) : RecyclerView.Adapter<TrendinRepoItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendinRepoItemAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_cust_trending_repo, parent, false)
        return ViewHolder(view)
    }

    public fun updateResult(activityList: MutableList<TrendingRepoModelItem>){
        this.activityList = activityList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TrendinRepoItemAdapter.ViewHolder, position: Int) {
        var itemViewModel = activityList[position]
        holder.tvAuthor.text = itemViewModel.author+"/"+itemViewModel.name
        holder.tvDescription.text =itemViewModel.description
        holder.tvLanguage.text =itemViewModel.language
        holder.tvStars.text = itemViewModel.stars.toString()

        //Picasso.get().load(itemViewModel[0].avatar).into(holder.ivAvtar)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
        //val ivAvtar: ImageView = itemView.findViewById(R.id.iv_avtar)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
        val tvLanguage: TextView = itemView.findViewById(R.id.tv_language)
        //val tvLanguageColor: TextView = itemView.findViewById(R.id.tv_language_color)
        val tvStars: TextView = itemView.findViewById(R.id.tv_stars)
    }
}