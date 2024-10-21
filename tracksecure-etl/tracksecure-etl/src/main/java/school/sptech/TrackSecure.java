package school.sptech;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties (ignoreUnknown = true)
public class TrackSecure {

    @JsonProperty("Maquina")
    private String Maquina;

    @JsonProperty("SO")
    private String SO;

    @JsonProperty("PorcentCPU")
    private Double PorcentCPU;

    @JsonProperty("FreqCPU")
    private Double FreqCPU;

    @JsonProperty("UsoRAM")
    private Double UsoRAM;

    @JsonProperty("PorcentRAM")
    private Double PorcentRAM;

    @JsonProperty("UsoDisco")
    private Double UsoDisco;

    @JsonProperty("PorcentDisco")
    private Double PorcentDisco;

    public String getMaquina() {
        return Maquina;
    }

    public void setMaquina(String maquina) {
        Maquina = maquina;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public Double getPorcentCPU() {
        return PorcentCPU;
    }

    public void setPorcentCPU(Double porcentCPU) {
        PorcentCPU = porcentCPU;
    }

    public Double getFreqCPU() {
        Double freqCpuFormatada = this.FreqCPU / Math.pow(10.0, 3.0);
        freqCpuFormatada = Double.parseDouble("%.2f".formatted(freqCpuFormatada).replace(",", "."));
        return freqCpuFormatada;
    }

    public void setFreqCPU(Double freqCPU) {
        FreqCPU = freqCPU;
    }

    public Double getUsoRAM() {
        Double usoRamFormatado = this.UsoRAM / Math.pow(10.0, 9.0);
        usoRamFormatado = Double.parseDouble("%.2f".formatted(usoRamFormatado).replace(",", "."));
        return usoRamFormatado;
    }

    public void setUsoRAM(Double usoRAM) {
        UsoRAM = usoRAM;
    }

    public Double getPorcentRAM() {
        return PorcentRAM;
    }

    public void setPorcentRAM(Double porcentRAM) {
        PorcentRAM = porcentRAM;
    }

    public Double getUsoDisco() {
        Double usoDiscoFormatado = this.UsoDisco / Math.pow(10.0, 9.0);
        usoDiscoFormatado = Double.parseDouble("%.2f".formatted(usoDiscoFormatado).replace(",", "."));
        return usoDiscoFormatado;
    }

    public void setUsoDisco(Double usoDisco) {
        UsoDisco = usoDisco;
    }

    public Double getPorcentDisco() {
        return PorcentDisco;
    }

    public void setPorcentDisco(Double porcentDisco) {
        PorcentDisco = porcentDisco;
    }
}