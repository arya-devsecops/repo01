resource "azurerm_resource_group" "example" {
  name     = var.rg_name
  location = var.location
}

resource "azurerm_network_security_group" "example" {
  name                = var.name
  location            = azurerm_resource_group.example.location
  resource_group_name = azurerm_resource_group.example.name

  security_rule {
    name      = var.security_rule_name
    priority  = var.priority
    direction = var.direction
    access    = var.access
    protocol  = var.protocol
  }

  tags = {
    environment = var.environment
  }
}