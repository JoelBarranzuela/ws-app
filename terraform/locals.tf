locals {
    #Debe ser único, ejemplo, alias = "ajbc"
    alias = "ajbc"
    #ejemplo, region = "East US 2"
    region = "Central US"
    workers = 2
    instancia = "Standard_D2_v2"
    subscripcion = "azure01"
    #az ad sp create-for-rbac --role="Contributor" --scopes="/subscriptions/<subscriptionID>/resourceGroups/<resourceGroupName>" 
    clientid = "64ff8fb8-0ffe-4485-adf7-3d4a5436ff44"
    clientsecret = "f8wVsDj2_oq-kxuEM7MsHPkoo_ymNnsSn3"
}
