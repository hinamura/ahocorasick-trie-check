package com.hideto0710.ahocorasickTrieCheck

import scala.collection.JavaConversions.collectionAsScalaIterable
import com.ibm.icu.text.Normalizer2
import org.ahocorasick.trie.Trie

import scala.collection.mutable.ListBuffer

class TrieSample(words: Seq[String]) {

  val trie = new Trie[Boolean].removeOverlaps()
  words.foreach(word => trie.addKeyword(Highlighter.normalize(word), true))

  def execute(s: String): List[String] = {
    val result = new ListBuffer[String]
    trie.parseText(Highlighter.normalize(s).replace("\n", " ")).toSeq.sortBy(_.getStart).foreach(e => {
      val r = s.substring(e.getStart, e.getEnd + 1)
      result.append(r)
    })
    result.toList
  }
}

object TrieSample {
  val normalizer = Normalizer2.getNFKCCasefoldInstance
  def normalize(s: String): String = normalizer.normalize(s)
}