# Sistema de Controle de Reservas de Hotel ☕

## 📝 Sobre o Projeto

Este repositório contém um sistema de **Controle de Reservas de Hotel** desenvolvido em Java. O projeto simula o núcleo operacional de um sistema hoteleiro real, gerenciando acomodações, hóspedes e o ciclo de vida completo de uma reserva.

O objetivo principal é aplicar boas práticas de orientação a objetos para resolver problemas clássicos de negócio, como o controle rigoroso de disponibilidade de quartos, cálculos de diárias e a prevenção de sobreposição de datas (overbooking).

## 💡 Principais Conceitos Abordados

* **Modelagem de Domínio:** Estruturação de classes essenciais para o contexto hoteleiro, como `Reserva`, `Quarto` e `Hospede`, definindo claramente as responsabilidades de cada entidade.
* **Manipulação de Datas (`java.time`):** Uso intensivo de `LocalDate` para calcular a duração da estadia, calcular valores totais com base na quantidade de diárias e verificar a validade dos períodos informados.
* **Validação de Regras de Negócio:** Algoritmos para iterar sobre reservas existentes e garantir que um mesmo quarto não seja agendado para dois clientes em períodos que se cruzam.
* **Tratamento de Exceções Customizadas:** Lançamento de exceções específicas do domínio (ex: `QuartoIndisponivelException` ou datas inválidas onde o check-out é anterior ao check-in), garantindo a integridade do sistema.

## 🛠️ Tecnologias Utilizadas

* Java (versão 17 ou superior recomendada)
* Maven (gerenciador de dependências e build)

---

## 🚀 Como Executar o Projeto

Você pode rodar este sistema e testar a criação de reservas tanto diretamente pelo terminal quanto utilizando a sua IDE de preferência.

### 📋 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* **Java JDK** (versão 17 ou superior) configurado nas variáveis de ambiente (`JAVA_HOME`).
* **Apache Maven** instalado (ou utilize o Maven Wrapper `./mvnw` se incluso no projeto).

### 💻 Opção 1: Executando pelo Terminal (Sem IDE)

Para compilar o código e interagir com o sistema de reservas via linha de comando:

1. **Clone o repositório:**
```bash
git clone https://github.com/joaoalbertorsc/controle-reservas-de-hotel.git
cd controle-reservas-de-hotel

```


2. **Compile o projeto:**
Execute o Maven para garantir o download das dependências e a compilação do código:
```bash
mvn clean compile

```


3. **Execute a aplicação:**
* Caso o plugin do Maven esteja devidamente configurado no `pom.xml`:
```bash
mvn exec:java

```


* Caso prefira rodar informando o caminho completo da classe principal (substitua pelo pacote correto da sua classe `Main`):
```bash
mvn exec:java -Dexec.mainClass="com.seuprojeto.Main"

```




4. **Execute os Testes Unitários:**
Para validar os cenários de sucesso e as tentativas de fraude/overbooking através de testes automatizados:
```bash
mvn test

```



### 🖥️ Opção 2: Executando via IDE (IntelliJ IDEA, Eclipse, VS Code)

Para uma experiência visual completa e facilitar testes com diferentes cenários de datas:

1. **Importar o Projeto:**
* Abra a sua IDE.
* Vá em **Open** ou **Import Project**.
* Navegue até a pasta clonada e selecione o arquivo `pom.xml`.


2. **Executar:**
* Encontre a classe de ponto de entrada do sistema (geralmente `Main` ou `Application` dentro da pasta `src/main/java`).
* Clique com o botão direito sobre ela e selecione **Run**.


3. **Explorar as Validações:**
* Tente instanciar uma reserva para um quarto em uma data que já está ocupada para observar como o sistema lança e captura a exceção, impedindo a sobreposição.



---

## 👨‍💻 Autor

**João Alberto** – Engenheiro de Software

---

*Se este projeto te ajudou a entender melhor a modelagem de regras de negócio e manipulação de datas no Java, deixe uma ⭐ no repositório!*
