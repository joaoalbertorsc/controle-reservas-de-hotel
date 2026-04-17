public class Hotel {

    private static final int CAPACIDADE_MAXIMA = 10;
    private Reserva[] reservas;
    private int totalReservas;

    public Hotel() {
        this.reservas = new Reserva[CAPACIDADE_MAXIMA];
        this.totalReservas = 0;
    }

    public boolean cadastrarReserva(Reserva reserva) {
        if (totalReservas >= CAPACIDADE_MAXIMA) {
            return false;
        }
        reservas[totalReservas] = reserva;
        totalReservas++;
        return true;
    }

    public Reserva[] getReservas() {
        Reserva[] resultado = new Reserva[totalReservas];
        for (int i = 0; i < totalReservas; i++) {
            resultado[i] = reservas[i];
        }
        return resultado;
    }

    public Reserva[] buscarPorNome(String nome) {
        int count = 0;
        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i].getNomeHospede().toLowerCase().contains(nome.toLowerCase())) {
                count++;
            }
        }
        Reserva[] resultado = new Reserva[count];
        int index = 0;
        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i].getNomeHospede().toLowerCase().contains(nome.toLowerCase())) {
                resultado[index] = reservas[i];
                index++;
            }
        }
        return resultado;
    }

    public void ordenarPorDiasDesc() {
        for (int i = 0; i < totalReservas - 1; i++) {
            for (int j = 0; j < totalReservas - 1 - i; j++) {
                if (reservas[j].getNumeroDias() < reservas[j + 1].getNumeroDias()) {
                    Reserva temp = reservas[j];
                    reservas[j] = reservas[j + 1];
                    reservas[j + 1] = temp;
                }
            }
        }
    }

    public int getTotalReservas() {
        return totalReservas;
    }

    public int getCapacidadeMaxima() {
        return CAPACIDADE_MAXIMA;
    }
}