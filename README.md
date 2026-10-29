# Lab: Padrões de Projeto com Spring Boot (Versão Evoluída)

Este projeto foi aprimorado a partir do laboratório de Padrões de Projeto em Spring Boot da DIO.

## 🌟 Padrões de Projeto Aplicados

1. **Singleton**: Gerido nativamente pelo IoC/DI Container do Spring Framework (`@Service`, `@RestController`, `@Repository`).
2. **Strategy**: Interface `ClienteService` com sua implementação injetada via `@Autowired`.
3. **Facade**: O controller REST `ClienteRestController` atua como facade, abstraindo a complexidade de persistência no banco H2 e do consumo do serviço de terceiros (ViaCEP).

## ⚡ Melhorias Enterprise Adicionadas

- **DTO (Data Transfer Object)**: Separação completa da camada REST e dos modelos de entidade JPA (`ClienteDTO`).
- **Bean Validation**: Validação rigorosa dos dados de entrada (`@NotBlank`, `@Pattern` para CEP com 8 dígitos numéricos).
- **Tratamento Global de Exceções**: `@RestControllerAdvice` capturando erros de validação e recursos não encontrados com respostas JSON padronizadas.
- **OpenFeign Fallback**: Resiliência contra indisponibilidade do serviço externo do ViaCEP.
- **Documentação OpenAPI/Swagger**: Disponível em `/swagger-ui.html` para testes interativos dos endpoints REST.

## 🚀 Como Executar
1. Certifique-se de ter o Java 11+ e o Maven instalados.
2. Execute `./mvnw spring-boot:run` na raiz do projeto.
3. Acesse o Swagger UI em `http://localhost:8080/swagger-ui.html`.
