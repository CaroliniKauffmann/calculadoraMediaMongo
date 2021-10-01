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

@RestController
@RequestMapping("/cadastro/aluno")
class CadastroAluno (private val alunoRepository: AlunoRepository, private val notasRepository: NotasRepository) {

    @PostMapping("/novo")
    fun cadastroAluno(@RequestBody dadosDoAluno: AlunoRequest): ResponseEntity<AlunoModel> {
        val alunoModel = AlunoModel(
            nome = dadosDoAluno.nome
        )
        alunoModel.inicializaNotas()
        val aluno = alunoRepository.save(alunoModel)
        return ResponseEntity(aluno, HttpStatus.CREATED)
    }

    @PostMapping("/enviar-notas")
    fun enviarNotas(@RequestBody request: EnviaNotasRequest): ResponseEntity<AlunoModel> {
        val aluno = alunoRepository.findOneById(request.aluno)
        val notas = notasRepository.findOneById(request.notas)
        if (aluno.notas.filter { it.id.equals(request.notas)}.isEmpty()) {
            aluno.addNotas(notas)
            notas.addAno(notas.ano)
            alunoRepository.save(aluno)
        }

        return ResponseEntity(aluno, HttpStatus.ACCEPTED)
    }

    @GetMapping("/media")
    fun media(@RequestParam alunoID: ObjectId, @RequestParam anoID: ObjectId, @RequestParam mediaAprovacao: Int): ResponseEntity<List<String>> {
        val aluno = alunoRepository.findOneById(alunoID)
        if (aluno.notas.isEmpty()) {
            return ResponseEntity(listOf("O Aluno não tem notas lançadas!"), HttpStatus.NO_CONTENT)
        }
        if (aluno.notas.filter { it.ano.id.equals(anoID)}.isEmpty()) {
            return ResponseEntity(listOf("O Ano não foi encontrado!"), HttpStatus.NOT_FOUND)
        }
        val notas = aluno.notas.find { it.ano.id.equals(anoID) }
        val resultado = notas?.let {
            listOf<String>(it.mostrarResultadoMedia(aluno.nome), notas.verificarAprovacao(mediaAprovacao))
        }
        return ResponseEntity(resultado, HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/deletarAluno/{alunoID}")
    fun deletarAluno(@PathVariable alunoID: ObjectId): ResponseEntity<String> {
        if (alunoRepository.existsById(alunoID)) {
            alunoRepository.deleteById(alunoID)
        }
       return ResponseEntity("Aluno deletado com sucesso!", HttpStatus.OK)
    }

}