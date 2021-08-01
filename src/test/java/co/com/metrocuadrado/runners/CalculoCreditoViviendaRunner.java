package co.com.metrocuadrado.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features/calcular_credito_vivienda.feature"},
    glue = {"co/com/metrocuadrado/definitions"})
public class CalculoCreditoViviendaRunner {}
