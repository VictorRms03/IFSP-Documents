function validateForm() {

    let x = document.forms["formulario"]["nome"].value;
    if ( x == null || x == "" ) {
        window.alert("Nome deve ser digitado");
        return false;
    }

    x = document.forms["formulario"]["endereco"].value;
    if ( x == null || x == "" ) {
        window.alert("Endereço deve ser digitado");
        return false;
    }

    x = document.forms["formulario"]["numero"].value;
    if ( x == null || x == "" ) {

        window.alert("Número deve ser digitado");
        return false;

    } else if ( x < 300 || x > 500 ) {

        window.alert("Número deve ser entre 300 e 500");
        return false;

    }

    x = document.forms["formulario"]["cep"].value;
    if ( x == null || x == "" ) {
        window.alert("CEP deve ser digitado");
        return false;
    }

    x = document.forms["formulario"]["bairro"].value;
    if ( x == null || x == "" ) {
        window.alert("Bairro deve ser digitado");
        return false;
    }

    x = document.forms["formulario"]["estado"].value;
    if ( x == null || x == "" ) {
        window.alert("Estado deve ser digitado");
        return false;
    }

    x = document.forms["formulario"]["cidade"].value;
    if ( x == null || x == "" ) {
        window.alert("Cidade deve ser digitado");
        return false;
    }

}

function inputToUpperCase() {
    document.getElementById("nome").value = document.forms["formulario"]["nome"].value.toUpperCase();
}

function alertForm() {

    const errors = [];

    let x = document.forms["formulario"]["nome"].value;
    if ( x == null || x == "" ) {
        errors.push("Nome");
    }

    x = document.forms["formulario"]["endereco"].value;
    if ( x == null || x == "" ) {
        errors.push("Endereço");
    }

    x = document.forms["formulario"]["numero"].value;
    if ( x == null || x == "" || x < 300 || x > 500 ) {
        errors.push("Número");
    }

    x = document.forms["formulario"]["cep"].value;
    if ( x == null || x == "" ) {
        errors.push("CEP");
    }

    x = document.forms["formulario"]["bairro"].value;
    if ( x == null || x == "" ) {
        errors.push("Bairro");
    }

    x = document.forms["formulario"]["estado"].value;
    if ( x == null || x == "" ) {
        errors.push("Estado");
    }

    x = document.forms["formulario"]["cidade"].value;
    if ( x == null || x == "" ) {
        errors.push("Cidade");
    }

    if ( errors.length > 0 ) {

        let errorStr = "Os seguintes campos estão errados: " + errors[0];

        for ( let i = 1; i < errors.length; i++ ) {
            errorStr = errorStr + ", " + errors[i];
        }

        window.alert( errorStr );

    } else {
        window.alert( "Campos corretamente preenchidos" );
    }

}

function writeData() {

    let datas = "Nome: " + document.forms["formulario"]["nome"].value + "<br>" +
                "Endereço: " + document.forms["formulario"]["endereco"].value + "<br>" +
                "Número: " + document.forms["formulario"]["numero"].value + "<br>" +
                "CEP: " + document.forms["formulario"]["CEP"].value + "<br>" +
                "Bairro: " + document.forms["formulario"]["Bairro"].value + "<br>" +
                "Estado: " + document.forms["formulario"]["Estado"].value + "<br>" +
                "Cidade: " + document.forms["formulario"]["Cidade"].value + "<br>";

    document.getElementsByName('body').innerHTML = datas;

}