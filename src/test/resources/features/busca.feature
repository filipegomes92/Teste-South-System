# language: pt
@Busca
  Funcionalidade: Realizar buscas filtrando conforme a expressão passada no campo de busca
    @BuscaPositivo
    Cenario: Validar busca com expressao valida
      Dado que estou na home do AGI
      Quando eu busco por uma expressao valida
      Entao vejo os resultados da minha busca
    @BuscaNegativo
    Cenario:Validar Busca com expressao invalida
      Dado que estou na home do AGI
      Quando eu busco por uma expressao invalida
      Entao vejo mensagem que nada foi encontrado