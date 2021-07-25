package runners;

import org.junit.Test;
import utilidades.CalculadoraCredito;

public class MyTest {
    @Test
    public void calcular(){
        double valor1 = CalculadoraCredito.evaluarCreditoVivienda("4000000","5 Años");
        double valor2 = CalculadoraCredito.evaluarCreditoVivienda("4000000","10 Años");
        System.out.println("valor 1 " +valor1 + "valor 2 " + valor2);


    }
}
