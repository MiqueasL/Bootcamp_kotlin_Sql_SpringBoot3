enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado no curso $nome.")
    }
}

fun main() {
    val usuario1 = Usuario("Jõao", Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)

    val conteudo1 = ConteudoEducacional("Kotlin Iniciante")
    val conteudo2 = ConteudoEducacional("POO Kotlin")

    val formacao = Formacao("Kotlin", listOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    
    println("Curso: ${formacao.nome}")
    println("Conteudo:")
    formacao.conteudos.forEach {
        println(" - ${it.nome}, Duração: ${it.duracao} minutos")
    }
    println("Alunos:")
    formacao.inscritos.forEach {
        println(" - ${it.nome}, Nível: ${it.nivel}")
    }
}
