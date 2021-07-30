package com.metrocuadrado.definitions;

import com.metrocuadrado.steps.CalculadoraCreditoViviendaStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class CalculadoraCreditoViviendaDefinition {

    @Steps
    CalculadoraCreditoViviendaStep calculadoraCreditoViviendaStep;

    @Dado("^que ingresé el valor de ingresos mensuales (.*), el plazo del crédito (.*)$")
    public void ingresarValoresCredito(String valorIngresos, String plazo){
        calculadoraCreditoViviendaStep.ingresarValoresCredito(valorIngresos, plazo);
    }

    @Cuando("^calculo el valor del crédito$")
    public void calcularCreditoVivienda(){
        calculadoraCreditoViviendaStep.calcularCredito();
    }

    @Entonces("^obtendré el valor del crédito que mejor se adapte a mi capacidad de pago, segun mis ingresos$")
    public void evaluarValorCredito() {
        calculadoraCreditoViviendaStep.verificarIngresosMensuales();
        calculadoraCreditoViviendaStep.verificarCreditoVivienda();
        //calculadoraCreditoViviendaStep.verificarCuotaInicial();

    }

}
