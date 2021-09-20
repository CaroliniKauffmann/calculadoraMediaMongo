package me.carolini.calculadoraMediaMongo.resquest

import me.carolini.calculadoraMediaMongo.model.AlunoModel
import me.carolini.calculadoraMediaMongo.model.NotasModel

class EnviaNotasRequest (val aluno: AlunoModel, val notas: NotasModel)
