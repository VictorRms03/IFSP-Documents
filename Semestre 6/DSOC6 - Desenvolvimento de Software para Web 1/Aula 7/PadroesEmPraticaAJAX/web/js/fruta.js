function cadastrar( event ){
    
    let nome = prompt( "Nome da Fruta:" );
    let cor = prompt( "Cor da Fruta:" );
    
    if ( !(nome === null) && !(cor === null) ){
        
        $.ajax("processaFruta",{
            data: {
                acao: "inserir",
                nome: nome,
                cor: cor
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
    $.ajax("processaFruta",{
        data:{
            acao: "listar"
        },
        dataType: "json"
    }).done((data) => {
        let $tbody = $("#tabela");
        $tbody.html("");

        data.forEach(fruta => {
            $tbody.append(
                `<tr>
                    <td>${fruta.nomeFruta}</td>
                    <td>${fruta.corFruta}</td>
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



