# language: es

Característica: Instalar widgets de aplicaciones instaladas.
    Como usuario administrador de la plataforma quiero poder instalar widgets de aplicaciones instaladas desde el gestor de widgets.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
        Y sigo el link "Configurar"
        Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
        Y presiono "Agregar Módulo"
        Y sigo "Nuevo Módulo"
        Y espero a que aparezca el contenido dinámico "Continuar" en ".modal-footer"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Desde la página principal de la plataforma agrego un nuevo módulo de aplicaciones instaladas en caracter de administrador. Entonces debo visualizar el selector de aplicaciones instaladas con el primer ambiente y espacio desplegados y la primer aplicación seleccionada.
    En el siguiente paso debo visualizar el formulario de widget de Galerías correspondiente, me dispongo a completar la instalación sin rellenar los campos requeridos y debo visualizar los mensajes de error desplegados por estos últimos.
        Dado hago click en ".installed-app-radio"
        Y presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Galería Corporativa" en "ul.environment-tree"
        Y hago click en ".installed-app:contains(Galería Corporativa)"
        Y hago click en ":contains(Continuar):visible"
        Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
        Cuando presiono "Finalizar"
        Entonces debo ver "Este campo es obligatorio."
        Y debo ver "Seleccione almenos una imagen."

    @javascript @loadInstallApplicationWidgetData
    Escenario: Desde la página principal de la plataforma agrego un nuevo módulo de aplicaciones instaladas en caracter de administrador. Entonces debo visualizar el selector de aplicaciones instaladas con el primer ambiente y espacio desplegados y la primer aplicación seleccionada.
    En el siguiente paso debo visualizar el formulario de widget de Galerías correspondiente y posteriormente la previsualización del mismo y el botón de confirmación para completar la instalación.
        Dado hago click en ".installed-app-radio"
        Y presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Galería Corporativa" en "ul.environment-tree"
        Y hago click en ".installed-app:contains(Galería Corporativa)"
        Y hago click en ":contains(Continuar):visible"
        Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
        Y relleno "name" con "Death Star"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(0)"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(1)"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(2)"
        Y hago click en "ul.images li input:eq(0)"
        Y hago click en "ul.images li input:eq(1)"
        Y hago click en "ul.images li input:eq(2)"
        Y hago click en ":contains(Finalizar):visible"
        Cuando hago click en ":contains(Aceptar):visible"
        Entonces espero a que aparezca el contenedor dinámico ".widget"

    @javascript @loadInstallApplicationWidgetData
    Escenario: Desde la página principal de la plataforma edito un widget de aplicaciones instaladas en caracter de administrador. Entonces debo visualizar el widget de Galerías previamente instalado, editar la información del mismo, aceptar los cambios y cofirmar estos últimos para completar la edición.
        Dado hago click en ".installed-app-radio"
        Y presiono "Continuar"
        Y espero a que aparezca el contenido dinámico "Galería Corporativa" en "ul.environment-tree"
        Y hago click en ".installed-app:contains(Galería Corporativa)"
        Y hago click en ":contains(Continuar):visible"
        Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
        Y relleno "name" con "Death Star"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(0)"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(1)"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(2)"
        Y hago click en "ul.images li input:eq(0)"
        Y hago click en "ul.images li input:eq(1)"
        Y hago click en "ul.images li input:eq(2)"
        Y presiono "Finalizar"
        Y hago click en ".widget-edit:eq(1)"
        Y hago click en ".edit-btn:eq(1)"
        Y espero a que aparezca el contenido dinámico "Título" en ".widget-form"
        Y selecciono "Rebel Alliance" de "album-selector"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(3)"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(4)"
        Y espero a que aparezca el contenedor dinámico "ul.images li input:eq(5)"
        Y hago click en "ul.images li input:eq(3)"
        Y hago click en "ul.images li input:eq(4)"
        Y hago click en "ul.images li input:eq(5)"
        Y hago click en ".install-button"
        Cuando presiono "Aceptar"
        Entonces espero a que aparezca el contenedor dinámico ".widget"
