# springboot_simple_store

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/>
  <img src="https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white"/>
  <img src="https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
</div>

---

## Como executar localmente com Docker

```bash
# 1. Clone o repositório
git clone https://github.com/Famel-svg/-Actions-springboot_simple_store.git
cd -Actions-springboot_simple_store

# 2. Suba a aplicação + banco
docker compose -f Compose.yaml up --build

# 3. Acesse a API
curl http://localhost:8080/users
```

---

## Pipeline CI/CD

**Ferramenta:** GitHub Actions — arquivo `.github/workflows/pipeline.yml`

**Registry:** GitHub Container Registry (GHCR) — sem configuração extra, usa `GITHUB_TOKEN` automático.

| Job | Descrição | Gatilho |
|---|---|---|
| 🔨 **Build** | `mvn clean package -DskipTests` | Push em qualquer branch |
| 🧪 **Test** | `mvn test` com perfil H2 in-memory | Após Build |
| 🐳 **Docker → GHCR** | Build da imagem + push para `ghcr.io` | Push na `main` |
| 🚀 **Deploy Staging** | Deploy no namespace `staging` do K8s | Após push da imagem |
| ✅ **Aprovação Manual** | Gate configurado no Environment `production` | Automático |
| 🏭 **Deploy Production** | Deploy no namespace `production` do K8s | Após aprovação |

### Configurar aprovação manual

1. Vá em **Settings → Environments → New environment**
2. Crie `staging` (sem reviewer)
3. Crie `production` → **Required reviewers** → adicione seu usuário → **Save**

---

## Containerização

Multi-stage build: `maven:3.9.12-eclipse-temurin-21` para compilação → `eclipse-temurin:21-jre-alpine` para runtime (~180MB).

Usuário não-root (`appuser`) para segurança em produção.

---

## Arquitetura Kubernetes

```
AKS / Cluster K8s
├── namespace: staging
│   ├── postgres     (Deployment + PVC 1Gi + Service)
│   └── springboot-store (1 réplica + LoadBalancer)
└── namespace: production
    ├── postgres     (Deployment + PVC 5Gi + Service)
    └── springboot-store (2 réplicas + LoadBalancer)
```

---

## Prints do Funcionamento

> Substitua pelos prints reais após execução do pipeline.

| Evidência | Descrição |
|---|---|
| `[print-build.png]` | Job Build concluído (verde) |
| `[print-test.png]` | Job Test com relatório JUnit |
| `[print-docker.png]` | Imagem publicada no GHCR |
| `[print-staging.png]` | Deploy Staging concluído |
| `[print-approval.png]` | Tela de aprovação manual |
| `[print-production.png]` | Deploy Production concluído |

---

## Tecnologias Utilizadas

| Categoria | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 4.0.2 |
| Build | Apache Maven 3.9 + Wrapper |
| Banco (test) | H2 in-memory |
| Banco (dev/prod) | PostgreSQL 16 |
| Container | Docker (multi-stage) |
| Orquestração | Kubernetes |
| CI/CD | GitHub Actions |
| Registry | GitHub Container Registry (GHCR) |

---

## Checklist de Entrega

| Item | Status |
|---|---|
| Projeto em .ZIP com estrutura organizada | ✅ |
| Dockerfile funcional (multi-stage) | ✅ |
| Compose.yaml para execução local | ✅ |
| Manifests Kubernetes (`kubernetes/`) | ✅ |
| Pipeline com build, test e deploy | ✅ |
| Deploy em staging e production | ✅ |
| README com instruções e prints | ✅ |
| Documentação técnica (PDF/PPT) | ☐ |

---

<div align="center">
  <strong>Desenvolvido por Famel-svg 🚀</strong>
</div>
