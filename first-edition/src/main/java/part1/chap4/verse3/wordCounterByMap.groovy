package part1.chap4.verse3

def textCorpus =
"""
Look for the bare necessities
The simple bare necessities
Forget about your worries and your strife
I mean the bare necessities
Old Mother Nature's recipes
That bring the bare necessities of life
"""

def words = textCorpus.tokenize()   // 공백을 기준으로 분리하여 리스트로 반환
def wordFrequency = [:]
words.each { word ->
    wordFrequency[word] = wordFrequency.get(word, 0) + 1
}
def wordList = wordFrequency.keySet().toList()
wordList.sort { wordFrequency[it] }

def statistic = "\n"
wordList[-1..-6].each { word ->
    statistic += word.padLeft(12) + ': '
    statistic += wordFrequency[word] + "\n"
}

assert statistic ==
"""
 necessities: 4
        bare: 4
         the: 3
        your: 2
        life: 1
          of: 1
"""