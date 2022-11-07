package ar.edu.ort.parcialtp3_g5.data

import ar.edu.ort.parcialtp3_g5.entities.RickAndMortyCharacter
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @field:SerializedName("results") val results: List<RickAndMortyCharacter>
)