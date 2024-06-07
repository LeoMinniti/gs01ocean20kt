package br.com.fiap.gs01ocean20.model

data class ItemModel(
        val praia: String
        , val cidade: String
        , val estado: String
        , val onRemove: (ItemModel) -> Unit

)