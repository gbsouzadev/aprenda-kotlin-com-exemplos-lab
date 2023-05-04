// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { GENNIN, CHUNNIN, JOUNNIN}

open class Usuario (val nome: String, var vila: String)
class Aluno (nome: String, vila: String): Usuario(nome = nome, vila = vila)
class Instrutor (nome: String, vila: String): Usuario(nome = nome, vila = vila)


data class ConteudoEducacional(val nome: String, val duracao: Int = 60, var instrutor: Instrutor)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        for (usuario in usuarios) {
            inscritos.add(usuario)
            println("${usuario.nome} da ${usuario.vila} se matriculou no curso: \"${this.nome}\".")
        }
    }
}

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val instrutor1 = Instrutor("Hatake Kakashi", "Vila da Folha")
    val instrutor2 = Instrutor("Maito Guy", "Vila da Folha")
    val instrutor3 = Instrutor("Yuhi Kurenai", "Vila da Folha")

    val ninjutsuBasico = ConteudoEducacional("Ninjutsu Básico", 60, instrutor1)
    val taijutsuBasico = ConteudoEducacional("Taijutsu Básico", 60, instrutor2)
    val genjutsuBasico = ConteudoEducacional("Gensutsu Básico", 60, instrutor3)

    val formacaoBasica = Formacao("PRIMEIRA FORMAÇÃO SHINOBI", Nivel.GENNIN, listOf(ninjutsuBasico, taijutsuBasico, genjutsuBasico))
    val aluno1: Usuario = Aluno("Uzumaki Naruto", "Vila da Folha")
    val aluno2: Usuario = Aluno("Sasuke Uchiha", "Vila da Folha")
    val aluno3: Usuario = Aluno("Haruno Sakura", "Vila da Folha")

    println("O curso \"${formacaoBasica.nome}\" foi lançado!")
    println("Este é um curso de nível ${formacaoBasica.nivel} composto pelos seguintes conteúdos:")
    for (conteudo in formacaoBasica.conteudos){
        println("-> ${conteudo.nome} - Ministrado por ${conteudo.instrutor.nome} (${conteudo.instrutor.vila}).")
    }
    println()

    formacaoBasica.matricular(aluno1, aluno2, aluno3);
    println()

    println("Matrículas encerradas. Confira a lista de inscritos abaixo:")
    var index = 1
    for (inscrito in formacaoBasica.inscritos) {
        println("$index - ${inscrito.nome}.")
        index ++
    }
}