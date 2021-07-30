package utilidades;

import utilidades.constantes.FactoresCobro;

public final class CalculadoraCredito {

    static final double PORCENTAJE_CUOTA_INICIAL = 0.30;
    static final double PORCENTAJE_CREDITO = 0.70;
    static int valorTotalCredito;

    private CalculadoraCredito() {
    }

    public static int evaluarCreditoVivienda(String valorIngresos, String plazo) {
        final double PORCENTAJE_CUOTA = 0.30;
        final int MESES_ANO = 12;
        int valorCuotaMensual = (int) (Integer.parseInt(valorIngresos) * PORCENTAJE_CUOTA);
        int plazoMeses;
        int plazoAnos = Integer.parseInt(plazo.replace("Años", "").trim());
        plazoMeses = MESES_ANO * plazoAnos;

        switch (plazo) {
            case "5 Años":
                valorTotalCredito = (int) (valorCuotaMensual * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_5_ANOS.getValor()) * plazoMeses));
                break;
            case "10 Años":
                valorTotalCredito = (int) (valorCuotaMensual * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_10_ANOS.getValor()) * plazoMeses));
                break;
            case "15 Años":
                valorTotalCredito = (int) (valorCuotaMensual * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_15_ANOS.getValor()) * plazoMeses));
                break;
            case "20 Años":
                valorTotalCredito = (int) (valorCuotaMensual * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_20_ANOS.getValor()) * plazoMeses));
                break;
            default:
                valorTotalCredito=0;
                break;
        }
        return valorTotalCredito;
    }

    public static int obtenerValorTransformado(String valorInicial) {
        valorInicial = valorInicial.replaceAll("[$ ,]*","");
        return Integer.parseInt(valorInicial);
    }

    public static int calcularCuotaInicial(){
        return (int) ((int) (valorTotalCredito* PORCENTAJE_CUOTA_INICIAL)/PORCENTAJE_CREDITO);
    }

}
