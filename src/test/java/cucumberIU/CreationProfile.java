package cucumberIU;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class CreationProfile {

    private WebDriver driver;
        String url="https://staging.tiered-planet.net/werk-it";

        @Given("je suis dans la page werk-it")
        public void je_suis_dans_la_page_werkit() {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            //je ouvre le navigateur de l'application
            driver.get(url);
        }

        @When("je  creer un profile avec des donnees valide")
        public void je_rentre_mes_logins(DataTable datatable) throws InterruptedException {
            driver.get(url);
            //Verifier le titre de la page web
            Assertions.assertThat(driver.getTitle()).isEqualTo("React App");
            Thread.sleep(2000);
            //verifer que l'onglet creat profile existe
            String linkCurrent = driver.findElement(By.xpath("//*[@id=\"navbarScroll\"]/div[2]/a[1]")).getText();
            //cliquer sur l'onglet creat profile
            driver.findElement(By.xpath("//*[@id=\"navbarScroll\"]/div[2]/a[1]")).click();
            //Remplir le champ firstName
            driver.findElement(By.name("firstName")).sendKeys(datatable.cell(1, 0));
            //Remplir le champ lastname
            driver.findElement(By.xpath("//*[@id=\"register\"]/div[2]/label/input")).sendKeys(datatable.cell(1, 1));
            //Remplir le champ email
            driver.findElement(By.xpath("//*[@id=\"register\"]/div[3]/label/input")).sendKeys(datatable.cell(1, 2));
            //Remplir le champ username
            driver.findElement(By.xpath("//*[@id=\"register\"]/div[4]/label/input")).sendKeys(datatable.cell(1, 3));
            //Remplir le champs password
            driver.findElement(By.xpath("//*[@id=\"register\"]/div[5]/label/input")).sendKeys(datatable.cell(1, 4));
            //cliquer sur Submit
            driver.findElement(By.xpath("//*[@id=\"register\"]/input")).click();
            }

    @Then("je vérifie la confirmation  de la creation du profile")
    public void jeVerifierLeMessagedeLaconfirmation() throws InterruptedException {
        //Accepter l'alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assertions.assertThat(alert.getText()).isEqualTo("You logged in with abdou and cgi123");
        alert.accept();
        Thread.sleep(3000);
        driver.quit();

    }
  
}


