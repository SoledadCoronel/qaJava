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

  @javascript @loadBenefitsPublicPlatform
  Escenario: Instalar widget de beneficios en un ambiente público sin login
    Y debo ver "Estándar"
    Y debo ver "Beneficios"
    Y no debo ver "Aplicaciones instaladas"
    Cuando hago click en ".benefits-app-radio"
    Y presiono "Continuar"
    Entonces debo ver "Especiales"
    Y debo ver "Categorías"
    Y debo ver "Ranking"
