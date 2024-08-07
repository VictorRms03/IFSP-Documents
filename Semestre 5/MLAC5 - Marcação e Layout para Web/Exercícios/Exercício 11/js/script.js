$( document ).ready( function() {

    $("#changeColorForm").submit( function(e) {
        e.preventDefault();
        $("body").css("background-color", $("#color").val() );
    })

    $("#emailForm").submit( function (e) {

        if ( isValidEmail( $("#email").val() ) ) {
            alert("Email inserido corretamente");
        } else {
            alert("Email não inserido corretamente");
            e.preventDefault();
        }

    })

    $("#changeVisibilityButton").click( function() {
        
        if ( $("#title").css("visibility") == "visible"){
            $("#title").css("visibility", "hidden");
        } else {
            $("#title").css("visibility", "visible");
        }

    })

    $("#changeStyleButton").click( function() {

        if( $("#title").hasClass("class1") ) {
            $("#title").removeClass("class1");
            $("#title").addClass("class2");
        } else {
            $("#title").removeClass("class2");
            $("#title").addClass("class1");
        }

        

    })

})

function isValidEmail( email ) { // Função simples de validação de e-mail

    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    
}