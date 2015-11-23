#language: es
Característica: Visualizar la vista detallada de áreas de una plataforma

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "Listar Cuentas"
        Entonces espero a que aparezca el contenido dinámico "Standard Account" en "#content"
        Y hago click en ".dropdown-toggle"
        Y sigo "Listar plataformas de Standard Account"
        Entonces espero a que aparezca el contenido dinámico "Hugo" en ".table-content"
        Y sigo "Hugo"
        Y espero a que aparezca el contenido dinámico "Administrar" en ".backoffice-header"
        Y hago click en ".more-options"
        Y sigo "Usuarios"
        Y espero a que aparezca el contenido dinámico "Administrar áreas y departamentos" en ".table-content"
        Y espero a que aparezca el contenido dinámico "John Connor" en ".backgrid-user-list"
        Y sigo "Administrar áreas y departamentos"
        Y espero a que aparezca el contenido dinámico "aliqua" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "quis" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nueva área" en ".container"

    @javascript @loadStandardData
    Escenario: Visualizar los datos del área sin departamentos
        Dado sigo "aliqua"
        Entonces espero a que aparezca el contenido dinámico "aliqua" en "#name"
        Y espero a que aparezca el contenido dinámico "El área no tiene departamentos relacionados" en ".area-departments"

     @javascript @loadStandardData
    Escenario: Visualizar los datos del área con departamentos
        Dado sigo "duis"
        Entonces espero a que aparezca el contenido dinámico "duis" en "#name"
        Y espero a que aparezca el contenido dinámico "Administración" en ".area-departments"