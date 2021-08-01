package utilidades;

public final class Transformaciones {

  public static int obtenerValorTransformado(String valorInicial) {
    valorInicial = valorInicial.replaceAll("[$ ,]*", "");
    return Integer.parseInt(valorInicial);
  }
}
