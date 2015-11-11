package com.hinamura.ahocorasickTrieCheck

import org.scalatest.{Matchers, FlatSpec}

class HighlighterSpec() extends FlatSpec() with Matchers {

  "Highlighter.execute" should "be return matched string" in {
    val sample = new Highlighter(Seq("テスト"))
    val body = "これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result should be ("これはAho-Corasick Trieの日本語<hit>テスト</hit>です。")
  }

  it should "be return matched string (including (kabu))" in {
    val sample = new Highlighter(Seq("テスト"))
    val body = "㈱ これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result should be ("㈱ これはAho-Corasick Trieの日本語<hit>テスト</hit>です。")
  }

  it should "be return matched string (including circle 1)" in {
    val sample = new Highlighter(Seq("テスト"))
    val body = "① これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result should be ("① これはAho-Corasick Trieの日本語<hit>テスト</hit>です。")
  }

  it should "be return matched string (including circle up)" in {
    val sample = new Highlighter(Seq("テスト"))
    val body = "㊤ これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result should be ("㊤ これはAho-Corasick Trieの日本語<hit>テスト</hit>です。")
  }

  it should "be return matched string (including hesei)" in {
    val sample = new Highlighter(Seq("テスト"))
    val body = "㍻ これはAho-Corasick Trieの日本語テストです。"
    val result = sample.execute(body)
    result should be ("㍻ これはAho-Corasick Trieの日本語<hit>テスト</hit>です。")
  }
}