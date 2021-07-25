package com.metrocuadrado.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@DefaultUrl("https://www.metrocuadrado.com/calculadora-credito-hipotecario-vivienda/")
public class CalculadoraCreditoViviendaPage extends PageObject {

    public CalculadoraCreditoViviendaPage(WebDriver driver){super(driver);}

    @FindBy(id = "ingresosMensuales")
    public WebElementFacade txtIngresosMensuales;

    @FindBy(xpath = "//button//h4[contains(text(),'Calcular Crédito')]")
    public WebElementFacade btnCalcularCredito;

    @FindBy(xpath = "//span[@class='m2-icon m2-icon-question']//ancestor::dd[1]")
    public WebElementFacade txtPrestamoBanco;

    public void ingresarValorIngresos(String valorIngresos) {
        txtIngresosMensuales.sendKeys(valorIngresos);
    }

    public void ingresarPlazoCredito(String plazo) {
        getDriver().findElement(By.xpath("//option[contains(text(),'" + plazo + "')]")).click();
    }

    public void calcularCredito() {
        btnCalcularCredito.click();
    }

    public String obtenerValorCredito() {
        String valorPrestamoBanco = txtPrestamoBanco.getText();
        return valorPrestamoBanco;
    }
}
