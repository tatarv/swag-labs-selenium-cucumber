@login
Feature:Efetuar Login
  Scenario: Cenário 02 - Verificar se não é possível efetuar o login após não preencher o campo username
    Given que eu acesso a aplicação
    And eu não preencho o campo username
    And eu preencho o campo password com uma senha válida
    When eu clico no botão Login
    Then uma mensagem de erro é exibida indicando que o campo username é obrigatório