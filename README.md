## ClickConnect
API do projeto ClickConnect - Site de vendas de periféricos

## Tarefas

- [] CRUD de Mouses 
- [] CRUD de MousePads
- [] CRUD de Teclados
- [] CRUD de Usuários
- [] CRUD de Carrinho   
- [] Procurar 

## Documentação da API

### Endpoints
- [Listar Todos os Mouses](#listar-todos-os-mouses)
- [Detalhes do Mouse](#detalhes-do-mouse)

### Listar Todos os mouses

`GET` /mouse

Retorna um array com todos os mouses cadastrados

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "GPRO SuperLight",
        "preco": 800
    }
]
```

#### Códigos de Status
|código | descrição |
|-------|-----------|
| 200 | Os dados dos mouses foram retornados com sucesso
| 401 | Acesso negado! Você deve se autenticar|
---

### Detalhes do Mouse

`GET` /mouse/`{id}`

Retornar os detalhes do mouse com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```js
// requisição para /mouse/1
[
    {
        "id": 1,
        "nome": "GPRO SuperLight",
        "preco": 800
    }
]
```

#### Códigos de Status
|código | descrição |
|-------|-----------|
| 200 | Os dados dos mouses foram retornados com sucesso
| 404 | Não existe categoria com o `id` informado|
---
