/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

class TrainSpec extends AnyWordSpec with Matchers {

  "Creating a Train" should {
    "throw an IllegalArgumentException for a schedule with 0 or 1 elements" in {
      an[IllegalArgumentException] should be thrownBy Train("ICE", 724, Vector())
      an[IllegalArgumentException] should be thrownBy Train("ICE", 724, Vector(munich))
    }
  }
}
