## Micronaut 4.7.0 Documentation

- [User Guide](https://docs.micronaut.io/4.7.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.7.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.7.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Maven Plugin documentation](https://micronaut-projects.github.io/micronaut-maven-plugin/latest/)
## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature maven-enforcer-plugin documentation

- [https://maven.apache.org/enforcer/maven-enforcer-plugin/](https://maven.apache.org/enforcer/maven-enforcer-plugin/)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)

# Banco Online - Projeto Acadêmico

Este projeto simula um sistema de banco digital desenvolvido em **Java** com o framework **Micronaut**, como parte de um trabalho acadêmico. Ele oferece funcionalidades bancárias básicas, como criação de contas, consultas de saldo, transferências e histórico de transações. O objetivo é aplicar conhecimentos em Java, APIs REST, persistência de dados e boas práticas de desenvolvimento.

---

## Funcionalidades Principais

- **Criar Conta**: Permite ao usuário cadastrar uma nova conta bancária.
- **Consultar Saldo**: Permite visualizar o saldo atual de uma conta.
- **Transferências**: Facilita a realização de transferências entre contas registradas no sistema.
- **Histórico de Transações**: Exibe o histórico de todas as transações da conta, incluindo depósitos, saques e transferências.

---

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Micronaut**: Framework leve para criação de microserviços, conhecido por sua inicialização rápida, baixo uso de memória e fácil integração com Java.
- **Banco de Dados (H2/MySQL)**: Utilizado para persistência de dados, configurado para uso com H2 (em memória) durante o desenvolvimento e com MySQL em produção.
- **Maven**: Ferramenta de build usada para gerenciar dependências e compilar o projeto.

---

## Arquitetura do Projeto

O projeto foi estruturado em camadas para facilitar a manutenção e separação de responsabilidades:

- **Controller**: Define os endpoints da API REST que permitem interagir com as funcionalidades do banco.
- **Service**: Contém a lógica de negócios, como regras de transações, validações e operações bancárias.
- **Repository**: Responsável pela persistência e recuperação de dados no banco de dados.

---

## Pré-requisitos

Para executar o projeto, você precisará de:

- **Java 11** ou superior
- **Micronaut CLI** (opcional, para comandos adicionais do Micronaut)
- **Maven** (para compilar e executar o projeto)
- **MySQL** (se desejar usar um banco de dados externo; configure as credenciais no arquivo `application.yml`)

---

## Instruções de Instalação e Execução

### 1. Clone o Repositório

```bash
git clone https://github.com/nunes262/qbank_faculdade
cd Qbank


