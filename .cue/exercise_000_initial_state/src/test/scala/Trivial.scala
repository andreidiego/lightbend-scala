

class Trivial extends AnyWordSpec with Matchers {
  "Running a trivial test" should {
    "succeed" in {
      val sum = 1 + 2
      sum shouldBe 3
    }
  }

}
