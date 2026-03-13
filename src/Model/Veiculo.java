package Model;

public class Veiculo {
    private int codigo;
    private String nome;
    private String documento;
    private String contato;
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private String tipo;        // Carro, Moto, Caminhonete
    private String categoria;   // Plano ou categoria do veículo
    private String dataEntrada;
    private String horaEntrada;
    private String status;

    // Construtor padrão
    public Veiculo() {}

    // Construtor completo
    public Veiculo(int codigo, String nome, String documento, String contato,
                   String placa, String modelo, String marca, String cor, String tipo, String categoria,
                   String dataEntrada, String horaEntrada, String status) {
        this.codigo = codigo;
        this.nome = nome;
        this.documento = documento;
        this.contato = contato;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.status = status;
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(String dataEntrada) { this.dataEntrada = dataEntrada; }

    public String getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(String horaEntrada) { this.horaEntrada = horaEntrada; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
