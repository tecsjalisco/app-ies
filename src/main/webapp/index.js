var dhx_win_adm;
var dhx_win_cat;
var dhx_win_exp;
var dhx_win_box;
var dhx_icon_path;
var dhx_win_camera;
var context_path;
var tool_data = "[{id:'NEW', type: 'button', img: 'NEW_1.png', imgdis: 'NEW_0.png', title: 'Nuevo'},{id:'EDIT', type: 'button', img: 'EDIT_1.png', imgdis: 'EDIT_0.png', title: 'Nuevo'},{id:'SAVE', type: 'button', img: 'SAVE_1.png', imgdis: 'SAVE_0.png', title: 'Guardar'}]";


function doOnLoad() {
    var dhx_main = new dhtmlXWindows();
    dhx_main.attachViewportTo("winVP");
    var layout = new dhtmlXLayoutObject({parent: document.body, pattern: "1C"});
    layout.cells("a").hideHeader();
    layout.cells("a").attachObject("winVP");
    dhx_win_adm = new dhtmlXWindows();
    dhx_win_adm.attachViewportTo("winVP");
    dhx_win_cat = new dhtmlXWindows();
    dhx_win_cat.attachViewportTo("winVP");
    
    context_path = "/";
    dhx_icon_path = "img/icon/";
    $.getScript("doc/DOC01.js?data="+Math.round(Math.random() * (5-1000)) + 5,function(){});
    
    var main_tool = layout.attachToolbar();
    main_tool.setIconsPath(dhx_icon_path);
    main_tool.loadStruct("sec/getTool?code=CORE01");
    main_tool.setIconSize(32);
    main_tool.attachEvent("onClick",
        function (id) {
            switch (id)
            {
                case "DOC01"   : DOC01();break;
                case "EXT01" :  window.location = "sec/logout";break;
            }
        }
    );
    main_status = layout.attachStatusBar({text:"<label id='status' name='status'></label>"});
}

function dateWorker() {
    var w;
    if (typeof (Worker) !== "undefined") {
        if (typeof (w) === "undefined") {
            w = new Worker("dateworker.js");
        }
        w.onmessage = function (event) {
            document.getElementById("status").innerHTML = event.data;
        };
    } else {
        alert("Sorry! No Web Worker support.");
    }
}
dateWorker();