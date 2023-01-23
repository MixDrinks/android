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
        fun bind(cocktail: Cocktail) = with(binding){
            nameTextView.text = cocktail.name
            Picasso.get().load(cocktail.images.first().srcset).into(contentImageView);
            if(cocktail.rating == null) {
                ratingImageView.visibility = ImageView.INVISIBLE
            } else {
                ratingImageView.visibility = ImageView.VISIBLE
                ratingTextView.text = cocktail.rating.toString()
            }
            if(cocktail.visitCount == null) {
                visitCountImageView.visibility = ImageView.GONE
            }
             else {
                visitCountTextView.text = cocktail.visitCount.toString()
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
}