package v1;

import java.util.ArrayList;

public class Veiculo {
    private static ArrayList<Moto> motos = new ArrayList<>();
    private static ArrayList<Carro> carros = new ArrayList<>();

    public static void cadastrarCarro(Carro c){
        carros.add(c);
    }

    public static void cadastrarMoto(Moto m){
        motos.add(m);
    }

    static public String veiculosDisponiveis(String tipoVeiculo){
        String retorno = "";

        if (tipoVeiculo.equals("moto")){
            for (Moto moto : motos){
                if (moto.getDisponivel() == 's'){
                    retorno += "Placa: " + moto.getPlaca() + "\n Marca: " + moto.marca +
                            "\nModelo: " + moto.modelo + "\n\n";
                }
            }
        }
        else if (tipoVeiculo.equals("simples")){
            for (Carro carro : carros){
                if (carro.getLuxo() == 'n' && carro.getDisponivel() == 's'){
                    retorno += "Placa: " + carro.getPlaca() + "\nMarca: " + carro.getMarca() +
                            "\nModelo: " + carro.getModelo() + "\n\n";
                }
            }
        }
        else{
            for (Carro carro : carros){
                if (carro.getLuxo() == 's' && carro.getDisponivel() == 's'){
                    retorno += "Placa: " + carro.placa + "\nMarca: " + carro.marca +
                            "\nModelo: " + carro.modelo + "\n\n";
                }
            }
        }
        return retorno;
    }

    public void reservaVeiculo(String tipoVeiculo, String placa){
        if (tipoVeiculo.equals("simples") || tipoVeiculo.equals("luxo")){
            for (Carro carro : carros){
                if (carro.getPlaca().equalsIgnoreCase(placa)){
                    carro.setDisponivel('n');
                }
            }
        }
        else{
            for (Moto moto : motos){
                if (moto.getPlaca().equalsIgnoreCase(placa)){
                    moto.setDisponivel('n');
                }
            }
        }
    }
}
