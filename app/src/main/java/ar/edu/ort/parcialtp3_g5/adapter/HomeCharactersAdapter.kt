package ar.edu.ort.parcialtp3_g5.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.parcialtp3_g5.R
import ar.edu.ort.parcialtp3_g5.entities.RickAndMortyCharacter

public class HomeCharactersAdapter(list: MutableList<RickAndMortyCharacter>?) : RecyclerView.Adapter<HomeCharactersAdapter.ViewHolder>(){

    val titles = arrayOf("Nombre1", "Nombre2", "Nombre3", "Nombre4", "Nombre5")
    val status = arrayOf("status", "status", "status", "status", "status")
    val images = intArrayOf(R.drawable.rick_and_morty,R.drawable.rick_and_morty, R.drawable.rick_and_morty, R.drawable.rick_and_morty, R.drawable.rick_and_morty )
    val responseList = list

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_character, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if(responseList != null){
            viewHolder.itemTitle.text = responseList[position].name
            viewHolder.itemStatus.text = responseList[position].status
            viewHolder.itemImage.setImageResource(images[position])
        }

   }
    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var itemImage: ImageView
        lateinit var itemTitle: TextView
        lateinit var itemStatus: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemStatus = itemView.findViewById(R.id.item_status)
        }
    }



}
