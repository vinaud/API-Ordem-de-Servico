# API Ordem de Servico

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

# Descrição

A API Ordem de Serviço é um rojeto que foi desenvolvido durante o Curso de Spring REST da Algaworks. Consiste em um sistema implementado em Java com Spring Boot.
O sistema fornece uma API que permite o cadastro e consulta de usuários, onde cada usuário pode ter ordens de serviço cadastradas em seu nome.
Além disso é possível cadastrar comentários para cada ordem de serviço disponível no sistema.

# Endpoints

## Clientes

### Cadastro de clientes

`POST localhost:8080/clientes/`

Envia um JSON com as informações do cliente a ser cadastrado:

```javascript
{
	"nome": "Kozuki Oden",
	"email": "oden@gmail.com",
	"telefone": "88 90987644"
}

```
