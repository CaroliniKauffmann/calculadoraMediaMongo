package me.carolini.calculadoraMediaMongo.repository

import me.carolini.calculadoraMediaMongo.model.Aluno
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface AlunoRepository : MongoRepository<Aluno, String> {
    fun findOneById(id: ObjectId): Aluno
}