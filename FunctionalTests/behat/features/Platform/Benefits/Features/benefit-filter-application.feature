# language: es

Característica: Instalar una aplicación en una plataforma.
Como usuario administrador quiero poder instalar aplicaciones en un espacio desde el front.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenedor dinámico ".workspace-menu"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar. Presiono instalar en la app Filtro de Beneficios, completo todos los campos requeridos y envío el formulario. Volviendo al listado de aplicaciones visualizo un mensaje que me indica que la aplicación se instaló correctamente.
        Dado hago click en ".workspace-menu:first"
        Y sigo "Agregar aplicación"
        Y la URL debe seguir el patrón "workspace/\d+/app/list"
        Y espero a que aparezca el contenedor dinámico ".application-preview"
        Y presiono "Filtro Beneficios"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y espero a que aparezca el contenido dinámico "Nombre de la aplicación" en "#application-install"
        Y relleno "name" con "Mi app de Filtro Beneficios con especiales"
        Y relleno "description" con "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum"
        Y hago click en ".custom-radio"
        Y relleno "txt-search" con "Av Corrientes 1080, Ciudad Autónoma de Buenos Aires, Argentina"
        Y hago click en ".search-btn"
        Y hago visible "attachmentUpload"
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Y hago click en "#collections-radio"
        Y selecciono "Navidad" de "specials"
        Cuando presiono "accept"
        Y espero a que aparezca el contenedor dinámico ".filter-items-list"
        Entonces la URL debe seguir el patrón "benefits/search/result"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar. Presiono instalar en la app Filtro de Beneficios, no completo todos los campos requeridos y envío el formulario obteniendo un error.
        Dado hago click en ".workspace-menu:first"
        Y sigo "Agregar aplicación"
        Y la URL debe seguir el patrón "workspace/\d+/app/list"
        Y espero a que aparezca el contenedor dinámico ".application-preview"
        Y presiono "Filtro Beneficios"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y espero a que aparezca el contenido dinámico "Nombre de la aplicación" en "#application-install"
        # Hay que esperar que aparezca el widget de categorías sino tira error en la validación.
        Y espero a que aparezca el contenedor dinámico "#tree-categories-list"
        Cuando presiono "accept"
        Y espero a que aparezca el contenido dinámico "Existen errores en el formulario" en "#install-app-view"
        Entonces debo ver "Existen errores en el formulario"
        Y debo ver "Ingrese el nombre de la aplicación"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar. Presiono instalar en la app Filtro de Beneficios, completo todos los campos requeridos y envío el formulario. Volviendo al listado de aplicaciones visualizo un mensaje que me indica que la aplicación se instaló correctamente.
        Dado hago click en ".workspace-menu:first"
        Y sigo "Agregar aplicación"
        Y la URL debe seguir el patrón "workspace/\d+/app/list"
        Y espero a que aparezca el contenedor dinámico ".application-preview"
        Y presiono "Filtro Beneficios"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y espero a que aparezca el contenido dinámico "Nombre de la aplicación" en "#application-install"
        Y relleno "name" con "Mi app de Filtro Beneficios con categorias"
        Y relleno "description" con "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum"
        Y hago click en ".custom-radio"
        Y relleno "txt-search" con "Villa Crespo - Buenos Aires, Autonomous City of Buenos Aires, Argentina"
        Y hago click en ".search-btn"
        Y hago visible "attachmentUpload"
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Y hago click en "#categories-radio"
        Y hago click en "ul.nav.nav-list.tree:eq(1) li:eq(0) input"
        Cuando presiono "accept"
        Y espero a que aparezca el contenido dinámico "Autos y Motos" en ".active-filters"
        Y espero a que aparezca el contenedor dinámico ".active-filters li"
        Entonces debo ver "Mi app de Filtro Beneficios con categorias"
        Y la URL debe seguir el patrón "benefits/search/result"

    @javascript @loadBenefitsStandardData @Solr
    Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar. Presiono instalar en la app Filtro de Beneficios, completo todos los campos requeridos y envío el formulario. Volviendo al listado de aplicaciones visualizo un mensaje que me indica que la aplicación se instaló correctamente.
        Dado hago click en ".workspace-menu:first"
        Y sigo "Agregar aplicación"
        Y la URL debe seguir el patrón "workspace/\d+/app/list"
        Y espero a que aparezca el contenedor dinámico ".application-preview"
        Y presiono "Filtro Beneficios"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y espero a que aparezca el contenido dinámico "Nombre de la aplicación" en "#application-install"
        Y relleno "name" con "Mi app de Filtro Beneficios con especiales"
        Y relleno "description" con "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum"
        Y hago visible "attachmentUpload"
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Y hago click en "#all-categories-radio"
        Y hago click en ".platform-radio"
        Cuando presiono "accept"
        Y espero a que aparezca el contenedor dinámico ".filter-items-list"
        Entonces la URL debe seguir el patrón "benefits/search/result"

    @javascript @loadBenefitsRestrictedPlatformsData
    Escenario: Desde la configuración de un espacio ingreso a la sección de aplicaciones disponibles para instalar.
    Presiono instalar en la app de Filtro de Beneficios, hago click en el filtro de Categorías y subcategorías y verifico la inhibición de la categoría Belleza y Salud.
        Dado hago click en ".workspace-menu:first"
        Y sigo "Agregar aplicación"
        Y la URL debe seguir el patrón "workspace/\d+/app/list"
        Y espero a que aparezca el contenedor dinámico ".application-preview"
        Y presiono "Filtro Beneficios"
        Y la URL debe seguir el patrón "workspace/\d+/app/\d+/install"
        Y espero a que aparezca el contenedor dinámico "#categories-control"
        Cuando hago click en "#categories-radio"
        Entonces no debo ver "Belleza y Salud"
