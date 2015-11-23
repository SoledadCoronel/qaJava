#language: es
Característica: Ver una Especial.
  Como usuario administrador del backoffice quiero ver un Beneficio Especial

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Cuando presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Entonces  espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y sigo "Administrar especiales"
        Y espero a que aparezca el contenedor dinámico ".table-collection-list"

        @javascript @loadCollectionBenefitsData
        Escenario: Ver beneficio
        Dado relleno "filters[name]" con "Día de la Madre"
        Y hago click en "#name-filter-btn-submit"
        Y espero a que aparezca el contenido dinámico "Día de la Madre" en ".backgrid-company-list"
        Y sigo "Día de la Madre"
        Y el breadcrumb debe ser "Inicio > Beneficios Corporativos > Especiales > Día de la Madre"
        Y espero a que aparezca el contenido dinámico "Día de la Madre" en ".backoffice-header"
        Y espero a que aparezca el contenido dinámico "Si" en "#active"
        Y espero a que aparezca el contenido dinámico "Día de la Madre" en "#name"
        Y debo ver "Dia das mães"
        Y debo ver "Mother's day "
        Y espero a que aparezca el contenido dinámico "19/10/2014" en "#validUntil"
        Y espero a que aparezca el contenido dinámico "test" en "#image"

        @javascript @loadCollectionBenefitsData
        Escenario: Editar beneficio
        Dado relleno "filters[name]" con "Día de la Madre"
        Y hago click en "#name-filter-btn-submit"
        Y espero a que aparezca el contenido dinámico "Día de la Madre" en ".backgrid-company-list"
        Y sigo "Día de la Madre"
        Y espero a que aparezca el contenido dinámico "Día de la Madre" en ".breadcrumb"
        Y el breadcrumb debe ser "Inicio > Beneficios Corporativos > Especiales > Día de la Madre"
        Y presiono "Editar"
        Entonces la URL debe seguir el patrón "/backoffice/benefits/collection/\d+/edit"
