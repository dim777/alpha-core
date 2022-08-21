# Deployment Tips
## Get namespaces
kubectl get namespace --kubeconfig /Users/derokhin/Library/Application\ Support/Lens/kubeconfigs/...

## Build arm-based images
### Nexus 
```shell
git clone https://github.com/sonatype/docker-nexus3 && cd docker-nexus3
docker buildx build --tag nexus:EAP-linux-arm64-3.41.0 -o type=image --platform=linux/arm64 .
docker tag nexus:EAP-linux-arm64-3.41.0 dim777/nexus:EAP-linux-arm64-3.41.0
docker push dim777/nexus:EAP-linux-arm64-3.41.0
```
Initial password inside Pod:
```shell
cat /nexus-data/admin.password
```
### Teamcity
```shell
wget -c https://download-cdn.jetbrains.com/teamcity/TeamCity-2022.04.3.tar.gz -O - | tar -xz -C context
```


```shell
export KUBECONFIG=/../kubeconfig.yaml
kubectl create deployment nginx --image=nginx
kubectl expose deploy nginx --port 80 --target-port 80 --type NodePort
```

## Following namespace's should be created and deployed:
- dev-tools (for ci/cd)
- utils (helpers)
```shell
kubectl create namespace dev-tools
kubectl create namespace utils
kubectl apply -f dev-tools/teamcity-deployment-###.yaml --kubeconfig /Users/derokhin/Library/Application\ Support/Lens/kubeconfigs/ec123040-5f48-4481-beb4-28495cda93cc
#nexus 
kubectl apply -f deploy/dev-tools/nexus-deployment-oke.yaml --kubeconfig /Users/derokhin/Library/Application\ Support/Lens/kubeconfigs/...
```

## PV and PVC configure

```shell
#helm repo add stable https://charts.helm.sh/stable
helm repo add kvaps https://kvaps.github.io/charts
helm repo update
```
# Choose specific storageClass according k8s cluster setup
```shell
# digital ocean k8s cluster
helm install nfs-server-provisioner kvaps/nfs-server-provisioner --version 1.4.0 --set persistence.enabled=true,persistence.storageClass=do-block-storage,persistence.size=200Gi,storageClass.mountOptions={"vers=4.2"}
# oracle cloud 
helm install nfs-server-provisioner kvaps/nfs-server-provisioner --version 1.4.0 --set persistence.enabled=true,persistence.storageClass=oci,persistence.size=100Gi,storageClass.mountOptions={"vers=4.2"}
# or minikube
helm install nfs-server-provisioner kvaps/nfs-server-provisioner --version 1.4.0 --set persistence.enabled=true,persistence.storageClass=standard,persistence.size=200Gi,storageClass.mountOptions={"vers=4.2"}
```

# Uninstall nfs-server-provisioner
```shell
helm uninstall nfs-server-provisioner
kubectl patch deployment teamcity --patch "$(cat teamcity-deployment.yaml)"
```

## Ingress deploy
For MiniKube local install
```shell
minikube addons enable ingress
minikube ip
```
For Digital Ocean
```shell
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.1.0/deploy/static/provider/do/deploy.yaml
kubectl apply -f https://github.com/jetstack/cert-manager/releases/download/v1.6.1/cert-manager.yaml
```
For Oracle Cloud
```shell
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.2.0/deploy/static/provider/cloud/deploy.yaml
kubectl apply -f https://github.com/jetstack/cert-manager/releases/download/v1.9.1/cert-manager.yaml
```

## Prior to publish teamcity
Configuration should be done via port forwarding (plz see useful hints)

## Useful hints

```shell
kubectl port-forward podId srcPort:dstPort
kubectl port-forward -n dev-tools teamcity-57d94cc657-x7ktf 18111:8111

```

## Publish to nexus
publishToNexus -Dfile.encoding=UTF-8 -Pnexus.user=admin -Pnexus.password=rTM***

## Squid utils
```shell
cd dev-tools
kubectl create configmap squid-config --from-file=squid=dev-tools\squid\squid.conf -n dev-tools
kubectl apply -f squid-deployment-do.yaml
```
