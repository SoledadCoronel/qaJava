#language: es
Característica: Como usuario administrador del backoffice quiero crear un comercio

    Antecedentes:
        Dado estoy en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y sigo "Beneficios Corporativos"
        Y espero a que aparezca el contenido dinámico "Listado de Comercios" en ".breadcrumb"
        Y sigo "Administrar categorías"
        Entonces espero a que aparezca el contenedor dinámico ".table-category-list"
        Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".table-category-list"
        Y hago click y sigo ".action-icon:first"
        Y espero a que aparezca el contenido dinámico "Editar categoría" en ".breadcrumb"
        Y espero a que aparezca el contenedor dinámico ".category-form"

    @javascript @loadBenefitsData
    Escenario: 1. Crear categoria
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "es_ES" con "Autos y Camionetas"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenedor dinámico "#category-container"
        Y espero a que aparezca el contenido dinámico "Autos y Camionetas" en "#name"



    @javascript @loadBenefitsData
    Escenario: 2. Editar una categoria sin datos obligatorios
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "es_ES" con ""
        Y relleno "pt_BR" con ""
        Y relleno "en_US" con ""
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenido dinámico "El campo Categoría en Español es obligatorio" en ".category-form .help-block"
        Y espero a que aparezca el contenido dinámico "El campo Categoría en Inglés es obligatorio" en ".category-form .help-block"
        Y espero a que aparezca el contenido dinámico "El campo Categoría en Portugués es obligatorio" en ".category-form .help-block"

    @javascript @loadBenefitsData
    Escenario: 3. Editar una Categoría sin respetar el máximo de caracteres en los campos
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "es_ES" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Y relleno "pt_BR" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Y relleno "en_US" con "Bebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeñosBebes y pequeños"
        Cuando presiono "Guardar"
        Entonces debo ver "El campo Categoría en Español no puede superar los 80 caracteres"
        Y debo ver "El campo Categoría en Inglés no puede superar los 80 caracteres"
        Y debo ver "El campo Categoría en Portugués no puede superar los 80 caracteres"

    @javascript @loadBenefitsData
    Escenario: 4. Editar una categoría Y restringir plataformas
        Y espero a que aparezca el contenedor dinámico ".field-translation-es"
        Y relleno "restrictedPlatforms-input" con "Standard Account"
        Y espero a que aparezca el contenido dinámico "Standard Account" en ".ui-menu-item"
        Y hago click en ".ui-menu-item:contains(Standard Account)"
        Y espero a que aparezca el contenido dinámico "Hugo" en ".selectable-platforms"
        Y hago click en ".selectable-platforms li:eq(0)"
        Cuando presiono "Guardar"
        Entonces espero a que aparezca el contenedor dinámico ".category-view-container"
        Y espero a que aparezca el contenido dinámico "Hugo" en ".category-restricted-platforms"
