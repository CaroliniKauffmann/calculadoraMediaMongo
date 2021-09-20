package me.carolini.calculadoraMediaMongo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("ano")
class NotasModel (
    @Id
    var id: ObjectId = ObjectId.get(),
    var notas: Int
)