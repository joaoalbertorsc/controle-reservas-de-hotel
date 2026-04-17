import java.util.Scanner;

public class Menu {

    private Hotel hotel;
    private Scanner scanner;
    int numMinimoDiariasPossiveis = 1;
    double valorMinimoDeUmaDiária = 0.01;

    private static final String BORDA_TOPO     = "╔══════════════════════════════════════╗";
    private static final String BORDA_MEIO     = "╠══════════════════════════════════════╣";
    private static final String BORDA_RODAPE   = "╚══════════════════════════════════════╝";
    private static final String BORDA_DIVISOR  = "╟──────────────────────────────────────╢";
    private static final int    LARGURA_INTERNA = 38;

    public Menu() {
        this.hotel = new Hotel();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;

        System.out.println(BORDA_TOPO);
        System.out.println(linha("Bem-vindo ao Hotel Reservas System"));
        System.out.println(BORDA_RODAPE);

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarReserva();
                    break;
                case 2:
                    exibirReservas(hotel.getReservas(), "Lista de Reservas");
                    break;
                case 3:
                    buscarPorNome();
                    break;
                case 4:
                    ordenarPorDiasDesc();
                    break;
                case 5:
                    System.out.println("\n" + BORDA_TOPO);
                    System.out.println(linha("Encerrando o sistema. Ate logo!"));
                    System.out.println(BORDA_RODAPE);
                    break;
                default:
                    System.out.println("\n  Opcao invalida. Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n" + BORDA_TOPO);
        System.out.println(linha("Menu Principal"));
        System.out.println(BORDA_MEIO);
        System.out.println(linhaCampo("1. Nova reserva"));
        System.out.println(linhaCampo("2. Listar reservas"));
        System.out.println(linhaCampo("3. Buscar reserva por nome"));
        System.out.println(linhaCampo("4. Ordenar reservas por dias"));
        System.out.println(linhaCampo("5. Sair"));
        System.out.println(BORDA_RODAPE);
        System.out.print("  Escolha uma opcao: ");
    }

    private void exibirReservas(Reserva[] lista, String titulo) {
        System.out.println("\n" + BORDA_TOPO);
        System.out.println(linha(titulo));
        System.out.println(BORDA_MEIO);
        if (lista.length == 0) {
            System.out.println(linha("Nenhuma reserva encontrada."));
        } else {
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
                if (i < lista.length - 1) {
                    System.out.println(BORDA_DIVISOR);
                }
            }
        }
        System.out.println(BORDA_RODAPE);
    }

    private void cadastrarReserva() {
        if (hotel.getTotalReservas() >= hotel.getCapacidadeMaxima()) {
            System.out.println("\n" + BORDA_TOPO);
            System.out.println(linha("Capacidade maxima atingida."));
            System.out.println(BORDA_RODAPE);
            return;
        }

        System.out.println("\n" + BORDA_TOPO);
        System.out.println(linha("Nova Reserva"));
        System.out.println(BORDA_RODAPE);

        System.out.print("\n  Nome do hospede: ");
        String nome = scanner.nextLine().trim();

        String tipoQuarto = lerTipoQuarto();

        int numeroDias = lerInteiro("\n  Numero de dias: ", numMinimoDiariasPossiveis);
        double valorDiaria = lerDouble("\n  Valor da diaria (R$): ", valorMinimoDeUmaDiária);

        Reserva reserva = new Reserva(nome, tipoQuarto, numeroDias, valorDiaria);
        boolean sucesso = hotel.cadastrarReserva(reserva);

        if (sucesso) {
            System.out.println("\n" + BORDA_TOPO);
            System.out.println(linha("Reserva cadastrada com sucesso!"));
            System.out.println(BORDA_RODAPE);
        } else {
            System.out.println("\n" + BORDA_TOPO);
            System.out.println(linha("Erro ao cadastrar reserva."));
            System.out.println(BORDA_RODAPE);
        }
    }

    private void buscarPorNome() {
        System.out.println("\n" + BORDA_TOPO);
        System.out.println(linha("Buscar Reserva por Nome"));
        System.out.println(BORDA_RODAPE);
        System.out.print("\n  Nome ou parte do nome: ");
        String nome = scanner.nextLine().trim();
        Reserva[] resultado = hotel.buscarPorNome(nome);
        exibirReservas(resultado, "Resultado da Busca");
    }

    private void ordenarPorDiasDesc() {
        hotel.ordenarPorDiasDesc();
        exibirReservas(hotel.getReservas(), "Reservas Ordenadas por Dias");
    }

    private String lerTipoQuarto() {
        String tipo = "";
        while (tipo.isEmpty()) {
            System.out.println("\n" + BORDA_TOPO);
            System.out.println(linha("Tipo do Quarto"));
            System.out.println(BORDA_MEIO);
            System.out.println(linhaCampo("S - Standard"));
            System.out.println(linhaCampo("L - Luxo"));
            System.out.println(linhaCampo("P - Presidencial"));
            System.out.println(BORDA_RODAPE);
            System.out.print("  Escolha: ");
            String entrada = scanner.nextLine().trim().toUpperCase();
            switch (entrada) {
                case "S":
                    tipo = "Standard";
                    break;
                case "L":
                    tipo = "Luxo";
                    break;
                case "P":
                    tipo = "Presidencial";
                    break;
                default:
                    System.out.println("\n  Opcao invalida. Digite S, L ou P.");
            }
        }
        return tipo;
    }

    private int lerOpcao() {
        int opcao = -1;
        try {
            opcao = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            // entrada inválida retorna -1, cai no default do switch
        }
        return opcao;
    }

    private int lerInteiro(String mensagem, int minimo) {
        int valor = -1;
        while (valor < minimo) {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < minimo) {
                    System.out.println("  Valor invalido. Minimo permitido: " + minimo);
                }
            } catch (NumberFormatException e) {
                System.out.println("  Entrada invalida. Digite um numero inteiro.");
            }
        }
        return valor;
    }

    private double lerDouble(String mensagem, double minimo) {
        double valor = -1;
        while (valor < minimo) {
            System.out.print(mensagem);
            try {
                valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
                if (valor < minimo) {
                    System.out.println("  Valor invalido. Minimo permitido: " + minimo);
                }
            } catch (NumberFormatException e) {
                System.out.println("  Entrada invalida. Digite um numero valido.");
            }
        }
        return valor;
    }

    private String linha(String texto) {
        int espacos = LARGURA_INTERNA - texto.length();
        int esqDir = espacos / 2;
        int dir = espacos - esqDir;
        return "║" + " ".repeat(esqDir) + texto + " ".repeat(dir) + "║";
    }

    private String linhaCampo(String texto) {
        int espacos = LARGURA_INTERNA - 2 - texto.length();
        return "║  " + texto + " ".repeat(Math.max(0, espacos)) + "║";
    }
}