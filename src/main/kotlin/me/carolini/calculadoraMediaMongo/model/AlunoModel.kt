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

    fun addNotas(notas: NotasModel) {
        if (!this::notas.isInitialized) {
            this.notas = arrayListOf<NotasModel>()
        }
        this.notas.add(notas)
    }
}
