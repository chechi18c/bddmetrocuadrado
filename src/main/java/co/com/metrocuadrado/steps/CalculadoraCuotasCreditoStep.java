package co.com.metrocuadrado.steps;

import co.com.metrocuadrado.page.CalculadoraCuotasCreditoPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.fluentlenium.core.annotation.Page;
import utilidades.CalculadoraCuotas;
import utilidades.Transformaciones;

public class CalculadoraCuotasCreditoStep {

  private int valorCredito;
  private String plazo;

  @Page CalculadoraCuotasCreditoPage calculadoraCuotasCreditoPage;

  @Step
  public void ingresarValoresCuota(int valorCredito, String plazo) {
    this.valorCredito = valorCredito;
    this.plazo = plazo;
    calculadoraCuotasCreditoPage.open();
    calculadoraCuotasCreditoPage.abrirCalculadoraCuotas();
    calculadoraCuotasCreditoPage.ingresarValorCredito(valorCredito);
    calculadoraCuotasCreditoPage.ingresarPlazoCuotas(plazo);
  }

  @Step
  public void calcularCuotas() {
    calculadoraCuotasCreditoPage.calcularCuotas();
  }

  @Step
  public void verificarCaracteristicasValorCuota() {
    int valorIngresosObtenidos =
        Transformaciones.obtenerValorTransformado(
            calculadoraCuotasCreditoPage.consultarValorIngresos());
    int valorIngresosCalculados = CalculadoraCuotas.calcularIngresosMensuales(valorCredito, plazo);
    SoftAssertions softly = new SoftAssertions();
    softly
        .assertThat(valorIngresosObtenidos)
        .as("El valor de ingresos mensuales no coincide con el valor esperado")
        .isEqualTo(valorIngresosCalculados);
    int cuotaInicialObtenida =
        Transformaciones.obtenerValorTransformado(
            calculadoraCuotasCreditoPage.consultarCuotaInicial());
    int cuotaInicialCalculada = CalculadoraCuotas.calcularCuotaInicial(valorCredito);
    softly
        .assertThat(cuotaInicialObtenida)
        .as("El valor de ingresos mensuales no coincide con el valor esperado")
        .isEqualTo(cuotaInicialCalculada);
    int valorInmuebleObtenido =
        Transformaciones.obtenerValorTransformado(
            calculadoraCuotasCreditoPage.consultarValorInmueble());
    int valorInmuebleCalculado = CalculadoraCuotas.calcularValorInmueble(valorCredito);
    softly
        .assertThat(valorInmuebleObtenido)
        .as("El valor de ingresos mensuales no coincide con el valor esperado")
        .isEqualTo(valorInmuebleCalculado);
    int cuotaMensualObtenida =
        Transformaciones.obtenerValorTransformado(
            calculadoraCuotasCreditoPage.consultarCuotaMensual());
    int cuotaMensualCalculada = CalculadoraCuotas.calcularCuotaCredito();
    softly
        .assertThat(cuotaMensualObtenida)
        .as("El valor de ingresos mensuales no coincide con el valor esperado")
        .isEqualTo(cuotaMensualCalculada);
    softly.assertAll();
  }
}
