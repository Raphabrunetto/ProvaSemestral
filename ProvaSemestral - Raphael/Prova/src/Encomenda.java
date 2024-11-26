public class Encomenda {
    private double peso;      // Peso da encomenda em kg
    private double volume;    // Volume da encomenda em m³
    private String destino;   // Destino da encomenda (local, internacional)
    private String tipo;      // Tipo de transporte (terrestre, aéreo, maritimo, drone)

    // Construtor para inicializar os parâmetros
    public Encomenda(double peso, double volume, String destino, String tipo) {
        this.peso = peso;
        this.volume = volume;
        this.destino = destino;
        this.tipo = tipo;
    }

    // Getters para acessar os valores
    public double getPeso() {
        return peso;
    }

    public double getVolume() {
        return volume;
    }

    public String getDestino() {
        return destino;
    }

    public String getTipo() {
        return tipo;
    }
}