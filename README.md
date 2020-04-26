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

### Atualização de cliente

`PUT localhost:8080/clientes/{id do cliente}`

Passa como paramêtro da chamada o id do cliente a ser atualizado. Envia um JSON com as informações a serem atualizadas do cliente:

```javascript
{
    "nome": "Lord Kozuki Oden",
    "email": "odennew@gmail.com",
    "telefone": "88 954545454"
}

```
Recebe um JSON com os dados atualizados na resposta caso o cliente do respectivo id seja encontrado:

```javascript
{
    "id": 9,
    "nome": "Lord Kozuki Oden",
    "telefone": "88 954545454",
    "email": "odennew@gmail.com"
}
```
Caso o cliente não exista, recebe um status 404 - Not Found como resposta.

### Deletar Cliente

`DELETE localhost:8080/clientes/{id do cliente}`

Passa como paramêtro da chamada o id do cliente a ser removiddo do sistema.

Recebe um status 204 - No Content caso a operação seja um sucesso.

Recebe um status 404 - Not Found caso o usuário já não exista


## Ordens de Serviço

### Cadastro de ordem de serviço

`POST localhost:8080/ordens-servico`

Envia um JSON com as informações da ordem de serviço a ser cadastrada, assim como o id do cliente associado a ela:

```javascript
{
	"cliente":{
		"id": 2
	},
	"descricao": "Reparo de Notebook Dell 87876 ",
	"preco": 350.50
}
```

Recebe como resposta um JSON com os dados da ordem cadastrada:

```javascript
{
    "id": 5,
    "cliente": {
        "id": 2,
        "nome": "Jinbei"
    },
    "descricao": "Reparo de Notebook Dell 878765 ",
    "preco": 350.50,
    "status": "ABERTA",
    "dataAbertura": "2020-04-26T16:09:21.276-03:00",
    "dataFinalizacao": null
}
```
Ao cadastrar recebe o status de ABERTA e a data de sua abertura é cadastrada.

### Finalizar ordem de Serviço

`PUT localhost:8080/ordens-servico/{id da ordem de serviço}/finalizacao`

Passa como parâmetro da requisição o id da ordem a ser finalizada. 

Se a ordem de serviço não existir ou não tiver status ABERTA, recebe um JSON com a resposta e o status 400 - Bad Request:

```JSON
{
    "status": 400,
    "dataHora": "2020-04-26T16:12:44.459-03:00",
    "titulo": "Ordem de serviço não pode ser finalizada"
}
```
Caso a finalização seja concluída com sucesso recebe como resposta o status 204 - No Content, a ordem de serviço passa a ter status FINALIZADA e sua data de finalização é cadastrada.

### Listar Ordens de Serviço

`GET localhost:8080/ordens-servico/`

Recebe como resposta um JSON com a listagem de ordens de serviço cadastradas:

```JSON
[
    {
        "id": 1,
        "cliente": {
            "id": 2,
            "nome": "Jinbei"
        },
        "descricao": "Reparo de Notebook Dell",
        "preco": 350.50,
        "status": "FINALIZADA",
        "dataAbertura": "2020-04-23T09:29:19-03:00",
        "dataFinalizacao": "2020-04-23T17:17:24-03:00"
    },
    {
        "id": 2,
        "cliente": {
            "id": 2,
            "nome": "Jinbei"
        },
        "descricao": "Reparo de Notebook Dell 2",
        "preco": 350.50,
        "status": "ABERTA",
        "dataAbertura": "2020-04-23T10:01:05-03:00",
        "dataFinalizacao": null
    },
    {
        "id": 3,
        "cliente": {
            "id": 2,
            "nome": "Jinbei"
        },
        "descricao": "Reparo de Notebook Dell6",
        "preco": 3509.50,
        "status": "ABERTA",
        "dataAbertura": "2020-04-23T12:43:42-03:00",
        "dataFinalizacao": null
    },
    {
        "id": 4,
        "cliente": {
            "id": 2,
            "nome": "Jinbei"
        },
        "descricao": "Reparo de Notebook Dell 87876 ",
        "preco": 350.50,
        "status": "FINALIZADA",
        "dataAbertura": "2020-04-23T13:19:04-03:00",
        "dataFinalizacao": "2020-04-26T16:14:57-03:00"
    },
    {
        "id": 5,
        "cliente": {
            "id": 2,
            "nome": "Jinbei"
        },
        "descricao": "Reparo de Notebook Dell 878765 ",
        "preco": 350.50,
        "status": "ABERTA",
        "dataAbertura": "2020-04-26T16:09:21-03:00",
        "dataFinalizacao": null
    }
]
```

### Buscar Ordem de Serviço

`GET localhost:8080/ordens-servico/{id da ordem de serviço}`

Envia como parâmtro da requisição o id da ordem de serviço a ser buscada. Caso ela exista recebe uma resposta com o JSON com suas informações:

```JSON
{
    "id": 1,
    "cliente": {
        "id": 2,
        "nome": "Jinbei"
    },
    "descricao": "Reparo de Notebook Dell",
    "preco": 350.50,
    "status": "FINALIZADA",
    "dataAbertura": "2020-04-23T09:29:19-03:00",
    "dataFinalizacao": "2020-04-23T17:17:24-03:00"
}
```

Caso ela não exista, recebe com respsota status 404 - Not Found.

## Comentários

###

###
