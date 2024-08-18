function changeColor() {

    let color = document.forms["changeColorForm"]["color"].value;

    if ( color == null || color == "" ) {
        window.alert("Insira uma cor");
    } else {
        document.body.style.background = color;
    }

}

function alertEmail() {

    if ( isValidEmail( document.forms["emailForm"]["email"].value ) ) {
        window.alert("Email inserido corretamente");
        return true;
    } else {
        window.alert("Email não inserido corretamente");
        return false;
    }

}

function isValidEmail( email ) { // Função simples de validação de e-mail

    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    
}

function changeVisibilityOfTitle() {
    
    let x = document.getElementById('title');

    if (x.style.visibility === 'hidden') {
        x.style.visibility = 'visible';
    } else {
        x.style.visibility = 'hidden';
    }
}

function toggleStyleOfTitle() {
    
    if ( document.getElementById('title').classList.contains("class1") ){

        document.getElementById('title').classList.remove("class1");
        document.getElementById('title').classList.add("class2");

    } else {

        document.getElementById('title').classList.remove("class2");
        document.getElementById('title').classList.add("class1");
        
    }
    
}

document.getElementById('eyeicon').onclick = function() {

    

}