# language: es
Característica: Configurar un ambiente público sin login como usuario admin

  Antecedentes:
    Dado estoy en "/auth/signin?_lang=es"
    Y relleno "_username" con "johnconnor"
    Y relleno "_password" con "123456"
    Cuando presiono "_submit"
    Entonces debo estar en "/"
    Y sigo "Sin Login"
    Y espero a que aparezca el contenido dinámico "Configurar" en "header.app-name"
    Y sigo el link "Configurar"
    Y espero a que aparezca el contenido dinámico "Agregar Módulo" en "header.app-name"
    Y presiono "Agregar Módulo"
    Y sigo "Nuevo Módulo"
    Y espero a que aparezca el contenido dinámico "Continuar" en ".modal-footer"

  @javascript @loadInstallApplicationWidgetData
  Escenario: Instalar widget estándar en un ambiente público sin login y una plataforma sin beneficios públicos
    Y debo ver "Estándar"
    Y no debo ver "Aplicaciones instaladas"
    Y no debo ver el contenedor dinámico ".benefits-app-radio"
    Y presiono "Continuar"
    Y espero a que aparezca el contenido dinámico "Tipo de módulos" en ".modal-body"
    Y presiono "Continuar"
    Y espero a que aparezca el contenido dinámico "Configuración" en ".widget-form"
    Y relleno "name" con "Banner 2"
    Y hago visible "banner-image-upload"
    Y adjunto el archivo "tyrion.jpg" a "banner-image-upload"
    Cuando presiono "Finalizar"
    Y presiono "Aceptar"
    Entonces debe aparecer el contenido dinámico "Sin Login" en "#environmentHome"
