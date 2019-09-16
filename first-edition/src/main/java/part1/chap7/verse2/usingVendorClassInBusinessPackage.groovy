package part1.chap7.verse2

import part1.chap7.verse2.business.Vendor

def canoo = new Vendor()
canoo.name = 'Canoo Engineering AG'

canoo.product = 'UltraLightClient (ULC)'

assert canoo.dump() =~ /ULC/