@login
Feature: Efetuar Login
  Scenario: Cenário 04 - Verificar se não é possível efetuar o login após preencher o campo username e
  password com valores diferentes dos permitidos
    Given que eu acesso a aplicação
    And eu preencho os campos username e password com um usuário e senha diferentes dos que estão listados na tela
    When eu clico no botão Login
    Then uma mensagem de erro é exibida indicando que o usuário e a senha informados não correspondem a nenhum usuário indicado

