public class Algoritmo47 {
    // faça um vetor que armazene 10 valores inteiros
    // IO.println() IO.readln()
    // imprima a média so valores.

    public void main() {
        
        int[] notas = new int[10];
        double soma =0;
        for(int i=0; i<notas.length; i++){

            int nota = Integer.parseInt(IO.readln("Digite o número:"));
            soma += nota;
            notas[i] = nota;
            
        }
        IO.println("soma: "+soma);
        double media;
        media = soma/10;
        IO.println("media: "+media);                        
    }

}