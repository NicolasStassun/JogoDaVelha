import java.util.Scanner;
import javax.swing.JOptionPane;

public class JogoDaVelha {

    static Scanner sc = new Scanner(System.in);

    static char jogo[][] = new char[3][3];
    static int VitoriasJogador1 = 0, VitoriasJogador2 = 0;
    static String NomeJogador1, NomeJogador2;

    public static void main(String[] args) {

        for(int i=0;i<3;i++) {

            for (int j = 0; j < 3; j++) {

                jogo[i][j] = '-';

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

       NomeJogador1 = JOptionPane.showInputDialog("Informe o nome do Jogador X: ");
       NomeJogador2 = JOptionPane.showInputDialog("Informe o nome do Jogador O: ");


    }
    public static int menu(){

        int escolha=0;

        for(int i=0;i<3;i++) {

            for (int j = 0; j < 3; j++) {

                jogo[i][j] = '-';

            }

        }



        escolha = Integer.parseInt(JOptionPane.showInputDialog("Jogo da Velha \n" +
                "--------------\n" +
                "1 - Jogar \n" +
                "2 - Mostra Placar \n" +
                "3 - Troca de Nome \n" +
                "0 - Sair."));


        return escolha;
    }
    public static void mostraPlacar(){
        JOptionPane.showMessageDialog(null,"----------------====Placar====---------------- \n "+
                "1° "+NomeJogador1+" ganhou "+VitoriasJogador1+"\n"+
                "2° "+NomeJogador2+" ganhou "+VitoriasJogador2+"\n"+
                "----------------==============----------------\n");
    }


    public static void JogoDaVelha(){

        int x = 0;
        int y =0;
        boolean teste1 = true;
        boolean teste2 = true;
        boolean ganhador = false;
        int Jogadas = 0;
        int jogador = 0;
        while(Jogadas!=9 || ganhador == false){

            if (ganhador == false){

                if(jogador == 0 & teste2 == true & ganhador == false){

                    x = Integer.parseInt(JOptionPane.showInputDialog(NomeJogador1+" Escolha a Coluna "));
                    y = Integer.parseInt(JOptionPane.showInputDialog(NomeJogador1+" Escolha a Linha "));

                    if(jogo[y][x]=='-'& x<=2 & y<=2 & x>=0 & y>=0){
                        jogo[y][x] = 'X';
                        teste1 = true;
                        Jogadas++;
                        ganhador = verificacao(ganhador);
                        jogador = 1;
                        System.out.println("\n");
                        escreveJogo();
                        System.out.println("\n");
                    }
                    else if(jogo[y][x]!='-' || x>2 || y>2 || x<0 || y<0){
                        JOptionPane.showMessageDialog(null,"Jogada Inválida de "+NomeJogador1);
                        teste1 = false;
                        Jogadas--;
                    }
                }
                if (Jogadas==9){
                    JOptionPane.showMessageDialog(null,"Empate");
                    menu();
                }
                if(jogador == 1 & teste1==true & ganhador == false & Jogadas!=9){

                    x = Integer.parseInt(JOptionPane.showInputDialog(NomeJogador2+" Escolha a Coluna "));
                    y = Integer.parseInt(JOptionPane.showInputDialog(NomeJogador2+" Escolha a Linha "));

                    if(jogo[y][x]=='-' & x<=2 & y<=2 & x>=0 & y>=0){
                        jogo[y][x] = 'O';
                        teste2 = true;
                        Jogadas++;
                        ganhador = verificacao(ganhador);
                        jogador = 0;
                        System.out.println("\n");
                        escreveJogo();
                        System.out.println("\n");
                    }
                    else if(jogo[y][x]!='-' || x>2 || y>2 || x<0 || y<0){
                        JOptionPane.showMessageDialog(null,"Jogada Inválida de "+NomeJogador2);
                        teste2 = false;
                        Jogadas--;
                    }
                }

            }

        }



    }
    public  static void escreveJogo(){

        JOptionPane.showMessageDialog(null, jogo[0][0] +"  |  " +jogo[0][1] +"  |  " +jogo[0][2] +"\n------------\n" +jogo[1][0] +"  |  " +jogo[1][1] +"  |  " +jogo[1][2] +"\n------------\n" +jogo[2][0] +"  |  " +jogo[2][1] +"  |  " +jogo[2][2]);

    }
    public static boolean verificacao(boolean ganhador){

        // Verificação Diagonal

        if(jogo[0][0]=='X' && jogo[1][1]=='X' && jogo[2][2]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }
        if(jogo[2][0]=='X' && jogo[1][1]=='X' && jogo[0][2]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }

        // Verificação Coluna

        if(jogo[0][0]=='X' && jogo[0][1]=='X' && jogo[0][2]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }
        if(jogo[1][0]=='X' && jogo[1][1]=='X' && jogo[1][2]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }
        if(jogo[2][0]=='X' && jogo[2][1]=='X' && jogo[2][2]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }

        // Verificação Linha

        if(jogo[0][0]=='X' && jogo[1][0]=='X' && jogo[2][0]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }
        if(jogo[0][1]=='X' && jogo[1][1]=='X' && jogo[2][1]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }
        if(jogo[0][2]=='X' && jogo[1][2]=='X' && jogo[2][2]=='X'){

            ganhador = true;
            VitoriasJogador1++;
            JOptionPane.showMessageDialog(null,NomeJogador1+" Ganhou");

        }

        //Verificação do Jogador 2

        if(jogo[0][0]=='O' && jogo[1][1]=='O' && jogo[2][2]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        if(jogo[2][0]=='O' && jogo[1][1]=='O' && jogo[0][2]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        if(jogo[0][0]=='O' && jogo[0][1]=='O' && jogo[0][2]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        if(jogo[1][0]=='O' && jogo[1][1]=='O' && jogo[1][2]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        if(jogo[2][0]=='O' && jogo[2][1]=='O' && jogo[2][2]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        // Verificação Linha

        if(jogo[0][0]=='O' && jogo[1][0]=='O' && jogo[2][0]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        if(jogo[0][1]=='O' && jogo[1][1]=='O' && jogo[2][1]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        if(jogo[0][2]=='O' && jogo[1][2]=='O' && jogo[2][2]=='O'){

            ganhador = true;
            VitoriasJogador2++;
            JOptionPane.showMessageDialog(null,NomeJogador2+" Ganhou");

        }
        return ganhador;
    }
    public static void TrocaNomeJogadores() {

        int troca1,troca2;

        troca1 = Integer.parseInt(JOptionPane.showInputDialog("Deseja troca o Jogador 1?\n" +
                "1 - Sim\n" +
                "2 - Não\n"));

        if(troca1==1) {

            NomeJogador1 = JOptionPane.showInputDialog("Informe o nome do Jogador X: ");
            VitoriasJogador1 = 0;
        }
        troca2 = Integer.parseInt(JOptionPane.showInputDialog("Deseja troca o Jogador 2?\n" +
                "1 - Sim\n" +
                "2 - Não\n"));

        if (troca2==1) {
            NomeJogador2 = JOptionPane.showInputDialog("Informe o nome do Jogador O: ");
            VitoriasJogador2 = 0;
        }
    }

}
