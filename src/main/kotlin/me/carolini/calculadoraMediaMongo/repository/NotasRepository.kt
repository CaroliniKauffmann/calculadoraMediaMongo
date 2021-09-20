package me.carolini.calculadoraMediaMongo.repository

import me.carolini.calculadoraMediaMongo.model.AnoModel
import me.carolini.calculadoraMediaMongo.model.NotasModel
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NotasRepository : MongoRepository<NotasModel, String> {
    fun findOneById(id: ObjectId): NotasModel
}