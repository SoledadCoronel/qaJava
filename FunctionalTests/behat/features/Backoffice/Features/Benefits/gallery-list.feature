#language: es
Característica: Visualizar el listado completo de gallerías de beneficios

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Administrar galerías" en ".list-galleries"
        Y sigo "Administrar galerías"
        Y espero a que aparezca el contenido dinámico "Galerías de beneficios" en ".breadcrumb"
        
    @javascript @loadGalleryData
    Escenario: Visualizar el listado por defecto de todas las galerías
        Dado espero a que aparezca el contenido dinámico "Acusage" en ".backgrid-gallery-list"
        Y espero a que aparezca el contenido dinámico "Poochies" en ".backgrid-gallery-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nueva galería" en ".container"
        Y espero a que aparezca el contenido dinámico "Listado de galerías" en ".container"

    @javascript @loadGalleryData
    Escenario: Visualizar y ordenar un listado
        Dado espero a que aparezca el contenido dinámico "Acusage" en ".backgrid-gallery-list"

        Cuando hago click en "#head-active"
        Entonces espero a que aparezca el contenido dinámico "Dogtown" en ".backgrid-gallery-list"
        Y no debo ver "Acusage"

        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Acusage" en ".backgrid-gallery-list"

        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Zaggles" en ".backgrid-gallery-list"
        Y no debo ver "Acusage"

        Cuando hago click en "#head-benefits"
        Entonces espero a que aparezca el contenido dinámico "Zaggles" en ".backgrid-gallery-list"
        Y no debo ver "Telepark"

        Cuando hago click en "#head-benefits"
        Entonces espero a que aparezca el contenido dinámico "Telepark" en ".backgrid-gallery-list"
        Y espero a que aparezca el contenido dinámico "4" en ".backgrid-gallery-list .template"

    @javascript @loadGalleryData
    Escenario: Visualizar un listado y navegar entre sus paginas usando todos los controles del paginador
        Dado espero a que aparezca el contenido dinámico "Acusage" en ".backgrid-gallery-list"
        Y espero a que aparezca el contenido dinámico "Poochies" en ".backgrid-gallery-list"

        Cuando hago click en "#page-2"
        Y espero a que aparezca el contenido dinámico "Progenex" en ".backgrid-gallery-list"
        Entonces espero a que aparezca el contenido dinámico "Zaggles" en ".backgrid-gallery-list"

        Cuando hago click en "#page-first"
        Y espero a que aparezca el contenido dinámico "Acusage" en ".backgrid-gallery-list"
        Entonces espero a que aparezca el contenido dinámico "Poochies" en ".backgrid-gallery-list"
        
        Cuando hago click en "#page-next"
        Y espero a que aparezca el contenido dinámico "Progenex" en ".backgrid-gallery-list"
        Entonces espero a que aparezca el contenido dinámico "Zaggles" en ".backgrid-gallery-list"

    @javascript @loadGalleryData
    Escenario: Visualizar un listado y filtrarlo buscando por el nombre de una galería
        Dado espero a que aparezca el contenido dinámico "Acusage" en ".backgrid-gallery-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "Savvy"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "Savvy" en ".backgrid-gallery-list"
        Y no debo ver "Acusage"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Cuando relleno "filters[name]" con "galería00000"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "No se encontraron galerías" en ".backgrid-gallery-list"
        Cuando hago click en "#name-filter-btn-close"
        Entonces espero a que aparezca el contenido dinámico "Acusage" en ".backgrid-gallery-list"