#language: es
Característica: Como usuario administrador del backoffice quiero crear una sub categoria

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y hago click y sigo ".list-categories"
        Entonces espero a que aparezca el contenedor dinámico ".table-category-list"
        Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".table-category-list"
        Y hago click y sigo ".string-cell:first"
        Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".breadcrumb"
        Y espero a que aparezca el contenido dinámico "Accesorios de Autos y Motos" en ".category-categories"
        Y hago click y sigo ".category-categories .action-icon:first"
        Y espero a que aparezca el contenido dinámico "Editar sub-categoría" en ".breadcrumb"
        Y espero a que aparezca el contenedor dinámico ".category-form"

    @javascript @loadBenefitsData
    Escenario: Crear una sub categoria
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "es_ES" con "Bebés"
        Y relleno "pt_BR" con "Bebês"
        Y relleno "en_US" con "Babies"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenedor dinámico ".category-view-container"
        Y espero a que aparezca el contenido dinámico "Bebés" en "#name"

    @javascript @loadBenefitsData
    Escenario: Crear una nueva sub categoria sin datos obligatorios
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "es_ES" con ""
        Y relleno "pt_BR" con ""
        Y relleno "en_US" con ""
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "El campo Categoría en Español es obligatorio" en ".category-form .help-block"
        Y espero a que aparezca el contenido dinámico "El campo Categoría en Inglés es obligatorio" en ".category-form .help-block"
        Y espero a que aparezca el contenido dinámico "El campo Categoría en Portugués es obligatorio" en ".category-form .help-block"

    @javascript @loadBenefitsData
    Escenario: Cargar una Sub Categoría sin respetar el máximo de caracteres en los campos
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "es_ES" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Y relleno "pt_BR" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Y relleno "en_US" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Cuando presiono "Guardar"
        Entonces debo ver "El campo Categoría en Español no puede superar los 80 caracteres"
        Y debo ver "El campo Categoría en Inglés no puede superar los 80 caracteres"
        Y debo ver "El campo Categoría en Portugués no puede superar los 80 caracteres"
