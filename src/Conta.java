public class Conta {
    
    private static int contador = 1;
    private int numero;
    private String titular;
    private double saldo = 0;

    public Conta(String titular){
        this.numero = contador++;
        this.titular = titular;
    }

    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public String getTitular(){
        return titular;
    }

    public void depositar(double val){
        saldo = saldo + val;
        System.out.println("Titular: "+ titular);
        System.out.println("Valor depositado R$" + val);
        System.out.println("Saldo total: R$" + saldo);
    }

    public void sacar(double val){
        System.out.println("Titular: "+ titular);
        if(val > saldo){
            System.out.println("Saldo insuficiente.");
        }else{
            saldo = saldo - val;
            System.out.println("O valor do saque foi R$" + val);
            System.out.println("Saldo total: R$"+ saldo);
        }
    }

    public void transferir(double val, Conta destino){
        if (val > saldo){
            System.out.println("Titular: "+ titular);
            System.out.println("Saldo insuficiente.");
        }else{
            sacar(val);
            destino.depositar(val);
            System.out.println("Depósito de R$"+ val +" realizado por "+ titular +" para "+ destino.titular +".");
        }
    }

    public void mostraSaldo(){
        System.out.println("Titular: "+ titular);
        System.out.println("Saldo total: R$"+ saldo);
    }
}
