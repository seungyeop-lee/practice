package part1.chap2.verse1

class Brevity {
    static void main(String[] args) {
        /*
        groovy에서는 아래의 package를 자동으로 import시켜주므로 코드가 간결해 짐
            groovy.lang.*
            groovy.util.*
            java.lang.*
            java.util.*
            java.net.*
            java.io.*
            java.math.BigInteger & BigDecimal
         */
        String javaSyntaxEncode = java.net.URLEncoder.encode("a b", "UTF-8");
        String groovySyntaxEncode = URLEncoder.encode("a b", "UTF-8")

        assert javaSyntaxEncode == groovySyntaxEncode
    }
}
