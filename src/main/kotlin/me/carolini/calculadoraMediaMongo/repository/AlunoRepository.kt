package me.carolini.calculadoraMediaMongo.repository

import me.carolini.calculadoraMediaMongo.model.AlunoModel
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface AlunoRepository : MongoRepository<AlunoModel, String> {
    fun findOneById(id: ObjectId): AlunoModel
}