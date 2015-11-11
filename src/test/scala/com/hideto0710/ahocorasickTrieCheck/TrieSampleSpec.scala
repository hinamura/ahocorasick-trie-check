package com.hideto0710.ahocorasickTrieCheck

import org.scalatest.{Matchers, FlatSpec}

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

class TrieSampleSpec() extends FlatSpec() with Matchers {

  val logger = Logger(LoggerFactory.getLogger("Hello"))

  "TrieSample.execute" should "be return matched string" in {
    val sample = new TrieSample(Seq("テスト"))
    val body = "これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result.head should be ("テスト")
  }

  it should "be return matched string (including (kabu))" in {
    val sample = new TrieSample(Seq("テスト"))
    val body = "㈱ これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result.head should be ("テスト")
  }

  it should "be return matched string (including circle 1)" in {
    val sample = new TrieSample(Seq("テスト"))
    val body = "① これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result.head should be ("テスト")
  }

  it should "be return matched string (including circle up)" in {
    val sample = new TrieSample(Seq("テスト"))
    val body = "㊤ これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result.head should be ("テスト")
  }

  it should "be return matched string (including hesei)" in {
    val sample = new TrieSample(Seq("テスト"))
    val body = "㍻ これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result.head should be ("テスト")
  }
}