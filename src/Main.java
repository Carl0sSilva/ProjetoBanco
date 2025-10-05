import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Mostrar saldo de uma conta");
            System.out.println("6 - Listar todas as contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1: //criar conta
                    System.out.println("Titular da conta");
                    String titular = sc.nextLine();

                    Conta novaConta = new Conta(titular);
                    contas.add(novaConta);
                    
                    System.out.println("Conta criada com sucesso, o número da sua conta é: "+ novaConta.getNumero());
                    break;
                case 2:
                    System.out.println("Digite o número da conta.");
                    int numDep = sc.nextInt();

                    System.out.println("Digite o valor a ser depositado.");
                    double valDeposito = sc.nextDouble();

                    Conta contaDep = buscarConta(contas, numDep);
                    if (contaDep != null){
                        contaDep.depositar(valDeposito);
                    }else{
                        System.out.println("Conta bancária não encontrada");
                    }

                    break;
                
                case 3:
                    System.out.println("Digite o número da conta.");
                    int numSaque = sc.nextInt();

                    System.out.println("Digite o valor do saque.");
                    double valSaque = sc.nextDouble();

                    Conta contaSaque = buscarConta(contas, numSaque);

                    if (contaSaque != null){
                        contaSaque.sacar(valSaque);
                    }else{
                        System.out.println("Conta bancária não encontrada.");
                    }
                    break;
                
                case 4:
                    System.out.println("Digite o número da sua conta.");
                    int numContaOrigem = sc.nextInt();

                    System.out.println("Digite o número da conta de destino");
                    int numContaDestino = sc.nextInt();

                    System.out.println("Digite o valor da transferência.");
                    double valTransf = sc.nextDouble();

                    Conta contaOrigem = buscarConta(contas, numContaOrigem);
                    Conta contaDestino = buscarConta(contas, numContaDestino);

                    if(contaOrigem != null && contaDestino != null){
                        contaOrigem.transferir(valTransf, contaDestino);
                    }else if (contaOrigem == null && contaDestino == null){
                        System.out.println("Nenhuma conta bancária encontrada.");
                    }else if(contaOrigem == null){
                        System.out.println("Conta origem não encontrada.");
                    }else{
                        System.out.println("Conta destino não encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Digite o número da conta.");
                    int numContaSaldo = sc.nextInt();

                    Conta contaVerSaldo = buscarConta(contas, numContaSaldo);

                    if(contaVerSaldo != null){
                        contaVerSaldo.mostraSaldo();
                    }else{
                        System.out.println("Conta bancária não encontrada.");
                    }
                    break;
                case 6:
                    if (contas.isEmpty()){
                        System.out.println("Nenhuma conta cadastrada.");
                    } else{
                        for (Conta c: contas){
                            System.out.println("Conta: "+ c.getNumero() +" | Titular: "+ c.getTitular() +" | Saldo: R$"+ c.getSaldo());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Até a próxima...");
                    break;

                default:
                    System.out.println("Opção inexistente.");
            }
        } while (opcao != 0);

        sc.close();
    }

    public static Conta buscarConta(ArrayList<Conta> contas, int num){
            for (Conta c : contas){
                if (c.getNumero() == num){
                    return c;
                }
            }
            return null;
        }

}