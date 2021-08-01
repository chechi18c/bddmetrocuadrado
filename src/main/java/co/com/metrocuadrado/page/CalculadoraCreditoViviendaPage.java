package co.com.metrocuadrado.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/")
public class CalculadoraCreditoViviendaPage extends PageObject {

  public CalculadoraCreditoViviendaPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "ingresosMensuales")
  public WebElementFacade txtIngresosMensuales;

  @FindBy(xpath = "//button//h4[contains(text(),'Calcular Crédito')]")
  public WebElementFacade btnCalcularCredito;

  @FindBy(xpath = "//span[@class='m2-icon m2-icon-question']//ancestor::dd[1]")
  public WebElementFacade txtPrestamoBanco;

  @FindBy(xpath = "//dt//span[contains(text(),'Con un ingreso mensual de:')]//following::dd[1]")
  public WebElementFacade txtValorIngresos;

  @FindBy(xpath = "//dl//span[@class='m2-icon m2-icon-question']//following::dd[1]")
  public WebElementFacade txtCuotaInicialMinima;

  @FindBy(xpath = "//dl//span[@class='m2-icon m2-icon-question']//following::dd[2]")
  public WebElementFacade txtValorInmueble;

  @FindBy(
      xpath =
          "//div[@class='col-md-7 col-sm-8 col-xs-12 resultados credito']//table[@id='td-resul-calc']//td[3]")
  public WebElementFacade txtCuotaMensual;

  public void ingresarValorIngresos(int valorIngresos) {
    txtIngresosMensuales.sendKeys(String.valueOf(valorIngresos));
  }

  public void ingresarPlazoCredito(String plazo) {
    getDriver().findElement(By.xpath("//option[contains(text(),'" + plazo + "')]")).click();
  }

  public void calcularCredito() {
    btnCalcularCredito.click();
  }

  public String obtenerValorIngresos() {
    return txtValorIngresos.getText();
  }

  public String obtenerValorCredito() {
    return txtPrestamoBanco.getText();
  }

  public String obtenerCuotaInicial() {
    return txtCuotaInicialMinima.getText();
  }

  public String obtenerValorInmueble() {
    return txtValorInmueble.getText();
  }

  public String obtenerCuotaMensual() {
    return txtCuotaMensual.getText();
  }
}
