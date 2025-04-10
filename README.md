# JogoBatalhaNaval

## Descrição

O programa **JogoBatalhaNaval** é uma implementação de um jogo de batalha naval em Java. O jogador tenta adivinhar as posições dos navios em um tabuleiro de 8x8, atacando coordenadas específicas. O objetivo é destruir todos os 10 navios posicionados aleatoriamente no tabuleiro dentro de um limite de 30 jogadas.

## Funcionalidades

1. **Inicialização do Tabuleiro**: Preenche os tabuleiros com água (`~`) e posiciona os navios (`N`) aleatoriamente.
2. **Interação com o Jogador**: Solicita coordenadas de ataque e verifica acertos (`X`) e erros (`O`).
3. **Fim do Jogo**: Exibe o tabuleiro final e informa se o jogador venceu ou perdeu.

## Estrutura do Código

### Classe `JogoBatalhaNaval`

- **Construtor**:
  - `JogoBatalhaNaval()`: Inicializa os tabuleiros, gerencia a interação com o jogador e determina o fim do jogo.

- **Métodos**:
  - `inicializacaoTabuleiro(String[][] tabuleiro, String[][] tabuleiroJogador)`: Preenche os tabuleiros com água e posiciona os navios aleatoriamente.
  - `interacaoJogador(String[][] tabuleiro, String[][] tabuleiroJogador, Scanner in)`: Lê as coordenadas do jogador, processa os ataques e atualiza o tabuleiro do jogador.
  - `fimDoJogo(String[][] tabuleiro, String[][] tabuleiroJogador, int naviosDestruidos)`: Exibe o tabuleiro final e informa o resultado do jogo.

### Método `main`

O método `main` cria uma nova instância da classe `JogoBatalhaNaval`, iniciando o jogo.

## Detalhes dos Métodos

### `inicializacaoTabuleiro`

- **Parâmetros**:
  - `tabuleiro`: Matriz representando o tabuleiro real com navios.
  - `tabuleiroJogador`: Matriz representando o tabuleiro que o jogador vê.
- **Descrição**: Preenche ambos os tabuleiros com água (`~`). Posiciona 10 navios (`N`) aleatoriamente no tabuleiro real.

### `interacaoJogador`

- **Parâmetros**:
  - `tabuleiro`: Matriz representando o tabuleiro real com navios.
  - `tabuleiroJogador`: Matriz representando o tabuleiro que o jogador vê.
  - `in`: Scanner para ler a entrada do jogador.
- **Descrição**: Solicita coordenadas de ataque, verifica acertos e erros, e atualiza o tabuleiro do jogador. Limita o jogador a 30 jogadas e encerra se todos os navios forem destruídos.
- **Retorno**: Número de navios destruídos pelo jogador.

### `fimDoJogo`

- **Parâmetros**:
  - `tabuleiro`: Matriz representando o tabuleiro real com navios.
  - `tabuleiroJogador`: Matriz representando o tabuleiro que o jogador vê.
  - `naviosDestruidos`: Número de navios destruídos pelo jogador.
- **Descrição**: Exibe o tabuleiro final e informa se o jogador venceu (destruiu todos os navios) ou perdeu.

## Como Executar

1. Certifique-se de ter o JDK instalado em sua máquina.
2. Compile o programa com o comando:
   ```sh
   javac TrabalhoFinal/JogoBatalhaNaval.java
   ```
3. Execute o programa com o comando:
   ```sh
   java TrabalhoFinal.JogoBatalhaNaval
   ```

## Exemplo de Uso

Ao executar o programa, o usuário verá uma solicitação para inserir coordenadas de ataque. O programa responderá com o resultado do ataque (`X` para acerto, `O` para erro) e atualizará o tabuleiro visível ao jogador. O jogo continuará até que todos os navios sejam destruídos ou o jogador use todas as 30 jogadas.

---
