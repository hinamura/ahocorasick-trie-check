package com.hideto0710.ahocorasickTrieCheck

import scala.collection.JavaConversions.collectionAsScalaIterable
import scala.collection.mutable.ListBuffer
import com.ibm.icu.text.Normalizer2
import org.ahocorasick.trie.Trie

class Highlighter(words: Seq[String]) {

  val trie = new Trie[Boolean].removeOverlaps()
  words.foreach(word => trie.addKeyword(Highlighter.normalize(word), true))

  def execute(s: String): String =
    try {
      val result = new ListBuffer[String]
      var end = 0
      trie.parseText(Highlighter.normalize(s).replace("\n", " ")).toSeq.sortBy(_.getStart).foreach(e => {
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

object Highlighter {
  val normalizer = Normalizer2.getNFKCCasefoldInstance
  def normalize(s: String): String = normalizer.normalize(s)
}