package com.hinamura.ahocorasickTrieCheck

import com.ibm.icu.text.Normalizer2

object Normalizer {
  def nfcNormalize(s: String): String = Normalizer2.getNFCInstance.normalize(s)
  def nfkcNormalize(s: String): String = Normalizer2.getNFKCCasefoldInstance.normalize(s)
}