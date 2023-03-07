/* global dhx_win_adm, dhx, dhtmlx, dhx_icon_path, dhx_win_cat, tool_data */

function DOC01(){
    var id, win, tool, grid, status;
    var version = "DOC01 - 1.0.0";
    var win = dhx_win_adm.createWindow("win" + (Math.round(Math.random() * (5 - 1000)) + 5), 5, 5, 1024, 600);
    win.progressOn();
    win.setText("Administración - Títulos");
    win.button("stick").show();
    dhx_win_cat = new dhtmlXWindows();
    dhx_win_cat.attachViewportTo(document.body);
    tool = win.attachToolbar();
    tool.setIconsPath(dhx_icon_path);
    tool.loadStruct("sec/getTool?code=DOC01",function(){
        tool.disableItem("DOC01_SEE");
        tool.disableItem("DOC01_VALID");
        win.progressOff();
    });
    tool.attachEvent("onClick",function (opc) {
        switch (opc){
            case "DOC01_SEE" : 
                var ids = grid.getSelectedRowId().split(",");
                if(ids.length === 1){
                    var id = parseInt(ids[0]);
                    BOX1(id * -1);
                }else{
                    dhtmlx.alert("Selecciona un solo título para consultar!");
                }
                break;
            case "DOC01_VALID" :
                BOX2(grid.getSelectedRowId().split(","));
                break;
                
        }
    });
    grid = win.attachGrid();
    grid.setImagePath("../lib/dhtmlx/dhtmlxGrid/codebase/imgs/");
    grid.setHeader("Folio,Nombre,Paterno,Materno,CURP,Carrera,Institución,RVOE,status"); 
    grid.attachHeader("#connector_text_filter,#connector_text_filter,#connector_text_filter,#connector_text_filter,#connector_text_filter,#connector_text_filter,#connector_text_filter,#connector_text_filter,#connector_text_filter");
    grid.setInitWidths("80,*,*,*,*,80,80,150,100");
    grid.setColAlign("left,left,left,left,left,left,left,left,left");
    grid.setColSorting("str,str,str,str,str,str,str,str,str");
    grid.enableAutoWidth(true);
    grid.setEditable(false);
    grid.init();
    grid.enableSmartRendering(true, 50);
    grid.enableMultiselect(true);
    grid.load("doc/getDocGrid?entity=docs", function () {});
    grid.attachEvent("onRowSelect", function (param) {
        id = parseInt(param);
        tool.enableItem("DOC01_SEE");
        tool.enableItem("DOC01_VALID");
    });
    status = win.attachStatusBar();
    status.setText(version);
        
    // NUEVA VENTANA --------------------------------------------------------------------------------------------------------------------------------------------------
    function BOX1(ID_DOC){
        var box, box_tool, box_form1, box_form2, box_form3, box_status,tab;
        box = dhx_win_cat.createWindow("box"+( Math.round(Math.random() * (5-1000)) + 5), 0, 0, 700, 500);
        box.progressOn();
        box.denyResize();
        box.button("stick").show();
        box.center();
        tab = box.attachTabbar();
        tab.addTab("a1", "Generales");
        tab.addTab("a2", "Protocolo");
        tab.addTab("a3", "Antecedentes");
        tab.tabs("a1").setActive();
        box_tool = box.attachToolbar();
        box_tool.setIconsPath(dhx_icon_path);
        box_tool.setIconSize(24);
        box_tool.loadStruct(tool_data,function(){ box.progressOff(); });
        box_form1 = tab.tabs("a1").attachForm([
            {type: "settings", position: "label-left", offsetLeft: "30", offsetTop: "15"},
            {type: "label", label: "", name: "DOC01D1_TXT_IMAGE"},
            {type: "calendar", name: "DOC01D1_DATE_EXP", inputTop: "-10", label: "Expedición: ", position: "label-top",labelWidth: "150", inputWidth: "150", validate: "NotEmpty", dateFormat:"%d/%m/%Y"},
            {type: "newcolumn", offset: "15"},
            {type: "input", name: "DOC01D1_TXT_CODE", offsetTop: "30", label: "Folio :",labelAlign: "left",labelWidth: "100", inputWidth: "280", validate: "NotEmpty", maxLength: "10"},
            {type: "input", name: "DOC01D1_TXT_NAME", label: "Nombre (s):",labelAlign: "left",labelWidth: "100", inputWidth: "280", validate: "NotEmpty", maxLength: "100"},
            {type: "input", name: "DOC01D1_TXT_FIRSTNAME", label: "Paterno:",labelAlign: "left",labelWidth: "100", inputWidth: "280", validate: "NotEmpty", maxLength: "25"},
            {type: "input", name: "DOC01D1_TXT_SECONDNAME", label: "Materno:",labelAlign: "left",labelWidth: "100", inputWidth: "280", maxLength: "25"},
            {type: "input", name: "DOC01D1_TXT_CURP", label: "CURP:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty", maxLength: "18" },
            {type: "input", name: "DOC01D1_TXT_EMAIL", label: "Email:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty,ValidEmail", maxLength: "200" }
        ]);
        box_form2 = tab.tabs("a2").attachForm([
            {type: "settings", position: "label-left", offsetLeft: "30", offsetTop: "15"},
            {type: "label", label: "", name: "DOC01D1_TXT_IMAGE"},
            {type: "newcolumn", offset: "15"},
            {type: "hidden", name: "DOC01D1_NUM_CENTER"},
            {type: "input", name: "DOC01D1_TXT_CENTER", offsetTop: "30", label: "Institución:", labelAlign: "left", labelWidth: "100", inputWidth: "280", disabled: "true" },
            {type: "combo", name: "DOC01D1_OPC_PROGRAM", filtering: "true", label: "Carrera:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty" },
            {type: "combo", name: "DOC01D1_OPC_MODE",  filtering: "true", label: "Modalidad:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty" },
            {type: "calendar", name: "DOC01D1_DATE_START2", label: "Inicio:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty", dateFormat:"%d/%m/%Y" },
            {type: "calendar", name: "DOC01D1_DATE_END2", label: "Termino:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty", dateFormat:"%d/%m/%Y" },
            {type: "calendar", name: "DOC01D1_DATE_PROTO", label: "Presentación: ",labelAlign: "left",labelWidth: "100", inputWidth: "280", validate: "NotEmpty", dateFormat:"%d/%m/%Y"},
            {type: "combo", name: "DOC01D1_OPC_SOC", filtering: "true", label: "Servicio:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty" },
            {type: "newcolumn", offset: "0"},
            {type: "button", name: "DOC01D1_BTN_CENTER", inputLeft: "-15", inputTop: "15", value: "...", tooltip: "Instituciones Educativas"}
        ]);
        box_form3 = tab.tabs("a3").attachForm([
            {type: "settings", position: "label-left", offsetLeft: "30", offsetTop: "15"},
            {type: "label", label: "", name: "DOC01D1_TXT_IMAGE"},
            {type: "newcolumn", offset: "15"},
            {type: "input", name: "DOC01D1_TXT_CENTER2", offsetTop: "30", label: "Institución:", labelAlign: "left", labelWidth: "100", inputWidth: "280", validate: "NotEmpty" },
            {type: "combo", name: "DOC01D1_OPC_LEVEL", filtering: "true", label: "Tipo:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty"},
            {type: "combo", name: "DOC01D1_OPC_STATE", filtering: "true", label: "Entidad:", labelAlign: "left", labelWidth: "100",  inputWidth: "280", validate: "NotEmpty"},
            {type: "calendar", name: "DOC01D1_DATE_START1", label: "Inicio: ",labelAlign: "left",labelWidth: "100", inputWidth: "280", validate: "NotEmpty", dateFormat:"%d/%m/%Y"},
            {type: "calendar", name: "DOC01D1_DATE_END1", label: "Termino: ",labelAlign: "left",labelWidth: "100", inputWidth: "280", validate: "NotEmpty", dateFormat:"%d/%m/%Y"},
            {type: "input", name: "DOC01D1_TXT_CED", label: "Cédula:", labelAlign: "left", labelWidth: "100", inputWidth: "280" }
        ]);
        LOAD();
        box_form1.enableLiveValidation(true);
        box_form1.attachEvent("onValidateError", function(name, value, result){
            switch(name){
                case "DOC01D1_TXT_CODE" : dhtmlx.message({type: "error", text: "Ups!. El folio que ha introducido no es válido."});break;
                case "DOC01D1_TXT_NAME" : dhtmlx.message({type: "error", text: "Ups!. El nombre que ha introducido no es válido."});break;
                case "DOC01D1_TXT_FIRSTNAME" : dhtmlx.message({type: "error", text: "Ups!. El apellido paterno que ha introducido no es válido."});break;
                case "DOC01D1_TXT_SECONDNAME" : dhtmlx.message({type: "error", text: "Ups!. El apellido materno que ha introducido no es válido."});break;
                case "DOC01D1_TXT_CURP" : dhtmlx.message({type: "error", text: "Ups!. La CURP que ha introducido no es válido."});break;
                case "DOC01D1_TXT_EMAIL" : dhtmlx.message({type: "error", text: "Ups!. El correo electrónico que ha introducido no es válido."});break;
                case "DOC01D1_DATE_EXP" : dhtmlx.message({type: "error", text: "Ups!. La fecha de expedición que ha introducido no es válido."});break;
            }
        });
        box_form2.enableLiveValidation(true);
        box_form2.attachEvent("onValidateError", function(name, value, result){
            switch(name){
                case "DOC01D1_OPC_PROGRAM" : dhtmlx.message({type: "error", text: "Ups!. La carrera que ha introducido no es válido."});break;
                case "DOC01D1_OPC_MODE" : dhtmlx.message({type: "error", text: "Ups!. La modalidad que ha introducido no es válido."});break;
                case "DOC01D1_DATE_PROTO" : dhtmlx.message({type: "error", text: "Ups!. La fecha de presentación que ha introducido no es válido."});break;
                case "DOC01D1_DATE_START2" : dhtmlx.message({type: "error", text: "Ups!. La fecha de inicio que ha introducido no es válido."});break;
                case "DOC01D1_DATE_END2" : dhtmlx.message({type: "error", text: "Ups!. La fecha de termino que ha introducido no es válido."});break;
                case "DOC01D1_OPC_SOC" : dhtmlx.message({type: "error", text: "Ups!. El servicio social que ha introducido no es válido."});break;
            }
        });
        box_form2.attachEvent("onButtonClick", function(id){
            if (id === "DOC01D1_BTN_CENTER"){ POP1(); }
        });
        box_form3.enableLiveValidation(true);
        box_form3.attachEvent("onValidateError", function(name, value, result){
            switch(name){
                case "DOC01D1_TXT_CENTER2" : dhtmlx.message({type: "error", text: "Ups!. La Institución de procedencia que ha introducido no es válido."});break;
                case "DOC01D1_OPC_LEVEL" : dhtmlx.message({type: "error", text: "Ups!. El tipo de Estudio que ha introducido no es válido."});break;
                case "DOC01D1_DATE_START1" : dhtmlx.message({type: "error", text: "Ups!. La fecha de inicio que ha introducido no es válido."});break;
                case "DOC01D1_DATE_END1" : dhtmlx.message({type: "error", text: "Ups!. La fecha de termino que ha introducido no es válido."});break;
            }
        });
        box_status = box.attachStatusBar();
        box_status.setText(version);
        // INICIALIZACIÓN ------------------------------------------------------------------------------------------------------------------------------------------------
        function LOAD(){
            box_form1.setItemLabel("DOC01D1_TXT_IMAGE","<img src='img/user.jpg' style='width: 118px; height: 127px; margin-left: 17px;'/>");
            box_form2.setItemLabel("DOC01D1_TXT_IMAGE","<img src='img/user.jpg' style='width: 118px; height: 127px; margin-left: 17px;'/>");
            box_form3.setItemLabel("DOC01D1_TXT_IMAGE","<img src='img/user.jpg' style='width: 118px; height: 127px; margin-left: 17px;'/>");
            if(ID_DOC === 0){
                box_tool.disableItem("EDIT");
                box_tool.disableItem("NEW");
                box_tool.enableItem("SAVE");
                NEW(); 
            }else{
                var title = "Editar Título - ";
                box_tool.disableItem("NEW");
                box_tool.disableItem("EDIT");
                box_tool.enableItem("SAVE");
                if(ID_DOC < 0){
                    ID_DOC = ID_DOC * -1;
                    box_tool.disableItem("SAVE");
                    LOCK();
                    title = "Consultar Título - ";
                }
                var loader = dhx.ajax.postSync("doc/getDocJson?entity=doc&id="+ID_DOC);
                var json = dhx.s2j(loader.xmlDoc.responseText);
                box.setText(title+json["CURP"]);
                box_form1.setItemValue("DOC01D1_TXT_CODE",json["code"]);
                box_form1.setItemValue("DOC01D1_TXT_NAME",json["name"]);
                box_form1.setItemValue("DOC01D1_TXT_FIRSTNAME",json["firstName"]);
                box_form1.setItemValue("DOC01D1_TXT_SECONDNAME",json["secondName"]);
                box_form1.setItemValue("DOC01D1_TXT_CURP",json["CURP"]);
                box_form1.setItemValue("DOC01D1_TXT_EMAIL",json["email"]);
                var date = json["date"].split("-");
                date = date[2]+"/"+date[1]+"/"+date[0];
                box_form1.setItemValue("DOC01D1_DATE_EXP",date);
                
                box_form2.setItemValue("DOC01D1_NUM_CENTER",json["center"]);
                box_form2.setItemValue("DOC01D1_TXT_CENTER",json["centerName"]);
                box_form2.reloadOptions("DOC01D1_OPC_PROGRAM","doc/getDocOpc?entity=program&id="+json["program"]+"&center="+json["center"]);
                box_form2.reloadOptions("DOC01D1_OPC_MODE","doc/getDocOpc?entity=mode&id="+json["mode"]);
                var proto = json["proto"].split("-");
                proto = proto[2]+"/"+proto[1]+"/"+proto[0];
                box_form2.setItemValue("DOC01D1_DATE_PROTO",proto);
                var start2 = json["start2"].split("-");
                start2 = start2[2]+"/"+start2[1]+"/"+start2[0];
                box_form2.setItemValue("DOC01D1_DATE_START2",start2);
                var end2 = json["end2"].split("-");
                end2 = end2[2]+"/"+end2[1]+"/"+end2[0];
                box_form2.setItemValue("DOC01D1_DATE_END2",end2);
                box_form2.reloadOptions("DOC01D1_OPC_SOC","doc/getDocOpc?entity=soc&id="+json["soc"]);
                box_form3.setItemValue("DOC01D1_TXT_CENTER2",json["center2"]);
                box_form3.reloadOptions("DOC01D1_OPC_LEVEL","doc/getDocOpc?entity=level&id="+json["level"]);
                box_form3.reloadOptions("DOC01D1_OPC_STATE","doc/getDocOpc?entity=states&id="+json["state"]);
                var start1 = json["start1"].split("-");
                start1 = start1[2]+"/"+start1[1]+"/"+start1[0];
                box_form3.setItemValue("DOC01D1_DATE_START1",start1);
                var end1 = json["end1"].split("-");
                end1 = end1[2]+"/"+end1[1]+"/"+end1[0];
                box_form3.setItemValue("DOC01D1_DATE_END1",end1);
                box_form3.reloadOptions("DOC01D1_TXT_CED",json["ced"]);
            }
        }
        // NUEVO REGISTRO ------------------------------------------------------------------------------------------------------------------------------------------------
        function NEW(){
            box.setText("Nuevo Título");
            box_form1.clear();
            box_form1.getInput("DOC01D1_TXT_CODE").placeholder = "Número de Folio";
            box_form1.getInput("DOC01D1_TXT_NAME").placeholder = "Nombre (s)";
            box_form1.getInput("DOC01D1_TXT_FIRSTNAME").placeholder = "Apellido paterno";
            box_form1.getInput("DOC01D1_TXT_SECONDNAME").placeholder = "Apellido materno";
            box_form1.getInput("DOC01D1_TXT_CURP").placeholder = "Clave única de registro poblacional";
            box_form1.getInput("DOC01D1_TXT_EMAIL").placeholder = "usuario@dominio.com";
            box_form1.getInput("DOC01D1_DATE_EXP").placeholder = "dd/mm/yyyy";
            box_form2.setItemValue("DOC01D1_NUM_CENTER",0);
            box_form2.getInput("DOC01D1_TXT_CENTER").placeholder = "Institución Educativa";
            box_form2.reloadOptions("DOC01D1_OPC_PROGRAM","doc/getDocOpc?entity=program&center=0");
            box_form2.reloadOptions("DOC01D1_OPC_MODE","doc/getDocOpc?entity=mode");
            box_form2.getInput("DOC01D1_DATE_PROTO").placeholder = "dd/mm/yyyy";
            box_form2.getInput("DOC01D1_DATE_START2").placeholder = "dd/mm/yyyy";
            box_form2.getInput("DOC01D1_DATE_END2").placeholder = "dd/mm/yyyy";
            box_form2.reloadOptions("DOC01D1_OPC_SOC","doc/getDocOpc?entity=soc");
            box_form3.getInput("DOC01D1_TXT_CENTER2").placeholder = "Institución Educativa de Procedencia";
            box_form3.reloadOptions("DOC01D1_OPC_LEVEL","doc/getDocOpc?entity=level");
            box_form3.reloadOptions("DOC01D1_OPC_STATE","doc/getDocOpc?entity=states");
            box_form3.getInput("DOC01D1_DATE_START1").placeholder = "dd/mm/yyyy";
            box_form3.getInput("DOC01D1_DATE_END1").placeholder = "dd/mm/yyyy";
            box_form3.getInput("DOC01D1_TXT_CED").placeholder = "";
            
            box_form1.enableItem("DOC01D1_TXT_CODE");
            box_form1.enableItem("DOC01D1_TXT_NAME");
            box_form1.enableItem("DOC01D1_TXT_FIRSTNAME");
            box_form1.enableItem("DOC01D1_TXT_SECONDNAME");
            box_form1.enableItem("DOC01D1_TXT_CURP");
            box_form1.enableItem("DOC01D1_TXT_EMAIL");
            box_form1.enableItem("DOC01D1_DATE_EXP");
            box_form2.disableItem("DOC01D1_OPC_PROGRAM");
            box_form2.enableItem("DOC01D1_OPC_MODE");
            box_form2.enableItem("DOC01D1_DATE_PROTO");
            box_form2.enableItem("DOC01D1_DATE_START2");
            box_form2.enableItem("DOC01D1_DATE_END2");
            box_form2.enableItem("DOC01D1_OPC_SOC");
            box_form3.enableItem("DOC01D1_TXT_CENTER2");
            box_form3.enableItem("DOC01D1_OPC_LEVEL");
            box_form3.enableItem("DOC01D1_OPC_STATE");
            box_form3.enableItem("DOC01D1_DATE_START1");
            box_form3.enableItem("DOC01D1_DATE_END1");
            box_form3.enableItem("DOC01D1_TXT_CED");
        }
        // EDITAR REGISTRO ------------------------------------------------------------------------------------------------------------------------------------------------
        function EDIT(){
            box_form1.enableItem("DOC01D1_TXT_CODE");
            box_form1.enableItem("DOC01D1_TXT_NAME");
            box_form1.enableItem("DOC01D1_TXT_FIRSTNAME");
            box_form1.enableItem("DOC01D1_TXT_SECONDNAME");
            box_form1.enableItem("DOC01D1_TXT_CURP");
            box_form1.enableItem("DOC01D1_TXT_EMAIL");
            box_form1.enableItem("DOC01D1_DATE_EXP");
            box_form2.enableItem("DOC01D1_BTN_CENTER");
            box_form2.enableItem("DOC01D1_OPC_PROGRAM");
            box_form2.enableItem("DOC01D1_OPC_MODE");
            box_form2.enableItem("DOC01D1_DATE_PROTO");
            box_form2.enableItem("DOC01D1_DATE_START2");
            box_form2.enableItem("DOC01D1_DATE_END2");
            box_form2.enableItem("DOC01D1_OPC_SOC");
            box_form3.enableItem("DOC01D1_TXT_CENTER2");
            box_form3.enableItem("DOC01D1_OPC_LEVEL");
            box_form3.enableItem("DOC01D1_OPC_STATE");
            box_form3.enableItem("DOC01D1_DATE_START1");
            box_form3.enableItem("DOC01D1_DATE_END1");
            box_form3.enableItem("DOC01D1_TXT_CED");
        }
        // BLOQUEAR REGISTRO ------------------------------------------------------------------------------------------------------------------------------------------------
        function LOCK(){
            box_form1.disableItem("DOC01D1_TXT_CODE");
            box_form1.disableItem("DOC01D1_TXT_NAME");
            box_form1.disableItem("DOC01D1_TXT_FIRSTNAME");
            box_form1.disableItem("DOC01D1_TXT_SECONDNAME");
            box_form1.disableItem("DOC01D1_TXT_CURP");
            box_form1.disableItem("DOC01D1_TXT_EMAIL");
            box_form1.disableItem("DOC01D1_DATE_EXP");
            box_form2.disableItem("DOC01D1_BTN_CENTER");
            box_form2.disableItem("DOC01D1_OPC_PROGRAM");
            box_form2.disableItem("DOC01D1_OPC_MODE");
            box_form2.disableItem("DOC01D1_DATE_PROTO");
            box_form2.disableItem("DOC01D1_DATE_START2");
            box_form2.disableItem("DOC01D1_DATE_END2");
            box_form2.disableItem("DOC01D1_OPC_SOC");
            box_form3.disableItem("DOC01D1_TXT_CENTER2");
            box_form3.disableItem("DOC01D1_OPC_LEVEL");
            box_form3.disableItem("DOC01D1_OPC_STATE");
            box_form3.disableItem("DOC01D1_DATE_START1");
            box_form3.disableItem("DOC01D1_DATE_END1");
            box_form3.disableItem("DOC01D1_TXT_CED");
        }
        // GUARDAR REGISTRO ------------------------------------------------------------------------------------------------------------------------------------------------
        function SAVE(){
            box.progressOn();
            var proto = box_form2.getItemValue("DOC01D1_DATE_PROTO",true).split("/");
            proto =  proto[2]+"/"+proto[1]+"/"+proto[0];
            var date = box_form1.getItemValue("DOC01D1_DATE_EXP",true).split("/");
            date =  date[2]+"/"+date[1]+"/"+date[0];
            var start2 = box_form2.getItemValue("DOC01D1_DATE_START2",true).split("/");
            start2 =  start2[2]+"/"+start2[1]+"/"+start2[0];
            var end2 = box_form2.getItemValue("DOC01D1_DATE_END2",true).split("/");
            end2 =  end2[2]+"/"+end2[1]+"/"+end2[0];
            var start1 = box_form3.getItemValue("DOC01D1_DATE_START1",true).split("/");
            start1 =  start1[2]+"/"+start1[1]+"/"+start1[0];
            var end1 = box_form3.getItemValue("DOC01D1_DATE_END1",true).split("/");
            end1 =  end1[2]+"/"+end1[1]+"/"+end1[0];
            dhx.ajax.post("doc/addDoc?id="+ID_DOC+"&code="+box_form1.getItemValue("DOC01D1_TXT_CODE")+"&name="+box_form1.getItemValue("DOC01D1_TXT_NAME")+"&firstName="+box_form1.getItemValue("DOC01D1_TXT_FIRSTNAME")
                +"&secondName="+box_form1.getItemValue("DOC01D1_TXT_SECONDNAME")+"&CURP="+box_form1.getItemValue("DOC01D1_TXT_CURP")+"&email="+box_form1.getItemValue("DOC01D1_TXT_EMAIL")
                +"&center="+box_form2.getItemValue("DOC01D1_NUM_CENTER")+"&program="+box_form2.getItemValue("DOC01D1_OPC_PROGRAM")+"&mode="+box_form2.getItemValue("DOC01D1_OPC_MODE")
                +"&proto="+proto+"&date="+date+"&soc="+box_form2.getItemValue("DOC01D1_OPC_SOC")+"&study_center="+box_form3.getItemValue("DOC01D1_TXT_CENTER2")+"&study_level="+box_form3.getItemValue("DOC01D1_OPC_LEVEL")
                +"&study_state="+box_form3.getItemValue("DOC01D1_OPC_STATE")+"&study_start="+start1+"&study_end="+end1+"&start="+start2+"&end="+end2+"&study_code="+box_form2.getItemValue("DOC01D1_TXT_CED"),
                function(result){
                    box.progressOff();
                    if (result !== null) {
                        var json = dhx.s2j(result.xmlDoc.responseText);
                        if(json["status"] === 1){
                            ID_DOC= json["id"];
                            grid.clearAndLoad("doc/getDocGrid?entity=docs");
                            LOCK();
                            box_tool.enableItem("EDIT");
                            box_tool.enableItem("NEW");
                            box_tool.disableItem("SAVE");
                            box_form2.disableItem("DOC01D1_BTN_CENTER");
                            dhtmlx.alert("El título se guardo con éxito!");
                        }else{
                            dhtmlx.message({type: "error", text: "ERROR[ " + json["msn"] + " ]"});
                        }
                    }else{
                        dhtmlx.message({type: "error", text: "Fuera de línea!, revisa tu conexión a internet y vuelve a intentar"});
                        box.close();
                    }
                }
            );
        }
        function POP1() {
            var myPop = new dhtmlXPopup({ form: box_form2, id: ["DOC01D1_BTN_CENTER"], mode: "top"});
            myPop.setDimension(450,150);
            var gridPop = myPop.attachGrid();
            myPop.attachEvent("onShow", function(id){box.button("close").disable();});
            myPop.attachEvent("onHide", function(id){box.button("close").enable();});
            gridPop.setHeader("Code,Nombre");
            gridPop.attachHeader("#connector_text_filter,#connector_text_filter");
            gridPop.setInitWidths("90,*");
            gridPop.setColAlign("left,left");
            gridPop.setColSorting("str,str");
            gridPop.enableAutoWidth(true);
            gridPop.setEditable(false);
            gridPop.init();
            gridPop.enableSmartRendering(true, 50);
            gridPop.load("doc/getDocPop?entity=centers", function () {});
            gridPop.attachEvent("onRowDblClicked", function(rId,cInd){
                box_form2.setItemValue("DOC01D1_NUM_CENTER",rId);
                box_form2.setItemValue("DOC01D1_TXT_CENTER",gridPop.cellById(rId,0).getValue()+" - "+gridPop.cellById(rId,1).getValue());
                box_form2.enableItem("DOC01D1_OPC_PROGRAM");
                box_form2.reloadOptions("DOC01D1_OPC_PROGRAM","doc/getDocOpc?entity=program&center="+rId);
                myPop.hide();
            });
            if (myPop.isVisible()) {
                myPop.hide();
            } else {
                myPop.show("DOC01D1_BTN_CENTER");
            }
        }
    }
    function BOX2(ID_DOC){
        var box, box_form1, box_status;
        box = dhx_win_cat.createWindow("box"+( Math.round(Math.random() * (5-1000)) + 5), 0, 0, 510, 300);
        box.denyResize();
        box.button("stick").show();
        box.center();
        box_form1 = box.attachForm([
            {type: "settings", position: "label-left", offsetLeft: "30", offsetTop: "15"},
            {type: "password", name: "DOC01D1_TXT_NIP", offsetTop: "30", label: "Password:",labelAlign: "left",labelWidth: "100", inputWidth: "280", validate: "NotEmpty", maxLength: "100"},
            {type: "upload", name: "DOC01D1_FILE_KEY", inputWidth: "340", offsetLeft: "100", titleText: "Selecciona la llave privada (SAT) del responsable con extensión .key", autoStart: "true", disabled: "true"}
        ]);
        var uploader = box_form1.getUploader("DOC01D1_FILE_KEY");
        box_form1.attachEvent("onEnter", function (name, value, state){
            box_form1.enableItem("DOC01D1_FILE_KEY");
            uploader.setURL("doc/uploadKey1?ids="+ID_DOC+"&nip="+box_form1.getItemValue("DOC01D1_TXT_NIP"));
        });
        box_form1.getInput("DOC01D1_TXT_NIP").placeholder = "********";
        box.setText("Firma de Validación");
        box_form1.attachEvent("onBeforeFileAdd",function(realName){
            var data2 = box_form1.getItemValue("DOC01D1_FILE_KEY");
            if(data2.DOC01D1_FILE_KEY_count === 0){
                return true;
            }else{
                dhtmlx.message({type: "error", text: "Ups!. Solo puedes seleccionar un archivo."});
                false;
            }
        });
        box_form1.attachEvent("onFileAdd",function(realName){
            box.progressOn();
        });
        box_form1.attachEvent("onUploadFail",function(realName){
            dhtmlx.message({type: "error", text: "Ups!. Error al subir la información"});
            box.progressOff();
        });
        box_form1.attachEvent("onUploadComplete",function(realName){
            box.progressOff();
            dhtmlx.alert("El título se valido con éxito!");
            grid.clearAndLoad("doc/getDocGrid?entity=docs");
            box.close();
        });
        box_status = box.attachStatusBar();
        box_status.setText(version);
    }
}
