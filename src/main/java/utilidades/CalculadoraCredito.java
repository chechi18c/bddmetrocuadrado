package utilidades;

import utilidades.constantes.FactoresCobro;

public final class CalculadoraCredito {

    private CalculadoraCredito() {
    }

    public static int evaluarCreditoVivienda(String valorIngresos, String plazo) {
        final double PORCENTAJE_CUOTA = 0.30;
        final int MESES_ANO = 12;
        int valorCuotaMensual = (int) (Integer.parseInt(valorIngresos) * PORCENTAJE_CUOTA);
        int valorTotalCredito;
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

    public static int obtenerValorCredito(String valorPrestamoBanco) {
        valorPrestamoBanco = valorPrestamoBanco.substring(2);
        String[] lstValorPrestamoBanco = valorPrestamoBanco.split(",");
        String valorPrestamo = "";
        for (int i = 0; i < lstValorPrestamoBanco.length; ++i){
            valorPrestamo += lstValorPrestamoBanco[i];
        }
        return Integer.parseInt(valorPrestamo);
    }

}
