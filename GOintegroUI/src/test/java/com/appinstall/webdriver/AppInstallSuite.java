package com.appinstall.webdriver;

/**
 * Created by soledad on 12/08/15.
 */

import org.openqa.selenium.WebElement;
import java.util.List;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public class AppInstallSuite {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();
        static int rand = (int) (Math.random() * 999999999);
        String nameBenefitsFilter = "NUEVA APP BENEFITS FILTER " + rand + " - AUTOMATICO";
        String nameBenefitsMaps = "NUEVA APP MAPA DE BENEFICIOS " + rand + " - AUTOMATICO";
        String nameCelebration = "NUEVA APP CELEBRACIONES " + rand + " - AUTOMATICA";
        String nameContent = "NUEVA APP CONTENIDOS " + rand + " - AUTOMATICO";
        String nameTournament = "NUEVA APP TORNEO PRO " + rand + " - AUTOMATICO";
        String nameGallery = "NUEVA APP GALERIA " + rand + " - AUTOMATICA";
        String nameNewRelease = "NUEVA APP NOVEDADES " + rand + " - AUTOMATICA";
        String nameNewCatalog = "NUEVA APP CATALOGO " + rand + " - AUTOMATICO";


        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "https://goc.p2-stage.gointegro.com/";
            driver.get(baseUrl);
            driver.findElement(By.id("_username")).clear();
            driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
            driver.findElement(By.id("_password")).clear();
            driver.findElement(By.id("_password")).sendKeys("coquito25");
            driver.findElement(By.name("_submit")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testAppA() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");

            driver.findElement(By.cssSelector("#application-list .span12:nth-child(2) .well:nth-child(4) button")).click();
            driver.findElement(By.id("all-categories-radio")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameBenefitsFilter);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameBenefitsFilter);
            driver.findElement(By.id("accept")).click();

            String capturedText = new String(driver.findElement(By.cssSelector(".top-title")).getText());

            //Se setea el texto de validación esperado
            String expectedText = "FILTRAR POR";

            // Se valida que el texto es el esperado
            if (capturedText.equals(expectedText)) {
                System.out.println("testAppBenefitsFilter  [OK]");
            } else {
                System.out.println("testAppBenefitsFilter  [FAIL]");
            }
        }

        @Test
        public void testAppB() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            //driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(1) .well:nth-child(4) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameBenefitsMaps);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameBenefitsMaps);
            driver.findElement(By.id("accept")).click();

            String capturedText = new String(driver.findElement(By.cssSelector(".call-to-action>a")).getText());

            //Se setea el texto de validación esperado
            String expectedText = "Ver más beneficios";

            // Se valida que el texto es el esperado
            if (capturedText.equals(expectedText)) {
                System.out.println("testInstallBenefitsMaps  [OK]");
            } else {
                System.out.println("testInstallBenefitsMaps  [FAIL]");
            }
        }

        @Test
        public void testAppC() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(1) .well:nth-child(5) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameNewCatalog);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameNewCatalog);
            driver.findElement(By.id("accept")).click();

            String capturedText = new String(driver.findElement(By.cssSelector(".btn.btn-default")).getText());

            //Se setea el texto de validación esperado
            String expectedText = "Mis Transacciones";

            // Se valida que el texto es el esperado
            if (capturedText.equals(expectedText)) {
                System.out.println("testInstallAppCatalog  [OK]");
            } else {
                System.out.println("testInstallAppCatalog  [FAIL]");
            }

        }

        @Test
        public void testAppD() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(2) .well:nth-child(2) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameCelebration);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameCelebration);
            driver.findElement(By.id("accept")).click();

            // se crea una nueva celebración
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".btn.new-event-header")).click();
            driver.findElement(By.id("collaborators-container-input")).clear();
            driver.findElement(By.id("collaborators-container-input")).sendKeys("Soledad");
            driver.findElement(By.cssSelector("div.text-suggestion.text-selected > span.text-label")).click();
            driver.findElement(By.id("title")).clear();
            driver.findElement(By.id("title")).sendKeys("Nueva celebración AUTOMATICA");
            driver.findElement(By.id("description")).clear();
            driver.findElement(By.id("description")).sendKeys("Nueva celebración AUTOMATICA");
            Thread.sleep(1000);
            driver.findElement(By.id("form-category-new")).click();
            driver.findElement(By.id("category-name")).clear();
            driver.findElement(By.id("category-name")).sendKeys("Cumpleaños AUTOMATICO");
            driver.findElement(By.name("new-category")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("date")).click();

            driver.findElement(By.cssSelector(".datepicker tr:nth-child(6) td:nth-child(6)")).click();
            driver.findElement(By.id("accept")).click();
            Thread.sleep(1000);

            String capturedText = new String(driver.findElement(By.cssSelector(".btn.new-event-header")).getText());

            //Se setea el texto de validación esperado
            String expectedText = "Nueva Celebración";

            // Se valida que el texto es el esperado
            if (capturedText.equals(expectedText)) {
                System.out.println("testInstallAppCelebrations  [OK]");
            } else {
                System.out.println("testInstallAppCelebrations  [FAIL]");
            }
        }

        @Test
        public void testAppE() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(2) .well:nth-child(1) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameContent);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameContent);
            driver.findElement(By.id("accept")).click();

            // se crea un contenido
            driver.findElement(By.id("createArticle")).click();
            // Ingreso al tinymce
            WebElement bodyIframe1 = driver.findElement(By.id("title_ifr"));
            driver.switchTo().frame(bodyIframe1);
            WebElement mce1 = driver.findElement(By.id("tinymce"));
            mce1.sendKeys("Nuevo contenido - AUTOMATICO");
            //Saca el foco del editor
            driver.switchTo().defaultContent();

            //Ingreso al segundo tinymce
            WebElement bodyIframe2 = driver.findElement(By.id("content_ifr"));
            driver.switchTo().frame(bodyIframe2);
            WebElement mce2 = driver.findElement(By.id("tinymce"));
            mce2.sendKeys("Nuevo contenido - AUTOMATICO");
            //Saca el foco del editor
            driver.switchTo().defaultContent();
            driver.findElement(By.id("accept")).click();

            String capturedText = new String(driver.findElement(By.cssSelector(".btn.new-article")).getText());

            //Se setea el texto de validación esperado
            String expectedText = "Nuevo contenido";

            // Se valida que el texto es el esperado
            if (capturedText.equals(expectedText)) {
                System.out.println("testInstallAppContents  [OK]");
            } else {
                System.out.println("testInstallAppContents  [FAIL]");
            }
        }


        @Test
        public void testAppF() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(2) .well:nth-child(3) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameTournament);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameTournament);
            driver.findElement(By.id("accept")).click();

            String capturedText = new String(driver.findElement(By.id("predictions-tab")).getText());

            //Se setea el texto de validación esperado
            String expectedText = "Pronóstico";

            // Se valida que el texto es el esperado
            if (capturedText.equals(expectedText)) {
                System.out.println("testInstallTournamentPRO  [OK]");
            } else {
                System.out.println("testInstallTournamentPRO  [FAIL]");
            }
        }

        @Test
        public void testAppG() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(1) .well:nth-child(2) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameGallery);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameGallery);
            driver.findElement(By.id("accept")).click();

            //Se crea un album y se sube una imagen
            Thread.sleep(2000);
            driver.findElement(By.linkText("Albumes")).click();
            driver.findElement(By.linkText("Nuevo")).click();
            driver.findElement(By.id("album-name")).clear();
            driver.findElement(By.id("album-name")).sendKeys("Nuevo album - AUTOMATICO");
            driver.findElement(By.cssSelector("#gallery-modal .modal-footer:nth-child(3) button")).click();

            Thread.sleep(2000);
            driver.findElement(By.id("content-upload")).sendKeys("/home/soledad/Imágenes/QA.png");
            Thread.sleep(5000);
            driver.findElement(By.id("title")).sendKeys("FOTO PRUEBA QA");
            //upload.sendKeys(Keys.ENTER);
            driver.findElement(By.cssSelector(".btn.dropdown-toggle.selected-item")).click();
            //driver.findElement(By.cssSelector("#albumId li:nth-child(4) a")).click();
            driver.findElement(By.cssSelector("#albumId .btn-group.dropdown-backbone-select li:nth-child(4) a")).click();
            driver.findElement(By.id("save-button")).click();
            System.out.println("testInstallAppGalleryImagen  [OK]");

        }

        @Test
        public void testAppH() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(1) .well:nth-child(2) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameGallery);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameGallery);
            driver.findElement(By.id("accept")).click();

            //Se crea un album y se sube una imagen
            Thread.sleep(2000);
            driver.findElement(By.linkText("Albumes")).click();
            driver.findElement(By.linkText("Nuevo")).click();
            driver.findElement(By.id("album-name")).clear();
            driver.findElement(By.id("album-name")).sendKeys("Nuevo album - AUTOMATICO");
            driver.findElement(By.xpath("//div[@id='gallery-modal']/div[3]/button")).click();

            Thread.sleep(2000);
            driver.findElement(By.id("content-upload")).sendKeys("/home/soledad/Vídeos/QA3.MOV");
            Thread.sleep(5000);
            driver.findElement(By.id("title")).sendKeys("VIDEO PRUEBA QA");
            //upload.sendKeys(Keys.ENTER);
            driver.findElement(By.cssSelector(".btn.dropdown-toggle.selected-item")).click();
            driver.findElement(By.xpath(".//*[@id='albumId']/div/ul/li[4]/a")).click();
            driver.findElement(By.id("save-button")).click();
            Thread.sleep(15000);
            System.out.println("testInstallAppGalleryVideo  [OK]");

        }


        @Test
        public void testAppI() throws Exception {
            driver.get(baseUrl + "workspace/6352/app/list");
            driver.findElement(By.cssSelector("#application-list .span12:nth-child(1) .well:nth-child(3) button")).click();
            driver.findElement(By.id("app-name")).clear();
            driver.findElement(By.id("app-name")).sendKeys(nameNewRelease);
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).clear();
            driver.findElement(By.cssSelector("textarea[name=\"description\"]")).sendKeys(nameNewRelease);
            driver.findElement(By.id("accept")).click();
            // se crea una novedad
            driver.findElement(By.id("createArticle")).click();
            driver.findElement(By.id("title")).clear();
            driver.findElement(By.id("title")).sendKeys("Nueva Novedad AUTOMATICA");

            //Ingreso al tinymce
            WebElement bodyIframe = driver.findElement(By.id("content_ifr"));
            driver.switchTo().frame(bodyIframe);
            WebElement mce = driver.findElement(By.id("tinymce"));
            mce.sendKeys("Nueva Novedad AUTOMATICA");
            //Saca el foco del editor
            driver.switchTo().defaultContent();

            driver.findElement(By.id("publicationDate")).click();
            driver.findElement(By.cssSelector(".datepicker tr:nth-child(6) td:nth-child(6)")).click();
            driver.findElement(By.id("publicationHour")).clear();
            driver.findElement(By.id("publicationHour")).sendKeys("15:30");
            driver.findElement(By.id("socialEnabled")).click();
            driver.findElement(By.id("accept")).click();

            Thread.sleep(1000);
            String capturedText = new String(driver.findElement(By.cssSelector(".btn.new-article")).getText());

            //Se setea el texto de validación esperado
            String expectedText = "Nueva Novedad";

            // Se valida que el texto es el esperado
            if (capturedText.equals(expectedText)) {
                System.out.println("testInstallAppNewReleases  [OK]");
            } else {
                System.out.println("testInstallAppNewReleases  [FAIL]");
            }

        }

        @Test
        public void testAppsJ() {
            driver.get(baseUrl + "/workspace/6352/app/sort");
            //Identificamos cada botón Eliminar en la página
            final List<WebElement> btnEliminar = driver.findElements(By.cssSelector(".btn.btn-secondary.pull-right.btn-delete"));

            //Iteramos los botones y se eliminan las apps
            for (WebElement ele : btnEliminar) {
                driver.navigate().refresh();
                driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
                driver.findElement(By.xpath("//div[@id='delete-modal']/div[3]/button")).click();
            }

            System.out.println("testUninstallAllApps  [OK]");
        }//end of test_by_id method


        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
}
