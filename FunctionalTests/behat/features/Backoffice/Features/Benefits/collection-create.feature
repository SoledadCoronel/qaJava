#language: es
Característica: Como usuario administrador del backoffice quiero crear un beneficio especial

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y sigo "Administrar especiales"
        Entonces espero a que aparezca el contenedor dinámico ".table-collection-list"
        Y sigo "Nuevo Especial"
        Entonces espero a que aparezca el contenedor dinámico ".collection-form"

    @javascript @loadBenefitsBenefitData
    Escenario: Crear un nuevo especial
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "internalName" con "Coleccion Maravillas"
        Y relleno "es_ES" con "Coleccion Maravillas de la naturaleza"
        Y relleno "en_US" con "Wonder of nature collection"
        Y relleno "pt_BR" con "Coleçao Maravilhas da natureza"
        Y relleno la fecha "validUntil" con "01/12/2020"

        Y adjunto el archivo "auto.jpg" a "file-image"
        Y espero a que aparezca el contenedor dinámico "#image-crop"
        Y hago click en ".crop-done"

        Y relleno "search-companies" con "Panamericano Bariloche"
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".ui-menu-item"
        Y hago click en ".ui-menu-item:contains(Panamericano Bariloche)"
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".table-benefits-selectable"
        Y hago click en ".table-benefits-selectable input[type=checkbox]:eq(0)"
        Y hago click en ".multi-select-button.left"
        Y espero a que aparezca el contenido dinámico "Panamericano Bariloche" en ".table-benefits-selected"

        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenedor dinámico ".collection-view-container"
        Y espero a que aparezca el contenido dinámico "Coleccion Maravillas de la naturaleza" en "#name"

    @javascript @loadBenefitsBenefitData
    Escenario: Crear un nuevo especial sin datos obligatorios
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "El campo Categoría en Español es obligatorio" en ".collection-form .help-block"
        Y espero a que aparezca el contenido dinámico "El campo Categoría en Inglés es obligatorio" en ".collection-form .help-block"
        Y espero a que aparezca el contenido dinámico "El campo Categoría en Portugués es obligatorio" en ".collection-form .help-block"
        Y espero a que aparezca el contenido dinámico "El especial debe tener al menos un beneficio relacionado" en "#benefits"

    @javascript @loadBenefitsBenefitData
    Escenario: Cargar un Especial sin respetar el máximo de caracteres en los campos
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "es_ES" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Y relleno "pt_BR" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Y relleno "en_US" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Cuando presiono "Guardar"
        Entonces debo ver "El campo Categoría en Español no puede superar los 80 caracteres"
        Y debo ver "El campo Categoría en Inglés no puede superar los 80 caracteres"
        Y debo ver "El campo Categoría en Portugués no puede superar los 80 caracteres"
