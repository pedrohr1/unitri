package v1;

public class Moto {
    String placa, marca, modelo = "";
    char disponivel;

    public Moto() {}

    public Moto(String placa, String marca, String modelo, char disponivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
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

    public String retornaMotos(){
        return "Placa: " + placa + "\n Marca: " + marca + "\n Modelo: " + modelo +
                "\n Disponível:" + disponivel;
    }
}