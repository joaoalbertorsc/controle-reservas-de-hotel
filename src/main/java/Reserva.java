public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto  = tipoQuarto;
        setNumeroDias(numeroDias);
        setValorDiaria(valorDiaria);
    }

    public Reserva(String nomeHospede, String tipoQuarto) {
        this(nomeHospede, tipoQuarto, 1, 0.01);
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        if (numeroDias < 1) {
            throw new IllegalArgumentException("Número de dias deve ser pelo menos 1.");
        }
        this.numeroDias = numeroDias;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException("Valor da diária deve ser maior que zero.");
        }
        this.valorDiaria = valorDiaria;
    }

    public double calcularValorTotal() {
        return this.numeroDias * this.valorDiaria;
    }

    @Override
    public String toString() {
        return "║  Hóspede : " + String.format("%-26s", nomeHospede) + "║\n" +
                "║  Quarto  : " + String.format("%-26s", tipoQuarto) + "║\n" +
                "║  Dias    : " + String.format("%-26s", numeroDias) + "║\n" +
                "║  Diária  : R$ " + String.format("%-23s", String.format("%.2f", valorDiaria)) + "║\n" +
                "║  Total   : R$ " + String.format("%-23s", String.format("%.2f", calcularValorTotal())) + "║";
    }
}