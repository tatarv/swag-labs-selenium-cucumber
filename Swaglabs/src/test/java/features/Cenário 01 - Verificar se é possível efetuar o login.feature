@login
Feature: Efetuar Login
  Scenario: Cenário 01 - Verificar se é possível efetuar o login
    Given que eu acesso a aplicação
    And eu preencho os campos username e password com um usuário e senha válidos
    When eu clico no botão Login
    Then a tela principal da aplicação é exibida
