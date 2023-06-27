package homework6;

public class Laptop {
    private String model;
    private String color;
    private Integer ram;
    private Integer cpuCores;

    public Laptop() {
    }

    public Laptop(String model, String color, int ram, int cpuCores) {
        this.model = model;
        this.color = color;
        this.ram = ram;
        this.cpuCores = cpuCores;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", ram=" + ram +
                ", cpuCores=" + cpuCores +
                '}';
    }
}
