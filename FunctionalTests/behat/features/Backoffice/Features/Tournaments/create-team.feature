#language: es
Característica: Crear un equipo de un torneo en la plataforma desde el backoffice.

  Antecedentes:
    Dado estoy en "/backoffice/signin"
    Y relleno "_username" con "apibackofficetester"
    Y relleno "_password" con "apitesterbackoffice"
    Y presiono "_submit"
    Y sigo "Torneos Pro"
    Entonces espero a que aparezca el contenido dinámico "Copa Mundial Brasil 2014" en "#content"
    Y hago click en ".dropdown-toggle"
    Cuando sigo "Listar Equipos"
    Entonces espero a que aparezca el contenido dinámico "Equipos" en "#content"
    Y sigo "Nuevo Equipo"
    Cuando espero a que aparezca el contenedor dinámico ".form-horizontal"

  @javascript @loadTournamentsStandardData
  Escenario: Visualizar el formulario de creación de equipo.
    Dado relleno "c2_name_es_ES" con "Burkina Faso"
    Y relleno "c2_name_en_US" con "Burkina Faso"
    Y relleno "c2_name_pt_BR" con "Burkina Faso"
    Y relleno "Abreviatura *" con "BKF"
    Y hago click en "#file-c2_file"
    Y adjunto el archivo "homerosapiens.jpg" a "file-c2_file"
    Y marco "Activo"
    Y presiono "Guardar"
    Y espero a que cambie la URL

  @javascript @loadTournamentsStandardData
  Escenario: Crear un equipo sin nombre
    Y relleno "Abreviatura *" con "BKF"
    Y hago click en "#file-c2_file"
    Y adjunto el archivo "homerosapiens.jpg" a "file-c2_file"
    Y marco "Activo"
    Y presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Debe completar todos los campos" en "#content"

  @javascript @loadTournamentsStandardData
  Escenario: Cargar un torneo con título mayor a 80 caracteres
    Dado relleno "c2_name_es_ES" con "Brasil1111111111111122222222222222222222222222222222223333333333333333333sssssssssssssssssssssssfffffffffffff"
    Y relleno "c2_name_en_US" con "Brasil1111111111111122222222222222222222222222222222223333333333333333333sssssssssssssssssssssssfffffffffffff"
    Y relleno "c2_name_pt_BR" con "Brasil1111111111111122222222222222222222222222222222223333333333333333333sssssssssssssssssssssssfffffffffffff"
    Y relleno "Abreviatura *" con "BKF"
    Y hago click en "#file-c2_file"
    Y adjunto el archivo "homerosapiens.jpg" a "file-c2_file"
    Y marco "Activo"
    Y presiono "Guardar"
    Entonces espero a que aparezca el contenido dinámico "Solo se pueden ingresar 40 caracteres" en "#content"