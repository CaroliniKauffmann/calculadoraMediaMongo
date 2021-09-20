package me.carolini.calculadoraMediaMongo.controller
import me.carolini.calculadoraMediaMongo.model.AnoModel
import me.carolini.calculadoraMediaMongo.model.AnoRequest
import me.carolini.calculadoraMediaMongo.model.NotasModel
import me.carolini.calculadoraMediaMongo.model.NotasRequest
import me.carolini.calculadoraMediaMongo.repository.AnoRepository
import me.carolini.calculadoraMediaMongo.repository.NotasRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cadastro/notas")
class NotasController (private val notasRepository: NotasRepository) {

    @PostMapping("/nova")
    fun cadastroAluno(@RequestBody request: NotasRequest): ResponseEntity<NotasModel> {
        val notas = notasRepository.save(NotasModel(
            notas = request.notas
        )
        )
        return ResponseEntity(notas, HttpStatus.CREATED)
    }

}
