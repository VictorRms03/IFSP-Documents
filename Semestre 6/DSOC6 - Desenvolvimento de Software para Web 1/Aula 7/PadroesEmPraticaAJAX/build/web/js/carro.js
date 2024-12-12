function cadastrar( event ){
    
    let nome = prompt( "Nome do Carro:" );
    let modelo = prompt( "Modelo do Carro:" );
    let anoFabricacao = prompt( "Ano de Fabricação do Carro:" );
    
    if ( !(nome === null) && !(modelo === null) && !(anoFabricacao === null) ){

        $.ajax("processaCarro", {
            data: {
                acao: "inserir",
                nome: nome,
                modelo: modelo,
                anoFabricacao: anoFabricacao
            },
            dataType: "json"
        })
        .done(() => {
            listar();
        })
        .fail((jqXHR, textStatus, errorThrown) => {
            console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);
        });
        
    } else {
        alert("Algum Campo vazio!");
    }
}

function listar( event ){
    $.ajax("processaCarro", {
        data: {
            acao: "listar"
        },
        dataType: "json"
    })
    .done((data) => {
        let $tbody = $("#tabela");
        $tbody.html("");

        data.forEach(carro => {
            $tbody.append(
                `<tr>
                    <td>${carro.nome}</td>
                    <td>${carro.modelo}</td>
                    <td>${carro.anoFabricacao}</td>
                </tr>`
            );
        });
    })
    .fail((jqXHR, textStatus, errorThrown) => {
        console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);
    });
}

$(document).ready(() => {
    listar();
});

