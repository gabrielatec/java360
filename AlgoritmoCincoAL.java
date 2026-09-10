public class AlgoritmoCincoAL {
    void main(){
        //Número inteiro, imprimir seu sucessor e seu antecessor
    int numero = Integer.parseInt(IO.readln("Digite o número inteiro: "));
             
              
    int antecessor = numero - 1;
    int sucessor = numero + 1;
        
    System.out.println("O antecessor é: " + antecessor);
    System.out.println("O sucessor é: " + sucessor);
        
    }
}
