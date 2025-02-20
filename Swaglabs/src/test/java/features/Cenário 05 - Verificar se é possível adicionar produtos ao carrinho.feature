@carrinho
Feature: Adicionar produtos ao carrinho
  Background:
    Given que eu acesso a aplicação
    And eu preencho os campos username e password com um usuário e senha válidos
    When eu clico no botão Login
    Then a tela principal da aplicação é exibida

  Scenario: Cenário 05 - Verificar se é possível adicionar produtos ao carrinho
    Given que os produtos são listados
    When eu clico no botão Add to cart
    Then o produto é adicionado ao carrinho