public class Main {
    public static void main(String[] args) {
        // Criação das encomendas
        Encomenda encomenda = new Encomenda(10, 4, "local", "aereo");  // 10 kg, 4 m³, destino local, transporte aéreo
        Encomenda encomenda2 = new Encomenda(10, 3, "local", "terrestre");  // 10 kg, 3 m³, destino local, transporte terrestre
        Encomenda encomenda3 = new Encomenda(60, 30, "local", "aereo");  // Encomenda com limites excedidos (exemplo de erro)
        Encomenda encomendaMaritima = new Encomenda(80, 150, "internacional", "maritimo");
        Encomenda encomendaDrone = new Encomenda(1, 0.5, "metropolitana", "drone");
        Encomenda encomendaErro = new Encomenda(3, 0.5, "metropolitana", "drone"); // Com Erro

        // Criando a transportadora
        Transportadora transportadora = new Transportadora();

        // Processando a encomenda 1 (aérea)
        if (encomenda.getTipo().equals("terrestre")) {
            transportadora.setTransporte(new TransporteTerrestre());
        } else if (encomenda.getTipo().equals("aereo")) {
            transportadora.setTransporte(new TransporteAereo());
        } else if (encomenda.getTipo().equals("maritimo")) {
            transportadora.setTransporte(new TransporteMaritimo());
        } else if (encomenda.getTipo().equals("drone")) {
            transportadora.setTransporte(new TransporteDrone());
        }
        transportadora.processarEncomenda(encomenda);

        System.err.println("\n");

        // Processando a encomenda 2 (terrestre)
        if (encomenda2.getTipo().equals("terrestre")) {
            transportadora.setTransporte(new TransporteTerrestre());
        } else if (encomenda2.getTipo().equals("aereo")) {
            transportadora.setTransporte(new TransporteAereo());
        } else if (encomenda2.getTipo().equals("maritimo")) {
            transportadora.setTransporte(new TransporteMaritimo());
        } else if (encomenda2.getTipo().equals("drone")) {
            transportadora.setTransporte(new TransporteDrone());
        }
        transportadora.processarEncomenda(encomenda2);

        System.out.println("\n");

        // Processando a encomenda 3 (com erro de limites)
        try {
            if (encomenda3.getTipo().equals("terrestre")) {
                transportadora.setTransporte(new TransporteTerrestre());
            } else if (encomenda3.getTipo().equals("aereo")) {
                transportadora.setTransporte(new TransporteAereo());
            } else if (encomenda3.getTipo().equals("maritimo")) {
                transportadora.setTransporte(new TransporteMaritimo());
            } else if (encomenda3.getTipo().equals("drone")) {
                transportadora.setTransporte(new TransporteDrone());
            }
            
            transportadora.processarEncomenda(encomenda3);

        } catch (IllegalArgumentException e) {
            
            System.out.println("Erro: Limites excedidos para o tipo de transporte aéreo.");
        }
        System.out.println("\n");

        try {
            transportadora.setTransporte(new TransporteMaritimo());
            transportadora.processarEncomenda(encomendaMaritima); // Deverá funcionar corretamente
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n");

        try {
            transportadora.setTransporte(new TransporteDrone());
            transportadora.processarEncomenda(encomendaDrone); // Deverá funcionar corretamente
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n");

        try {
            transportadora.processarEncomenda(encomendaErro); // Deverá lançar exceção devido ao peso
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("\n");
    }
}