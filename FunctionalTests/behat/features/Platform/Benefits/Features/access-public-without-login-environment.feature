# language: es
Característica: Acceder a un ambiente público sin login

  Antecedentes:
    Dado estoy en "/?_lang=es"
    Entonces espero a que aparezca el contenido dinámico "Inicio" en "#environments"
    Y debo ver "Grilla + Muro" en el elemento "#environments"
    Y debo ver "Beneficios Corporativos" en el elemento "#environments"
    Y debo ver "Sin Login" en el elemento "#environments"
    Y "Sin Login" debe estar activo

  @javascript @loadBenefitsPublicPlatform
  Escenario: Acceder a un ambiente público sin login y con beneficios públicos
    Y debo ver "Widget de HTML/Texto."
    Y debo ver "ESPACIO PÚBLICO SIN LOGIN"
    Y debo ver "Mapa de Categorías de Beneficios Corporativos"
    Y espero a que aparezca el contenedor dinámico ".benefits-ranking"
    Y espero a que aparezca el contenedor dinámico ".cross-search"
    # @todo Comprobar la búsqueda cuando esté terminada la vista de resultado de búsqueda por beneficios.
    # Debería redirigirte directamente al resultado por beneficios sin pasar por el general.
