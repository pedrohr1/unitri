package v1;

public class Carro {
    String placa, marca, modelo = "";
    char disponivel, luxo;

    public Carro() {}

    public Carro(String placa, String marca, String modelo, char luxo, char disponivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.luxo = luxo;
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public char getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(char disponivel) {
        this.disponivel = disponivel;
    }

    public char getLuxo() {
        return luxo;
    }

    public void setLuxo(char luxo) {
        this.luxo = luxo;
    }

    public String retornaVeiculos(){
        return "Placa: " + placa + "\nMarca: " + marca + "\nModelo: " + modelo +
                "\nDisponível:" + disponivel + "\nLuxo:" + luxo;
    }
}