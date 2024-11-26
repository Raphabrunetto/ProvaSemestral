public class TransporteDrone implements Transporte {
    @Override
    public void calcularCusto(Encomenda encomenda) {
        // Definir custo base para o transporte por drone
        double custoBase = 30.0; // Um valor fixo base para o transporte por drone
        double custoPeso = encomenda.getPeso() * 10.0; // 10.0 por kg de peso (valores mais altos devido à limitação do drone)
        double custoVolume = encomenda.getVolume() * 5.0; // 5.0 por m³ de volume (valores ajustados para transporte pequeno)
        double custoDestino = 0.0;
        
        // Verifica se o destino é metropolitano (onde o drone pode operar)
        if (encomenda.getDestino().equals("metropolitana")) {
            custoDestino = 20.0; // Custo adicional para destinos metropolitanos
        } else {
            custoDestino = 50.0; // Destino fora da área metropolitana (possivelmente com custos maiores)
        }
        
        // Imprimir os valores intermediários para diagnóstico
        System.out.println("Custo Base: R$" + custoBase);
        System.out.println("Custo Peso (" + encomenda.getPeso() + " kg * 10): R$" + custoPeso);
        System.out.println("Custo Volume (" + encomenda.getVolume() + " m³ * 5): R$" + custoVolume);
        System.out.println("Custo Destino (" + encomenda.getDestino() + "): R$" + custoDestino);
        
        // Cálculo do custo total
        double custoTotal = custoBase + custoPeso + custoVolume + custoDestino;
        
        // Exibe o custo total
        System.out.println("O custo total do transporte por drone é: R$" + custoTotal);
    }

    @Override
    public void verificarRequisitos(Encomenda encomenda) {
        // Limite de peso para o transporte por drone (exemplo de limite de 2kg)
        if (encomenda.getPeso() > 2) {
            throw new IllegalArgumentException("Entrega por drone é limitada a pacotes de até 2kg.");
        }
        
        // Verifica se o destino é metropolitano
        if (!encomenda.getDestino().equals("metropolitana")) {
            throw new IllegalArgumentException("Entrega por drone é limitada a áreas metropolitanas.");
        }
    }
}