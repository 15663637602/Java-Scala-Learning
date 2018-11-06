/**
  * The value title is private to the class, not to the instance, Since the method printTitle is a member of the class, it can access private values of other instances.
  *
  * If you wanted title to be private to the instance, you would use the private[this] modifier instead.
  *
  * Further, the private[package] modifier, where package is the name of the package the definition occurs in, can share the private member with the package. For example
  *
  * package com.sample.foo
  *
  * class Book(private[foo] title: String)
  * would be accessible to all code in package com.sample.foo
  *
  * @param title
  */
class Book(private val title: String) {
  def printTitle(b: Book) {
    println(b.title)
  }
}

val book = new Book("Beginning Scala")
book.printTitle(new Book("Beginning Erlang"))