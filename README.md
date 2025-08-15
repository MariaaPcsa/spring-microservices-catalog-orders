O repositório spring-microservices-catalog-orders é um projeto que demonstra a construção de um sistema de microserviços utilizando tecnologias modernas da stack Java. O foco principal é um catálogo de produtos integrado a um simulador de pedidos, com arquitetura baseada em Spring Boot e Spring Cloud.

🛠️ Stack Tecnológica

Java 17

Spring Boot 3.3.x

Spring Cloud 2024.0.x

Eureka (Descoberta de Serviços)

Spring Cloud Gateway (API Gateway)

Banco de Dados H2 (para persistência do catálogo de produtos)

🧱 Módulos do Sistema

O projeto é dividido em quatro módulos principais:

discovery-server

Eureka Server (porta 8761): responsável pela descoberta de serviços.

product-catalog-service

Serviço de catálogo de produtos (porta 8110): oferece operações CRUD básicas para gerenciamento de produtos, com persistência em banco de dados H2.

order-simulator-service

Simulador de pedidos (porta 8210): permite a criação e simulação de pedidos.

api-gateway

Gateway de API: centraliza o acesso aos serviços, roteando as requisições conforme necessário.

📄 Arquitetura Geral

O sistema segue uma arquitetura de microserviços, onde cada módulo é independente e se comunica com os demais através de APIs REST. O Eureka Server facilita a descoberta e registro dos serviços, enquanto o API Gateway atua como ponto de entrada único para as requisições externas.

🚀 Como Executar

Para rodar o sistema localmente, siga os passos abaixo:

Clone o repositório:

git clone https://github.com/MariaaPcsa/spring-microservices-catalog-orders.git
cd spring-microservices-catalog-orders


Compile e execute os serviços:

Inicie o Eureka Server:

cd discovery-server
mvn spring-boot:run


Inicie o Product Catalog Service:

cd product-catalog-service
mvn spring-boot:run


Inicie o Order Simulator Service:

cd order-simulator-service
mvn spring-boot:run


Inicie o API Gateway:

cd api-gateway
mvn spring-boot:run
