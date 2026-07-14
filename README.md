# Controle de Reservas de Hotel

Sistema de console em Java para gerenciamento de reservas de hotel, desenvolvido como projeto de estudo de POO.

## Funcionalidades

- Cadastrar nova reserva (hóspede, tipo de quarto, dias e valor da diária)
- Listar todas as reservas
- Buscar reservas por nome do hóspede
- Ordenar reservas por número de dias (decrescente)
- Cálculo automático do valor total da reserva

## Tecnologias

- Java 21
- Maven

## Estrutura

- `Main` – ponto de entrada da aplicação
- `Menu` – interface de terminal (entrada/saída do usuário)
- `Hotel` – armazena e gerencia as reservas (capacidade máxima de 10)
- `Reserva` – modelo de dados de uma reserva

## Como executar

```bash
mvn compile
mvn exec:java -Dexec.mainClass="Main"
```

Ou compile e rode diretamente:

```bash
javac -d target src/main/java/*.java
java -cp target Main
```
