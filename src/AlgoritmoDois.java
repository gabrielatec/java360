public class AlgoritmoDois {
    void main(){
        //ENTRADA
        
        IO.println("Seja bem vindo ao portal Java 360!");
        String usuario = IO.readln("Qual o seu nome? ");
        IO.println("Olá," + usuario +" ! Bem-vindo ao portal");
        //int estrelas = 0;
        //mais rapido sem métodos

        //Integer.parseInt(valor para conversão)
        //Integer é uma classe (Mais lento, com métodos)
        int estrelas = 0;
        IO.println("Quem criou o Java?");
        IO.println("1 - James Gosling");
        IO.println("2 - Bill Gates");
        IO.println("3 - Steve Jobs");
        IO.println("4 - Mark Zuckerberg");
        int resp = Integer.parseInt(IO.readln("Digite o número:"));
        if(resp ==1){
            IO.println("Parabéns, você acertou!");
            estrelas = estrelas + 1;//variável de incremento
            //estrelas++;
        }else{
            IO.println("Você errou!");
        }

        IO.println("\nVocê obteve " + estrelas + " estrelas." );
    }

}
