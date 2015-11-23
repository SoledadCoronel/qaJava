#language: es

Característica: Actualizar fechas de nacimiento de colaboradores en la app de clebraciones.   
Como usuario admin o básico modifico mi fecha de nacimiento en mi perfil

    Antecedentes:       
        Dado estoy en "/auth/signin?_lang=en_US"
        Y relleno "_username" con "privateworkspaceuser"
        Y relleno "_password" con "123456"
        Y presiono "_submit"
        Y espero a que aparezca el contenido dinámico "Espacio Público" en "#workspaces"
        Y hago click en ".profile-pic .dropdown-toggle"
        Y sigo "My Profile"
        Y hago click en "#data-edit .icon-pencil"
        Y hago click en ".dropdown-menu #data-edit-modal-link"
        Y espero a que aparezca el contenido dinámico "Mis datos" en ".modal-header"
    
    @javascript @loadPrivateWSCelebrationApp
    Escenario: Cambiar la fecha de nacimiento de un usuario.
		Y relleno "birthdate" con la fecha de hoy en el año "1986"
        Y hago click en "#saveProfileData"
		Y sigo "Inicio"
		Y espero a que aparezca el contenido dinámico "Espacio Privado" en "#workspaces"
		Y sigo "Celebraciones en WS privado"
		Y espero a que aparezca el contenedor dinámico ".datepicker-switch"
		Cuando seteo el datepicker ".datepicker" con la fecha de hoy
        Entonces espero a que aparezca el contenido dinámico "privateworkspace user" en ".celebration-list"