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
    public void evaluarCreditoVivienda() {
        int valorPrestamoBanco = CalculadoraCredito.obtenerValorCredito(calculadoraCreditoViviendaPage.obtenerValorCredito());
        MatcherAssert.assertThat("El cálculo del valor para el crédito hipotecario no es el esperado",
                CalculadoraCredito.evaluarCreditoVivienda(this.valorIngresos, this.plazo),
                new Equals(valorPrestamoBanco)
        );
    }
}

