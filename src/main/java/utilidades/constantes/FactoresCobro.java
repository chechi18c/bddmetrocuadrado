package utilidades.constantes;

public enum FactoresCobro {
    FACTOR_COBRO_5_ANOS("0.7881078333333333"),
    FACTOR_COBRO_10_ANOS("0.6359688374750071"),
    FACTOR_COBRO_15_ANOS("0.5229890745501285"),
    FACTOR_COBRO_20_ANOS("0.4378294027777778");


    private final String valor;

    FactoresCobro(String valor){this.valor=valor;}

    public String getValor(){return this.valor;}
}
