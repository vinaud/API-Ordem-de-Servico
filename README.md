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

Envia no body um JSON com as informações do cliente a ser cadastrado:

```javascript
{
	"nome": "Kozuki Oden",
	"email": "oden@gmail.com",
	"telefone": "88 90987644"
}

```
Se o email informado já tiver sido usado recebe como resposta:

```javascript
{
    "status": 400,
    "dataHora": "2020-04-25T17:26:44.796-03:00",
    "titulo": "Já existe um usuário cadastrado com esse e-mail"
}

```

Se o cadastro for concluido com sucesso recebe a seguinte resposta:

```javascript
{
    "id": 3,
    "nome": "Kozuki Oden3",
    "telefone": "88 90987644",
    "email": "oden@gmail.com"
}

```


### Listagem de clientes

`GET localhost:8080/clientes/`

Recebe um JSON com a listagem dos clientes cadastrados:

```javascript
[
    {
        "id": 1,
        "nome": "Trafalgar D. Water Law",
        "telefone": "11 987654321",
        "email": "trao@gmail.com"
    },
    {
        "id": 2,
        "nome": "Jinbei",
        "telefone": "99 98765443",
        "email": "jinbei@gmail.com"
    },
    {
        "id": 3,
        "nome": "Lord Kozuki Oden",
        "telefone": "88 954545454",
        "email": "oden@gmail.com"
    }
]

```

### Busca de cliente

`GET localhost:8080/clientes/{id do cliente}`
Passa como paramêtro da chamada o id do cliente a ser buscado. Recebe um JSON na resposta caso o cliente do respectivo id seja encontrado:

```javascript
{
    "id": 1,
    "nome": "Trafalgar D. Water Law",
    "telefone": "11 987654321",
    "email": "trao@gmail.com"
}

```

Caso não haja um cliente com id passado, receberá como resposta o status 404 - Not Found


## Ordens de serviço

## Comentários
