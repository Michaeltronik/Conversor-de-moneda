public class Moneda {
    private String monedaBase;
    private String monedaObjetivo;
    private double tasaDeConversion;
    private double resultadoConversion;
    private double cantidad;
    private String resultado;

    public Moneda(MonedaApi monedaApi, double valor) {
        this.tasaDeConversion = monedaApi.conversion_rate();
        this.monedaBase = monedaApi.base_code();
        this.monedaObjetivo = monedaApi.target_code();
        this.resultadoConversion = monedaApi.conversion_result();
        this.cantidad = valor;
        this.resultado = monedaApi.result();
    }

    public String getResultado() {
        return resultado;
    }

    public double valorConvertido() {
        double valorTotal = this.tasaDeConversion * cantidad;
        return valorTotal;
    }

    @Override
    public String toString() {
        return (String.format("_______________________________________________________________________________________________________\n\n" +
                        "El valor: %.2f [%s] corresponde al valor final de ==> %.4f [%s]\n" +
                        "_______________________________________________________________________________________________________\n"
                , cantidad, monedaBase, valorConvertido(), monedaObjetivo));
    }
}



