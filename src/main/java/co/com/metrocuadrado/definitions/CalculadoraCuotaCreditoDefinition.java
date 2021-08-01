package co.com.metrocuadrado.definitions;

import co.com.metrocuadrado.steps.CalculadoraCuotasCreditoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class CalculadoraCuotaCreditoDefinition {

  @Steps CalculadoraCuotasCreditoStep calculadoraCuotasCreditoStep;

  @Dado("^que ingresé el valor del crédito (.*), el plazo del crédito (.*)$")
  public void ingresarValoresCuota(int valorCredito, String plazo) {
    calculadoraCuotasCreditoStep.ingresarValoresCuota(valorCredito, plazo);
  }

  @Cuando("^calculo el valor de la cuota del crédito$")
  public void calcularCuotaCredito() {
    calculadoraCuotasCreditoStep.calcularCuotas();
  }

  @Entonces("^pueda obtener un valor que sea fácil de pagar durante la vigencia del préstamo$")
  public void consultarValorCuota() {
    calculadoraCuotasCreditoStep.verificarCaracteristicasValorCuota();
  }
}
