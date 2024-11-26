public class TransporteTerrestre implements Transporte {

    @Override
    public void calcularCusto(Encomenda encomenda) {
        // Definir custo base para o transporte terrestre
        double custoBase = 50.0; // Custo fixo base para o transporte terrestre
        double custoPeso = encomenda.getPeso() * 3.0; // 3.0 por kg de peso
        double custoVolume = encomenda.getVolume() * 2.0; // 2.0 por m³ de volume
        double custoDestino = 0.0;
        
        // Verifica se o destino é internacional (maior custo)
        if (encomenda.getDestino().equals("internacional")) {
            custoDestino = 40.0; // Custo adicional para destino internacional
        } else {
            custoDestino = 20.0; // Custo adicional para destino nacional
        }

        // Cálculo do custo total
        double custoTotal = custoBase + custoPeso + custoVolume + custoDestino;

        // Exibe o custo detalhado e o custo total
        System.out.println("Custo Base: R$" + custoBase);
        System.out.println("Custo Peso (" + encomenda.getPeso() + " kg * 3): R$" + custoPeso);
        System.out.println("Custo Volume (" + encomenda.getVolume() + " m³ * 2): R$" + custoVolume);
        System.out.println("Custo Destino (" + encomenda.getDestino() + "): R$" + custoDestino);
        System.out.println("O custo total do transporte terrestre é: R$" + custoTotal);
    }

    @Override
    public void verificarRequisitos(Encomenda encomenda) {
        // Limite de peso e volume para o transporte terrestre
        if (encomenda.getPeso() > 30 || encomenda.getVolume() > 50) {
            throw new IllegalArgumentException("Limites excedidos para transporte terrestre.");
        }
    }
}