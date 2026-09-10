public class AlgoritmoDezAL {
    void main(){
    //Entrar com dois numeros reais e imprimir a media aritmética com a mensagem media antes do resultado

        float nt1 = Float.parseFloat(IO.readln("Digite a primeira nota: "));
        float nt2 = Float.parseFloat(IO.readln("Digite a segunda nota: "));
        float media = (nt1 + nt2)/2;
        System.out.printf("a media das notas: %.2f ", media );
            
    }
    
}
