public class Transportadora {
    private Transporte transporte; // Transporte configurado

    // Método para configurar o tipo de transporte
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    // Método para processar a encomenda
    public void processarEncomenda(Encomenda encomenda) {
        // Verificar os requisitos antes de calcular o custo
        if (transporte != null) {
            transporte.verificarRequisitos(encomenda);  // Verifica requisitos (peso, volume, etc.)
            transporte.calcularCusto(encomenda);  // Chama o cálculo do custo
        } else {
            System.out.println("Erro: Nenhum transporte configurado.");
        }
    }
}