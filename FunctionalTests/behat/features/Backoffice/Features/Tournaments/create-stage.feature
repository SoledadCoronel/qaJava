#language: es
Característica: Crear un Torneo Pro en la plataforma desde el backoffice.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "Torneos Pro"
    Entonces espero a que aparezca el contenido dinámico "Fase de grupos y eliminación directa" en "#content"
    Y hago click en ".dropdown-toggle"
    Y sigo "Listar Fases"
    Entonces espero a que aparezca el contenido dinámico "Fase de grupos" en "#content"
    Y sigo "Nueva Fase"
    Cuando espero a que aparezca el contenedor dinámico ".form-horizontal"

    @javascript @loadStandardTournamentData
    Escenario: Cargar una nueva fase.
      Dado relleno "c1_name_es_ES" con "Semifinales ES"
      Y relleno "c1_name_en_US" con "Semifinales EN"
      Y relleno "c1_name_pt_BR" con "Semifinales PT"
      Y relleno "c1_exactResultPoints" con "10"
      Y relleno "c1_resultPoints" con "20"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014" en "#content"

    @javascript @loadStandardTournamentData
    Escenario: Cargar una fase sin nombre.
      Dado relleno "c1_exactResultPoints" con "10"
      Y relleno "c1_resultPoints" con "20"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Debe completar todos los campos" en "#content"

    @javascript @loadStandardTournamentData
    Escenario: Cargar una fase sin puntos ganador.
      Dado relleno "c1_name_es_ES" con "Semifinales ES"
      Y relleno "c1_name_en_US" con "Semifinales EN"
      Y relleno "c1_name_pt_BR" con "Semifinales PT"
      Y relleno "c1_resultPoints" con "20"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Valor requerido" en "#content"

    @javascript @loadStandardTournamentData
    Escenario: Cargar una fase sin puntos Resultado.
      Dado relleno "c1_name_es_ES" con "Semifinales ES"
      Y relleno "c1_name_en_US" con "Semifinales EN"
      Y relleno "c1_name_pt_BR" con "Semifinales PT"
      Y relleno "c1_exactResultPoints" con "10"
      Cuando presiono "Guardar"
      Entonces espero a que aparezca el contenido dinámico "Valor requerido" en "#content"