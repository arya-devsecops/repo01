terraform {
  backend "azurerm" {
    storage_account_name = "myterraformstorageaccount"
    container_name       = "tfstate"
    key                  = "terraform.tfstate"
    access_key           = "myaccesskey"
  }
}
