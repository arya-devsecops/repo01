variable "rg_name" {
  type    = any
  default = "az_exegroup"
}

variable "location" {
  type    = string
  default = "westus2"
}

variable "name" {
  type    = any
  default = "acceptanceTestSecurityGroup1"
}

variable "security_rule_name" {
  type    = any
  default = "test123"
}

variable "protocol" {
  type    = any
  default = "Tcp"
}

variable "access" {
  type    = any
  default = "Allow"
}

variable "priority" {
  type    = any
  default = "100"
}

variable "direction" {
  type    = any
  default = "Inbound"
}




variable "environment" {
  type    = any
  default = "Production"

}