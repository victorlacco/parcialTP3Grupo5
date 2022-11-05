package ar.edu.ort.parcialtp3_g5.data

import com.google.gson.annotations.SerializedName

data class CharacterResponse<Tdata> (
    @field:SerializedName("id") val id: Number,
    @field:SerializedName("image") val image: String,
    @field:SerializedName("status") val status: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("species") val species: String,
    @field:SerializedName("origen") val origen: Tdata,
)