resource "azurerm_resource_group" "example" {
  name     = var.rg_name
  location = var.location
}

resource "azurerm_network_security_group" "example" {
  name                = var.net_name
  location            = azurerm_resource_group.example.location
  resource_group_name = azurerm_resource_group.example.name

  security_rule {
    name      = var.security_rule_name
    priority  = var.priority
    direction = var.direction
    access    = var.access
    protocol  = var.protocol
    source_port_range          = var.source_port_range
    destination_port_range     = var.destination_port_range
    source_address_prefix      = var.source_address_prefix
    destination_address_prefix = var.destination_address_prefix
  }

  tags = {
    environment = var.environment
  }
}
