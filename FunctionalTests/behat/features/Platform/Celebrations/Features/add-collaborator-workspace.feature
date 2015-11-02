#language: es

Característica: Crear o eliminar eventos de cumpleaños seguún se agreguen o se quiten colaboradores
de un espacio público o privado sin autojoin

    Antecedentes:       
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "privateworkspaceuser"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/" 
        Y sigo "Inicio"
        Y espero a que aparezca el contenedor dinámico ".workspace-menu"
        Y debo ver "Espacio Privado"
        Y hago click en ".workspace-menu:eq(1)"
        Y hago click y sigo ".spaces:eq(1) .dropdown-menu:visible a:contains('Configurar espacio')"
        Y espero a que aparezca el contenido dinámico "Guardar" en "#save"
    
    @javascript @loadPrivateWSCelebrationApp
    Escenario: Agregar usuario a espacio privado y se debe actualizar la aplicacion de celebraciones
        Dado presiono "Agregar colaboradores"
        Y espero a que aparezca el contenido dinámico "Unir colaboradores al espacio" en "#addcolabsresponsive"
        Y espero a que aparezca el contenido dinámico "John Connor" en "#collaboratorsList"
        Y hago click en "button.btnSelectCollaborator:eq(3)"
        Y hago click en "#btnJoin"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"
        Entonces espero a que aparezca el contenedor dinámico ".workspace-menu"
        Y debo ver "Espacio Privado"
        Y sigo "Celebraciones en WS privado"
        Entonces espero a que aparezca el contenido dinámico "Cumpleaños de Sarah Connor" en ".celebration-list"

    @javascript @loadPrivateWSCelebrationApp
    Escenario:  Quitar usuario a espacio privado y se debe actualizar la aplicacion de celebraciones
        Dado presiono "Agregar colaboradores"
        Y espero a que aparezca el contenido dinámico "Unir colaboradores al espacio" en "#addcolabsresponsive"
        Y espero a que aparezca el contenido dinámico "John Salchichón" en "#collaboratorsList"
        Y hago click en "button.btnSelectCollaborator:eq()"
        Y hago click en "#btnJoin"
        Cuando presiono "Guardar"
        Entonces la URL debe seguir el patrón "/workspaces/\d+/edit"                                                                    
        Entonces espero a que aparezca el contenedor dinámico ".workspace-menu"
        Y debo ver "Espacio Privado"
        Y sigo "Celebraciones en WS privado"
        Entonces espero a que aparezca el contenido dinámico "Celebraciones en WS privado" en ".app-name"
        Y no debo ver "John Salchichón"