#language: es
Característica: Visualizar el listado completo de comercios

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        
    @javascript @loadBenefitsData
    Escenario: Visualizar el listado por defecto de todos los comercios
        Dado espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "Discovery" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nuevo comercio" en ".container"
        Y espero a que aparezca el contenido dinámico "Administrar categorías" en ".container"

    @javascript @loadBenefitsData
    Escenario: Visualizar y ordenar un listado
        Dado espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"

        Cuando hago click en "#head-country"
        Entonces espero a que aparezca el contenido dinámico "Argentina" en ".backgrid-company-list"
        Y no debo ver "Brasil"

        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"

        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Welcome Instituto de Idiomas" en ".backgrid-company-list"
        Y no debo ver "45 minutos"
        Y debo ver "Prestige"
        Y no debo ver "Discovery"

    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador
        Dado espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "Discovery" en ".backgrid-company-list"

        Cuando hago click en "#page-2"
        Y espero a que aparezca el contenido dinámico "Dulce Sueño" en ".backgrid-company-list"
        Entonces espero a que aparezca el contenido dinámico "Hotel Tucumán Center Suites & Business" en ".backgrid-company-list"

        Cuando hago click en "#page-first"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Entonces espero a que aparezca el contenido dinámico "Discovery" en ".backgrid-company-list"
        
        Cuando hago click en "#page-next"
        Y espero a que aparezca el contenido dinámico "Dulce Sueño" en ".backgrid-company-list"
        Entonces espero a que aparezca el contenido dinámico "Hotel Tucumán Center Suites & Business" en ".backgrid-company-list"

    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de un comercio
        Dado espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "Panamericano Bariloche"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backgrid-company-list"
        Y no debo ver "45 minutos"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Cuando relleno "filters[name]" con "comercio00000"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "No hay comercios" en ".backgrid-company-list"
        Cuando hago click en "#name-filter-btn-close"
        Entonces espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"