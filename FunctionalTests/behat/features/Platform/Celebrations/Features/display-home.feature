#language: es

Característica: Pantalla de inicio de Celebraciones.
    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Espacio Público" en "#workspaces"
        Y sigo "Celebraciones Corporativas"

    @javascript @loadStandardUserData
    Escenario: Ver la home de Celebraciones vacía.
        Dado la URL debe seguir el patrón "/app/celebrations/\d+"
        Cuando espero a que aparezca el contenido dinámico "No se encontraron celebraciones" en ".alert"
        Entonces debo ver "Nueva Celebración"

    @javascript @loadCelebrationsData
    Escenario: Mostrar las primeras 10 celebraciones.
        Dado la URL debe seguir el patrón "/app/celebrations/\d+"
        Cuando espero a que aparezca el contenido dinámico "Categoría de prueba 1" en "#category-list"
        Entonces el orden de "div.events-list article div.title" debe ser "Celebración de prueba 11,Celebración de prueba 12,Celebración de prueba 13"

    @javascript @loadCelebrationsData
    Escenario: Mostrar las últimas celebraciones cargadas con paginación.
        Dado espero a que aparezca el contenido dinámico "Celebración de prueba 1" en ".events-list"
        Y la URL debe seguir el patrón "/app/celebrations/\d+"
        Y el orden de "div.events-list article div.title" debe ser "Celebración de prueba 11,Celebración de prueba 12,Celebración de prueba 13"
        Cuando escroleo "html, body" hacia abajo 3000 px
        Entonces espero a que aparezca el contenido dinámico "Celebración de prueba 25" en ".main-container"

    @javascript @loadCelebrationsData
    Escenario: Mostrar todas las celebraciones a partir de hoy.
        Dado la URL debe seguir el patrón "/app/celebrations/\d+"
        Cuando hago click en "#events-filter-today"
        Entonces el orden de "div.events-list article div.title" debe ser "Celebración de prueba 11,Celebración de prueba 12,Celebración de prueba 13"

    @javascript @loadCelebrationsData
    Escenario: Mostrar las últimas celebraciones cargadas de una categoría.
        Dado la URL debe seguir el patrón "/app/celebrations/\d+"
        Cuando sigo "Categoría de prueba 1"
        Entonces debe aparecer el contenido dinámico "Celebración de prueba 11" en ".events-list"

    @javascript @loadCelebrationsHomeData
    Escenario: Mostrar la home de Celebraciones filtrada por fecha mediante el calendario.
        Dado la URL debe seguir el patrón "/app/celebrations/\d+"
        Y espero a que aparezca el contenido dinámico "Celebración de prueba 1" en ".events-list"
        Cuando hago click en el elemento ".day" que contiene el texto "3"
        Entonces espero a que aparezca el contenido dinámico "Celebración de prueba de día 3" en ".events-list"

    @javascript @loadCelebrationsData
    Escenario: Ingreso al home de Celebraciones y marco "Me gusta" en la primer celebración.
        Dado la URL debe seguir el patrón "/app/celebrations/\d+"
        Y espero a que aparezca el contenido dinámico "Celebración de prueba 1" en ".events-list"
        Cuando hago click en ".like-button"
        Entonces espero a que aparezca el contenido dinámico "Ya no me gusta" en ".event-likes"
        Y espero a que aparezca el contenido dinámico "Te gusta esto." en ".readable-like-count"
        Y hago click en ".unlike-button"
        Y espero a que aparezca el contenido dinámico "Me gusta" en ".events-list"

    @javascript @loadCelebrationsData
    Escenario: Ver la imagen de una celebración.
        Dado sigo "Nueva Celebración"
        Y espero a que aparezca el contenido dinámico "Desde mi PC" en ".platform"
        Y relleno "title" con "Prueba Imagen"
        Y relleno "description" con "Imagen"
        Y relleno la fecha "date" con "31/12/2020"
        Y selecciono "Categoría de prueba 10" de "categories"
        Y hago visible "attachmentUpload"
        Y adjunto el archivo "homerosapiens.jpg" a "attachmentUpload"
        Y presiono "Guardar"
        Y espero a que cambie la URL
        Y la URL debe seguir el patrón "/app/celebrations/\d+"
        Y espero a que aparezca el contenedor dinámico "#category-list"
        Y sigo "Categoría de prueba 10"
        Y espero a que aparezca el contenedor dinámico ".celeb-image"
        Cuando hago click en ".celeb-image"
        Entonces espero a que aparezca el contenedor dinámico "#lightbox"
