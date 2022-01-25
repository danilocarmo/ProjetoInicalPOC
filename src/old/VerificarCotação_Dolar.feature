Feature: Verificar Cotação do Dolar
  Eu quero através do site do UOL consultar o valor do Dólar em Reais.

 
  Scenario Outline:	 Cotação do Dólar
    Given Entrar no site do 'Google' "<site>" "<cenario>"
    And no campo de pesquisa pesquisar por "<palavraChave>"
    And clico no 'botão de Pesquisa'
    And clico no link do site pesquisado para direcionamento
    And clico na aba de 'Economia'
    Then verifico a cotação do Dólar
    
    
    
    
    
    Examples: 
    				|cenario         |site                         |palavraChave|
    			  |Cotação do Dólar| https://www.google.com.br   |site do UOL |
