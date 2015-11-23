#language: es
Característica: Ver galería de beneficios

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Administrar galerías" en ".list-galleries"
        Y sigo "Administrar galerías"
        Y espero a que aparezca el contenido dinámico "Galerías de beneficios" en ".breadcrumb"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"

    @javascript @loadGalleryData
    Escenario: Visualizar los datos de la galería
        Dado relleno "filters[name]" con "Telepark"
        Y hago click en "#name-filter-btn-submit"
        Y espero a que aparezca el contenido dinámico "Telepark" en ".backgrid-gallery-list"
        Cuando sigo "Telepark"
        Y espero a que aparezca el contenido dinámico "Información básica" en ".gallery-basic-information"
        Entonces la URL debe seguir el patrón "backoffice/benefits/gallery/\d+/view"
        Y espero a que aparezca el contenido dinámico "Telepark" en ".gallery-basic-information"
        Y espero a que aparezca el contenido dinámico "Si" en ".gallery-basic-information"
        Y espero a que aparezca el contenido dinámico "Beneficios" en ".gallery-benefits"
        Y espero a que aparezca el contenido dinámico "Computers Depot" en ".string-cell"
        Y debo ver "ex"
        Y debo ver "30%"
        Y debo ver "Regalos al Mundo"
        Y debo ver "velit"
        Y debo ver "70%"