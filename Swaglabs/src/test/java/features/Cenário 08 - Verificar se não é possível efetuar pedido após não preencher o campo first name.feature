@carrinho
Feature: Finalizar pedido
  Background:
    Given que eu acesso a aplicação
    And eu preencho os campos username e password com um usuário e senha válidos
    When eu clico no botão Login
    Then a tela principal da aplicação é exibida
    And que há produtos adicionados ao carrinho

  Scenario: Cenário 08 - Verificar se não é possível efetuar pedido após não preencher o campo first name
    Given que eu acesso o carrinho
    When eu clico no botão Check out
    And preencho as informações necessárias para entrega do pedido sem informar o campo first name
    When eu clico no botão Continue
    Then uma mensagem de erro é exibida indicando que o campo first name é obrigatório
