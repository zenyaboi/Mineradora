# Sistema de Mineração com Máquina de Estados

Este projeto implementa um sistema de simulação de mineração usando o padrão de design **State Machine** (Máquina de Estados) em Java. O sistema simula a interação entre um Minerador e um Vendedor, cada um com seus próprios estados e comportamentos.

## Requisitos

- **JDK 18** ou superior
- IntelliJ IDEA (recomendado) ou qualquer IDE Java

### Instalando o JDK 18

Se você ainda não tem o JDK 18 instalado:

1. **Download**:
   - Acesse [Oracle JDK 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html) ou [OpenJDK 18](https://jdk.java.net/18/)
   - **Caso usar o IntelliJ IDEA, o IDE consegue baixar por conta própria. Um aviso aparecerá que é necessário baixar, só apertar no texto que ele já abre uma janela para a instalação.**

2. **Instalação**:
   - Execute o instalador baixado
   - Siga as instruções do assistente de instalação

3. **Verificar Instalação**:
   ```bash
   java -version
   ```
   Deve exibir algo como: `java version "18.0.x"`


## Como Compilar e Executar

### Usando IntelliJ IDEA (Recomendado)

1. **Abrir o Projeto**:
   - Abra o IntelliJ IDEA
   - Clique em `File` → `Open` e selecione a pasta do projeto

2. **Configurar o Projeto** (se necessário):
   - O IntelliJ detectará automaticamente os arquivos `.java`
   - Certifique-se de que o JDK está configurado (`File` → `Project Structure` → `Project`)

3. **Executar**:
   - Abra o arquivo `Main.java`
   - Clique com o botão direito no arquivo ou na classe `Main`
   - Selecione `Run 'Main.main()'`
   - Ou use o atalho: `Shift + F10`

4. **Parar a Execução**:
   - Clique no botão vermelho de "Stop" na aba Run
   - Ou use o atalho: `Ctrl + F2`

O programa entrará em um loop infinito, executando as ações dos agentes a cada 6 segundos. Para interromper, pressione `Ctrl+C`.

## Padrões de Design Utilizados

- **State Pattern**: Cada estado é uma classe separada que implementa o comportamento específico
- **Interface Segregation**: `Estados` e `Personagem` definem contratos claros
- **Generics**: `EstadoAbstrato<T>` permite reutilização de código entre diferentes tipos de personagens

## Configurações

- **Intervalo de atualização**: 6 segundos (configurável em `GerenciadorAgentes.java`)
- **Limites de transição**: Podem ser ajustados diretamente nas classes de estado

## Agentes do Sistema

### 1. **Minerador**
Agente responsável por extrair minérios, gerenciar seu nível de cansaço e entregar os minérios ao vendedor.

**Atributos:**
- `minerio`: Quantidade de minérios coletados
- `cansaco`: Nível de cansaço atual (0-12+)
- `vendedor`: Referência ao vendedor para entregas

**Estados:**
- **Minerar**: Estado inicial e de trabalho
- **Descansar**: Estado de recuperação
- **Entregar**: Estado de entrega de minérios

### 2. **Vendedor**
Agente responsável por receber minérios do minerador e vendê-los.

**Atributos:**
- `minerioEstocado`: Quantidade de minérios em estoque
- `minerioVendido`: Quantidade vendida na última transação

**Estados:**
- **EsperarMinerios**: Estado de espera (inicial)
- **VenderMinerio**: Estado de venda

## Estados e Transições

### Estados do Minerador

#### **Minerar** (Estado Inicial)
- **Ação**: Adiciona 5 minérios e 2 de cansaço
- **Transições**:
  - → **Descansar**: Quando `cansaco > 12`
  - → **Entregar**: Quando `minerio > 20`

#### **Descansar**
- **Ação**: Reduz 4 pontos de cansaço por ciclo
- **Transições**:
  - → **Entregar**: Quando `cansaco ≤ 0` E `minerio > 20`
  - → **Minerar**: Quando `cansaco ≤ 0` E `minerio ≤ 20`

#### **Entregar**
- **Ação**: Transfere até 5 minérios para o vendedor, adiciona 1 de cansaço
- **Transições**:
  - → **Descansar**: Quando `cansaco > 12`
  - → **Minerar**: Quando `minerio ≤ 0`

### Estados do Vendedor

#### **EsperarMinerios** (Estado Inicial)
- **Ação**: Aguarda recebimento de minérios, reseta vendas
- **Transições**:
  - → **VenderMinerio**: Quando `minerioEstocado > 0`

#### **VenderMinerio**
- **Ação**: Vende até 3 minérios por ciclo
- **Transições**:
  - → **EsperarMinerios**: Quando `minerioEstocado ≤ 0`

## Observando as Transições nos Logs

O sistema imprime mensagens detalhadas no console para cada transição de estado:

### Mensagens de Entrada em Estados
```
Minerador foi minerar...
O minerador foi descansar...
Minerador saiu para entregas...
O vendedor agora está aguardando algum minério ser entregue...
Vendedor começou a vender os minérios...
```

### Mensagens de Saída de Estados
```
O minerador descansou, voltando ao trabalho!
Entregas realizadas!
```

### Status dos Agentes
A cada ciclo, o status é impresso:

```
+---- Minerador ----+
Minérios: 15
Cansaço: 8

+---- Vendedor ----+
Minérios vendidos: 3
Minérios no estoque: 7
```
