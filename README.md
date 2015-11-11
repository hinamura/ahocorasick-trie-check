# ahocorasick-trie-check

## Test
`$ sbt test`

## Result

| word  | result |
| :---- | :---:  |
| ㈱ | Failed |
| ① | Success|
| ㊤ | Success |
| ㍻ | Failed |

```
[info] TrieSampleSpec:
[info] TrieSample.execute
[info] - should be return matched string
[info] - should be return matched string (including (kabu)) *** FAILED ***
[info]   "[トです]" was not equal to "[テスト]" (TrieSampleSpec.scala:23)
[info] - should be return matched string (including circle 1)
[info] - should be return matched string (including circle up)
[info] - should be return matched string (including hesei) *** FAILED ***
[info]   "[ストで]" was not equal to "[テスト]" (TrieSampleSpec.scala:45)
[info] ScalaTest
[info] Run completed in 411 milliseconds.
[info] Total number of tests run: 5
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 3, failed 2, canceled 0, ignored 0, pending 0
[info] *** 2 TESTS FAILED ***
[error] Failed: Total 5, Failed 2, Errors 0, Passed 3
[error] Failed tests:
[error] 	com.hideto0710.ahocorasickTrieCheck.TrieSampleSpec
[error] (test:test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 4 s, completed Nov 11, 2015 12:27:10 PM
```
