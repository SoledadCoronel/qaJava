#language: es
Característica: Como usuario administrador del backoffice quiero ver las sucursales de un comercio

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "45 minutos" en ".backgrid-company-list"
        Y relleno "filters[name]" con "Panamericano Bariloche"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backgrid-company-list"
        Cuando sigo "Panamericano Bariloche"
        Y espero a que aparezca el contenedor dinámico ".company-view-container"
        Entonces el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Panamericano Bariloche"
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".backoffice-header"
        Y sigo "Sucursales (27)"
        Y espero a que aparezca el contenido dinámico "Balvanera" en "#stores"
        Y hago click y sigo "#stores .complete-list-link"
        Y espero a que aparezca el contenido dinámico "Listar sucursales" en ".breadcrumb"

    @javascript @loadBenefitsData
    Escenario: Visualizar el listado por defecto de todas las sucursales
        Dado espero a que aparezca el contenido dinámico "Balvanera" en ".backgrid-store-list"
        Y espero a que aparezca el contenido dinámico "Pinturerías del Centro" en ".backgrid-store-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nueva sucursal" en ".container"

    @javascript @loadBenefitsData
    Escenario: Visualizar y ordenar un listado
        Dado espero a que aparezca el contenido dinámico "Balvanera" en ".backgrid-store-list"

        Cuando hago click en "#head-name"
        Y espero a que aparezca el contenido dinámico "Pinturerías del Centro" en ".backgrid-store-list"
        Entonces no debo ver "Star Iluminación"

        Cuando hago click en "#head-name"
        Y espero a que aparezca el contenido dinámico "Star Iluminación" en ".backgrid-store-list"
        Entonces no debo ver "Balvanera"

    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador
        Dado espero a que aparezca el contenido dinámico "Balvanera" en ".backgrid-store-list"
        Y espero a que aparezca el contenido dinámico "Pinturerías del Centro" en ".backgrid-store-list"

        Cuando hago click en "#page-2"
        Y espero a que aparezca el contenido dinámico "Star Iluminación" en ".backgrid-store-list"
        Entonces espero a que aparezca el contenido dinámico "Villa Crespo" en ".backgrid-store-list"

        Cuando hago click en "#page-first"
        Entonces espero a que aparezca el contenido dinámico "Balvanera" en ".backgrid-store-list"
        
        Cuando hago click en "#page-next"
        Y espero a que aparezca el contenido dinámico "Star Iluminación" en ".backgrid-store-list"
        Entonces espero a que aparezca el contenido dinámico "Villa Crespo" en ".backgrid-store-list"

    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de una sucursal
        Dado espero a que aparezca el contenido dinámico "Balvanera" en ".backgrid-store-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "Star Iluminación"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Star Iluminación" en ".backgrid-store-list"
        Y no debo ver "Balvanera"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Cuando relleno "filters[name]" con "sucursal00000"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "No hay sucursales" en ".backgrid-store-list"
        Cuando hago click en "#name-filter-btn-close"
        Entonces espero a que aparezca el contenido dinámico "Balvanera" en ".backgrid-store-list"