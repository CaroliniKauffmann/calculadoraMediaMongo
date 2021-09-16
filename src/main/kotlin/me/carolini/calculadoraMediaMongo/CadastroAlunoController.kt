package me.carolini.calculadoraMediaMongo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cadastro/aluno")
class CadastroAluno {

    @PostMapping("/novo")
    fun cadastroAluno(@RequestBody dadosDoAluno: DadosDoAluno): ArrayList<String> {
        val aluno = Aluno()

        aluno.preencherNome(dadosDoAluno.nome)
        aluno.preencherAno(dadosDoAluno.ano)
        aluno.preencherNotas(dadosDoAluno.notas)

        return arrayListOf(aluno.mostrarResultadoMedia(), aluno.verificarAprovacao(7))
    }

}