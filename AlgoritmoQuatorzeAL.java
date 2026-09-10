public class AlgoritmoQuatorzeAL {
    public void main(){
    
        System.out.println("\nEscolha uma opcao: ");
        System.out.println("\n1 - Iniciar o jogo ");
        System.out.println("\n2 - Vidas acabando ");
        System.out.println("\n3 - Sair / Game Over");

        int opcao= Integer.parseInt(IO.readln("\nComece o jogo: "));
                
        switch (opcao) {
            case 1:
                System.out.println("Jogo iniciado");
                break;
            case 2:
                System.out.println("Suas vidas estão acabando");
                break;
            case 3:
                System.out.println("Game Over!");
                break;
            default:
                System.out.println("Número inválido");
                break;
        }
    }
}