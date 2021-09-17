package me.carolini.calculadoraMediaMongo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("ano")
class AnoModel (
    @Id
    var id: ObjectId = ObjectId.get(),
    var ano: Int
)