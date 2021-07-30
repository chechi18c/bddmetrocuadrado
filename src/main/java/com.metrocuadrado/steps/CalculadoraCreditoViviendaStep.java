package com.metrocuadrado.steps;

import com.metrocuadrado.page.CalculadoraCreditoViviendaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.mockito.internal.matchers.Equals;
import utilidades.CalculadoraCredito;

public class CalculadoraCreditoViviendaStep {

    private String valorIngresos;
    private String plazo;

    @Page
    CalculadoraCreditoViviendaPage calculadoraCreditoViviendaPage;

    @Step
    public void ingresarValoresCredito(String valorIngresos, String plazo) {
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
    public void verificarIngresosMensuales() {
        int valorIngresos = CalculadoraCredito.obtenerValorTransformado(calculadoraCreditoViviendaPage.obtenerValorIngresos());
        MatcherAssert.assertThat("El valor de ingresos no coincide con el esperado: ",
                Integer.parseInt(this.valorIngresos),
                new Equals(valorIngresos));
    }

    @Step
    public void verificarCreditoVivienda() {
        int valorCalculadoPrestamo = CalculadoraCredito.obtenerValorTransformado(calculadoraCreditoViviendaPage.obtenerValorCredito());
        int valorPrestamo = CalculadoraCredito.evaluarCreditoVivienda(this.valorIngresos, this.plazo);
        MatcherAssert.assertThat("El cálculo del valor del crédito hipotecario no coincide con el esperado",
                valorPrestamo,
                new Equals(valorCalculadoPrestamo));
    }

    public void verificarCuotaInicial() {
        int cuotaInicialCalculada = CalculadoraCredito.calcularCuotaInicial();
        int cuotaInicialEsperada = CalculadoraCredito.obtenerValorTransformado(calculadoraCreditoViviendaPage.obtenerCuotaInicial());
        MatcherAssert.assertThat("El cálculo del valor de la cuota inicial no coincide con el esperado",
                cuotaInicialCalculada,
                new Equals(cuotaInicialEsperada));
    }

}

