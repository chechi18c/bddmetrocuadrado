package co.com.metrocuadrado.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/")
public class CalculadoraCuotasCreditoPage extends PageObject {

  public CalculadoraCuotasCreditoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//ul[@class='nav nav-tabs']//li//a[@class='vercuotas']")
  public WebElementFacade btnCalculadoraCuotas;

  @FindBy(name = "loadAmount")
  public WebElementFacade txtValorCredito;

  @FindBy(xpath = "//button[@class='btn btn-upload cuotas']//h4")
  public WebElementFacade btnCalcularCuotas;

  @FindBy(
      xpath =
          "//div[@class='col-md-7 col-sm-8 col-xs-12 resultados cuotas']//dl//span[@class='m2-icon m2-icon-question']//ancestor::dd")
  public WebElementFacade txtValorIngresos;

  @FindBy(
      xpath =
          "//div[@class='col-md-7 col-sm-8 col-xs-12 resultados cuotas']//dl//span[@class='m2-icon m2-icon-question']//following::dd")
  public WebElementFacade txtCuotaInicial;

  @FindBy(
      xpath =
          "//div[@class='col-md-7 col-sm-8 col-xs-12 resultados cuotas']//table[@id='td-resul-calc']//td[2]")
  public WebElementFacade txtCuotaMensual;

  @FindBy(
      xpath =
          "//div[@class='col-md-7 col-sm-8 col-xs-12 resultados cuotas']//span[contains(text(),'Puedes comprar un inmueble de:')]//following::dd")
  public WebElementFacade txtValorInmueble;

  public void abrirCalculadoraCuotas() {
    btnCalculadoraCuotas.click();
  }

  public void ingresarValorCredito(int valorCredito) {
    txtValorCredito.waitUntilVisible().sendKeys(String.valueOf(valorCredito));
  }

  public void ingresarPlazoCuotas(String plazo) {
    getDriver()
        .findElement(
            By.xpath(
                "//div[@class='valorCuotas tab-pane ng-scope active']//select//child::option[contains(text(),'"
                    + plazo
                    + "')]"))
        .click();
  }

  public void calcularCuotas() {
    btnCalcularCuotas.click();
  }

  public String consultarValorIngresos() {
    return txtValorIngresos.getText();
  }

  public String consultarCuotaInicial() {
    return txtCuotaInicial.getText();
  }

  public String consultarCuotaMensual() {
    return txtCuotaMensual.getText();
  }

  public String consultarValorInmueble() {
    return txtValorInmueble.getText();
  }
}
