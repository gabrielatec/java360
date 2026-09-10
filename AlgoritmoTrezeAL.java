public class AlgoritmoTrezeAL {

    public void main(){

            int numero1 = Integer.parseInt(IO.readln("\nDigite o primeiro numero: "));
            int numero2 = Integer.parseInt(IO.readln("\nDigite o segundo numero: "));
            
            if (numero1 > numero2) {
            System.out.println("O maior número é: " + numero1);
            System.out.println("O menor número é: " + numero2);
        } else if (numero2 > numero1) {
            System.out.println("O maior número é: " + numero2);
            System.out.println("O menor número é: " + numero1);
        } else {
            System.out.println("Os dois números são iguais: " + numero1);
    }
    
}
}

