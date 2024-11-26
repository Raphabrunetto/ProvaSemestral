public class TransporteAereo implements Transporte {
    @Override
public void calcularCusto(Encomenda encomenda) {
    // Definir custo base para o transporte aéreo
    double custoBase = 100.0; // Um valor fixo base para o transporte aéreo
    double custoPeso = encomenda.getPeso() * 5.0; // 5.0 por kg de peso
    double custoVolume = encomenda.getVolume() * 3.0; // 3.0 por m³ de volume
    double custoDestino = 0.0;
    
    // Verifica se o destino é internacional (maior custo)
    if (encomenda.getDestino().equals("internacional")) {
        custoDestino = 50.0; // Custo adicional para destino internacional
    } else if (encomenda.getDestino().equals("local")) {
        custoDestino = 20.0; // Custo adicional para destino nacional (local)
    }
    
    // Imprimir os valores intermediários para ajudar no diagnóstico
    System.out.println("Custo Base: R$" + custoBase);
    System.out.println("Custo Peso (" + encomenda.getPeso() + " kg * 5): R$" + custoPeso);
    System.out.println("Custo Volume (" + encomenda.getVolume() + " m³ * 3): R$" + custoVolume);
    System.out.println("Custo Destino (" + encomenda.getDestino() + "): R$" + custoDestino);
    
    // Cálculo do custo total
    double custoTotal = custoBase + custoPeso + custoVolume + custoDestino;
    
    // Exibe o custo total
    System.out.println("O custo total do transporte aéreo é: R$" + custoTotal);
}

    @Override
    public void verificarRequisitos(Encomenda encomenda) {
        // Limite de peso e volume para o transporte aéreo
        if (encomenda.getPeso() > 50 || encomenda.getVolume() > 100) {
            throw new IllegalArgumentException("Limites excedidos para transporte aéreo.");
        }
    }
}