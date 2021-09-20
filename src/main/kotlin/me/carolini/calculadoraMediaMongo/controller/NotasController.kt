package me.carolini.calculadoraMediaMongo.controller
import me.carolini.calculadoraMediaMongo.model.AnoModel
import me.carolini.calculadoraMediaMongo.model.AnoRequest
import me.carolini.calculadoraMediaMongo.model.NotasModel
import me.carolini.calculadoraMediaMongo.model.NotasRequest
import me.carolini.calculadoraMediaMongo.repository.AnoRepository
import me.carolini.calculadoraMediaMongo.repository.NotasRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cadastro/notas")
class NotasController (private val notasRepository: NotasRepository) {

    @PostMapping("/nova")
    fun cadastroAluno(@RequestBody request: NotasRequest): ResponseEntity<NotasModel> {
        val notasModel = NotasModel(
            notas = request.notas
        )
        notasModel.ano = AnoModel(request.anoID)
        val notas = notasRepository.save(notasModel)
        return ResponseEntity(notas, HttpStatus.CREATED)
    }

}
