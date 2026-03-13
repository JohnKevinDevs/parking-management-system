# parking-management-system
# 🚗 Sistema de Gerenciamento de Estacionamento

Aplicação desktop desenvolvida em **Java** para simular o controle e a gestão de acesso de veículos em um estacionamento.

O sistema permite autenticação de usuários, cadastro de visitantes, controle de entrada e saída de veículos e gerenciamento dos registros do estacionamento.

O projeto foi desenvolvido aplicando conceitos importantes de **Programação Orientada a Objetos**, **integração com banco de dados** e **arquitetura de software**, utilizando os padrões **MVC** e **DAO** para melhor organização e manutenção do código.

---

# 🛠️ Tecnologias Utilizadas

- **Java SE**
- **Java Swing** (Interface gráfica)
- **MySQL** (Banco de dados relacional)
- **JDBC** (Conectividade com banco de dados)
- **MVC (Model–View–Controller)**
- **DAO (Data Access Object)**
- **NetBeans** (IDE utilizada no desenvolvimento)

---

# ⚙️ Funcionalidades do Sistema

O sistema possui as seguintes funcionalidades:

- Autenticação de usuários (login)
- Cadastro e gerenciamento de visitantes
- Controle de entrada e saída de veículos
- Visualização e manutenção de registros
- Exportação de dados em formato **CSV**
- Manipulação e armazenamento de **imagens** (veículos e usuários)
- **Splash Screen** na inicialização do sistema

---

# 🗂️ Estrutura do Projeto

A organização do projeto segue a separação por responsabilidades:

src/

model/
Classes responsáveis por representar os dados do sistema.

controller/
Responsável pela lógica da aplicação e controle de fluxo.

dao/
Classes responsáveis pelo acesso ao banco de dados (CRUD).

view/
Interfaces gráficas desenvolvidas utilizando Java Swing.

imagem/
Recursos visuais utilizados pelo sistema.


---

# 🧩 Arquitetura Utilizada

O projeto foi estruturado utilizando dois padrões principais:

## MVC (Model – View – Controller)

Separação das responsabilidades da aplicação:

- **Model** → Representação dos dados e regras do sistema  
- **View** → Interface gráfica do usuário  
- **Controller** → Responsável por controlar a interação entre as camadas  

## DAO (Data Access Object)

Responsável por isolar a lógica de acesso ao banco de dados da lógica da aplicação.

### Benefícios dessa arquitetura

✔ Melhor organização do código  
✔ Separação clara de responsabilidades  
✔ Facilidade de manutenção  
✔ Maior escalabilidade do sistema  

---

# ▶️ Como Executar o Projeto

1. Instale e configure o **MySQL** em sua máquina  
2. Crie o banco de dados conforme os scripts fornecidos  
3. Importe o projeto em sua IDE (**NetBeans ou similar**)  
4. Configure a conexão com o banco de dados no arquivo:

Conecta_DB.java


5. Compile e execute o projeto.

---

# 🗄 Banco de Dados

O sistema utiliza **MySQL** para armazenar informações como:

- usuários do sistema
- visitantes cadastrados
- veículos registrados
- histórico de entrada e saída

A comunicação entre aplicação e banco de dados é realizada através da API **JDBC**.

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com fins educacionais, com o objetivo de praticar:

- Programação Orientada a Objetos (POO)
- Arquitetura MVC
- Integração de aplicações Java com banco de dados
- Organização de código em camadas
- Persistência de dados utilizando JDBC
- Desenvolvimento de interfaces gráficas com Swing

---

# 🚀 Possíveis Melhorias Futuras

- Migração para **Spring Boot (API REST)**
- Implementação de uma camada **Service**
- Melhor organização de pacotes
- Implementação de **testes automatizados**
- Modernização da interface gráfica

---

# 👨‍💻 Autor

**John Kevin**

Estudante de e Técnico em Informática, com foco em desenvolvimento **Java Backend e arquitetura de software**.

GitHub:  
https://github.com/JohnKevinDevs
