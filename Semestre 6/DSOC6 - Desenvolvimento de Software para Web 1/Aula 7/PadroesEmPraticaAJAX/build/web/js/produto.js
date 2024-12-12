function cadastrar( event ){
    
    let descricao = prompt( "Descrição do Produto:" );
    let quantidade = prompt( "Quantidade do Produto:" );
    
    if ( !(descricao===null) && !(quantidade===null) ){

        $.ajax("processaProduto",{
            data: {
                acao: "inserir",
                descricao: descricao,
                quantidade: quantidade
            },
            dataType: "json"
        }).done(() => {
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
    
    $.ajax("processaProduto",{
        data:{
            acao: "listar"
        },
        dataType: "json"
    }).done((data) => {
        let $tbody = $("#tabela");
        $tbody.html("");

        data.forEach(produto => {
            $tbody.append(
                `<tr>
                    <td>${produto.descricao}</td>
                    <td>${produto.quantidade}</td>
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



