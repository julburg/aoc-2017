package kotl.de.aoc


fun String.findAll(value: String) = value.toRegex().findAll(this);