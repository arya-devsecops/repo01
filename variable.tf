variable "rg_name" {
  description = " The name of the resource group in which to create the network security group. Changing this forces a new resource to be created."
  type    = any
  default = "az_exegroup"
}

variable "location" {
  description = "Specifies the supported Azure location where the resource exists. Changing this forces a new resource to be created."
  type    = string
  default = "westus2"
}

variable "net_name" {
  description = "Specifies the name of the network security group. Changing this forces a new resource to be created."
  type    = any
  default = "SecurityGroup1"
}

variable "security_rule_name" {
  description = "List of objects representing security rules, as defined below."
  type    = any
  default = "test123"
}

variable "protocol" {
  description = " (Required) Network protocol this rule applies to. Possible values include Tcp, Udp, Icmp, Esp, Ah or * (which matches all)."
  type    = any
  default = "Tcp"
}

variable "access" {
  description = "Specifies whether network traffic is allowed or denied. Possible values are Allow and Deny."
  type    = any
  default = "Allow"
}

variable "priority" {
  description = " Specifies the priority of the rule. The value can be between 100 and 4096. The priority number must be unique for each rule in the collection. The lower the priority number, the higher the priority of the rule."
  type    = any
  default = "100"
}

variable "direction" {
  description = " The direction specifies if rule will be evaluated on incoming or outgoing traffic. Possible values are Inbound and Outbound."
  type    = any
  default = "Inbound"
}

variable "source_port_range" {
  description = "A range of source ports."
  type        = string
  default     = "1024-65535"  # Provide a default value if needed
}


variable "destination_port_range" {
  description = "List of destination ports or port ranges. This is required if destination_port_range is not specified."
  type = any
  default = "*"
}

variable "source_address_prefix" {
  description = " List of source address prefixes. Tags may not be used. This is required if source_address_prefix is not specified."
  type = any
  default = "*"
}

variable "destination_address_prefix" {
  description = "The destination address prefix."
  type        = string
  default     = "0.0.0.0/0"  # Provide a default value if needed
}



variable "environment" {
  description = "A mapping of tags to assign to the resource.specify the environment for your resource"
  type    = any
  default = "Production"

}
