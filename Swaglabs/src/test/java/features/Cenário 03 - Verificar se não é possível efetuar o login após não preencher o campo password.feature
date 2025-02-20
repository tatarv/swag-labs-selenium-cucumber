@login
Feature: Efetuar Login
  Scenario: Cenário 03 - Verificar se não é possível efetuar o login após não preencher o campo password
    Given que eu acesso a aplicação
    And eu preencho o campo username com um usuário válido
    And eu não preencho o campo password
    When eu clico no botão Login
    Then uma mensagem de erro é exibida indicando que o campo password é obrigatório