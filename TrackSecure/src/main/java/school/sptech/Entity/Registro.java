package school.sptech.Entity;

public class Registro {
    private Integer idRegistro;
    private String so;
    private String dtHora;
    private Double porcentagemProcessador;
    private Double porcentagemMemoria;
    private Double porcentagemDisco;
    private Double freqProcessador;
    private Double freqMaxProcessador;
    private Double memoriaTotal;
    private Double memoriaUsada;
    private Double discoTotal;
    private Double discoUsado;
    private Integer fkServidor;

    public Registro(String so, String dtHora, Double porcentagemProcessador, Double porcentagemMemoria, Double porcentagemDisco, Double freqProcessador, Double freqMaxProcessador, Double memoriaTotal, Double memoriaUsada, Double discoTotal, Double discoUsado) {
        this.so = so;
        this.dtHora = dtHora;
        this.porcentagemProcessador = porcentagemProcessador;
        this.porcentagemMemoria = porcentagemMemoria;
        this.porcentagemDisco = porcentagemDisco;
        this.freqProcessador = freqProcessador;
        this.freqMaxProcessador = freqMaxProcessador;
        this.memoriaTotal = memoriaTotal;
        this.memoriaUsada = memoriaUsada;
        this.discoTotal = discoTotal;
        this.discoUsado = discoUsado;
    }

    public Registro(Integer idRegistro, String so, String dtHora, Double porcentagemProcessador, Double porcentagemMemoria, Double porcentagemDisco, Double freqProcessador, Double freqMaxProcessador, Double memoriaTotal, Double memoriaUsada, Double discoTotal, Double discoUsado, Integer fkServidor) {
        this.idRegistro = idRegistro;
        this.so = so;
        this.dtHora = dtHora;
        this.porcentagemProcessador = porcentagemProcessador;
        this.porcentagemMemoria = porcentagemMemoria;
        this.porcentagemDisco = porcentagemDisco;
        this.freqProcessador = freqProcessador;
        this.freqMaxProcessador = freqMaxProcessador;
        this.memoriaTotal = memoriaTotal;
        this.memoriaUsada = memoriaUsada;
        this.discoTotal = discoTotal;
        this.discoUsado = discoUsado;
        this.fkServidor = fkServidor;
    }

    public Registro() {
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getdtHora() {
        return dtHora;
    }

    public void setdtHora(String dtHora) {
        this.dtHora = dtHora;
    }

    public Double getPorcentagemProcessador() {
        return porcentagemProcessador;
    }

    public void setPorcentagemProcessador(Double porcentagemProcessador) {
        this.porcentagemProcessador = porcentagemProcessador;
    }

    public Double getPorcentagemMemoria() {
        return porcentagemMemoria;
    }

    public void setPorcentagemMemoria(Double porcentagemMemoria) {
        this.porcentagemMemoria = porcentagemMemoria;
    }

    public Double getPorcentagemDisco() {
        return porcentagemDisco;
    }

    public void setPorcentagemDisco(Double porcentagemDisco) {
        this.porcentagemDisco = porcentagemDisco;
    }

    public Double getFreqProcessador() {
        return freqProcessador;
    }

    public void setFreqProcessador(Double freqProcessador) {
        this.freqProcessador = freqProcessador;
    }

    public Double getFreqMaxProcessador() {
        return freqMaxProcessador;
    }

    public void setFreqMaxProcessador(Double freqMaxProcessador) {
        this.freqMaxProcessador = freqMaxProcessador;
    }

    public Double getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(Double memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public Double getMemoriaUsada() {
        return memoriaUsada;
    }

    public void setMemoriaUsada(Double memoriaUsada) {
        this.memoriaUsada = memoriaUsada;
    }

    public Double getDiscoTotal() {
        return discoTotal;
    }

    public void setDiscoTotal(Double discoTotal) {
        this.discoTotal = discoTotal;
    }

    public Double getDiscoUsado() {
        return discoUsado;
    }

    public void setDiscoUsado(Double discoUsado) {
        this.discoUsado = discoUsado;
    }

    public Integer getFkServidor() {
        return fkServidor;
    }

    public void setFkServidor(Integer fkServidor) {
        this.fkServidor = fkServidor;
    }

    @Override
    public String toString() {
        return """
                [Registro]
                Máquina %d
                idRegistro: %d
                SO: %s
                Data Hora: %s
                PorcentagemProcessador: %.2f
                porcentagemMemoria:  %.2f
                porcentagemDisco:  %.2f
                freqProcessador:  %.2f
                freqMaxProcessador:  %.2f
                memoriaTotal:  %.2f
                memoriaUsada:  %.2f
                discoTotal:  %.2f
                discoUsado:  %.2f
                """.formatted(fkServidor, idRegistro, so, dtHora, porcentagemProcessador, porcentagemMemoria, porcentagemDisco, freqProcessador,
                freqMaxProcessador, memoriaTotal, memoriaUsada, discoTotal, discoUsado);
    }
}
