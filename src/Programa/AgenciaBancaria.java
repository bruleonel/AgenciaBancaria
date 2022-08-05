package Programa;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class AgenciaBancaria {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Conta> contas;

    public static void main(String[] args) {
        contas = new ArrayList<Conta>();
        menu();
    }

    public static void menu() {

        System.out.println("....................................................................");
        System.out.println("|                              BEM VIDO                            |");
        System.out.println("|..................................................................|");
        System.out.println("|                           Digite a opção:                        |");
        System.out.println("|   1) Para criar conta                                            |");
        System.out.println("|   2) Para realizar um depósito                                   |");
        System.out.println("|   3) Para saque                                                  |");
        System.out.println("|   4) Para transferência                                          |");
        System.out.println("|   5) Para listar                                                 |");
        System.out.println("|   6) Sair                                                        |");
        System.out.println("|..................................................................|");

        int menu = scan.nextInt();

        switch (menu){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Obrigada!");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida, digite novamente ");
                menu();
                break;
        }
    }
     public static void criarConta() {
         System.out.println("Digite o nome do usuário: ");
         String nome = scan.nextLine();

         System.out.println("Digite o CPF do usuário: ");
         String cpf = scan.nextLine();

         System.out.println("Digite o e-mail nome do usuário: ");
         String email = scan.nextLine();

         Pessoa pessoa = new Pessoa(nome, cpf, email);
         Conta conta = new Conta(pessoa);

         contas.add(conta);
         System.out.println("Conta criada com sucesso, o número da sua conta é: " + conta.getNumeroConta());

         menu();

     }

     private static Conta buscar(int numConta){
        Conta conta = null;
        if(contas.size()>0){
            for(Conta conta1 :contas){
                if(conta1.getNumeroConta() == numConta)
                    conta = conta1;
            }
        }
        return conta;
     }

     public static void depositar() {
         System.out.println("Digite o número da conta: ");
         int numConta = scan.nextInt();

         Conta conta = buscar(numConta);
         if (conta != null) {
             System.out.println("Digite o valor do depósito: ");
             double valor = scan.nextDouble();
             conta.depositar(valor);
         } else {
             System.out.println("Conta não encontrada! ");
         }
     }

     public static void sacar() {
         System.out.println("Digite o número da conta: ");
         int numConta = scan.nextInt();

         Conta conta = buscar(numConta);
         if (conta != null) {
             System.out.println("Digite o valor que deseja sacar: ");
             double valor = scan.nextDouble();
             conta.sacar(valor);
         } else {
             System.out.println("Conta não encontrada! ");
         }

     }

    public static void transferir() {
        System.out.println("Digite o número da conta do remetente: ");
        int numConta = scan.nextInt();

        Conta contaRemetente = buscar(numConta);

        if (contaRemetente != null) {
            System.out.println("Digite o número da conta do destinatário: ");
            int numDestinatario = scan.nextInt();

            Conta contaDestinatario = buscar(numDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Digite o valor que deseja transferir: ");
                double valor = scan.nextDouble();

                contaRemetente.transferir(valor, contaDestinatario);
            } else {
                System.out.println("Conta não encontrada! ");
            }

        }
        menu();
    }

    public static void listar() {
        if(contas.size()>0){
            for(Conta conta: contas){
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
         menu();
    }
}
