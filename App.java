package aplicativos;
import java.io.IOException;
import java.util.Scanner;
import aplicativos.Registro.Pessoa;
import aplicativos.Registro.Piloto;
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);     
        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = in.nextInt();
            in.nextLine();
            if (opcao == 1) {
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                    else{                 
                    Piloto piloto = new Piloto();
                    System.out.println("\nDigite o nome do piloto: ");
                    piloto.setNome(in.nextLine());
                    System.out.println("\nE o cpf: ");
                    piloto.setCpf(in.nextLine());
                    System.out.println("\nAgora, digite o breve do piloto: ");
                    piloto.setBreve(in.nextLine());
                    System.out.println("\nNúmero da matricula: ");
                    piloto.setMatricula(in.nextInt());
                    in.nextLine();    
                    pilotos[qtdCadastrados] = piloto;
                    qtdCadastrados++;                              
                }
                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {
               
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }               
                for(int i = 0; i < qtdCadastrados; i++){

                    System.out.println("\nPiloto:");
                    System.out.println(pilotos[i].getNome());               
                }              
                voltarMenu(in);
            } else if (opcao == 3) {
                String c;
                System.out.println("\nDigite o CPF: ");
                c = in.nextLine();

                for (int i = 0; i < qtdCadastrados; i++){
                    if(c.equals(pilotos[i].getCpf())){
                        System.out.println("\nO Cpf pertence à:");
                        System.out.println("\nPiloto: " + pilotos[i].getNome());
                    } 
                    if(c.equals(pilotos[i].getCpf()) == false){
                        System.out.println("\nPiloto não encontrado, tente novamente.");
                    }
                }
                voltarMenu(in);

            } else if (opcao == 4) {
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);
        System.out.println("\nFim do programa!");
        in.close();
    }
    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
