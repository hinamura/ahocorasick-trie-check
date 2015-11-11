package com.hinamura.ahocorasickTrieCheck

import scala.collection.JavaConversions.collectionAsScalaIterable
import org.ahocorasick.trie.Trie

import scala.collection.mutable.ListBuffer

class TrieSample(words: Seq[String]) {

  private val normalize = (s: String) =>  Normalizer.nfcNormalize(s)

  val trie = new Trie[Boolean].removeOverlaps()
  words.foreach(word => trie.addKeyword(normalize(word), true))

  def execute(s: String): List[String] = {
    val result = new ListBuffer[String]
    trie.parseText(normalize(s).replace("\n", " ")).toSeq.sortBy(_.getStart).foreach(e => {
      val r = s.substring(e.getStart, e.getEnd + 1)
      result.append(r)
    })
    result.toList
  }
}