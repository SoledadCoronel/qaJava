# language: es
Característica: Como usuario quiero poder taggear otros usuarios al compartir un post

      Antecedentes:
          Dado estoy en "/auth/signin?_lang=es"
          Y relleno "_username" con "johnconnor"
          Y relleno "_password" con "123456"
          Cuando presiono "_submit"
          Entonces debo estar en "/"

      @javascript @loadStandardData
      Escenario: Compartir un post agregando varios colaboradores
          Dado sigo "Actividad Social"
          Y espero a que aparezca el contenido dinámico "Archivo" en "body"
          Y hago click en ".post-file a:first"
          Y espero a que aparezca el contenido dinámico "Subir archivos desde mi computadora" en ".post-form"
          Y hago visible "attachmentUpload"
          Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
          Y espero a que la barra de progreso ".progress" se cargue completamente
          Y relleno "post-file-input" con "La evolución del hombre según los Simpsons"
          Y presiono "post-file"
          Y espero a que aparezca el contenido dinámico "La evolución del hombre según los Simpsons" en ".all-feeds.wall-feed"
          Y sigo "Compartir"
          Y espero a que aparezca el contenedor dinámico ".text-tags"
          Y relleno "textarea" con "Sarah"
          Y espero a que aparezca el contenido dinámico "Sarah Connor" en "#sharing-targets"
          Y hago click en "#sharing-targets span.text-label"
          Y sigo "share-btn"
          Cuando sigo "collaborators-list"
          Y espero a que aparezca el contenido dinámico "Sarah Connor" en "#collaborators-grid"
          Y sigo "Sarah Connor"
          Entonces debo estar en "/profile/sarah-connor"
          Y espero a que aparezca el contenedor dinámico ".all-feeds.wall-feed"
          Y espero a que aparezca el contenido dinámico "La evolución del hombre según los Simpsons" en ".well-image"
