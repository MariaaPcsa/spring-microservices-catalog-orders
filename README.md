# Sistema de Microserviços: Catálogo de Produtos & Simulador de Pedidos

> **Stack**: Java 17, Spring Boot 3.3.x, Spring Cloud 2024.0.x, Eureka (Service Discovery), Spring Cloud Gateway (API Gateway), H2 Database (catálogo).



## Módulos
- `discovery-server` (porta `8761`): Eureka Server.
- `product-catalog-service` (porta `8110`): CRUD básico de produtos (`/produtos`) com persistência H2.
- `order-simulator-service` (porta `8210`): simulação de pedidos (`/pedidos`) sem persistência, consulta o catálogo.
- `api-gateway` (porta `8710`): expõe todos os endpoints via Gateway.

As portas atendem os requisitos: catálogo 8100–8199; pedidos 8200–8299; gateway 8700–8799.

## Como rodar
1. **Build** (na raiz):
   ```bash
   mvn -q -DskipTests package
   ```
2. **Suba os serviços** (em 4 terminais):
   ```bash
   # 1) Discovery
   cd discovery-server && mvn spring-boot:run

   # 2) Catálogo
   cd product-catalog-service && mvn spring-boot:run

   # 3) Gateway
   cd api-gateway && mvn spring-boot:run

   # 4) Pedidos
   cd order-simulator-service && mvn spring-boot:run
   ```

3. **Acesse**
   - Eureka: http://localhost:8761
   - H2 Console: http://localhost:8110/h2-console  (JDBC URL: `jdbc:h2:mem:catalogdb` | user `sa` | pass `password`)
   - API via Gateway:
     - `GET http://localhost:8710/produtos`
     - `POST http://localhost:8710/produtos` (body JSON abaixo)
     - `GET http://localhost:8710/produtos/{id}`
     - `GET http://localhost:8710/pedidos/produtos` (lista produtos via serviço de pedidos)
     - `POST http://localhost:8710/pedidos` (simula pedido)

### Exemplos de requisição
**Criar produto**
```http
POST /produtos
Content-Type: application/json

{
  "nome": "Mouse",
  "descricao": "Mouse óptico USB",
  "preco": 49.90
}
```

**Simular pedido**
```http
POST /pedidos
Content-Type: application/json

{
  "productIds": [1, 2, 3]
}
```

**Resposta do pedido (exemplo)**
```json
{
  "orderId": "c4e1a6ab-40fc-4d2e-9b0b-2b1f2d4e1f3a",
  "items": [
    {"productId":1,"nome":"Caneca","preco":29.90},
    {"productId":2,"nome":"Camiseta","preco":59.90}
  ],
  "total": 89.80
}
```

## Boas práticas aplicadas
- **REST**: recursos em plural, códigos de status adequados, `Location` no `POST`.
- **Validação**: bean validation nas entradas.
- **Camadas simples**: Controller/Repository.
- **Configuração externa**: `application.yml` por serviço.
- **Service Discovery + Gateway**: roteamento via `lb://` e `Path` por contexto (`/produtos`, `/pedidos`).
- **Observabilidade**: Actuator exposto (health/info).

## Observações
- O `order-simulator-service` consome o catálogo via **Gateway** (`catalog.service.base-url: http://localhost:8710`). Isso garante que **todos os endpoints** sejam acessados via Gateway, conforme requisito.
- Dados de exemplo são carregados no catálogo ao subir.
