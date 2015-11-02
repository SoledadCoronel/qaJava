# language: es

Característica: Como usuario administrador del backoffice quiero poder ver los beneficios asociados a una sucursal.

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".backgrid-company-list"
        Y sigo "Computers Depot"
        Y el breadcrumb debe ser "Inicio > Beneficios Corporativos > Listado de Comercios > Computers Depot"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".company-stores"
        Cuando hago click en el índice "2" del elemento que contiene el texto "Computers Depot"
        Entonces espero a que aparezca el contenedor dinámico ".store-benefits"
        Y el breadcrumb debe ser "Beneficios Corporativos > Listado de Comercios > Computers Depot > Sucursales > Computers Depot"
        Y espero a que aparezca el contenido dinámico "addonna" en ".store-benefits"
        Y hago click en el elemento "#benefits .complete-list-link" que contiene el texto "Ver todos"

    @javascript @loadStoreBenefitsData
    Escenario: Visualizar el listado por defecto de los beneficios de una sucursal.
        Dado espero a que aparezca el contenido dinámico "Listado de Beneficios por Sucursal" en ".container"
        Y espero a que aparezca el contenido dinámico "addonna" en ".backgrid-store-benefits-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "tempor" en ".backgrid-store-benefits-list tbody tr:last"

    @javascript @loadStoreBenefitsData
    Escenario: Visualizar y ordenar el listado de los beneficios de una sucursal.
        Dado espero a que aparezca el contenido dinámico "addonna" en ".backgrid-store-benefits-list tbody tr:first"
        Y hago click en "#head-name"
        Y espero a que aparezca el contenido dinámico "addonna" en ".backgrid-store-benefits-list tbody tr:first"
        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "veniam" en ".backgrid-store-benefits-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "aliquip" en ".backgrid-store-benefits-list tbody tr:last"

    @javascript @loadStoreBenefitsData
    Escenario: Visualizar el listado de beneficios de una sucursal y filtrarlo buscando por el nombre de un beneficio.
        Dado espero a que aparezca el contenido dinámico "addonna" en ".backgrid-store-benefits-list tbody tr:first"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "magna"
        Cuando hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "magna" en ".backgrid-store-benefits-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "Beneficio inexistente"
        Y hago click en "#name-filter-btn-submit"
        Y espero a que aparezca el contenido dinámico "No hay beneficios" en ".backgrid-store-benefits-list"
        Y hago click en "#name-filter-btn-close"
        Y espero a que aparezca el contenido dinámico "addonna" en ".backgrid-store-benefits-list"
