public class Algoritmo48 {
    
    //Considere a matriz quadrada
    /*
        20,50,80
        45,60,90
        45,67,89

    */
    //faça um algoritmo que mostre apenas os valores
    //da diagonal principal.
    public void main(){

        double[][] notas = {
            {20,50,80},
            {45,60,90},
            {45,67,89}
        };
        IO.println("Valores da diagonal principal:");
        for(int i=0; i<notas.length; i++){
            IO.println(notas[i][i]);
        }
           
    }
    
}
