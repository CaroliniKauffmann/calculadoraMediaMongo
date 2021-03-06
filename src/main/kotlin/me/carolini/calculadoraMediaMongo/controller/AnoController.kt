package me.carolini.calculadoraMediaMongo.controller
import me.carolini.calculadoraMediaMongo.model.AnoModel
import me.carolini.calculadoraMediaMongo.resquest.AnoRequest
import me.carolini.calculadoraMediaMongo.repository.AnoRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cadastro/ano")
class AnoController (private val anoRepository: AnoRepository) {

    @PostMapping("/novo")
    fun cadastroAluno(@RequestBody request: AnoRequest): ResponseEntity<AnoModel> {
        val ano = anoRepository.save(AnoModel(
            ano = request.ano
        ))
        return ResponseEntity(ano, HttpStatus.CREATED)
    }
    @DeleteMapping("/deletarAno/{anoID}")
    fun deletarAno(@PathVariable anoID: ObjectId): ResponseEntity<String> {
        if (anoRepository.existsById(anoID)) {
            anoRepository.deleteById(anoID)
        }
        return ResponseEntity("Ano deletado com sucesso!", HttpStatus.OK)
    }

}