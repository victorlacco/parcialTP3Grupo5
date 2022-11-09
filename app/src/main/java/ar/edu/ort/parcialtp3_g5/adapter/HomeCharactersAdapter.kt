package ar.edu.ort.parcialtp3_g5.adapter;

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.parcialtp3_g5.R
import ar.edu.ort.parcialtp3_g5.entities.RickAndMortyCharacter
import com.squareup.picasso.Picasso


public class HomeCharactersAdapter(list: MutableList<RickAndMortyCharacter>?) : RecyclerView.Adapter<HomeCharactersAdapter.ViewHolder>(){

   val responseList = list

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_character, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if(responseList != null){
            viewHolder.itemTitle.text = responseList[position].name
            viewHolder.itemStatus.text = translateStatus(responseList[position].status)
            Picasso.get().load(responseList[position].image).into(viewHolder.itemImage)
        }

   }
    override fun getItemCount(): Int {
        return responseList?.size ?: 0
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

    private fun translateStatus(status: String): String {
        var returnStatus = "Desconocido"
        if(status == "Alive")
            returnStatus = "Vivo"
        else if(status == "Dead")
            returnStatus = "Muerto"

        return returnStatus
    }

}
