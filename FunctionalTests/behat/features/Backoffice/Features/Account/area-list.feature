#language: es
Característica: Visualizar el listado completo de áreas de una plataforma

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
        
    @javascript @loadStandardData
    Escenario:  Visualizar el listado por defecto de las áreas de una plataforma
        Dado sigo "Administrar áreas y departamentos"
        Y espero a que aparezca el contenido dinámico "aliqua" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "quis" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nueva área" en ".container"

    @javascript @loadStandardData
    Escenario: Visualizar y ordenar un listado
        Dado sigo "Administrar áreas y departamentos"
        Y espero a que aparezca el contenido dinámico "aliqua" en ".backgrid-company-list"

        Cuando hago click en "#head-name"
        Y espero a que aparezca el contenido dinámico "cillum" en ".backgrid-company-list"
        Entonces no debo ver "ullamco"

        Cuando hago click en "#head-name"
        Y espero a que aparezca el contenido dinámico "ullamco" en ".backgrid-company-list"
        Entonces no debo ver "cillum"

    @javascript @loadStandardData
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador
        Dado sigo "Administrar áreas y departamentos"
        Y espero a que aparezca el contenido dinámico "aliqua" en ".backgrid-company-list"

        Cuando hago click en "#page-2"
        Entonces espero a que aparezca el contenido dinámico "ullamco" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "voluptate" en ".backgrid-company-list"

        Cuando hago click en "#page-first"
        Entonces espero a que aparezca el contenido dinámico "cillum" en ".backgrid-company-list"
        
        Cuando hago click en "#page-next"
        Entonces espero a que aparezca el contenido dinámico "ullamco" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "voluptate" en ".backgrid-company-list"

    @javascript @loadStandardData
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de una sucursal
        Dado sigo "Administrar áreas y departamentos"
        Y espero a que aparezca el contenido dinámico "aliqua" en ".backgrid-company-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "labore"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "labore" en ".backgrid-company-list"
        Y no debo ver "aliqua"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Cuando relleno "filters[name]" con "administración"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "No hay áreas" en ".backgrid-company-list"
        Cuando hago click en "#name-filter-btn-close"
        Entonces espero a que aparezca el contenido dinámico "aliqua" en ".backgrid-company-list"