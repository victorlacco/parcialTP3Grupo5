package ar.edu.ort.parcialtp3_g5.entities

import ar.edu.ort.parcialtp3_g5.data.Origin
import com.google.gson.annotations.SerializedName

data class RickAndMortyCharacter (
    @field:SerializedName("id") val id: Number,
    @field:SerializedName("image") val image: String,
    @field:SerializedName("status") val status: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("species") val species: String,
    @field:SerializedName("origin") val origin: Origin
)