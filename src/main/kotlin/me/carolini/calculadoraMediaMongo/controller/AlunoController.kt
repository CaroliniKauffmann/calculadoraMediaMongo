package me.carolini.calculadoraMediaMongo

import me.carolini.calculadoraMediaMongo.model.AlunoModel
import me.carolini.calculadoraMediaMongo.model.NotasModel
import me.carolini.calculadoraMediaMongo.resquest.AlunoRequest
import me.carolini.calculadoraMediaMongo.repository.AlunoRepository
import me.carolini.calculadoraMediaMongo.repository.NotasRepository
import me.carolini.calculadoraMediaMongo.resquest.EnviaNotasRequest
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.isInitialized as isInitialized

@RestController
@RequestMapping("/cadastro/aluno")
class CadastroAluno (private val alunoRepository: AlunoRepository, private val notasRepository: NotasRepository) {

    @PostMapping("/novo")
    fun cadastroAluno(@RequestBody dadosDoAluno: AlunoRequest): ResponseEntity<AlunoModel> {
        val aluno = alunoRepository.save(AlunoModel(
            nome = dadosDoAluno.nome
        ))
        return ResponseEntity(aluno, HttpStatus.CREATED)
    }
    @PostMapping("/enviar-notas")
    fun enviarNotas(@RequestBody request: EnviaNotasRequest): ResponseEntity<AlunoModel> {
        val aluno = alunoRepository.findOneById(request.aluno)
        val notas = notasRepository.findOneById(request.notas)
        aluno.addNotas(notas)
        notas.addAno(notas.ano)
        alunoRepository.save(aluno)
        return ResponseEntity(aluno, HttpStatus.ACCEPTED)
    }
    @GetMapping("/media")
    fun media(@RequestParam alunoID: ObjectId, @RequestParam anoID: ObjectId): ResponseEntity<List<String>> {
        val resultado = listOf<String>("Carolini, do ano 2021, teve a média x", "Você foi aprovado!")
        return ResponseEntity(resultado, HttpStatus.ACCEPTED)
    }

}