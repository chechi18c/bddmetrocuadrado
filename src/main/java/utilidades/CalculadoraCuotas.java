package utilidades;

import utilidades.constantes.FactoresCobro;

public final class CalculadoraCuotas {

  static int valorIngresosMensuales;
  static int valorCuotaInicial;

  private CalculadoraCuotas() {}

  public static int calcularIngresosMensuales(int valorCredito, String plazo) {
    switch (plazo) {
      case "5 Años":
        valorIngresosMensuales =
            (int)
                Math.round(
                    valorCredito
                        * (Double.parseDouble(FactoresCobro.FACTOR_CUOTA_5_ANOS.getValor())));
        break;
      case "10 Años":
        valorIngresosMensuales =
            (int)
                Math.round(
                    valorCredito
                        * (Double.parseDouble(FactoresCobro.FACTOR_CUOTA_10_ANOS.getValor())));
        break;
      case "15 Años":
        valorIngresosMensuales =
            (int)
                Math.round(
                    valorCredito
                        * (Double.parseDouble(FactoresCobro.FACTOR_CUOTA_15_ANOS.getValor())));
        break;
      case "20 Años":
        valorIngresosMensuales =
            (int)
                Math.round(
                    valorCredito
                        * (Double.parseDouble(FactoresCobro.FACTOR_CUOTA_20_ANOS.getValor())));
        break;
      default:
        valorIngresosMensuales = 0;
        break;
    }
    return valorIngresosMensuales;
  }

  public static int calcularCuotaInicial(int valorCredito) {
    valorCuotaInicial =
        ((int)
            Math.round(
                valorCredito
                    * (Double.parseDouble(FactoresCobro.PORCENTAJE_CUOTA_INICIAL.getValor()))
                    / (Double.parseDouble(FactoresCobro.PORCENTAJE_CREDITO.getValor()))));
    return valorCuotaInicial;
  }

  public static int calcularCuotaCredito() {
    int valorCuotaCredito =
        (int)
            Math.round(
                valorIngresosMensuales
                    * (Double.parseDouble(FactoresCobro.PORCENTAJE_CUOTA_INICIAL.getValor())));
    return valorCuotaCredito;
  }

  public static int calcularValorInmueble(int valorCredito) {
    int valorInmueble = valorCuotaInicial + valorCredito;
    return valorInmueble;
  }
}
