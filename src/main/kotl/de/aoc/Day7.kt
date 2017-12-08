package de.aoc

/**
 * @author  Julia Burgard - burgard@synyx.de
 */
fun day7(input: String): String {

    val allElements = findElements(input)

    val allChildren = findChildren(input)


    val rootElement = allElements.toMutableList()
    rootElement.removeAll(allChildren.toList());

    if (rootElement.isEmpty() || rootElement.size > 1) {
        throw Exception("something went wront")
    }

    return rootElement.toList().get(0);
}


fun day7b(input: String): String {

    var treeNodes = ArrayList<DiscTreeNode>();
    input.split("\n").forEach {
        val parent = findElements(it).first();
        val weight = findWeight(it).first().toInt();
        val node = DiscTreeNode(parent, weight);
        treeNodes.add(node)
    }

    input.split("\n").forEach {
        val parentAsString = findElements(it).first();
        val parent = treeNodes.filter { it.id == parentAsString }.first();

        val children = findChildren(it);
        children.forEach {
            val childAsString = it;
            val child = treeNodes.filter { it.id == childAsString }.first();
            parent.addChild(child)
        }
    }
    //vgzejbd
    val parent = treeNodes.filter { it.id == "vgzejbd" }.first();

    calculateWeight(parent);

    println(parent.toString());
    return "";

}

//102055, 148790, 134829
fun calculateWeight(parent: DiscTreeNode): Int {
    if (parent.children.isEmpty()) {
        return parent.weigth;
    }

    val weights = parent.children.map() {
        calculateWeight(it);
    }
    if (weights.toSet().size > 1) {
        println(parent.id)
        weights.forEach{println(it)}
        parent.children.forEach{println(it.id)}
        //parent.children.forEach { println(it.id + " " + it.weigth) }
    }
    return weights.sum() + parent.weigth;
}

private fun findChildren(input: String): Sequence<String> {
    return input.findAll("""-> (.*)""").map {
        val (result: String) = it.destructured
        val splitted = result.split(",").map { it.trim() }
        splitted
    }.flatten()
}

private fun findWeight(input: String): Sequence<String> {
    return input.findAll("""\((\d*)\)""").map {
        val (result: String) = it.destructured
        result
    }
}

private fun findElements(input: String): Sequence<String> {
    return input.findAll("""(\w*)\s\(""").map {
        val (result: String) = it.destructured
        result
    }
}


class DiscTreeNode(value: String, weight: Int) {
    var id: String = value
    var weigth: Int = weight
    var weigthSum: Int = 0
    var balanced: Boolean = true;
    var result: Int = 0;
    var children: MutableList<DiscTreeNode> = mutableListOf()

    fun addChild(node: DiscTreeNode) {
        children.add(node)
    }

    override fun toString(): String {
        var s = "${id}" + "(" + weigth + ")" + "(" + balanced + ")" + "(" + result + ")\n"
        if (!children.isEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DiscTreeNode

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}