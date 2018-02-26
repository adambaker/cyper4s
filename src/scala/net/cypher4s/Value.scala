package net.cypher4s

import org.neo4j.graphdb

sealed abstract class Value

sealed abstract class Property extends Value
sealed abstract class Simple extends Property {
  type U
}
final case class Str(value: String) extends Simple {
  type U = String
}
final case class Integral(value: Long) extends Simple {
  type U = Long
}
final case class Floating(value: Double) extends Simple {
  type U = Double
}
final case class Bool(value: Boolean) extends Simple {
  type U = Boolean
}

case object Null extends Property
final case class ByteA(value: Array[Byte]) extends Property
final case class PropList[T <: Simple](value: IndexedSeq[T#U]) extends Property
//Underlying is Array[T#U]

final case class CyMap(value: Map[String, Value]) extends Value
final case class CyList(value: Vector[Value]) extends Value

final case class Node(id: Long, labels: Array[graphdb.Label],
  properties: Map[String, Property]) extends Value
final case class Relationship(id: Long, relType: graphdb.RelationshipType,
  from: Node, to: Node, properties: Map[String, Property])
final case class Path(value: Vector[Relationship]) extends Value
