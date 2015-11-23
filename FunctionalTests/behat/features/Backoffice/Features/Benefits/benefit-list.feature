#language: es
Característica: Como usuario administrador del backoffice quiero ver los beneftios de un comercio

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y relleno "filters[name]" con "Computers Depot"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Computers Depot" en ".backgrid-company-list"
        Cuando sigo "Computers Depot"
        Y espero a que aparezca el contenedor dinámico ".company-view-container"
        Entonces el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Computers Depot"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".backoffice-header"
        Y sigo "Beneficios (22)"
        Y espero a que aparezca el contenido dinámico "cupidatat" en "#benefits"
        Y hago click y sigo "#benefits .complete-list-link"
        Y espero a que aparezca el contenido dinámico "Listado de Beneficios" en ".breadcrumb"

    @javascript @loadBenefitsData
    Escenario: Visualizar el listado por defecto de todas los beneficios
        Dado espero a que aparezca el contenido dinámico "addonna" en ".backgrid-benefit-list  tbody tr:first"
        Y espero a que aparezca el contenido dinámico "pariatur" en ".backgrid-benefit-list  tbody tr:last"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nuevo Beneficio" en ".container"

    @javascript @loadBenefitsData
    Escenario: Visualizar y ordenar un listado
        Dado espero a que aparezca el contenido dinámico "addonna" en ".backgrid-benefit-list tbody tr:first"

        Cuando hago click en "#head-name"
        Y espero a que aparezca el contenido dinámico "addonna" en ".backgrid-benefit-list tbody tr:first"
        Entonces no debo ver "voluptate"

        Cuando hago click en "#head-name"
        Y espero a que aparezca el contenido dinámico "voluptate" en ".backgrid-benefit-list tbody tr:first"
        Entonces no debo ver "addonna"

    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador
        Dado espero a que aparezca el contenido dinámico "addonna" en ".backgrid-benefit-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "pariatur" en ".backgrid-benefit-list tbody tr:last"

        Cuando hago click en "#page-2"
        Y espero a que aparezca el contenido dinámico "reprehende" en ".backgrid-benefit-list tbody tr:first"
        Entonces espero a que aparezca el contenido dinámico "voluptate" en ".backgrid-benefit-list tbody tr:last"

        Cuando hago click en "#page-first"
        Y espero a que aparezca el contenido dinámico "addonna" en ".backgrid-benefit-list tbody tr:first"
        Entonces espero a que aparezca el contenido dinámico "pariatur" en ".backgrid-benefit-list tbody tr:last"
        
        Cuando hago click en "#page-next"
        Y espero a que aparezca el contenido dinámico "reprehende" en ".backgrid-benefit-list tbody tr:first"
        Entonces espero a que aparezca el contenido dinámico "voluptate" en ".backgrid-benefit-list tbody tr:last"

    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de beneficio
        Dado espero a que aparezca el contenido dinámico "addonna" en ".backgrid-benefit-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "voluptate"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "voluptate" en ".backgrid-benefit-list"
        Y no debo ver "addonna"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Cuando relleno "filters[name]" con "Beneficio Corporativo 0000000"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "No hay beneficios" en ".backgrid-benefit-list"
        Cuando hago click en "#name-filter-btn-close"
        Entonces espero a que aparezca el contenido dinámico "addonna" en ".backgrid-benefit-list"