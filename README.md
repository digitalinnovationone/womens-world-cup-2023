<h1>womens-world-cup-2023</h1>
<p>Este é um projeto que visa fornecer informações sobre a Copa do Mundo de Futebol Feminino de 2023. O projeto inclui uma API em Kotlin que permite o acesso aos dados das seleções participantes e integração com o ChatGPT-4 para simular as partidas da Copa e prever os resultados dos jogos.</p>
<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
     <a alt="Kotlin">
        <img src="https://img.shields.io/badge/Kotlin-v1.8.22-purple.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.1.1-brightgreen.svg" />
    </a>
    <a alt="Spring Cloud">
        <img src="https://img.shields.io/badge/Spring%20Cloud-v4.0.3-brightgreen.svg" />
    </a>
    <a alt="Gradle">
        <img src="https://img.shields.io/badge/Gradle-v7.6-lightgreen.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v2.1.214-darkblue.svg" />
    </a>
</p>

## Configuração

Essas instruções fornecerão aos usuários as etapas necessárias para clonar o repositório e iniciar a aplicação em
diferentes ambientes (Unix e Windows) com o perfil de desenvolvimento ativado.

1. Clone o repositório: git clone `git@github.com:digitalinnovationone/womens-world-cup-2023.git`
2. Inicie a aplicação no ambiente Unix: `./gradlew bootrun --args='--spring.profiles.active=dev'`
3. Inicie a aplicação no ambiente Windows: `gradle.bat bootrun --args='--spring.profiles.active=dev'`

Para integrar com o ChatGPT e usá-lo como um modelo para análise de sentimentos dos nossos comentários.

Seguem alguns links úteis:

1. Endpoint que vamos consumir: https://platform.openai.com/docs/api-reference/chat/create
2. Collection Postman da OpenAI: https://www.postman.com/devrel/workspace/openai/documentation/13183464-90abb798-cb85-43cb-ba3a-ae7941e968da

> Request

```
curl https://api.openai.com/v1/chat/completions \
 -H "Authorization: Bearer $OPENAI_API_KEY" \
 -H "Content-Type: application/json" \
 -d '{
 "model": "gpt-3.5-turbo",
 "messages": [
    {"role": "user", "content": "What is the OpenAI mission?"}] 
 }'
```

> Response

```
{
  "id": "chatcmpl-6p5FEv1JHictSSnDZsGU4KvbuBsbu",
  "object": "messages",
  "created": 1677693600,
  "model": "gpt-3.5-turbo",
  "choices": [
    {
      "index": 0,
      "finish_reason": "stop",
      "message": {
        "role": "assistant",
        "content": "OpenAI's mission is to ensure that artificial general intelligence benefits all of humanity."
      }
    }
  ],
  "usage": {
    "prompt_tokens": 20,
    "completion_tokens": 18,
    "total_tokens": 38
  }
}
```
---

## Uso da API

> Request

### Simular partida entre dois times:

- Método: `GET`
- Endpoint: `/simulate/{team1Id}/{team2Id}`

Parâmetros de caminho:
- `{team1Id}`: ID da primeira equipe.
- `{team2Id}`: ID da segunda equipe.

- Exemplo de solicitação:

```http
GET /simulate/ARG/BRA
```

> Response

- Código de resposta: `200 OK`
- Corpo da resposta: `TeamDto` contendo os dados da equipe vencedora.

Exemplo de resposta:

```json
{
  "id": "ARG",
  "name": "Argentina",
  "score": 1682.45
}
```

#### Códigos de resposta possíveis:

- `200 OK`: A simulação foi concluída com sucesso e a equipe vencedora é retornada.
- `422 Unprocessable Entity`: Uma ou ambas as equipes não foram encontradas na Copa do Mundo Feminina.

## Documentação do Swagger

A documentação da API pode ser encontrada no Swagger. Para visualizá-la,
acesse: [Documentação do Swagger](http://localhost:8080/swagger-ui/index.html#/).

## Hospedagem no Railway.app

Este projeto está hospedado no Railway.app. Para acessar a aplicação,
acesse: [URL da Aplicação](https://sua-url-de-hospedagem-aqui).

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o
arquivo <a href="https://github.com/digitalinnovationone/womens-world-cup-2023/blob/main/LICENSE.md">(LICENSE)</a> para obter.

## Autores

<table>
  <tr>
    <td align="center"><a href="https://github.com/falvojr"><img src="https://avatars.githubusercontent.com/u/730492?v=4&s=100" width="100px;" alt=""/><br/><strong>Venilton FalvoJr</strong></a><br/><a href="https://www.linkedin.com/in/falvojr/">LinkedIn</a></td>
    <td align="center"><a href="https://github.com/cami-la"><img src="https://avatars.githubusercontent.com/u/64323124?v=4&s=100" width="100px;" alt=""/><br/><strong>Camila Cavalcante</strong></a><br/><a href="https://www.linkedin.com/in/cami-la/">LinkedIn</a></td>
  </tr>
</table>