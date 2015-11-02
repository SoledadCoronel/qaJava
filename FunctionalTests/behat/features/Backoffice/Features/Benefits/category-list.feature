#language: es
Característica: Visualizar el listado completo de categorias

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Administrar categorías" en ".list-categories"
        Y sigo "Administrar categorías"
        Y espero a que aparezca el contenido dinámico "Categorías" en ".breadcrumb"
        
    @javascript @loadBenefitsData
    Escenario: Visualizar el listado por defecto de todos las categorias
        Dado espero a que aparezca el contenido dinámico "Autos y Motos" en ".backgrid-category-list"
        Y espero a que aparezca el contenido dinámico "Tv y Video" en ".backgrid-category-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nueva Categoría" en ".container"

    @javascript @loadBenefitsData
    Escenario: Visualizar y ordenar un listado
        Dado espero a que aparezca el contenido dinámico "Autos y Motos" en ".backgrid-category-list"
        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Autos y Motos" en ".backgrid-category-list"
        Y no debo ver "Viajes y Turismo"
        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Viajes y Turismo" en ".backgrid-category-list"
        Y no debo ver "Autos y Moto"


    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador
        Dado espero a que aparezca el contenido dinámico "Autos y Motos" en ".backgrid-category-list"
        Y espero a que aparezca el contenido dinámico "Tv y Video" en ".backgrid-category-list"

        Cuando hago click en "#page-2"
        Y espero a que aparezca el contenido dinámico "Viajes y Turismo" en ".backgrid-category-list"

        Cuando hago click en "#page-first"
        Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".backgrid-category-list"
        Entonces espero a que aparezca el contenido dinámico "Tv y Video" en ".backgrid-category-list"
        
        Cuando hago click en "#page-next"
        Y espero a que aparezca el contenido dinámico "Viajes y Turismo" en ".backgrid-category-list"

    @javascript @loadBenefitsData
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de un comercio
        Dado espero a que aparezca el contenido dinámico "Autos y Motos" en ".backgrid-category-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "Viajes y Turismo"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Viajes y Turismo" en ".backgrid-category-list"
        Y no debo ver "Autos y Motos"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Cuando relleno "filters[name]" con "categoria00000"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "No hay categorías" en ".backgrid-category-list"
        Cuando hago click en "#name-filter-btn-close"
        Entonces espero a que aparezca el contenido dinámico "Autos y Motos" en ".backgrid-category-list" 