package part1.chap7.verse2

class Vendor {
    String name
    String product
    Address address = new Address()
}

class Address {
    String street, town, state
    int zip
}

def canoo = new Vendor()
canoo.name = 'Canoo Engineering AG'
canoo.product = 'UltraLightClient (ULC)'
canoo.address.street = 'Kirschgartenst. 7'
canoo.address.zip = 4051
canoo.address.town = 'Basel'
canoo.address.state = 'Switzerland'

assert canoo.dump() =~ /ULC/
assert canoo.address.dump() =~ /Basel/