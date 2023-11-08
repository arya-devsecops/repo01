terraform {
  backend "azurerm" {
    resource_group_name  = "az_exegroup"  
    storage_account_name = "myterraformstorageaccount"
    container_name       = "az_storage"
    key                  = "terraform.tfstate"
    access_key           = "myaccesskey"
  }
}
