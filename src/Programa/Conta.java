package Programa;

import Utilitarios.Utils;

public class Conta {

    private static int contContas = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private double saldo;
    private double limite = 0.0;
    private boolean contaEspecial;

    public Conta(int numeroConta, Pessoa pessoa, double saldo) {
        this.numeroConta = contContas;
        this.pessoa = pessoa;
        contContas += 1;
    }


    public Conta(Pessoa pessoa) {
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean isContaEspecial() {
        return contaEspecial;
    }

    public void setContaEspecial(boolean contaEspecial) {
        this.contaEspecial = contaEspecial;
    }

    public String toString(){
        return "\n Número da conta: " + this.getNumeroConta() +
                "\n Nome: " + this.pessoa.getNome() +
                "\n CPF: " + this.pessoa.getCpf() +
                "\n E-mail: " + this.pessoa.getEmail() +
                "\n Saldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }
    public void depositar(Double deposito) {
        if(deposito > 0) {
            setSaldo(getSaldo()+deposito);
            System.out.println("Deposito no valor de: R$ " + deposito + " efetuado com sucesso!");
            System.out.println("Seu novo saldo é de: " + saldo);
        } else {
            System.out.println("Não foi possível realizar o deposito, digite outro valor! ");
        }
    }

    public void sacar(Double saque){
        if (saldo > 0 && saque <= this.getSaldo()){
            setSaldo(getSaldo()-saque);
        } else if (contaEspecial == true && saque <= limite){
            setSaldo(getSaldo()-saque);
            setLimite(getLimite()-saque);
        } else {
            System.out.println("Não foi possível realizar o saque! ");

        }
    }

    public void transferir(double transferencia, Conta contaDeposito){
        if (saldo > 0 && transferencia <= saldo){
            setSaldo(getSaldo()-transferencia);
            contaDeposito.saldo = contaDeposito.getSaldo() + transferencia;
            System.out.println("Transferência realizada com sucesso: ");
        } if (contaEspecial == true && transferencia <= limite){
            setSaldo(getSaldo()-transferencia);
            setLimite(getLimite()-transferencia);
        } else {
            System.out.println("Não foi possível realizar a transferência! ");
        }
    }

}
