package v1;

public class Aluguel {
    private double valorMoto = 15.00;
    private double valorVeiculoSimples = 70.00;
    private double valorVeiculoLuxo = 100.00;

    public String consultaVeiculosDisponiveis(String tipoVeiculo){
        Veiculo veiculo = new Veiculo();
        if (tipoVeiculo == "moto"){
            return veiculo.veiculosDisponiveis(tipoVeiculo);
        }
        else if (tipoVeiculo == "simples"){
            return veiculo.veiculosDisponiveis(tipoVeiculo);
        }
        else {
            return veiculo.veiculosDisponiveis(tipoVeiculo);
        }
    }

    public double simulaValorAluguel(int qtdDiarias, String tipoVeiculo) {
        if (tipoVeiculo == "moto"){
            return valorMoto * qtdDiarias;
        }
        else if (tipoVeiculo == "simples"){
            return valorVeiculoSimples * qtdDiarias;
        }
        else {
            return valorVeiculoLuxo * qtdDiarias;
        }
    }

    public String alugar (String tipoVeiculo, String placa, int qtdDiarias, String cpf) {
        Pessoa pessoa = new Pessoa();
        if (pessoa.existePessoa(cpf)) {
            Veiculo veiculo = new Veiculo();
            veiculo.reservaVeiculo(tipoVeiculo, placa);
            return String.format("Veiculo reservado para: " + pessoa.retornaNome(cpf) + "\nValor da reserva: R$%.2f", simulaValorAluguel(qtdDiarias, tipoVeiculo));
        }
        else {
            return "Pessoa inexistente na base de dados, por favor relizar o cadastro";
        }
    }
}
