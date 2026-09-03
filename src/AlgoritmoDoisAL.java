public class AlgoritmoDoisAL {
    void main(){
        IO.println("Quem ousa entrar na Sala do Eco?");
        String nome = IO.readln("Gabriela");
        IO.println(" Ah aluna " + nome + ". Eu esperava por você! ");
        IO.println("Quantos algoritmos você venceu?");
        String resposta = IO.readln("200");
        int total = Integer.parseInt("200");
        IO.println("Só mais " + (360 - total) + " pela frente. ");
    }
}
