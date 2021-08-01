package utilidades;

import utilidades.constantes.FactoresCobro;

public final class CalculadoraCredito {

  static int valorTotalCredito;
  static int cuotaInicialMinima;

  private CalculadoraCredito() {}

  public static int evaluarCreditoVivienda(int valorIngresos, String plazo) {
    final double PORCENTAJE_CUOTA = 0.30;
    final int MESES_ANO = 12;
    int valorCuotaMensual = (int) ((valorIngresos) * PORCENTAJE_CUOTA);
    int plazoMeses;
    int plazoAnos = Integer.parseInt(plazo.replace("Años", "").trim());
    plazoMeses = MESES_ANO * plazoAnos;

    switch (plazo) {
      case "5 Años":
        valorTotalCredito =
            (int)
                (valorCuotaMensual
                    * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_5_ANOS.getValor())
                        * plazoMeses));
        break;
      case "10 Años":
        valorTotalCredito =
            (int)
                (valorCuotaMensual
                    * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_10_ANOS.getValor())
                        * plazoMeses));
        break;
      case "15 Años":
        valorTotalCredito =
            (int)
                (valorCuotaMensual
                    * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_15_ANOS.getValor())
                        * plazoMeses));
        break;
      case "20 Años":
        valorTotalCredito =
            (int)
                (valorCuotaMensual
                    * (Double.parseDouble(FactoresCobro.FACTOR_COBRO_20_ANOS.getValor())
                        * plazoMeses));
        break;
      default:
        valorTotalCredito = 0;
        break;
    }
    return valorTotalCredito;
  }

  public static int calcularCuotaInicial() {
    cuotaInicialMinima =
        ((int)
            Math.round(
                valorTotalCredito
                    * (Double.parseDouble(FactoresCobro.PORCENTAJE_CUOTA_INICIAL.getValor()))
                    / Double.parseDouble(FactoresCobro.PORCENTAJE_CREDITO.getValor())));
    return cuotaInicialMinima;
  }

  public static int calcularValorInmueble() {
    int valorInmueble = valorTotalCredito + cuotaInicialMinima;
    return valorInmueble;
  }

  public static int calcularCuotaMensual(int valorIngresos) {
    int cuotaMensual =
        (int)
            Math.round(
                valorIngresos
                    * Double.parseDouble(FactoresCobro.PORCENTAJE_CUOTA_INICIAL.getValor()));
    return cuotaMensual;
  }
}
