# language: es
Característica: Acceder a un ambiente público sin login

  Antecedentes:
    Dado estoy en "/?_lang=es"
    Entonces espero a que aparezca el contenido dinámico "Inicio" en "#environments"
    Y debo ver "Grilla + Muro" en el elemento "#environments"
    Y debo ver "Beneficios Corporativos" en el elemento "#environments"
    Y debo ver "Sin Login" en el elemento "#environments"
    Y "Sin Login" debe estar activo

  @javascript @loadInstallApplicationWidgetData
  Escenario: Acceder a un ambiente público sin login y sin beneficios
    Y debo ver "Widget de HTML/Texto."
    Y debo ver "ESPACIO PÚBLICO SIN LOGIN"
    Y no debo ver el contenedor dinámico ".cross-search"
    Y no debo ver "Mapa de Categorías de Beneficios Corporativos"

  @javascript @loadInstallApplicationWidgetData
  Escenario: Acceder a un ambiente público sin login y sin beneficios e intentar acceder a un ambiente con login
    Cuando sigo "Inicio"
    Entonces debo estar en "/auth/signin"
