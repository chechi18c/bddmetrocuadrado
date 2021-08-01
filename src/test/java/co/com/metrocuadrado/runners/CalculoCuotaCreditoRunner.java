package co.com.metrocuadrado.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features/calcular_valor_cuotas.feature"},
    glue = {"co/com/metrocuadrado/definitions"})
public class CalculoCuotaCreditoRunner {}
