# Desafio Final Bootcamp Arquiteto(a) de Software

## Link repositorio com implementação: https://github.com/adriano-moreira/2025-xpe-pos-arquitetura-de-software-desafio-final

Implementacão utilizando:
- Java 21 (LTS atual em fevereiro 2025)
- Quarkus 3.15.3 (LTS atual em fevereiro 2025)


# Vendas-online-api

repo: https


## Estrutura de pasta
```
└── api
    ├── controller
    │   └── ProdutoController.java
    ├── model
    │   └── ProdutoEntity.java
    ├── repository
    │   └── ProdutoRepository.java
    └── service
        └── ProdutoService.java
```

## Diagrama de sequencia, apresentado o fluxo entre as classes para endpoints de Produto 
```mermaid
sequenceDiagram
    actor bff as bff-*
        
    box Aplicação java/Quarkus    
    participant ProdutoController
    participant ProdutoService
    participant ProdutoRepository
    end
        
    participant Database

bff ->> ProdutoController: 
ProdutoController ->> ProdutoService: 
ProdutoService ->> ProdutoRepository: 
ProdutoRepository ->> Database: 


```

## Diagrama de fluxo
```mermaid
flowchart

subgraph front-end
bff1[bff-site]
bff2[bff-backoffice-gestores]
bff3[bff-backoffice-entregas]
end

subgraph core
api[venda-online-api] --> db[(venda-online-db)]
end

bff1 --> api
bff2 --> api
bff3 --> api
```


## C4 Component Diagram
```mermaid
C4Context
    Person(cliente, "Cliente")
    Person(colaborador1, "Colaborador Administrativo")
    Person(colaborador2, "Colaborador Estoque")

    Enterprise_Boundary(b0, "Sistema") {
        Enterprise_Boundary(bf, "Font-End") {
            System(site, "site")
            System(backoffice-administracao, "Backoffice Administração")
            System(backoffice-entregas, "Backoffice Entregas")
            System(site-bff, "BFF Site")
            System(backoffice-administracao-bff, "BFF Backoffice Administração")
            System(backoffice-entregas-bff, "BFF Backoffice Entregas")
        }

        Enterprise_Boundary(b1, "Core") {
            System(api, "vendas-online-api")
            SystemDb(db, "vendas-online-db")
        }
    }

    Rel(cliente, site, "compra")
    Rel(colaborador1, backoffice-administracao, "administra")
    Rel(colaborador2, backoffice-entregas, "baixa estoque")
    Rel(site, site-bff, "")
    Rel(backoffice-administracao, backoffice-administracao-bff, "")
    Rel(backoffice-entregas, backoffice-entregas-bff, "")
    
    Rel(backoffice-administracao-bff, api, "")
    Rel(backoffice-entregas-bff, api, "")
    Rel(site-bff, api, "")
    Rel(api, db, "")
    UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
```
