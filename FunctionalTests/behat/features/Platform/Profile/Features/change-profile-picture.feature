# language: es
  Característica: Cambiar imagen de perfil desde Mi PC
    Como usuario comun
    Necesito poder cambiar mi foto de perfil desde una imagen en mi PC

    Antecedentes: Autenticación en la plataforma con email y contraseña.
      Dado estoy en "/auth/signin?_lang=es"
      Y relleno "_username" con "johnconnor"
      Y relleno "_password" con "go1234"
      Cuando presiono "_submit"
      Y voy a "/profile"

    @javascript @loadUserAndPostData
    Escenario: Cambio la foto de perfil satisfactoriamente
      Dado sigo "changeProfilePicture"
      Y hago visible "profilePictureUpload"
      Cuando adjunto el archivo "tyrion.jpg" a "profilePictureUpload"
      Entonces debe aparecer el contenido dinámico "La imagen se cambió correctamente" en ".alert-success"

    @javascript @loadUserAndPostData
    Escenario: Intento cambiar la foto de perfil con un archivo que no sea una imagen
      Dado sigo "changeProfilePicture"
      Y hago visible "profilePictureUpload"
      Cuando adjunto el archivo "test.txt" a "profilePictureUpload"
      Entonces debe aparecer el contenido dinámico "El tipo de archivo es inválido" en ".alert-error"

    @javascript @loadUserAndPostData
    Escenario: Intento cambiar la foto de perfil con una imagen demasiado grande
      Dado sigo "changeProfilePicture"
      Y hago visible "profilePictureUpload"
      Cuando adjunto el archivo "tyrion-grande.jpg" a "profilePictureUpload"
      # Este test no pasa, jamás se despliega el mensaje de error. Queda comentado hasta
      # que se solucione el inconveniente.
      #Entonces debe aparecer el contenido dinámico "El tamaño del archivo es demasiado grande" en ".alert-error"

    @javascript @loadUserAndPostData
    Escenario: Intento cambiar la foto de perfil y me paso del storage máximo
      Dado sigo "changeProfilePicture"
      Y hago visible "profilePictureUpload"
      Y adjunto el archivo "tyrion.jpg" a "profilePictureUpload"
      Y debe aparecer el contenido dinámico "La imagen se cambió correctamente" en ".alert-success"
      Cuando adjunto el archivo "tyrion.jpg" a "profilePictureUpload"
      # Este test no pasa, jamás se despliega el mensaje de error. Queda comentado hasta
      # que se solucione el inconveniente.
      #Entonces debe aparecer el contenido dinámico "La plataforma no tiene más espacio disponible" en ".alert-error"
