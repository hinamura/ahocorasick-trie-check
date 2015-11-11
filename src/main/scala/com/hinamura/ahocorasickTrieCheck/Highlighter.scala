package com.hinamura.ahocorasickTrieCheck

import scala.collection.JavaConversions.collectionAsScalaIterable
import scala.collection.mutable.ListBuffer
import org.ahocorasick.trie.Trie

class Highlighter(words: Seq[String]) {

  private val normalize = (s: String) =>  Normalizer.nfcNormalize(s)

  val trie = new Trie[Boolean].removeOverlaps()
  words.foreach(word => trie.addKeyword(normalize(word), true))

  def execute(s: String): String =
    try {
      val result = new ListBuffer[String]
      var end = 0
      trie.parseText(normalize(s).replace("\n", " ")).toSeq.sortBy(_.getStart).foreach(e => {
        if (e.getStart >= end) {
          val r = s.substring(end, e.getStart) + "<hit>" + s.substring(e.getStart, e.getEnd + 1) + "</hit>"
          result.append(r)
          end = e.getEnd + 1
        }
      })
      if (end < s.length) result.append(s.substring(end))
      result.fold("")((a, b) => a + b).trim
    } catch {
      case e: StringIndexOutOfBoundsException => s
    }

}