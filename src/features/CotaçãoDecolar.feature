Feature: Verificar Cotação de Passagens aéreas
  Eu quero através do site do Decolar pesquisar valores de passagens aéreas
  e obter os valores.

 
  Scenario Outline:	 Pesquisa de Passagens aéreas
    Given Entrar no site "<site>" "<cenario>"
    And selecionar modalidade 'Passagens'
    And clico no botão 'Ida e Volta'
    And digito 'Origem' "<origem>"
    And digito 'Destino' "<destino>"
    And digito 'Data Ida' "<dataIda>"
    And digito 'Data Volta' "<dataVolta>" 
    And clico em 'Procurar'
    Then verifico valido 'Preço por companhia aérea'
    
    
    
    
    
    Examples: 
    				|cenario         |site                            |origem         |destino   |dataIda        |dataVolta       |
    			  |Cotação DECOLAR | https://www.decolar.com        |Ribeirão Preto |Navegantes|20              |20              |