package Model;

public class Visitante {
    private int codigo;
    private String nome;
    private String documento;
    private String empresa;
    private String motivo;
    private String contato;
    private String colaborador;
    private String dataEntrada;
    private String horaEntrada;
    private String status;
    private String foto; // ✅ Agora é o caminho da imagem (String)

    public Visitante() {}

    public Visitante(int codigo, String nome, String documento, String empresa, String motivo,
                     String contato, String colaborador, String dataEntrada, String horaEntrada,
                     String status, String foto) {
        this.codigo = codigo;
        this.nome = nome;
        this.documento = documento;
        this.empresa = empresa;
        this.motivo = motivo;
        this.contato = contato;
        this.colaborador = colaborador;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.status = status;
        this.foto = foto;
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public String getColaborador() { return colaborador; }
    public void setColaborador(String colaborador) { this.colaborador = colaborador; }

    public String getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(String dataEntrada) { this.dataEntrada = dataEntrada; }

    public String getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(String horaEntrada) { this.horaEntrada = horaEntrada; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
}
