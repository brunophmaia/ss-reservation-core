# Microservices Demo (Java 21, Spring Boot 3.3.4)

Este repositório contém um exemplo mínimo de microsserviços para rodar no Kubernetes **sem Ingress e sem Service Mesh**:
- **api-gateway** (Spring Cloud Gateway) exposto via Service `LoadBalancer`/`NodePort`
- **account-service** (REST)
- **order-service** (REST)

## Requisitos
- Java 21+
- Maven 3.9+
- Docker
- kubectl
- minikube **ou** kind

## Como rodar local (sem K8s)
```bash
# Em terminais separados
mvn -f account-service/pom.xml spring-boot:run
mvn -f order-service/pom.xml spring-boot:run
mvn -f api-gateway/pom.xml spring-boot:run

# Teste
curl http://localhost:8080/account/hello
curl http://localhost:8080/order/hello
```

## Build de imagens (Minikube - usando Docker interno)
```bash
eval $(minikube docker-env)

# Build
docker build -t account-service:1.0 ./account-service
docker build -t order-service:1.0 ./order-service
docker build -t api-gateway:1.0 ./api-gateway
```

## Deploy no Kubernetes (manifests em `k8s/`)
```bash
kubectl apply -f k8s/account-service.yaml
kubectl apply -f k8s/order-service.yaml
kubectl apply -f k8s/api-gateway.yaml
```

### Obter URL (Minikube)
```bash
minikube service api-gateway --url
# Use a URL retornada:
curl <URL>/account/hello
curl <URL>/order/hello
```

### Se estiver usando kind:
O kind não provê LoadBalancer nativo. Altere o `Service` do api-gateway para `NodePort`
ou use um LB como MetalLB. Para teste rápido com NodePort:
- Edite `k8s/api-gateway.yaml` e troque `type: LoadBalancer` por `type: NodePort`
- Aplique novamente e descubra a porta com:
```bash
kubectl get svc api-gateway -o wide
```
Depois acesse via IP do nó.

## Próximos passos
- Adicionar autenticação/autorização no Gateway
- Observabilidade (Actuator, Prometheus, Grafana)
- Ingress Controller (NGINX/Traefik) quando quiser uma edge mais robusta
- Service Mesh (Istio/Linkerd) para mTLS, retries, circuit breaking
