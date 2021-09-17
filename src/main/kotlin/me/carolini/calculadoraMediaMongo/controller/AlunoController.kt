package me.carolini.calculadoraMediaMongo

import me.carolini.calculadoraMediaMongo.model.AlunoModel
import me.carolini.calculadoraMediaMongo.model.AlunoRequest
import me.carolini.calculadoraMediaMongo.repository.AlunoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cadastro/aluno")
class CadastroAluno (private val alunoRepository: AlunoRepository) {

    @PostMapping("/novo")
    fun cadastroAluno(@RequestBody dadosDoAluno: AlunoRequest): ResponseEntity<AlunoModel> {
        val aluno = alunoRepository.save(AlunoModel(
            nome = dadosDoAluno.nome
        ))
        return ResponseEntity(aluno, HttpStatus.CREATED)
    }

}