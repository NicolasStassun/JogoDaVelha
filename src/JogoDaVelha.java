import java.util.Scanner;

public class JogoDaVelha {

    static Scanner sc = new Scanner(System.in);

    static int jogo[][] = new int[3][3];
    static int VitoriasJogador1 = 0, VitoriasJogador2 = 0;
    static String NomeJogador1, NomeJogador2;

    public static void main(String[] args) {

        for(int i=0;i<3;i++) {

            for (int j = 0; j < 3; j++) {

                jogo[i][j] = 0;

            }

        }


        int escolha =0;

        NomeJogadores();

        do{

            escolha = menu();

            switch (escolha){

                case 1:

                    JogoDaVelha();

                    break;

                case 2:

                    mostraPlacar();

                    break;

                case 3:

                    TrocaNomeJogadores();

                    break;

            }

        }while (escolha!=0);

    }

    public static void NomeJogadores(){

        System.out.println("Informe o nome do Jogador X: ");
        NomeJogador1 = sc.next();
        sc.nextLine();
        System.out.println("Informe o nome do Jogador O: ");
        NomeJogador2 = sc.next();
        sc.nextLine();

    }
    public static int menu(){

        int escolha=0;

        for(int i=0;i<3;i++) {

            for (int j = 0; j < 3; j++) {

                jogo[i][j] = 0;

            }

        }

        System.out.println("Jogo da Velha");
        System.out.println("-------------");
        System.out.println("1 - Jogar");
        System.out.println("2 - Ver placar");
        System.out.println("3 - Trocar Nomes");
        System.out.println("0 - Sair");

        escolha = sc.nextInt();

        return escolha;
    }
    public static void mostraPlacar(){
        System.out.println("----------------====Placar====----------------");
        System.out.println("1° "+NomeJogador1+" ganhou "+VitoriasJogador1);
        System.out.println("2° "+NomeJogador2+" ganhou "+VitoriasJogador2);
        System.out.println("----------------==============----------------");
    }


    public static void JogoDaVelha(){

        int x,y;
        int NumJogadas = 0;
        boolean ganhador = false;
            do {
                if (ganhador == false) {
                    NumJogadas++;
                    System.out.println("Jogador " + NomeJogador1 + " escolha sua jogada");
                    System.out.println("Coluna: ");
                    x = sc.nextInt();
                    System.out.println("Linha: ");
                    y = sc.nextInt();

                    if (jogo[y][x] == 0) {

                        jogo[y][x] = 1;

                    } else {
                        System.out.println("Jogada Inválida");
                        menu();
                    }
                    if (NumJogadas==9){
                        System.out.println("Empate");
                    }
                }
                escreveJogo();
                ganhador = verificacao(ganhador);
                if (ganhador == false) {
                    NumJogadas++;
                    System.out.println("Jogador " + NomeJogador2 + " escolha sua jogada");
                    System.out.println("Coluna: ");
                    x = sc.nextInt();
                    System.out.println("Linha: ");
                    y = sc.nextInt();

                    if (jogo[y][x] == 0) {

                        jogo[y][x] = 2;

                    } else {
                        System.out.println("Jogada Inválida");
                        menu();
                    }
                    if (NumJogadas==9){
                        System.out.println("Empate");
                    }
                }
            escreveJogo();
            ganhador = verificacao(ganhador);
        }while(ganhador != true || NumJogadas!=9);

            menu();


    }
    public  static void escreveJogo(){

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                if(j<2) {
                    if (jogo[i][j] == 1) {

                        System.out.print(" X |");

                    }
                    else if (jogo[i][j] == 2){

                        System.out.print(" O |");

                    }
                    else if(jogo[i][j] == 0){

                        System.out.print(" - |");

                    }
                }
                if(j==2){
                    if (jogo[i][j] == 1) {

                        System.out.println(" X ");

                    }
                    else if (jogo[i][j] == 2){

                        System.out.println(" O ");

                    }
                    else if(jogo[i][j] == 0){

                        System.out.println(" - ");

                    }
                }
            }

        }
    }
    public static boolean verificacao(boolean ganhador){

        // Verificação Diagonal

        if(jogo[0][0]==1 && jogo[1][1]==1 && jogo[2][2]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }
        if(jogo[2][0]==1 && jogo[1][1]==1 && jogo[0][2]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }

        // Verificação Coluna

        if(jogo[0][0]==1 && jogo[0][1]==1 && jogo[0][2]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }
        if(jogo[1][0]==1 && jogo[1][1]==1 && jogo[1][2]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }
        if(jogo[2][0]==1 && jogo[2][1]==1 && jogo[2][2]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }

        // Verificação Linha

        if(jogo[0][0]==1 && jogo[1][0]==1 && jogo[2][0]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }
        if(jogo[0][1]==1 && jogo[1][1]==1 && jogo[2][1]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }
        if(jogo[0][2]==1 && jogo[1][2]==1 && jogo[2][2]==1){

            ganhador = true;
            VitoriasJogador1++;
            System.out.println(NomeJogador1+" Ganhou");

        }

        //Verificação do Jogador 2

        if(jogo[0][0]==2 && jogo[1][1]==2 && jogo[2][2]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        if(jogo[2][0]==2 && jogo[1][1]==2 && jogo[0][2]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        if(jogo[0][0]==2 && jogo[0][1]==2 && jogo[0][2]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        if(jogo[1][0]==2 && jogo[1][1]==2 && jogo[1][2]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        if(jogo[2][0]==2 && jogo[2][1]==2 && jogo[2][2]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        // Verificação Linha

        if(jogo[0][0]==2 && jogo[1][0]==2 && jogo[2][0]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        if(jogo[0][1]==2 && jogo[1][1]==2 && jogo[2][1]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        if(jogo[0][2]==2 && jogo[1][2]==2 && jogo[2][2]==2){

            ganhador = true;
            VitoriasJogador2++;
            System.out.println(NomeJogador2+" Ganhou");

        }
        return ganhador;
    }
    public static void TrocaNomeJogadores() {

        int troca1,troca2;

        System.out.println("Deseja Trocar o Jogador 1?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        troca1 = sc.nextInt();

        if(troca1==1) {

            System.out.println("Informe o nome do Jogador X: ");
            NomeJogador1 = sc.next();
            sc.nextLine();
            VitoriasJogador1 = 0;
        }
        System.out.println("Deseja Trocar o Jogador 2?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        troca2 = sc.nextInt();

        if (troca2==1) {
            System.out.println("Informe o nome do Jogador O: ");
            NomeJogador2 = sc.next();
            sc.nextLine();
            VitoriasJogador2 = 0;
        }
    }

}
