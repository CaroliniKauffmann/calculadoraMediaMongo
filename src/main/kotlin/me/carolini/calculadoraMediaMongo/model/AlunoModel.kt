package me.carolini.calculadoraMediaMongo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import kotlin.collections.ArrayList

@Document("aluno")
class AlunoModel (
    @Id
    var id: ObjectId = ObjectId.get(),
    var nome: String
) {
    @DBRef
    lateinit var notas: ArrayList<NotasModel>


//    private fun calcularMedia(): Float {
//
//        val totalDeNotas = notas.size
//        val soma = notas.sum()
//        return soma / totalDeNotas
//    }
//
//    fun mostrarResultadoMedia(): String {
//        return "$nome, do ano $ano, teve a média ${calcularMedia()}"
//    }
//
//    fun verificarAprovacao(mediaAprovacao:Int): String {
//        if (calcularMedia() >= mediaAprovacao) {
//            return "Você foi aprovado!"
//        } else {
//            return "Você foi reprovado!"
//        }
//
//    }
}
