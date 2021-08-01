package co.com.metrocuadrado.steps;

import co.com.metrocuadrado.page.CalculadoraCreditoViviendaPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.fluentlenium.core.annotation.Page;
import utilidades.CalculadoraCredito;
import utilidades.Transformaciones;

public class CalculadoraCreditoViviendaStep {

  private int valorIngresos;
  private String plazo;

  @Page CalculadoraCreditoViviendaPage calculadoraCreditoViviendaPage;

  @Step
  public void ingresarValoresCredito(int valorIngresos, String plazo) {
    this.valorIngresos = valorIngresos;
    this.plazo = plazo;
    calculadoraCreditoViviendaPage.open();
    calculadoraCreditoViviendaPage.ingresarValorIngresos(valorIngresos);
    calculadoraCreditoViviendaPage.ingresarPlazoCredito(plazo);
  }

  @Step
  public void calcularCredito() {
    calculadoraCreditoViviendaPage.calcularCredito();
  }

  @Step
  public void evaluarCaracteristicasCredito() {
    int valorIngresos =
        Transformaciones.obtenerValorTransformado(
            calculadoraCreditoViviendaPage.obtenerValorIngresos());
    SoftAssertions softly = new SoftAssertions();
    softly
        .assertThat(this.valorIngresos)
        .as("El valor de ingresos no coincide con el esperado:")
        .isEqualTo(valorIngresos);
    int valorPrestamoObtenido =
        Transformaciones.obtenerValorTransformado(
            calculadoraCreditoViviendaPage.obtenerValorCredito());
    int valorPrestamoCalculado =
        CalculadoraCredito.evaluarCreditoVivienda(this.valorIngresos, this.plazo);
    softly
        .assertThat(valorPrestamoObtenido)
        .as("El cálculo del valor del crédito hipotecario no coincide con el esperado:")
        .isEqualTo(valorPrestamoCalculado);
    int cuotaInicialCalculada = CalculadoraCredito.calcularCuotaInicial();
    int cuotaInicialObtenida =
        Transformaciones.obtenerValorTransformado(
            calculadoraCreditoViviendaPage.obtenerCuotaInicial());
    softly
        .assertThat(cuotaInicialObtenida)
        .as("El cálculo del valor de la cuota inicial no coincide con el esperado:")
        .isEqualTo(cuotaInicialCalculada);
    int valorInmuebleObtenido =
        Transformaciones.obtenerValorTransformado(
            calculadoraCreditoViviendaPage.obtenerValorInmueble());
    int valorInmuebleCalculado = CalculadoraCredito.calcularValorInmueble();
    softly
        .assertThat(valorInmuebleObtenido)
        .as("El cálculo del valor de la cuota inicial no coincide con el esperado:")
        .isEqualTo(valorInmuebleCalculado);
    int cuotaMensualObtenida =
        Transformaciones.obtenerValorTransformado(
            calculadoraCreditoViviendaPage.obtenerCuotaMensual());
    int cuotaMensualCalculada = CalculadoraCredito.calcularCuotaMensual(valorIngresos);
    softly
        .assertThat(cuotaMensualObtenida)
        .as("El cálculo del valor de la cuota inicial no coincide con el esperado:")
        .isEqualTo(cuotaMensualCalculada);
    softly.assertAll();
  }
}
