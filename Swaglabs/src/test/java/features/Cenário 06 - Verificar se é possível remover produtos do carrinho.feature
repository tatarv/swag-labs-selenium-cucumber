@carrinho
Feature: Remover produtos do carrinho
  Background:
    Given que eu acesso a aplicação
    And eu preencho os campos username e password com um usuário e senha válidos
    When eu clico no botão Login
    Then a tela principal da aplicação é exibida

  Scenario: Cenário 06 - Verificar se é possível remover produtos do carrinho
    Given que há produtos adicionados ao carrinho
    When  eu clico no botão Remove em um desses produtos
    Then o o produto é removido do carrinho