@carrinho
Feature: Finalizar pedido
  Background:
    Given que eu acesso a aplicação
    And eu preencho os campos username e password com um usuário e senha válidos
    When eu clico no botão Login
    Then a tela principal da aplicação é exibida
    And que há produtos adicionados ao carrinho

  Scenario: Cenário 07 - Verificar se é possível finalizar o pedido
    Given que eu acesso o carrinho
    And eu clico no botão Check out
    And preencho as informações necessárias para entrega do pedido
    And as informações do pedido são exibidas
    When eu clico no botão Finish
    Then o pedido é realizado com sucesso
    And a mensagem de confirmação é exibida
