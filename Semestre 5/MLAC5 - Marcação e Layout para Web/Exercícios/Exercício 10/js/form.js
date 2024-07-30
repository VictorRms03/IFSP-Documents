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

    let x = document.forms["formulario"]["nome"].value;

    document.forms["formulario"]["nome"].value = x.toU

}