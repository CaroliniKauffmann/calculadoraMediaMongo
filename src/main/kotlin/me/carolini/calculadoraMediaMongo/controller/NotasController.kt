package me.carolini.calculadoraMediaMongo.controller
import me.carolini.calculadoraMediaMongo.model.AnoModel
import me.carolini.calculadoraMediaMongo.model.NotasModel
import me.carolini.calculadoraMediaMongo.repository.AnoRepository
import me.carolini.calculadoraMediaMongo.resquest.NotasRequest
import me.carolini.calculadoraMediaMongo.repository.NotasRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cadastro/notas")
class NotasController (private val notasRepository: NotasRepository, val anoRepository: AnoRepository) {

    @PostMapping("/nova")
    fun cadastroAluno(@RequestBody request: NotasRequest): ResponseEntity<NotasModel> {
        val notasModel = NotasModel(
            notas = request.notas
        )
        notasModel.ano = anoRepository.findOneById(request.anoID)
        val notas = notasRepository.save(notasModel)
        return ResponseEntity(notas, HttpStatus.CREATED)
    }
    @DeleteMapping("/deletarNota/{notaID}")
    fun deletarNotas(@PathVariable notaID: ObjectId): ResponseEntity<String> {
        if (notasRepository.existsById(notaID)) {
            notasRepository.deleteById(notaID)
        }
        return ResponseEntity("Nota deletada com sucesso!", HttpStatus.OK)
    }
}
