package me.carolini.calculadoraMediaMongo.repository

import me.carolini.calculadoraMediaMongo.model.AnoModel
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface AnoRepository : MongoRepository<AnoModel, String> {
    fun findOneById(id: ObjectId): AnoModel
}