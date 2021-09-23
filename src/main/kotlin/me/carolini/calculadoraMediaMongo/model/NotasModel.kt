package me.carolini.calculadoraMediaMongo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("notas")
class NotasModel (
    @Id
    var id: ObjectId = ObjectId.get(),
    var notas: ArrayList<Double>
    ){
    @DBRef
    lateinit var ano: AnoModel


    fun addAno(ano: AnoModel) {
        if (!this::ano.isInitialized){
            this.ano = ano
        }
    }

    private fun calcularMedia(): Double {
        val totalDeNotas = notas.size
        val soma = notas.sum()
        return soma / totalDeNotas
    }

    fun mostrarResultadoMedia(nome: String): String {
        return "$nome, do ano ${ano.ano}, teve a média ${calcularMedia()}"
    }

    fun verificarAprovacao(mediaAprovacao:Int): String {
        if (calcularMedia() >= mediaAprovacao) {
            return "Você foi aprovado!"
        } else {
            return "Você foi reprovado!"
        }

    }
}

