describe('Transações', () => {

    beforeEach( () => {
        cy.visit('https://dev-finance.netlify.app/');
    })

    it('Cadastrar Nova Transação - Entrada', () => {

        cy.contains("Nova Transação").click();

        cy.get('#description').type("Descrição");

        cy.get('#amount').type("500");

        cy.get('#date').type("2023-10-20");

        cy.contains('button', 'Salvar').click();

        cy.get("tbody tr td.description").should("have.text", "Descrição");

    });

    it('Cadastrar Nova Transação - Saída', () => {

        cy.contains("Nova Transação").click();

        cy.get('#description').type("Gasto");

        cy.get('#amount').type("-300");

        cy.get('#date').type("2023-10-20");

        cy.contains('button', 'Salvar').click();

        cy.get("tbody tr td.description").should("have.text", "Gasto");

    });

    it('Cadastrar Nova Transação - Saída Refatorada - Function', () => {

        criarTransacao("Pagamento", -300, "2024-12-10");

        cy.get("tbody tr td.description").should("have.text", "Pagamento");
    })

    it('Excluir Transação - Opção 1', () => {

        criarTransacao("Ganhos com Victor Ramos", 1000, "2004-06-13");
        criarTransacao("Gastos com Vinicius Ramos", -800, "2002-05-07");

        cy.contains(".description", "Ganhos com Victor Ramos").parent().find("img").click();

        cy.get('tbody tr').should("have.length", 1);

    })

    it('Excluir Transação - Opção 2', () => {

        criarTransacao("Ganhos com Victor Ramos", 1000, "2004-06-13");
        criarTransacao("Gastos com Vinicius Ramos", -800, "2002-05-07");

        cy.contains(".description", "Ganhos com Victor Ramos").siblings().children("img").click();

        cy.get('tbody tr').should("have.length", 1);

    })

    it('Campos Vazios - Descrição', () => {

        cy.contains("Nova Transação").click();

        cy.get('#amount').type(300);

        cy.get('#date').type("2024-01-01");

        cy.contains('button', 'Salvar').click();

        cy.on('window:alert', (texto) => {
            expect(texto).to.equal('Por favor, preencha todos os campos corretamente');
        });

    })

    it('Campos Vazios - Valor', () => {

        cy.contains("Nova Transação").click();

        cy.get('#description').type("Gasto sem Valor");

        cy.get('#date').type("2024-01-01");

        cy.contains('button', 'Salvar').click();

        cy.on('window:alert', (texto) => {
            expect(texto).to.equal('Por favor, preencha todos os campos corretamente');
        });

    });

    it('Campos Vazios - Data', () => {

        cy.contains("Nova Transação").click();

        cy.get('#description').type("Gasto sem Valor");

        cy.get('#amount').type(300);

        cy.contains('button', 'Salvar').click();

        cy.on('window:alert', (texto) => {
            expect(texto).to.equal('Por favor, preencha todos os campos corretamente');
        });

    });

    it('Cards Corretos - Positivo', () => {

        criarTransacao("Gastos com Ar Condicionado do IFSP", -12000, "2002-05-07");
        criarTransacao("Ganhos com Vendas de Livros", 3000, "2004-05-07");
        criarTransacao("Ganhos com Premiações", 13000, "2002-05-07");

        cy.contains(".card", "Entradas").parent().find("#incomeDisplay").contains("R$ 16.000,00");
        cy.contains(".card", "Saídas").parent().find("#expenseDisplay").contains("-R$ 12.000,00");
        cy.contains(".card.total", "Total").parent().find("#totalDisplay").contains("R$ 4.000,00");

    })

    it('Cards Corretos - Negativo', () => {

        criarTransacao("Gastos com Ar Condicionado do IFSP", -12000, "2002-05-07");
        criarTransacao("Ganhos com Premiações", 11000, "2002-05-07");

        cy.contains(".card", "Entradas").parent().find("#incomeDisplay").contains('R$ 11.000,00');
        cy.contains(".card", "Saídas").parent().find("#expenseDisplay").contains("-R$ 12.000,00");
        cy.contains(".card.total", "Total").parent().find("#totalDisplay").contains("-R$ 1.000,00");

    })

});

function criarTransacao(descricao, valor, data) {

    cy.contains("Nova Transação").click();

    cy.get('#description').type(descricao);

    cy.get('#amount').type(valor);

    cy.get('#date').type(data);

    cy.contains('button', 'Salvar').click();

}