#language: es
Característica: Administrar widgets de celebraciones

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Y espero a que aparezca el contenido dinámico "Configurar" en "#environmentHome"
    Entonces debo estar en "/"
    Y sigo el link "Configurar"
    Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
    Y presiono "Agregar Módulo"
    Y sigo "Nuevo Módulo"
    Y espero a que aparezca el contenido dinámico "Continuar" en ".modal-footer"
    Y hago click en ".installed-app-radio"
    Y presiono "Continuar"
    Y espero a que aparezca el contenido dinámico "Celebraciones Corporativas" en ".workspace-tree"
    Y hago click en ".installed-app:contains(Celebraciones Corporativas)"
    Y hago click en ".next-button:contains(Continuar)"
    Y espero a que aparezca el contenedor dinámico ".category-input:first"

  @javascript @loadCelebrationsData
  Escenario: Crear widget de celebraciónes con orden cronológico sólo para la Categoría 2, luego guardo los cambios
    Y relleno "name" con "Celebraciones en un widget 1"
    Y hago click en ".all-categories"
    Y hago click en ".category-input:eq(1)"
    Cuando hago click en ".install-button:contains(Finalizar)"
    Y espero a que desaparezca "#categories-list"
    Entonces no debo ver "Categoría de prueba 1"
    Y hago click en ".configuration-commit:contains(Aceptar)"
    Y espero a que aparezca el contenedor dinámico ".widgetCelebrations"

  @javascript @loadCelebrationsData
  Escenario: Crear widget de celebraciónes con las últimas cargadas de toda la aplicación, luego guardo los cambios
    Y relleno "name" con "Celebraciones en un widget 2"
    Y hago click en ".category-input:last"
    Cuando hago click en ".install-button:contains(Finalizar)"
    Y hago click en ".configuration-commit:contains(Aceptar)"
    Entonces espero a que aparezca el contenedor dinámico ".widgetCelebrations"
