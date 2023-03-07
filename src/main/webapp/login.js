/* global dhtmlx, id, dhx */

var SEC01_STRUCTURE = [
    {type: "settings", position: "label-top"},
    {type: "block", width: "320", list: [
        {type: "input", name: "SEC01_TXT_EMAIL", offsetLeft: "30", label: "Usuario:", inputWidth: "300", style: "background-color:#F8EFBA; color: #242580;", tooltip: "Email", validate: "NotEmpty", maxLength: "100"},
        {type: "input", name: "SEC01_TXT_CENTER", offsetLeft: "30", label: "IES:", inputWidth: "300", style: "background-color:#F8EFBA; color: #242580;", tooltip: "IES", validate: "NotEmpty", maxLength: "15"},
        {type: "password", name: "SEC01_TXT_NIP", offsetLeft: "30", label: "NIP:", inputWidth: "300", style: "background-color:#F8EFBA; color: #242580;", tooltip: "Contraseña", validate: "NotEmpty", maxLength: "15"},
        {type: "button", offsetLeft: "90", offsetTop: "30", name: "SEC01_BTN_LOGIN", value: " INICIAR SESIÓN ", tooltip: ""}
    ]}
];
var SEC01_FORM = new dhtmlXForm("form", SEC01_STRUCTURE);
SEC01_FORM.enableLiveValidation(true);
SEC01_FORM.attachEvent("onValidateError", function(name, value, result){
    switch(name){
        case "SEC01_TXT_EMAIL" : dhtmlx.message({type: "error", text: "El usuario es obligatorio."});break;
        case "SEC01_TXT_CENTER" : dhtmlx.message({type: "error", text: "La clave IES es obligatorio y no debe de tener más de 15 caracteres."});break;
        case "SEC01_TXT_NIP" : dhtmlx.message({type: "error", text: "El NIP es obligatorio y no debe de tener más de 15 caracteres."});break;
    }
});
SEC01_FORM.attachEvent("onButtonClick", function(id){
    if (id === "SEC01_BTN_LOGIN"){
        SEC01_FORM.disableItem("SEC01_TXT_EMAIL");
        SEC01_FORM.disableItem("SEC01_TXT_NIP");
        SEC01_FORM.disableItem("SEC01_BTN_LOGIN");
        SEC01_FORM.disableItem("SEC01_BTN_CENTER");
        if (SEC01_FORM.validate()) {
            dhx.ajax.post("sec/login?email="+SEC01_FORM.getItemValue("SEC01_TXT_EMAIL")+"&NIP="+SEC01_FORM.getItemValue("SEC01_TXT_NIP")+"&center="+SEC01_FORM.getItemValue("SEC01_TXT_CENTER"),function(r){
                var msn = r.xmlDoc.responseText.split(",");
                switch (msn[0])
                {
                    case "CORE000":
                        $.redirect("index.jsp");break;
                    case "SEC001":
                        swal({ type: "error", title: "Oops...", text: "[SAFE001]: El usuario no es valido!"});
                        break;
                    case "SEC002":
                        swal({ type: "error", title: "Oops...", text: "[SAFE002]: El usuario tiene mas de dos cuentas!"});
                        break;
                    case "SEC003":
                        swal({ type: "error", title: "Oops...", text: "[SAFE003]: El NIP es incorrecto!"});
                        break;
                    case "SEC004":
                        swal({ type: "error", title: "Oops...", text: "[SAFE004]: La clave IES no es correcta!"});
                        break;
                    default:
                        swal({ type: "error", title: "Oops...", text: "Error desconocido! ["+msn+"]"});
                        break;
                }
            });
            SEC01_FORM.enableItem("SEC01_TXT_EMAIL");
            SEC01_FORM.enableItem("SEC01_TXT_NIP");
            SEC01_FORM.enableItem("SEC01_BTN_LOGIN");
        }
    }
});


