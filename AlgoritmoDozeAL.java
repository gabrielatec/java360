public class AlgoritmoDozeAL {
    public void main(){
                    
        int numero = Integer.parseInt(IO.readln("Digite um numero inteiro: "));
        
        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é par.");
        } else {
            System.out.println("O número " + numero + " é ímpar.");
        }
        
    }
}

