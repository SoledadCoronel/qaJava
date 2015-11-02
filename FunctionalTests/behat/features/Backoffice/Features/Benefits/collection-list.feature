#language: es
Característica: Visualizar el listado completo de colecciones especiales

    Antecedentes:
        Dado estoy en "/backoffice/signin" 
        Y relleno "_username" con "apibackofficetester" 
        Y relleno "_password" con "apitesterbackoffice" 
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Administrar especiales" en ".button-bar"
        Y sigo "Administrar especiales"
        Y espero a que aparezca el contenido dinámico "Especiales" en ".breadcrumb"
        
    @javascript @loadCollectionBenefitsData
    Escenario: Visualizar el listado por defecto de todos los especiales con 6 especiales creados
        Dado espero a que aparezca el contenido dinámico "Colección Verano 2013" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "Día del Padre" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "Día del Padre" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "Día de la Mujer" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "Día de la Madre" en ".backgrid-company-list"
        Y espero a que aparezca el contenido dinámico "》》" en ".paginator"
        Y espero a que aparezca el contenido dinámico "Nuevo Especial" en ".create-collection"

    @javascript @loadCollectionBenefitsData
    Escenario: Visualizar y ordenar un listado
        Dado espero a que aparezca el contenido dinámico "Colección Verano 2013" en ".backgrid-company-list"

        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Colección Verano 2013" en ".backgrid-company-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "Navidad" en ".backgrid-company-list  tbody tr:last"

        Cuando hago click en "#head-name"
        Entonces espero a que aparezca el contenido dinámico "Navidad" en ".backgrid-company-list tbody tr:first"
        Y espero a que aparezca el contenido dinámico "Colección Verano 2013" en ".backgrid-company-list  tbody tr:last"

    @javascript @loadCollectionBenefitsData
    Escenario: Visualizar un listado y filtrarlo busco por el nombre de un especial
        Dado espero a que aparezca el contenido dinámico "Colección Verano 2013" en ".backgrid-company-list"
        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Y relleno "filters[name]" con "Navidad"
        Y hago click en "#name-filter-btn-submit"
        Y espero a que desaparezca el contenido dinámico "Colección Verano 2013" en ".backgrid-company-list"

        Y espero a que aparezca el contenedor dinámico "#name-filter-container"
        Cuando relleno "filters[name]" con "categoria00000"
        Y hago click en "#name-filter-btn-submit"
        Entonces espero a que aparezca el contenido dinámico "No hay especiales" en ".backgrid-company-list"
        
        Cuando hago click en "#name-filter-btn-close"
        Entonces espero a que aparezca el contenido dinámico "Colección Verano 2013" en ".backgrid-company-list"  
