public class TransporteMaritimo implements Transporte {
    @Override
    public void calcularCusto(Encomenda encomenda) {
        // Definir custo base para o transporte marítimo
        double custoBase = 150.0; // Um valor fixo base para o transporte marítimo (valor hipotético)
        double custoPeso = encomenda.getPeso() * 3.0; // 3.0 por kg de peso (valor hipotético)
        double custoVolume = encomenda.getVolume() * 2.5; // 2.5 por m³ de volume (valor hipotético)
        double custoDestino = 0.0;
        
        // Verifica se o destino é internacional (maior custo)
        if (encomenda.getDestino().equals("internacional")) {
            custoDestino = 100.0; // Custo adicional para destino internacional
        } else if (encomenda.getDestino().equals("local")) {
            custoDestino = 40.0; // Custo adicional para destino nacional (local)
        }
        
        // Imprimir os valores intermediários para diagnóstico
        System.out.println("Custo Base: R$" + custoBase);
        System.out.println("Custo Peso (" + encomenda.getPeso() + " kg * 3): R$" + custoPeso);
        System.out.println("Custo Volume (" + encomenda.getVolume() + " m³ * 2.5): R$" + custoVolume);
        System.out.println("Custo Destino (" + encomenda.getDestino() + "): R$" + custoDestino);
        
        // Cálculo do custo total
        double custoTotal = custoBase + custoPeso + custoVolume + custoDestino;
        
        // Exibe o custo total
        System.out.println("O custo total do transporte marítimo é: R$" + custoTotal);
    }

    @Override
    public void verificarRequisitos(Encomenda encomenda) {
        // Limite de peso e volume para o transporte marítimo
        if (encomenda.getPeso() > 100 || encomenda.getVolume() > 200) {
            throw new IllegalArgumentException("Limites excedidos para transporte marítimo.");
        }

        // Verifica se o destino é internacional
        if (!encomenda.getDestino().equals("internacional")) {
            throw new IllegalArgumentException("Transporte marítimo é apenas para entregas internacionais.");
        }
    }
}
