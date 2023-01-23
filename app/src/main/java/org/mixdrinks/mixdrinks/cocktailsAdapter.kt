package org.mixdrinks.mixdrinks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.mixdrinks.mixdrinks.databinding.CocktailItemBinding
import org.mixdrinks.mixdrinks.models.Cocktail

class CocktailsAdapter : RecyclerView.Adapter<CocktailsAdapter.CocktailHolder>(){
    var cocktailList = ArrayList<Cocktail>()

    class CocktailHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = CocktailItemBinding.bind(item)
        fun bind(coctail: Cocktail) = with(binding){
            Picasso.get().load(coctail.images.first().srcset).into(imageView);
            textView.text = coctail.name
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