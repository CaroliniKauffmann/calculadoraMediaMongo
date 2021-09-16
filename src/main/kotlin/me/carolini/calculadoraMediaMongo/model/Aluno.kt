package me.carolini.calculadoraMediaMongo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import kotlin.collections.ArrayList

@Document
class Aluno {
    @Id
    var id: ObjectId = ObjectId.get()
    private var nome = "string"
    private var ano = 0
    private var notas: ArrayList<Float> = ArrayList()


    fun preencherNome(nome:String){
        this.nome = nome
    }

    fun preencherAno(ano:Int) {
        this.ano = ano
    }

    fun preencherNotas(notas:ArrayList<Float>) {
        this.notas = notas

    }
    private fun calcularMedia(): Float {

        val totalDeNotas = notas.size
        val soma = notas.sum()
        return soma / totalDeNotas
    }

    fun mostrarResultadoMedia(): String {
        return "$nome, do ano $ano, teve a média ${calcularMedia()}"
    }

    fun verificarAprovacao(mediaAprovacao:Int): String {
        if (calcularMedia() >= mediaAprovacao) {
            return "Você foi aprovado!"
        } else {
            return "Você foi reprovado!"
        }

    }
}
