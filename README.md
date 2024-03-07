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
- [Cadastrar Mouse](#cadastrar-mouse)
- [Apagar Mouse](#apagar-mouse)
- [Atualizar Mouse](#atualizar-mouse)

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
| 404 | Não existe categoria com o `id` informado
---

### Cadastrar Mouse

`POST` /mouse

Adiciona um novo mouse para a página de mouses

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome do mouse.
|descricao|string|✅|Descrição do mouse.
|preco|double|❌|Preço do mouse.

```js
{
    "nome": "GPRO SuperLight",
    "descricao": "O novo mouse PRO SuperLight é mais rápido e mais preciso. Pesando apenas 60g e projetado em parceria com os principais jogadores profissionais do mundo.",
    "preco": 800
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "GPRO SuperLight",
    "descricao": "O novo mouse PRO SuperLight é mais rápido e mais preciso. Pesando apenas 60g e projetado em parceria com os principais jogadores profissionais do mundo.",
    "preco": 800
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|201|Mouse cadastrado com sucesso.
|400|Dados enviados são inválidos. Verifique o corpo da requisição.
|401|Acesso negado. Você deve se autenticar.

---

### Apagar Mouse

`DELETE` /mouse/`{id}`

Apaga o mouse com o `id` especificado no parâmetro de path.

#### Códigos de Status

|código|descrição|
|------|---------|
|204|Mouse foi apagado com sucesso.
|401|Acesso negado. Você deve se autenticar.
|404|Não existe Mouse com o `id` informado.

___

### Atualizar Mouse

`PUT` /mouse/`{id}`

Alteração dos dados do mouse especificado no `id`, utilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome do mouse.
|descricao|string|✅|Descrição do mouse.
|preco|double|✅|Preço do mouse.

```js
{
    "nome": "GPRO SuperLight",
    "descricao": "O novo mouse PRO SuperLight é mais rápido e mais preciso. Pesando apenas 60g e projetado em parceria com os principais jogadores profissionais do mundo.",
    "preco": 800
}
```
#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "GPRO SuperLight",
    "descricao": "O novo mouse PRO SuperLight é mais rápido e mais preciso. Pesando apenas 60g e projetado em parceria com os principais jogadores profissionais do mundo.",
    "preco": 800
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Mouse alterado com sucesso.
|400|Dados enviados são inválidos. Verifique o corpo da requisição.
|401|Acesso negado. Você deve se autenticar.
|404|Não existe mouse com o `id` informado.

---

