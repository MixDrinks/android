package org.mixdrinks.mixdrinks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.mixdrinks.mixdrinks.databinding.CocktailItemBinding
import org.mixdrinks.mixdrinks.models.Cocktail

class CocktailsAdapter : RecyclerView.Adapter<CocktailsAdapter.CocktailHolder>(){
    var cocktailList = ArrayList<Cocktail>()

    class CocktailHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = CocktailItemBinding.bind(item)
        fun bind(coctail: Cocktail) = with(binding){
            nameTextView.text = coctail.name
            Picasso.get().load(coctail.images.first().srcset).into(contentImageView);
            if(coctail.rating == null) {
                ratingImageView.visibility = ImageView.GONE
            } else {
                ratingTextView.text = coctail.rating.toString()
            }
            if(coctail.visitCount == null) {
                visitCountImageView.visibility = ImageView.GONE
            }
             else {
                visitCountTextView.text = coctail.visitCount.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cocktail_item, parent, false)
        return CocktailHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailHolder, position: Int) {
        holder.bind(cocktailList[position])

    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    fun setData(c: ArrayList<Cocktail>) {
        cocktailList.addAll(c)
        notifyDataSetChanged();

    }
}