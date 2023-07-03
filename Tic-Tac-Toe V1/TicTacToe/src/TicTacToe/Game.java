package TicTacToe;
import java.util.Scanner;
import java.lang.String;
public class Game {
	String [][] tabuleiro = new String [3][3];
	
	int jogador;
		
	public void game() {
		Scanner scanner = new Scanner(System.in);
		
		int jogadaLinha = 0;
		int jogadaColuna = 0;
		int validador = 0;
		boolean jogoTerminado = false;	
		
		//Monta o tabuleiro
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				tabuleiro[i][j] = " ";
			}
		}
	
		while(jogoTerminado == false) {
			mostraTabuleiro();
			for (int y=1; y<=2; y++) {
				validador = 0;	
				while(validador < 1) {
					if(y%2 != 0) {
						System.out.println("\nJogador 1 (X)");
						System.out.print("Linha: ");
						jogadaLinha = scanner.nextInt();
						scanner.nextLine();
						
						if(jogadaLinha == 1) {
							jogadaLinha = 0;
						}
						else if(jogadaLinha == 2) {
							jogadaLinha = 1;
						}
						else if(jogadaLinha == 3) {
							jogadaLinha = 2;
						}
						
						System.out.print("Coluna: ");
						jogadaColuna = scanner.nextInt();
						scanner.nextLine();
						
						if(jogadaColuna == 1) {
							jogadaColuna = 0;
						}
						else if(jogadaColuna == 2) {
							jogadaColuna = 1;
						}
						else if(jogadaColuna == 3) {
							jogadaColuna = 2;
						}
							
						if(tabuleiro[jogadaLinha][jogadaColuna] != " ") {
							System.out.println("\nJogada invalida!");
							validador = 0;
						}else {
							tabuleiro[jogadaLinha][jogadaColuna] = "X";
							validador = 1;
						}
						
						if(verificarVitoria("X")) {
							mostraTabuleiro();
							System.out.println("jogado 1 venceu (X)");
							jogoTerminado = true;
							break;
						}
						mostraTabuleiro();
					}
					
					else if(y%2 == 0) {
						System.out.println("\nJogador 2 (O)");
						System.out.print("Linha: ");
						jogadaLinha = scanner.nextInt();
						scanner.nextLine();
						
						if(jogadaLinha == 1) {
							jogadaLinha = 0;
						}
						else if(jogadaLinha == 2) {
							jogadaLinha = 1;
						}
						else if(jogadaLinha == 3) {
							jogadaLinha = 2;
						}
						
						System.out.print("Coluna: ");
						jogadaColuna = scanner.nextInt();
						scanner.nextLine();
						
						if(jogadaColuna == 1) {
							jogadaColuna = 0;
						}
						else if(jogadaColuna == 2) {
							jogadaColuna = 1;
						}
						else if(jogadaColuna == 3) {
							jogadaColuna = 2;
						}
						
						if(tabuleiro[jogadaLinha][jogadaColuna] != " ") {
							System.out.println("\nJogada invalida!");
							validador = 0;
						}else {
							tabuleiro[jogadaLinha][jogadaColuna] = "O";
							validador = 1;
						}
						
						if(verificarVitoria("O")) {
							mostraTabuleiro();
							System.out.println("jogado 2 venceu (O)");
							jogoTerminado = true;
							break;
						}
					}
				}
			}
		}
	}
	public void mostraTabuleiro() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("[%s]", tabuleiro[i][j]);
				if(j == 2) {
						System.out.println("");
				}
			}
		}
	}
	private boolean verificarVitoria(String jogador) {
        // Verificar linhas horizontais
        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][0] == jogador &&
                tabuleiro[linha][1] == jogador &&
                tabuleiro[linha][2] == jogador) {
                return true;
            }
        }

        // Verificar colunas verticais
        for (int coluna = 0; coluna < 3; coluna++) {
            if (tabuleiro[0][coluna] == jogador &&
                tabuleiro[1][coluna] == jogador &&
                tabuleiro[2][coluna] == jogador) {
                return true;
            }
        }

        // Verificar diagonal principal
        if (tabuleiro[0][0] == jogador &&
            tabuleiro[1][1] == jogador &&
            tabuleiro[2][2] == jogador) {
            return true;
        }

        // Verificar diagonal secundária
        if (tabuleiro[0][2] == jogador &&
            tabuleiro[1][1] == jogador &&
            tabuleiro[2][0] == jogador) {
            return true;
        }

        return false;
    }

	
	public String vencedor(String jogador) {
		String Jogador = jogador;
		
		return Jogador;
	}

	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.game();
	}
}
