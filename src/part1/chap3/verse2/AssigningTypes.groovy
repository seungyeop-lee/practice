package part1.chap3.verse2

def a = 1
assert a instanceof Integer

def b = 1.0f
assert b instanceof Float

int c = 1
assert c instanceof Integer

float d = 1
assert d instanceof Float

Integer e = 1
assert e instanceof Integer

String f = '1'
assert f instanceof String

def g = 1
assert g instanceof Integer
g = '2'
assert g instanceof String
