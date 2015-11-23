# language: es
Característica: Activar / Desactivar características sociales
                Como usuario de admin (y de back office) quiero poder activar y desactivar la características sociales a nivel plataforma y aplicación.

    Antecedentes:
        Dado estoy en "/auth/signin?_lang=es"
        Y relleno "_username" con "johnconnor"
        Y relleno "_password" con "123456"
        Cuando presiono "_submit"
        Entonces debo estar en "/"

    @javascript @loadStandardUserData
    Escenario: Ingresar al muro de la plataforma
        Y el elemento ".navbar" debe contener "Muro social"
        Y debo ver "Actividad Social"
        Cuando voy a "/social/wall"
        Entonces no debo ver "¡Mmmh, lo sentimos!"
        Y debo ver "Actividad social"

    @javascript @loadStandardUserData
    Escenario: Desactivar social en la plataforma
        Y el elemento ".navbar" debe contener "Muro social"
        Y debo ver "Actividad Social"
        Y voy a "/auth/signout"
        Y voy a "/backoffice"
        Y debo estar en "/backoffice/signin"
        Y relleno "_username" con "apibackofficetester"
        Y relleno "_password" con "apitesterbackoffice"
        Y presiono "_submit"
        Y debo estar en "/backoffice/"
        Y estoy en el detalle de la cuenta "Standard Account"
        Y sigo "Listar Plataformas"
        Y debe aparecer el contenido dinámico "Hugo" en ".string-cell"
        Y hago click y sigo ".action-icon:first"
        Y la URL debe seguir el patrón "/backoffice/platform/\d+/edit"
        Entonces desmarco "socialEnabled"
        Y selecciono "America/Argentina/Buenos_Aires" de "timeZone"
        Y presiono "Guardar"
        Y sigo el link "Cerrar Sesión"
        Y voy a "/auth/signin?_lang=es"
        Y relleno "_username" con "john-salchichon"
        Y relleno "_password" con "cabezona"
        Cuando presiono "_submit"
        Y debo estar en "/"
        Y espero a que aparezca el contenido dinámico "Artículos Corporativos" en "#workspaces"
        Entonces no debo ver "Actividad Social Corporativa"
        Y voy a "/social/wall"
        Y debo ver "404"
        Y debo ver "La página a la que intentas acceder no se encuentra"
