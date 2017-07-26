import groovy.json.JsonOutput

class A {

    // 不建议使用 `def` 关键字，原因，你不知道类型
    static void main(String[] args) {
        usingClosure()
        usingMap() // 相比前一种，更推荐使用 Map
    }

    static void usingClosure() {
        Closure jsonClosure = {
            user msg: "1", con: 1
            str msg: "2"
        }
        println "usingClosure: JSON 内容是："
        println JsonOutput.prettyPrint(JsonOutput.toJson(jsonClosure))
    }

    static void usingMap() {
        Map jsonMap = [
                user: [msg: "1", con: 1],
                str : [msg: "2"]
        ]
        println "usingMap: JSON 内容是："
        println JsonOutput.prettyPrint(JsonOutput.toJson(jsonMap))
    }
}
