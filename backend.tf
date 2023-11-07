terraform {
  backend "azurerm" {
    resource_group_name   = "az_exegroup"
    storage_account_name  = "dummyterraform"
    container_name        = "terrraformstate"
    key                   = "sample/vm"
  }
}
